package project.serviceboard.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.serviceuser.BaseTimeEntity;

import javax.persistence.*;

@Entity(name = "`like`")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class LikeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    private Long userId;

    @JoinColumn(name = "article_id")
    private Long articleId;
}
