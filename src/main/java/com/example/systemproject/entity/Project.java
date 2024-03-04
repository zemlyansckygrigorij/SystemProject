package com.example.systemproject.entity;

import com.example.systemproject.exceptions.WrongStateException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class Project
 * Проект имеет атрибуты:
 * 1. Название - строка;
 * 2. Номер - строка;
 * 3. Состояние - перечисление, см. ниже;
 * 4. Средний процент выполнения - вещественное число;
 * 5. Руководитель - строка.
 * */
@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;
    @Column(name = "state")
    private State state;
    @Column(name = "average_completion_percentage")
    private Double averageCompletion;
    @Column(name = "leader")
    private String leader;


    @OneToMany(mappedBy="project",cascade = CascadeType.ALL, orphanRemoval = true)
   // @JoinColumn(name = "id")
    private List<Task> listTasks =new ArrayList<>();
    public Project(String name, String number, String leader){
        this.name = name;
        this.number = number;
        this.state = State.CREATED;
        this.averageCompletion = 0.0;
        this.leader = leader;
    }

    public void sendForApproval(){
        if(state==State.CREATED||state==State.FINALIZATION){
            this.state = State.APPROVAL;
        }else{
           throw new WrongStateException();
        }
    }

    public void approve(){
        if(state==State.APPROVAL){
            this.state = State.EXECUTION;
        }else{
            throw new WrongStateException();
        }
    }
    public void returnForFinalization(){
        if(state==State.APPROVAL){
            this.state = State.FINALIZATION;
        }else{
            throw new WrongStateException();
        }
    }

    public boolean isCompleted(){
       return listTasks.stream().filter(t -> t.getCompletionPercentage()<100).count()==0;
    }
}
