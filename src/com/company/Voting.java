package com.company;

import ir.huri.jcal.JalaliCalendar;
import java.util.*;

/**
 * This class represent a voting with a question and some choice for voter.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since Mar.28.2020
 */
public class Voting {
    // show type of voting
    private int type;
    // question of voting
    private String question;
    // list of person that vote to a choice
    private ArrayList<Person> voters;
    // list of choices
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * This is constructor of Voting class.
     * @param type represent type of voting.
     * @param question is string for main question of voting.
     */
    public Voting(int type, String question){
        voters = new ArrayList<>();
        polls = new HashMap<>();
        this.type=type;
        this.question=question;
    }

    /**
     * This method add a choice or poll to voting.
     * If new choice was repeated show an appropriate massage.
     * @param choice is poll that you wanna add.
     */
    public void createPoll(String choice){
        if(polls.containsKey(choice)){
            System.out.println("This choice already exist in vote.");
            return;
        }
        HashSet<Vote> votes2= new HashSet<>();
        polls.put(choice, votes2);
    }

    /**
     * Vote method registration a vote and add person to list of voter.
     * This method check a person that can't vote twice.
     * Also have random choice for single voting type.
     * If choices in input don't exist in the voting print an appropriate massage.
     * @param person is voter.
     * @param choices is list of polls that voter choose them.
     */
    public void vote(Person person, ArrayList<String> choices){
        if(voters.contains(person)){
            System.out.println("This person was attended in the voting in the past.");
            return;
        }
        JalaliCalendar date=new JalaliCalendar();
        Vote vote=new Vote(person, date.toString());
        if(type==0){
            if(choices.size()>1){
                System.out.println("Process field. This person just can vote to a choice.");
                return;
            }
            if(choices.contains("Random choice")){
                Random random= new Random();
                Object[] keys = polls.keySet().toArray();
                Object randomKey = keys[random.nextInt(keys.length)];
                polls.get(randomKey).add(vote);
                voters.add(person);
                return;
            }
            polls.get(choices.get(0)).add(vote);
            voters.add(person);
        }
        else if(type==1){
            for(String string: choices)
                polls.get(string).add(vote);
            voters.add(person);
        }
        else
            System.out.println("Invalid input for voting type.");
    }

    /**
     * This method show result of voting.
     */
    public void printVotes(){
        int counter=1;
        for(String string: polls.keySet()){
            System.out.println( counter + ") " + string + " [" + polls.get(string).size() + "]");
            counter++;
        }
        if(type==0)
            System.out.println( counter + ") Random choice");
    }


    /**
     * get the question of voting.
     * @return question field.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * get the persons that attend to voting.
     * @return voters field.
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * get the polls of voting.
     * @return polls field.
     */
    public HashMap<String, HashSet<Vote>> getPolls() {
        return polls;
    }
}
