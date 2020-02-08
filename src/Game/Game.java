package Game;

import Tools.ImageLoader;
import Tools.SpriteSheet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends Application implements Runnable {
    //project data
    private int width = 1920;
    private int height = 1080;
    private ResizableCanvas canvas;
    private Thread thread;
    private boolean gameloop = false;
    private String gameTitle = "Niciarex";

    //images
    private BufferedImage testImage; // Testimage initialiseren
    private SpriteSheet sheet;

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("Starting stage....");

        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);


        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1) {
                    last = now;
                }
                update((now - last) / 1000000000.0);
                last = now;
                draw(g2d);
            }
        }.start();

        stage.setScene(new Scene(mainPane, width, height));
        stage.setTitle(gameTitle);
        stage.show();

    }

    public void init() {
        testImage = ImageLoader.loadImage("/Textures/spritesheetfilled1.png"); // Voorbeeld van het laden en initializen van een image, als test
            sheet = new SpriteSheet(testImage);
        // Voor het tekenen van deze image:  graphics.drawImage(testImage, 0, 0, null);

        //spritesheet = ImageLoader.loadImage("sprite.png");
    }

    public void draw(FXGraphics2D graphics) {
        //graphics.drawImage( sheet.crop(32,0, 35, 51), 5,5, null); // using the crop method

        graphics.setBackground(Color.white);

        //Eerst het scherm leeg maken
        graphics.clearRect(0, 0, 1920, 1080);
        graphics.drawImage(testImage, 0, 0, null); // drawing a simple image

        // Hier begin ik met tekenen





        // Hier stop ik het tekenen
        graphics.dispose();

    }

    public void update(double deltaTime) {

    }


    public static void main(String[] args) {
        launch(Game.class);
    }

    @Override
    public void run() {
        init();
        while (gameloop) {
            update(100000);

        }

        stop();
    }

    public synchronized void start() {
        if (gameloop) {
            return;
        }
        gameloop = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!gameloop) {
            return;
        }

        gameloop = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
