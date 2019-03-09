package projectsmanagement.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@NoArgsConstructor
public class UserEntity
{
    //Instance fields
    @Email
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> userTask;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "userName")})
    private List<RoleEntity>  userRoles;

    //Geters and setters
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<TaskEntity> getUserTask()
    {
        return userTask;
    }

    public void setUserTask(List<TaskEntity> userTask)
    {
        this.userTask = userTask;
    }

    public List<RoleEntity> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<RoleEntity> userRoles)
    {
        this.userRoles = userRoles;
    }

    //Constructor
    public UserEntity(String email,  String name, String password)
    {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
