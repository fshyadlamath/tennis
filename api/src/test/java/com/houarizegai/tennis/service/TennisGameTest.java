package com.houarizegai.tennis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void setup() {
        tennisGame = new TennisGame();
    }

    @Test
    void shouldReturnLoveAll() {
        String score = tennisGame.getScore();
        assertEquals("Love All", score);
    }

    @Test
    void firstPlayerWinsFirstBall() {
        playersWins(1, 0);
        String score = tennisGame.getScore();

        assertEquals("Fifteen Love", score);
    }

    @Test
    void firstPlayerWinsTwoBall() {
        playersWins(2, 0);
        String score = tennisGame.getScore();

        assertEquals("Thirty Love", score);
    }

    @Test
    void firstPlayerWinsThreeBall() {
        playersWins(3, 0);
        String score = tennisGame.getScore();

        assertEquals("Forty Love", score);
    }

    @Test
    void secondPlayerWinsFirstBall() {
        playersWins(0, 1);
        String score = tennisGame.getScore();

        assertEquals("Love Fifteen", score);
    }

    @Test
    void secondPlayerWinsTwoBall() {
        playersWins(0, 2);
        String score = tennisGame.getScore();

        assertEquals("Love Thirty", score);
    }

    @Test
    void secondPlayerWinsThreeBall() {
        playersWins(0, 3);
        String score = tennisGame.getScore();

        assertEquals("Love Forty", score);
    }

    @Test
    void playersAreDeuce() {
        playersWins(3, 3);
        String score = tennisGame.getScore();

        assertEquals("Deuce", score);
    }

    @Test
    void bothPlayersWinsOneBall() {
        playersWins(1, 1);
        String score = tennisGame.getScore();

        assertEquals("Fifteen All", score);
    }

    private void playersWins(int firstPlayerTimes, int secondPlayerTimes) {
        for(int i = 0; i < firstPlayerTimes; i++) {
            tennisGame.firstPlayerWin();
        }

        for(int i = 0; i < secondPlayerTimes; i++) {
            tennisGame.secondPlayerWin();
        }
    }
}
