package com.example.devopsgithubactions.Services;
import org.springframework.stereotype.Component;

//Klass för att returnera ett slumpmässigt tal
@Component
public class RandomNumberGenerator {

    public double generateRandomNumber() {
        return Math.random();
    }
}
