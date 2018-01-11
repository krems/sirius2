package com.sirius.builder;

import java.util.Date;

public class BuilderDemo {
    public static void main(final String[] args) {
        final Date dob = new Date(1970, 1, 1);
        final Person plain = new Person("Valery", "Alekseevich", "Ovchinnikov",
                dob, Sex.Male, MaritalStatus.Married);
        
        final PersonBuilder builder = new PersonBuilder();
        builder.named("Valery");
        builder.withMiddleName("Alekseevich");
        builder.withSurname("Ovchinnikov");
        builder.bornAt(dob);
        builder.male();
        builder.married();
        final Person built = builder.build();
        
        final Person fluentlyBuilt = new PersonFluentBuilder()
                .named("Valery")
                .withMiddleName("Alekseevich")
                .withSurname("Ovchinnikov")
                .bornAt(dob)
                .male()
                .married().build();
    }
}
