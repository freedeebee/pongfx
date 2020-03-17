package de.freedeebee.pongfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Screen {

    private final Canvas canvas;
    private final GraphicsContext ctx;

    private Handle handleLeft;
    private Handle handleRight;
    private Ball ball;

    public Screen(int width, int height) {
        this.canvas = new Canvas(width, height);
        this.ctx = canvas.getGraphicsContext2D();
        this.handleLeft = new Handle();
        this.handleRight = new Handle(true);
        this.ball = new Ball();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getCtx() {
        return ctx;
    }

    public void render() {

        // clear screen
        ctx.setFill(Color.WHITE);
        ctx.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        // draw left handle
        ctx.setFill(Color.BLACK);
        ctx.fillRect(handleLeft.getPosX(), handleLeft.getPosY(), Constants.HANDLE_WIDTH, Constants.HANDLE_HEIGHT);

        // draw right handle
        ctx.fillRect(handleRight.getPosX(), handleRight.getPosY(), Constants.HANDLE_WIDTH, Constants.HANDLE_HEIGHT);

        // draw ball
        ctx.fillRect(ball.getPosX(), ball.getPosY(), Constants.BALL_SIZE, Constants.BALL_SIZE);
    }

    public Handle getHandleLeft() {
        return handleLeft;
    }

    public Handle getHandleRight() {
        return handleRight;
    }

    public Ball getBall() {
        return ball;
    }
}
