package projectsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_ROLE")
public class Role
{
    //Instance fields
    @Id
    private String roleName;

    @ManyToMany(mappedBy = "userRoles")
    private List<User> usersRole;

    //Getters and setters
    public String getUserName()
    {
        return roleName;
    }

    public void setUserName(String userName)
    {
        this.roleName = userName;
    }

    public List<User> getUsersRole()
    {
        return usersRole;
    }

    public void setUsersRole(List<User> usersRole)
    {
        this.usersRole = usersRole;
    }

    //Constructor
    public Role(String userName)
    {
        this.roleName = userName;
    }
}
