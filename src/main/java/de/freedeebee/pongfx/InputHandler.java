package de.freedeebee.pongfx;

import javafx.scene.Scene;

public class InputHandler {

    private Scene scene;
    private Screen screen;

    private boolean leftMovingUp;
    private boolean leftMovingDown;
    private boolean rightMovingUp;
    private boolean rightMovingDown;

    private int directionY = -1;
    private int directionX = -1;

    public InputHandler(Scene scene, Screen screen) {
        this.scene = scene;
        this.screen = screen;
        init();
    }

    public void init() {
        scene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case W:
                    leftMovingUp = true;
                    break;
                case S:
                    leftMovingDown = true;
                    break;
                case UP:
                    rightMovingUp = true;
                    break;
                case DOWN:
                    rightMovingDown = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                    leftMovingUp = false;
                    break;
                case S:
                    leftMovingDown = false;
                    break;
                case UP:
                    rightMovingUp = false;
                    break;
                case DOWN:
                    rightMovingDown = false;
                    break;
            }
        });
    }

    public void move() {

        Handle leftHandle = this.screen.getHandleLeft();
        Handle rightHandle = this.screen.getHandleRight();

        if (leftMovingUp && leftHandle.getPosY() >= 0) {
            leftHandle.setPosY(leftHandle.getPosY() - 10);
        }
        if (leftMovingDown && leftHandle.getPosY() + Constants.HANDLE_HEIGHT <= Constants.SCREEN_HEIGHT) {
            leftHandle.setPosY(leftHandle.getPosY() + 10);
        }
        if (rightMovingUp && rightHandle.getPosY() >= 0) {
            rightHandle.setPosY(rightHandle.getPosY() - 10);
        }
        if (rightMovingDown && rightHandle.getPosY() + Constants.HANDLE_HEIGHT <= Constants.SCREEN_HEIGHT) {
            rightHandle.setPosY(rightHandle.getPosY() + 10);
        }
    }

    public void moveBall() {

        Ball ball = this.screen.getBall();

        int speed = 10;

        // TODO: Ball Movement
        if (ball.getPosY() <= 0) {
            directionY = 1;
        } else if (ball.getPosY() + Constants.BALL_SIZE > Constants.SCREEN_HEIGHT) {
            directionY = -1;
        }

        if (ball.getPosX() <= 0) {
            directionX = 1;
        } else if (ball.getPosX() + Constants.BALL_SIZE > Constants.SCREEN_WIDTH) {
            directionX = -1;
        }


        ball.setPosY(ball.getPosY() + directionY * speed);
        ball.setPosX(ball.getPosX() + directionX * speed);


    }


}
