package com.example.devopsgithubactions.Services;
import com.example.devopsgithubactions.Model.CoinFlip;
import org.springframework.stereotype.Component;

//Klass för att räkna ut användarens vinstfrekvens i procent
@Component
public class WinRateCalculator {
    public double calculateWinRate(CoinFlip coinFlip) {
        if (coinFlip.getTurns() == 0) {
            return 0.0;
        }
        return ((double) coinFlip.getUserScore() / coinFlip.getTurns()) * 100;
    }
}
