package com.example.devopsgithubactions.Services;
import com.example.devopsgithubactions.Model.CoinFlip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinRateCalculatorTest {

    WinRateCalculator winRateCalculator;
    CoinFlip coinFlip;

    @BeforeEach
    void setup (){
        winRateCalculator = new WinRateCalculator();
        coinFlip = new CoinFlip();
    }

    @Test
    void calculateWinRateStartsAt0() {
        assertEquals(winRateCalculator.calculateWinRate(coinFlip), 0);
    }

    @Test
    void whenUserHasWonAllWinRateIs100() {
        coinFlip.setTurns(1);
        coinFlip.setUserScore(1);
        assertEquals(winRateCalculator.calculateWinRate(coinFlip), 100);
    }

    @Test
    void whenUserHasLostAllWinRateIsZero() {
        coinFlip.setTurns(1);
        coinFlip.setUserScore(0);
        assertEquals(winRateCalculator.calculateWinRate(coinFlip), 0);
    }

    @Test
    void whenUserHasWonHalfWinRateIs50() {
        coinFlip.setTurns(2);
        coinFlip.setUserScore(1);
        assertEquals(winRateCalculator.calculateWinRate(coinFlip), 50);
    }
}
