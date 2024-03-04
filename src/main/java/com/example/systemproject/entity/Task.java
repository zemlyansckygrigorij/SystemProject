package com.example.systemproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class Task
Работа имеет атрибуты:
1. Название - строка;
2. Начало - дата;
3. Окончание - дата;
4. Процент выполнения - вещественное число;
5. Исполнитель - строка.
 * */

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "starting")
    private Date starting;
    @Column(name = "ending")
    private Date ending;
    @Column(name = "completion")
    private Double completionPercentage;
    @Column(name = "executor")
    private String executor;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

   /* @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id", referencedColumnName = "id")
    private Point point;*/
    public void setName(String name) {
        if(completionPercentage<100){
            this.name = name;
        }
    }

    public void setStarting(Date starting) {
        if(completionPercentage<100){
            this.starting = starting;
        }
    }

    public void setEnding(Date ending) {
        if(completionPercentage<100){
            this.ending = ending;
        }
    }

    public void setCompletionPercentage(Double completionPercentage) {
        if(completionPercentage<100){
            this.completionPercentage = completionPercentage;
        }
    }

    public void setExecutor(String executor) {
        if(completionPercentage<100){
            this.executor = executor;
        }
    }
}
