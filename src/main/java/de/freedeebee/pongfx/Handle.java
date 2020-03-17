package de.freedeebee.pongfx;

public class Handle {

    private boolean isRightHandle;

    private int posX;
    private int posY;

    public Handle() {
        this.isRightHandle = false;
        this.posX = 10;
        this.posY = Constants.SCREEN_HEIGHT / 2 - Constants.HANDLE_HEIGHT / 2;
    }

    public Handle(boolean isRightHandle) {
        this.isRightHandle = isRightHandle;
        this.posX = Constants.SCREEN_WIDTH - 10 - Constants.HANDLE_WIDTH;
        this.posY = Constants.SCREEN_HEIGHT / 2 - Constants.HANDLE_HEIGHT / 2;
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
