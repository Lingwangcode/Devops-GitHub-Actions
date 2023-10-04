package com.example.devopsgithubactions.Controllers;
import com.example.devopsgithubactions.Services.Game;
import com.example.devopsgithubactions.Model.CoinFlip;
import com.example.devopsgithubactions.Model.RoundResult;
import com.example.devopsgithubactions.Services.RandomNumberGenerator;
import com.example.devopsgithubactions.Services.WinRateCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

//Klass som tillhandahåller endpoints för spelet
//Innefattar instanser av klasserna Game, WinRateCalculator, RoundResult samt RandomNumberGenerator
@Controller

public class CoinFlipController {

    //Here is going to be a conflict
    //test merge conflicts from feature branch
    private List<RoundResult> rounds = new ArrayList<>();
    private final Game game;
    private final WinRateCalculator winRateCalculator;
    private final RandomNumberGenerator randomNumberGenerator;

    @Autowired
    public CoinFlipController(Game game, WinRateCalculator winRateCalculator, RandomNumberGenerator randomNumberGenerator) {
        this.game = game;
        this.winRateCalculator = winRateCalculator;
        this.randomNumberGenerator=randomNumberGenerator;
    }

    //Startsida där användaren väljer heads/tails
    @GetMapping("/")
    public String index(Model model) {
        CoinFlip coinFlip = game.getCoinFlip();
        double winRate = winRateCalculator.calculateWinRate(coinFlip);

        model.addAttribute("userScore", coinFlip.getUserScore());
        model.addAttribute("computerScore", coinFlip.getComputerScore());
        model.addAttribute("turns", coinFlip.getTurns());
        model.addAttribute("winRate", winRate);
        return "index";
    }

    //När användaren valt heads/tails uppdateras sidan med relevant information i /flip-endpointen
    //Användaren fortsätter spela så många omgångar han/hon vill
    @PostMapping("/flip")
    public String publishFlip(@RequestParam String choice, Model model) {
        double resultAsDouble = randomNumberGenerator.generateRandomNumber();
        RoundResult roundResult = game.playGame(choice, resultAsDouble);
        double winRate = winRateCalculator.calculateWinRate(game.getCoinFlip());

        rounds.add(roundResult);
        model.addAttribute("rounds", rounds);
        model.addAttribute("WINNER", roundResult.getWinner() + " WINS!!!!!");
        model.addAttribute("userScore", game.getCoinFlip().getUserScore());
        model.addAttribute("computerScore", game.getCoinFlip().getComputerScore());
        model.addAttribute("turns", game.getCoinFlip().getTurns());
        model.addAttribute("winRate", winRate);

        return "index";
    }
}