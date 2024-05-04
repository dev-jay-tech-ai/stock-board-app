package project.servicestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.servicestock.model.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
