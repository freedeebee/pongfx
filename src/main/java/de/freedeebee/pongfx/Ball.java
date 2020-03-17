package de.freedeebee.pongfx;

public class Ball {

    private int posX;
    private int posY;

    public Ball() {
        this.posX = Constants.SCREEN_WIDTH / 2 - Constants.BALL_SIZE / 2;
        this.posY = Constants.SCREEN_HEIGHT / 2 - Constants.BALL_SIZE / 2;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
