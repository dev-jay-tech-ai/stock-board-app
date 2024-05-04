package project.serviceboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.serviceboard.model.entity.ArticleEntity;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String body;
    private Integer userId;
    private String StockId;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp removedAt;
    public static Article fromEntity(ArticleEntity entity) {
        return new Article(
                entity.getId(),
                entity.getTitle(),
                entity.getBody(),
                entity.getUserId(),
                entity.getStockId(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getRemovedAt()
        );
    }
}
