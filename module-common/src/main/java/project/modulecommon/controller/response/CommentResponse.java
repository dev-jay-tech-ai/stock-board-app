package project.modulecommon.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String comment;
    private Long userId;
    private String userName;
    private Long stockId;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp removedAt;

}
