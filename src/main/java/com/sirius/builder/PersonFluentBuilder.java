package com.sirius.builder;

import java.util.Date;

public class PersonFluentBuilder {
    private String firstName;
    private String middleName;
    private String surname;
    private Date dateOfBirth;
    private Sex sex;
    private MaritalStatus maritalStatus;
    
    private void validate() {
        if (firstName == null || surname == null || dateOfBirth == null) {
            throw new IllegalStateException();
        }
    }
    
    Person build() {
        validate();
        return new Person(firstName, middleName, surname, dateOfBirth, sex, maritalStatus);
    }
    
    PersonFluentBuilder named(String name) {
        this.firstName = name;
        return this;
    }
    
    PersonFluentBuilder withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
    
    PersonFluentBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }
    
    PersonFluentBuilder bornAt(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    
    PersonFluentBuilder male() {
        this.sex = Sex.Male;
        return this;
    }
    
    PersonFluentBuilder female() {
        this.sex = Sex.Female;
        return this;
    }
    
    PersonFluentBuilder married() {
        this.maritalStatus = MaritalStatus.Married;
        return this;
    }
    
    PersonFluentBuilder single() {
        this.maritalStatus = MaritalStatus.Single;
        return this;
    }
}
