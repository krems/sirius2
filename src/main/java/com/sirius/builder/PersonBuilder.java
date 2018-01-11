package com.sirius.builder;

import java.util.Date;

public class PersonBuilder {
    private String firstName;
    private String middleName;
    private String surname;
    private Date dateOfBirth;
    private Sex sex;
    private MaritalStatus maritalStatus;
    
    Person build() {
        validate();
        return new Person(firstName, middleName, surname, dateOfBirth, sex, maritalStatus);
    }
    
    void named(String name) {
        this.firstName = name;
    }
    
    void withMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    void withSurname(String surname) {
        this.surname = surname;
    }
    
    void bornAt(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    void male() {
        this.sex = Sex.Male;
    }
    
    void female() {
        this.sex = Sex.Female;
    }
    
    void married() {
        this.maritalStatus = MaritalStatus.Married;
    }
    
    void single() {
        this.maritalStatus = MaritalStatus.Single;;
    }
    
    private void validate() {
        if (firstName == null || surname == null || dateOfBirth == null || sex == null) {
            throw new IllegalStateException();
        }
    }
}
