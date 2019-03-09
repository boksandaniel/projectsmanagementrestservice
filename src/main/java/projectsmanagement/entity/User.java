package projectsmanagement.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@NoArgsConstructor
public class User
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
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

    //Constructor
    public User(String email, String name, String password)
    {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
