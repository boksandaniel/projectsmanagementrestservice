package projectsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleEntity
{
    @Id
    private String userName;
    @ManyToMany(mappedBy = "userRoles")
    private List<UserEntity> usersRole;

    //Required constructor
    public RoleEntity(String userName)
    {
        this.userName = userName;
    }
}
