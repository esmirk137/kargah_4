package com.company;

import java.util.ArrayList;

/**
 * VotingSystem class use for management voting.
 * @author Sayed Mohammad Ali Mirkazemi
 * @version 1.0.0
 * @since Mar.28.2020
 */
public class VotingSystem {
    // list of voting in the system
    private ArrayList<Voting> votingList;

    /**
     * Constructor for field of class VotingSystem
     */
    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    /**
     * Method createVoting make voting and add it to list of voting in system.
     * This method also check if new voting was repeated show an appropriate massage.
     * @param question is question of voting.
     * @param type is type of voting (single or multi vote).
     * @param choices is list of polls of voting.
     */
    public void createVoting(String question, int type, ArrayList<String> choices){
        Voting voting=new Voting(type,question);
        for(String string: choices)
            voting.createPoll(string);
        if(votingList.contains(voting)){
            System.out.println("This voting already exist.");
            return;
        }
        System.out.println("Process successfully done. New voting create and added list.");
        votingList.add(voting);
    }

    /**
     * This method get index and registration the vote with calling vote method in Voting class.
     * @param index is index of voting in the list of voting in the system.
     * @param person is voter.
     * @param choices is list of polls that voter choose them.
     */
    public void vote(int index, Person person, ArrayList<String> choices){
        votingList.get(index).vote(person,choices);
    }

    /**
     * This method print question of voting in the list.
     * If there is no question in the list show an appropriate massage.
     */
    public void printListOfVotes(){
        boolean first=true;
        for(Voting voting: votingList){
            if(first){
                System.out.println("Questions of voting list :");
                first=false;
            }
            System.out.println(voting.getQuestion());
        }
        if(first)
            System.out.println("There is no question.");
    }

    /**
     * This method get index of a voting and show it's question and polls.
     * @param indexOfVote is index of voting that you wanna print.
     */
    public void printVoting(int indexOfVote){
        System.out.println("The question is: " + votingList.get(indexOfVote).getQuestion());
        System.out.println("The choices are: " + votingList.get(indexOfVote).getPolls().keySet());
    }

    /**
     * This method get index of a voting and show the result.
     * @param index is index of voting that you wanna see it's result.
     */
    public void printResult(int index){
        votingList.get(index).printVotes();
    }

    /**
     * get the list of voting in the system.
     * @return votingList field.
     */
    // This additional method is just for Test class.
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }
    
}
