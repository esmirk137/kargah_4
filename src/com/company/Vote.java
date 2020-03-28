package com.company;

import java.util.Objects;

/**
 * This class represent detail of a vote include voter and date of voting.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since Mar.28.2020
 */
public class Vote {
    // voter
    private Person person;
    // date of voting
    private String date;

    /**
     * This is constructor of Vote class.
     * @param person is person for field person.
     * @param date is date of voting based on your system's date.
     */
    public Vote(Person person, String date){
        this.person = new Person(person.getFirstName(), person.getLastName());
        this.date=date;
    }

    /**
     * This method is overriding of equals method for Vote class.
     * @param o is an object that receive to compare.
     * @return boolean that show these to object are equals or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(person, vote.person) &&
                Objects.equals(date, vote.date);
    }

    /**
     * This method is overriding of hashcode method for upper overriding.
     * @return boolean that show these to object have same hash code or not.
     */
    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }

    /**
     * get the person for voter.
     * @return person field.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * get the date for make vote.
     * @return date field.
     */
    public String getDate() {
        return date;
    }

}
