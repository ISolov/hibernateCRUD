package Entities;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int version;


    private Employee employee;
}
