package com.company;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Person person1=new Person("mmd1","mk1");
        Person person2=new Person("mmd2","mk2");
        Person person3=new Person("mmd3","mk3");
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("poll 1");
        arrayList.add("poll 2");
        arrayList.add("poll 3");
        arrayList.add("poll 4");
        VotingSystem votingSystem=new VotingSystem();
        votingSystem.createVoting("I should to choose...",0,arrayList);
        votingSystem.printListOfVotes();
        votingSystem.printResult(0);

        ArrayList<String> arrayList1=new ArrayList<>();
        arrayList1.add("poll 1");
        votingSystem.vote(0,person1,arrayList1);

        ArrayList<String> arrayList2=new ArrayList<>();
        arrayList2.add("poll 2");
        arrayList2.add("poll 3");
        votingSystem.vote(0,person2,arrayList2);

        ArrayList<String> arrayList3=new ArrayList<>();
        arrayList3.add("Random choice");
        votingSystem.vote(0,person3,arrayList3);
        votingSystem.printResult(0);

        votingSystem.printVoting(0);

        votingSystem.getVotingList().get(0).createPoll("another poll");
        votingSystem.printResult(0);

    }
}
