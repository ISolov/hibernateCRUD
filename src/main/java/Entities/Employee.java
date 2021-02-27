package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;


    private Address address;

    private String FIO;


    private Department department;


    private List<Project> projects;

}
