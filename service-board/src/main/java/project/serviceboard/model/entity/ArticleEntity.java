package project.serviceboard.model.entity;

import lombok.*;
import project.serviceuser.BaseTimeEntity;

import javax.persistence.*;

@Entity(name = "article")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ArticleEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "like_id")
    private Long likeId;
//
    @Column(name = "stock_id")
    private String stockId;

    public static ArticleEntity of(String stockId, Integer userId, String title, String body) {
        ArticleEntity entity = new ArticleEntity();
        entity.setStockId(stockId);
        entity.setUserId(userId);
        entity.setTitle(title);
        entity.setBody(body);
        return entity;
    }

}
