package com.example.devopsgithubactions.Services;
import com.example.devopsgithubactions.Model.CoinFlip;
import com.example.devopsgithubactions.Model.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    @InjectMocks
    private Game mockGame;
    @Mock
    private CoinFlip mockCoinFlip;

    CoinFlip coinFlip;

    @BeforeEach
    void setup() {
        coinFlip = new CoinFlip();
        game = new Game(coinFlip);
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void userWinsWithHeads() {
        RoundResult roundResult = mockGame.playGame("heads", 0.6);
        assertEquals(roundResult.getWinner(), "User");
    }

    @Test
    void userWinsWithTails() {
        RoundResult roundResult = game.playGame("tails", 0.3);
        assertEquals(roundResult.getWinner(), "User");
    }

    @Test
    void userLosesWithHeads() {
        RoundResult roundResult = game.playGame("heads", 0.3);
        assertEquals(roundResult.getWinner(), "Computer");
    }

    @Test
    void userLosesWithTails() {
        RoundResult roundResult = game.playGame("tails", 0.6);
        assertEquals(roundResult.getWinner(), "Computer");
    }

    @Test
    void flipCoinShouldReturnHeads() {
        String result = game.flipCoin(0.6);
        assertEquals(result, "heads");
    }

    @Test
    void flipCoinShouldReturnTails() {
        String result = game.flipCoin(0.3);
        assertEquals(result, "tails");
    }

    @Test
    void choosingHeadMeansComputerGetsTails() {
        String computerChoice = game.calculateComputerChoice("heads");
        assertEquals(computerChoice, "tails");
    }

    @Test
    void choosingTailsMeansComputerGetsHeads() {
        String computerChoice = game.calculateComputerChoice("tails");
        assertEquals(computerChoice, "heads");
    }

    @Test
    void whenChoiceAndResultIsHeadsUserWins() {
        String winner = game.calculateWinner("heads", "heads");
        assertEquals(winner, "User");
    }

    @Test
    void whenChoiceAndResultIsTailsUserWins() {
        String winner = game.calculateWinner("tails", "tails");
        assertEquals(winner, "User");
    }

    @Test
    void whenChoiceEqualsHeadsAndResultEqualsTailsComputerWins() {
        String winner = game.calculateWinner("heads", "tails");
        assertEquals(winner, "Computer");
    }

    @Test
    void whenChoiceEqualsTailsAndResultEqualsHeadsComputerWins() {
        String winner = game.calculateWinner("tails", "heads");
        assertEquals(winner, "Computer");
    }

    @Test
    void whenUserWinsUserScoreIncreases() {
        int oldScore = coinFlip.getUserScore();
        game.updateCoinFlip("User");
        assertTrue(oldScore < coinFlip.getUserScore());
    }

    @Test
    void whenComputerWinsComputerScoreIncreases() {
        int oldScore = coinFlip.getComputerScore();
        game.updateCoinFlip("Computer");
        assertTrue(oldScore < coinFlip.getComputerScore());
    }

    @Test
    void whenUserLosesUserScoreRemains() {
        int oldScore = coinFlip.getUserScore();
        game.updateCoinFlip("Computer");
        assertEquals(oldScore, coinFlip.getUserScore());
    }

    @Test
    void whenComputerLosesComputerScoreRemains() {
        int oldScore = coinFlip.getComputerScore();
        game.updateCoinFlip("User");
        assertEquals(oldScore, coinFlip.getComputerScore());
    }

    @Test
    void whenComputerWinsTurnsIncreases() {
        int oldTurns = coinFlip.getTurns();
        game.updateCoinFlip("Computer");
        assertTrue(oldTurns < coinFlip.getTurns());
    }

    @Test
    void whenUserWinsTurnsIncreases() {
        int oldTurns = coinFlip.getTurns();
        game.updateCoinFlip("User");
        assertTrue(oldTurns < coinFlip.getTurns());
    }

    @Test
    void invalidWinnerInputDoesNotChangeUserScore(){
        int oldScore = coinFlip.getUserScore();
        game.updateCoinFlip("");
        assertEquals(oldScore, coinFlip.getUserScore());
    }
    @Test
    void invalidWinnerInputDoesNotChangeComputerScore() {
        int oldScore = coinFlip.getComputerScore();
        game.updateCoinFlip("");
        assertEquals(oldScore, coinFlip.getComputerScore());
    }
    @Test
    void invalidWinnerInputDoesNotChangeTurns() {
        int oldTurns = coinFlip.getTurns();
        game.updateCoinFlip("");
        assertEquals(oldTurns, coinFlip.getTurns());
    }

    @Test
    void getCoinFlip() {
        assertNotNull(game.getCoinFlip());
    }
}