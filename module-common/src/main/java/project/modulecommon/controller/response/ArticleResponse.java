package project.modulecommon.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

    @Getter
    @AllArgsConstructor
    public class ArticleResponse {
        private Integer id;
        private String title;
        private String body;
        private Long stockId;
        private Timestamp registeredAt;
        private Timestamp updatedAt;

    }
