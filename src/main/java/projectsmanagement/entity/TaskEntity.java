package projectsmanagement.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;

@Entity
public class TaskEntity
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
    private UserEntity userEntity;

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

    public UserEntity getUserEntity()
    {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity)
    {
        this.userEntity = userEntity;
    }


    //Constructors
    public TaskEntity(String date, SimpleDateFormat startTime, SimpleDateFormat endTime, String taskDescription, UserEntity userEntity)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
        this.userEntity = userEntity;
    }

    public TaskEntity(String date, SimpleDateFormat startTime, SimpleDateFormat endTime, String taskDescription)
    {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskDescription = taskDescription;
    }
}
