package projectsmanagement.entity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "APP_TASK")
public class Task
{
    //Instance fields
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String date;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String endTime;

    @NotEmpty
    @Column(length = 100)
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    //Getters and setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getTaskDescription()
    {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }


    //Constructors
    public Task(String date, String startTime, String endTime, String taskDescription, User user)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
        this.user = user;
    }

    public Task(String date, String startTime, String endTime, String taskDescription)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
    }

    public Task() {}
}
