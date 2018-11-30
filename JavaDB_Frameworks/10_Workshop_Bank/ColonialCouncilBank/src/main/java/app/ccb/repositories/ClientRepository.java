package app.ccb.repositories;

import app.ccb.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByFullName(String fullName);

    @Query("SELECT c FROM app.ccb.domain.entities.Client AS c JOIN c.bankAccount AS ba " +
            "GROUP BY c.id " +
            "ORDER BY size(ba.cards) DESC")
    List<Client> findClientByNumberOfCards();
}
