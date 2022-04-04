package com.vkarakay.tasktracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks", schema = "task_tracker_db")
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "shortname")
    private String shortname;
    @Basic
    @Column(name = "developer")
    private int developer;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "done")
    private boolean done;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "employee_task",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public int getDeveloper() {
        return developer;
    }

    public void setDeveloper(int developer) {
        this.developer = developer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (developer != task.developer) return false;
        if (status != task.status) return false;
        if (done != task.done) return false;
        if (shortname != null ? !shortname.equals(task.shortname) : task.shortname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortname != null ? shortname.hashCode() : 0);
        result = 31 * result + developer;
        result = 31 * result + status;
        result = 31 * result + (done ? 1 : 0);
        return result;
    }
}
