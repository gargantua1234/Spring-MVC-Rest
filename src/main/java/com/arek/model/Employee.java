package com.arek.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Arek on 08.02.2017.
 */

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate;


    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    public long getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(object instanceof Employee){
            Employee employee = (Employee) object;
            if(employee.getName().equals(this.getName())
                    && employee.getLastName().equals(this.getLastName())
                    && employee.getGender().equals(this.getGender())
                    /*&& employee.getBirthday().equals(this.getBirthday())*/
                    )
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (name.hashCode()+ lastName.hashCode()+gender.hashCode()
                /*+birthday.hashCode()*/
        );
    }
}
