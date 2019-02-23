package projectsmanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "job")
public class JobEntity extends BaseEntity
{
    @NotNull
    private String jobTitle;

    @NotNull
    private String jobRole;
}
