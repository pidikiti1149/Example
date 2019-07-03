package com.example.a200429757_midterm;



public class game {
    String FName;
    String LName;
    int GameId;
    String Choice;
    String Winner;

    public game(String id, String fName, String lName, String choice) {

    }

    public game(String FName, String LName, int gameId, String choice) {
        this.FName = FName;
        this.LName = LName;
        GameId = gameId;
        Choice = choice;
        //Winner = winner;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public int getGameId() {
        return GameId;
    }

    public String getChoice() {
        return Choice;
    }
}