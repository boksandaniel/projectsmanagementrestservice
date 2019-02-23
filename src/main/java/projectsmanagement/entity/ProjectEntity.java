package projectsmanagement.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class ProjectEntity extends BaseEntity
{
    @Column
    @NotNull
    private String projectName;

    @Column
    @NotNull
    private Date startDate;

    @Column
    @NotNull
    private Date endDate;

    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

}
