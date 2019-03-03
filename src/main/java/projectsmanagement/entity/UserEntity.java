package projectsmanagement.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_table")
public class UserEntity
{
    @Email
    @Id
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Column(name = "username")
    private String name;

    @NotEmpty
    @Size(min = 6)
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> userTask;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "userName")})
    private List<RoleEntity>  userRoles;

    public UserEntity(String email,  String name, String password)
    {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
