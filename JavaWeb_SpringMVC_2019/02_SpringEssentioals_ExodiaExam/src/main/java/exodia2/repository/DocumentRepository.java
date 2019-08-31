package exodia2.repository;

import exodia2.domain.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    Optional<Document> findById(String id);

    void deleteById(String id);
}
