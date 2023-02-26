package com.example.APIRest.models;
import jakarta.persistence.*;

// Al poner entity hace que cada campo que añada aca sea una columna en la bbdd
@Entity
@Table(name = "task")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Boolean completed;

    @Column
    private level_task level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public level_task getLevel() {
        return level;
    }

    public void setLevel(level_task level) {
        this.level = level;
    }
}
