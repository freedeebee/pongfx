package de.freedeebee.pongfx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Screen screen = new Screen(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        Scene scene = new Scene(new StackPane(screen.getCanvas()));
        InputHandler inputHandler = new InputHandler(scene, screen);

        stage.setScene(scene);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                screen.render();
                inputHandler.move();
                inputHandler.moveBall();
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
