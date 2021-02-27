package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String address;


    private List<Employee> employees = new ArrayList<>();
}
