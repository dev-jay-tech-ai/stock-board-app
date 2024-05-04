package project.servicestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.servicestock.model.entity.StocksEntity;

@Repository
public interface StocksRepository extends JpaRepository<StocksEntity, Long> {

}
