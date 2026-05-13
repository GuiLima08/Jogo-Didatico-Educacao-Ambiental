package com.jogo.Controller;

import java.io.IOException;

import com.jogo.App;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button playButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button exitButton;


    @FXML
    private void onPlayPress() throws IOException {
        App.setRoot("game");
    }

    @FXML
    private void onSettingsPress() throws IOException {
        App.setRoot("settings");
    }

    @FXML
    private void onExitPress() throws IOException {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void initialize() {
        // Hint: initialize() will be called when the associated FXML has been completely loaded.
    }
}
