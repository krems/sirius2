package com.sirius.builder;

import java.util.Date;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String surname;
    private final Date dateOfBirth;
    private final Sex sex;
    private final MaritalStatus maritalStatus;
    
    Person(String firstName, String middleName, String surname, Date dateOfBirth, Sex sex, MaritalStatus maritalStatus) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
    }
}
