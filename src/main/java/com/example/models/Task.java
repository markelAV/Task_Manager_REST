package com.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks", schema = "public", catalog = "postgres")
public class Task {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String Description;

    @Basic
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date; //Todo look on class of Import

    @Basic
    @Column(name = "complete")
    private boolean complete;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "tasks_user__fk"))
    private User user;

    public void generateTaskId() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.user.getId())
                .append(this.date.hashCode());
        this.id = builder.toString();
    }
}
