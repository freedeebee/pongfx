package de.freedeebee.pongfx;

import de.freedeebee.pongfx.gameobjects.Ball;
import de.freedeebee.pongfx.gameobjects.Handle;
import de.freedeebee.pongfx.utils.Constants;
import javafx.application.Platform;
import javafx.scene.Scene;

public class InputHandler {

    private Scene scene;
    private Game game;

    private boolean leftMovingUp;
    private boolean leftMovingDown;
    private boolean rightMovingUp;
    private boolean rightMovingDown;

    private int directionY = -1;
    private int directionX = -1;

    public InputHandler(Scene scene, Game game) {
        this.scene = scene;
        this.game = game;
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
                case ESCAPE:
                    Platform.exit();
                    System.exit(0);
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

        Handle leftHandle = this.game.getHandleLeft();
        Handle rightHandle = this.game.getHandleRight();

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

        GameState gameState = GameState.getInstance();

        Ball ball = this.game.getBall();
        Handle leftHandle = this.game.getHandleLeft();
        Handle rightHandle = this.game.getHandleRight();

        if (ball.getPosY() <= 0) {
            directionY = 1;
        } else if (ball.getPosY() + Constants.BALL_SIZE > Constants.SCREEN_HEIGHT) {
            directionY = -1;
        }

        if (ball.getPosX() <= 0) {
            // Win Right
            gameState.setGameOver(true);
        } else if (ball.getPosX() + Constants.BALL_SIZE > Constants.SCREEN_WIDTH) {
            // Win left
            gameState.setGameOver(true);
        }

        if (ball.getPosX() < leftHandle.getPosX() + Constants.HANDLE_WIDTH && ball.getPosY() > leftHandle.getPosY() && ball.getPosY() + Constants.BALL_SIZE < leftHandle.getPosY() + Constants.HANDLE_HEIGHT) {
            directionX = 1;
        } else if (ball.getPosX() + Constants.BALL_SIZE > rightHandle.getPosX() && ball.getPosY() + Constants.BALL_SIZE > rightHandle.getPosY() && ball.getPosY() < rightHandle.getPosY() + Constants.HANDLE_HEIGHT ) {
            directionX = -1;
        }


        ball.setPosY(ball.getPosY() + directionY * Constants.BALL_SPEED);
        ball.setPosX(ball.getPosX() + directionX * Constants.BALL_SPEED);


    }


}
