package alararestaurant.service;

import alararestaurant.domain.dtos.ItemXmlDto;
import alararestaurant.domain.dtos.OrderXmlImportDto;
import alararestaurant.domain.dtos.OrderXmlImportRootDto;
import alararestaurant.domain.entities.*;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final static String ORDERS_XML_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\AlaraRestaurant-skeleton\\AlaraRestaurant\\src\\main\\resources\\files\\orders.xml";
    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, EmployeeRepository employeeRepository, ItemRepository itemRepository, OrderItemRepository orderItemRepository, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean ordersAreImported() {

        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return this.fileUtil.readFile(ORDERS_XML_FILE_PATH);
    }

    @Override
    public String importOrders() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(OrderXmlImportRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        OrderXmlImportRootDto orderXmlImportRootDto = (OrderXmlImportRootDto) unmarshaller
                .unmarshal(new File(ORDERS_XML_FILE_PATH));

        for (OrderXmlImportDto orderXmlImportDto : orderXmlImportRootDto.getOrderXmlImportDtos()) {

            if (!this.validationUtil.isValid(orderXmlImportDto)) {
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());
                continue;
            }

            Employee employeeEntity = this.employeeRepository
                    .findByName(orderXmlImportDto.getEmployee()).orElse(null);

            if (employeeEntity == null) {
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());
                continue;
            }


            Order orderEntity = new Order();

            orderEntity.setCustomer(orderXmlImportDto.getCustomer());

            orderEntity.setDateTime(LocalDateTime
                    .parse(orderXmlImportDto.getDateTime(), dateTimeFormatter));

            orderEntity.setOrderType(OrderType.valueOf(orderXmlImportDto.getType()));

            orderEntity.setEmployee(employeeEntity);

            List<OrderItem> listOrderItem = new ArrayList<>();
            Boolean isAllItemsValid = true;
            for (ItemXmlDto itemXmlDto : orderXmlImportDto.getItems().getItemXmlDtos()) {

                if (!this.validationUtil.isValid(itemXmlDto)) {
                    importResult.append("Invalid data format.")
                            .append(System.lineSeparator());
                    continue;
                }

                Item itemEntity = this.itemRepository
                        .findByName(itemXmlDto.getName()).orElse(null);

                if (itemEntity == null) {
                    importResult.append("Invalid data format.")
                            .append(System.lineSeparator());

                    isAllItemsValid = false;
                    continue;
                }

                OrderItem orderItemEntity = new OrderItem();
                orderItemEntity.setQuantity(itemXmlDto.getQuantity());
                orderItemEntity.setOrder(orderEntity);
                orderItemEntity.setItem(itemEntity);


                listOrderItem.add(orderItemEntity);

            }

            if (!isAllItemsValid) {
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());

                continue;
            }


            this.orderRepository.saveAndFlush(orderEntity);

            this.orderItemRepository.saveAll(listOrderItem);


            importResult.append(String.format("Order for %s on %s added",
                    orderXmlImportDto.getCustomer(), orderXmlImportDto.getDateTime()))
                    .append(System.lineSeparator());
        }

        System.out.println();
        return importResult.toString().trim();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder exportResult = new StringBuilder();

        List<Order> orders = this.orderRepository.findByOrdersFinished();

        for (Order order : orders) {
            exportResult.append(String.format("Name: %s", order.getEmployee().getName()))
                    .append(System.lineSeparator())
                    .append("Orders:").append(System.lineSeparator())
                    .append(String.format(" Customer: %s", order.getCustomer()))
                    .append(System.lineSeparator())
                    .append("Items:").append(System.lineSeparator());

            for (OrderItem item : order.getItems()) {
                exportResult.append(String.format("     Name: %s",
                        item.getItem().getName()))
                        .append(System.lineSeparator())
                        .append(String.format("     Price: %.2f",
                                item.getItem().getPrice()))
                        .append(System.lineSeparator())
                        .append(String.format("     Quantity: %d",
                                item.getQuantity()))
                        .append(System.lineSeparator())
                        .append(System.lineSeparator());
            }

        }
        return exportResult.toString().trim();
    }
}
