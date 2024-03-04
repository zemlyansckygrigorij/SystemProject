package com.example.systemproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * @author Grigoriy Zemlyanskiy
 * @version 1.0
 * class Point
Контрольная точка имеет атрибуты:
1. Название - строка;
2. Окончание - дата.
 * */

@Entity
@Table(name = "point")
@Getter
@Setter
@NoArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ending")
    private Date ending;
    //@OneToOne//(mappedBy = "task",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(name = "point_id", referencedColumnName = "id")
   // private Task task;
}
