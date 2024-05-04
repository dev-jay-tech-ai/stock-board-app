package project.serviceboard.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.serviceuser.BaseTimeEntity;

import javax.persistence.*;

@Entity(name = "comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class CommentEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "article_id")
    private Long articleId;
}
