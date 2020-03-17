package de.freedeebee.pongfx;

import de.freedeebee.pongfx.utils.Constants;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        Game game = new Game(canvas);
        Scene scene = new Scene(new StackPane(canvas));
        InputHandler inputHandler = new InputHandler(scene, game);

        stage.setScene(scene);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                GameState gameState = GameState.getInstance();

                if (gameState.isGameOver()) {
                    this.stop();
                }

                game.render();
                inputHandler.move();
                inputHandler.moveBall();

            }
        }.start();

        System.out.println("Someone won");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
