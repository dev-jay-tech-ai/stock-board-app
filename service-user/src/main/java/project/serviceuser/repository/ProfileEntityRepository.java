package project.serviceuser.repository;

import project.serviceuser.model.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileEntityRepository extends JpaRepository<ProfileEntity, Integer> {
    Optional<ProfileEntity> findByUserId(Integer userId);

}
