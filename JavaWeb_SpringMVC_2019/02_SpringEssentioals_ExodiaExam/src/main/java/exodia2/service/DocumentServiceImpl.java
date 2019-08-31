package exodia2.service;

import exodia2.domain.entities.Document;
import exodia2.domain.entities.User;
import exodia2.domain.models.service.DocumentServiceModel;
import exodia2.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public DocumentServiceModel createDocument(DocumentServiceModel documentServiceModel) {

        Document document = this.modelMapper.map(documentServiceModel, Document.class);

        try {
            this.documentRepository.saveAndFlush(document);
            return this.modelMapper.map(document, DocumentServiceModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        //
//        return this.modelMapper
//                .map(this.documentRepository
//                                .saveAndFlush(this.modelMapper
//                                        .map(documentServiceModel, Document.class)),
//                        DocumentServiceModel.class);
    }

    @Override
    public boolean deleteDocument(String id) {
        try {
            this.documentRepository
                    .deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DocumentServiceModel findById(String id) {
        Document document = this.documentRepository
                .findById(id)
                .orElse(null);

        return document == null
                ? null
                : this.modelMapper.map(document, DocumentServiceModel.class);
    }

    @Override
    public List<DocumentServiceModel> findAllDocuments() {
        return this.documentRepository
                .findAll()
                .stream()
                .map(x -> this.modelMapper
                        .map(x, DocumentServiceModel.class))
                .collect(Collectors.toList());
    }
}
