package projectsmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_ROLE")
public class Role
{
    @Id
    private String roleName;

    @ManyToMany(mappedBy = "userRoles")
    private List<User> usersRole;

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

    public Role(String userName)
    {
        this.roleName = userName;
    }
}
