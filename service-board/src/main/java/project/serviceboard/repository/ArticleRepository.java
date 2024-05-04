package project.serviceboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.serviceboard.model.entity.ArticleEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    public Page<ArticleEntity> findAllByUserId(Integer userId, Pageable pageable);

    public Page<ArticleEntity> findByTitleContaining(String searchKeyword, Pageable pageable);

    // public Page<ArticleEntity> findByUsernameContaining(Pageable pageable, String searchKeyword);

    public Page<ArticleEntity> findByBodyContaining(String searchKeyword, Pageable pageable);
}
