package projectsmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@Table(name = "user")
public class User
{
    //Instance fields
    @Email
    @Id
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String userName;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "roleName")})
    private List<Role>  userRoles;

    //Geters and setters
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Task> getUserTask()
    {
        return tasks;
    }

    public void setUserTask(List<Task> userTask)
    {
        this.tasks = userTask;
    }

    public List<Role> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles)
    {
        this.userRoles = userRoles;
    }

    //Constructors
    public User(String email, String userName, String password)
    {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User() { }
}