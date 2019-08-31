package realestateapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realestateapplication.domain.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

}
