package ch.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlParserImpl implements XmlParser {
    @Override
    public <O> O parseXml(Class<O> objectClass, String path) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(objectClass);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(path))));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (O) unmarshaller.unmarshal(reader);
    }
}
