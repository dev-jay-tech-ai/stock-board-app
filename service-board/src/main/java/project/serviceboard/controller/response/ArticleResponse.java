package project.serviceboard.controller.response;

import project.serviceboard.model.Article;
import project.serviceboard.model.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

    @Getter
    @AllArgsConstructor
    public class ArticleResponse {
        private Long id;
        private String title;
        private String body;
        private Integer userId;
        private String stockId;
        private Timestamp registeredAt;
        private Timestamp updatedAt;

        public static ArticleResponse fromArticle(Article article) {
            return new ArticleResponse(
                    article.getId(),
                    article.getTitle(),
                    article.getBody(),
                    article.getUserId(),
                    article.getStockId(),
                    article.getRegisteredAt(),
                    article.getUpdatedAt()
            );
        }

    }
