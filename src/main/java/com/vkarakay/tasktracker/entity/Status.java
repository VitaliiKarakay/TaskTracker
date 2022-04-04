package com.vkarakay.tasktracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "statuses", schema = "task_tracker_db")
public class Status {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "status_name")
    private String statusName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "")
    private List<Task> tasks;

    public Status() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (id != status.id) return false;
        if (statusName != null ? !statusName.equals(status.statusName) : status.statusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        return result;
    }
}
