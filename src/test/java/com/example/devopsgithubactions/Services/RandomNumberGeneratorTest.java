package com.example.devopsgithubactions.Services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setup() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void generateRandomNumberShouldReturnAtLeast0() {
        assertTrue(randomNumberGenerator.generateRandomNumber() >= 0);
    }

    @Test
    void generateRandomNumberShouldReturnLessThan1() {
        assertTrue(randomNumberGenerator.generateRandomNumber() < 1);
    }

}
