package project.serviceuser.model;


import project.serviceuser.model.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Profile {
    private Integer id;
    private User user;
    private String profileImgUrl;
    private String description;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp removedAt;

    public static Profile fromEntity(ProfileEntity entity) {
        return new Profile(
                entity.getId(),
                User.fromEntity(entity.getUser()),
                entity.getProfileImgUrl(),
                entity.getDescription(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getRemovedAt()
        );
    }

}
