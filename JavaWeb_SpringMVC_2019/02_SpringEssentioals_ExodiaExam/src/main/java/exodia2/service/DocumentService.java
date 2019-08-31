package exodia2.service;

import exodia2.domain.models.service.DocumentServiceModel;

import java.util.List;

public interface DocumentService {

    DocumentServiceModel createDocument(DocumentServiceModel documentServiceModel);

    boolean deleteDocument(String id);

    DocumentServiceModel findById(String id);

    List<DocumentServiceModel> findAllDocuments();
}
