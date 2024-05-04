package project.serviceboard.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class LikeResponse {
    private Long id;
    private Long userId;
    private String userName;
    private Long articleId;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp removedAt;
}
