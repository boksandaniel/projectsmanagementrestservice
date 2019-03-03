package projectsmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Entity
public class TaskEntity extends BaseEntity
{
    @NotEmpty
    private String date;

    @NotEmpty
    private Date startTime;

    @NotEmpty
    private Date endTime;

    @NotEmpty
    private String taskDescription;
    @ManyToMany
    @JoinColumn(name = "USER_EMAIL")
    private UserEntity userEntity;

    public TaskEntity(String date, Date startTime, Date endTime, String taskDescription, UserEntity userEntity)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
        this.userEntity = userEntity;
    }

    public TaskEntity(String date, Date startTime, Date endTime, String taskDescription)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
    }

    public TaskEntity(){}
}
