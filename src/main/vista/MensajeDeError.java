package vista;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class MensajeDeError {

    public SequentialTransition generarAvisoParpadeante () {
        Label label = new Label("Blinking");
        label.setStyle("-fx-text-fill: red; -fx-padding: 10px;");

        Timeline blinker = createBlinker(label);
        blinker.setOnFinished(event -> label.setText("Fading"));
        FadeTransition fader = createFader(label);

        SequentialTransition blinkThenFade = new SequentialTransition(label, blinker,fader);

        return blinkThenFade;
    }

    private Timeline createBlinker(Node node) {
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        new KeyValue(
                                node.opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.5),
                        new KeyValue(
                                node.opacityProperty(),
                                0,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(
                                node.opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(3);

        return blink;
    }

    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(2), node);
        fade.setFromValue(1);
        fade.setToValue(0);

        return fade;
    }
}
