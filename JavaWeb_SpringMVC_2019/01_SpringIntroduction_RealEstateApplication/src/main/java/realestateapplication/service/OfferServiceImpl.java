package realestateapplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realestateapplication.domain.entities.Offer;
import realestateapplication.domain.models.service.OfferServiceModel;
import realestateapplication.repository.OfferRepository;

import javax.validation.Validator;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, Validator validator) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {

        if (this.validator.validate(offerServiceModel).size() != 0) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        this.offerRepository
                .saveAndFlush(this.modelMapper.map(offerServiceModel, Offer.class));
    }
}
