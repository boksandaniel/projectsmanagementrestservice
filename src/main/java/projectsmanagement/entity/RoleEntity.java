package projectsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleEntity
{
    //Instance fields
    @Id
    private String userName;
    @ManyToMany(mappedBy = "userRoles")
    private List<UserEntity> usersRole;

    //Getters and setters
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public List<UserEntity> getUsersRole()
    {
        return usersRole;
    }

    public void setUsersRole(List<UserEntity> usersRole)
    {
        this.usersRole = usersRole;
    }

    //Constructor
    public RoleEntity(String userName)
    {
        this.userName = userName;
    }
}
