package com.example.devopsgithubactions.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoundResultTest {

    RoundResult roundResult;
    @BeforeEach
    void setUp(){
        roundResult = new RoundResult("heads", "tails","Computer");
    }

    @Test
    void testGetUserChoice() {
        assertEquals("heads", roundResult.getUserChoice());
    }

    @Test
    void testSetUserChoice() {
        roundResult.setUserChoice("tails");
        assertEquals("tails", roundResult.getUserChoice());
    }

    @Test
    void testGetComputerChoice() {
        assertEquals("tails", roundResult.getComputerChoice());
    }

    @Test
    void testSetComputerChoice() {
        roundResult.setComputerChoice("heads");
        assertEquals("heads", roundResult.getUserChoice());
    }

    @Test
    void testGetWinner() {
        assertEquals("Computer", roundResult.getWinner());
    }

    @Test
    void testSetWinner() {
        roundResult.setWinner("User");
        assertEquals("User", roundResult.getWinner());
    }
}
