package com.company;

/**
 * This class represent identity of a person.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since Mar.28.2020
 */
public class Person {
    // first name of person
    private String firstName;
    // last name of person
    private String lastName;

    /**
     * This is constructor of Person class.
     * @param firstName is first name of a person.
     * @param lastName is last name of a person.
     */
    public Person(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }


    /**
     * This method is overriding of toString method for Person class.
     * @return fields of this class into string form.
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    /**
     * get the first name of person.
     * @return firstName field.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the last name of person.
     * @return lastName field.
     */
    public String getLastName() {
        return lastName;
    }
}
