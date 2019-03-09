package projectsmanagement.entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;

@Entity
public class Task
{
    //Instance fields
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String date;

    @NotEmpty
    private SimpleDateFormat startTime;

    @NotEmpty
    private SimpleDateFormat endTime;

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

    public SimpleDateFormat getStartTime()
    {
        return startTime;
    }

    public void setStartTime(SimpleDateFormat startTime)
    {
        this.startTime = startTime;
    }

    public SimpleDateFormat getEndTime()
    {
        return endTime;
    }

    public void setEndTime(SimpleDateFormat endTime)
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
    public Task(String date, SimpleDateFormat startTime, SimpleDateFormat endTime, String taskDescription, User user)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
        this.user = user;
    }

    public Task(String date, SimpleDateFormat startTime, SimpleDateFormat endTime, String taskDescription)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
    }
}
