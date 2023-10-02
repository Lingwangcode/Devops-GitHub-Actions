package com.example.devopsgithubactions.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinFlipTest {

    CoinFlip coinFlip;
    @BeforeEach
    void setUp() {
        coinFlip = new CoinFlip();
    }

    @Test
    void testGetUserScore() {
        assertEquals(0, coinFlip.getUserScore());
    }

    @Test
    void testSetUserScore() {
        coinFlip.setUserScore(2);
        assertEquals(2, coinFlip.getUserScore());
    }

    @Test
    void testGetComputerScore() {
        assertEquals(0, coinFlip.getComputerScore());
    }

    @Test
    void testSetComputerScore() {
        coinFlip.setComputerScore(3);
        assertEquals(3, coinFlip.getComputerScore());
    }

    @Test
    void testGetTurns() {
        assertEquals(0, coinFlip.getTurns());
    }

    @Test
    void testSetTurns() {
        coinFlip.setTurns(5);
        assertEquals(5, coinFlip.getTurns());
    }
}
