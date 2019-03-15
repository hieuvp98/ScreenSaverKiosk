package fx;

import animation.FadeIn;
import animation.FadeOut;
import data.AppImageService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import transition.FadeOutFadeIn;

import java.util.List;

public class FXBuilder {

    private List<Image> images;
    private int next;
    private JFXPanel jfxPanel;
    private static final int LOOP_TIME = 8000;

    public FXBuilder(JFXPanel jfxPanel){
        System.out.println("loading resource...");
        images = new AppImageService().findAllImage();
        System.out.println("finish");
        this.jfxPanel = jfxPanel;
    }

    public JFXPanel build(){
        next = 1;
        ImageView[] imageView = new ImageView[2];
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root,jfxPanel.getWidth(),jfxPanel.getHeight());
        scene.getRoot().requestFocus();
        for (int i = 1; i >= 0; i--) {
            imageView[i] = new ImageView();
            imageView[i].setFitWidth(jfxPanel.getWidth());
            imageView[i].setFitHeight(jfxPanel.getHeight());
            root.getChildren().add(imageView[i]);
        }
        imageView[0].setImage(images.get(0));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(LOOP_TIME), event -> {
            new FadeOutFadeIn(imageView[0], imageView[1], images.get(next), new FadeOut(imageView[0]), new FadeIn(imageView[1])).start();
            if (next == images.size() - 1) {
                next = 0;
            } else {
                next++;
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();
        jfxPanel.setScene(scene);
        jfxPanel.requestFocus();
        return this.jfxPanel;
    }

}
