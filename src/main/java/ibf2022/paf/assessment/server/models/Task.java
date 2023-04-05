package ibf2022.paf.assessment.server.models;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


// TODO: Task 4

public class Task {

    private int taskId;
    private String description;
    private int priority;
    private LocalDate dueDate;
    private String UserId;

    private List<User> users = new LinkedList<>();

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    

	public List<User> getUser() { return this.users; }
    public void setUser(List<User> users) { this.users = users; }
	public void addUser(User user) { this.users.add(user); }




}

