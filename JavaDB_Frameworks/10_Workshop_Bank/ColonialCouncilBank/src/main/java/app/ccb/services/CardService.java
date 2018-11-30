package app.ccb.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CardService {

    Boolean cardsAreImported();

    String readCardsXmlFile() throws IOException;

    String importCards() throws JAXBException;
}
