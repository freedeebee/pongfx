package de.freedeebee.pongfx;

public class GameState {

    private static GameState instance;

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    private GameState() {
        this.gameOver = false;
    }

    private boolean gameOver;



    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
