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
@Table(name = "user")
public class UserEntity extends BaseEntity
{
    @NotNull
    @Column(name = "username")
    private String userName;

    @NotNull
    @Size(min = 6)
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Email
    @Column
    private String email;

    public List<GrantedAuthority> userAuthorities()
    {
        return AuthorityUtils.createAuthorityList(userRole.getRoleName());
    }

}
