package com.example.devopsgithubactions.Model;

import org.springframework.stereotype.Component;

//Klass som håller koll på användarens samt datorns score, samt hur många omgångar som körts
@Component
public class CoinFlip {
    private int userScore = 0;
    private int computerScore = 0;
    private int turns = 0;

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}