package com.jogo.Controller;

import java.io.IOException;

import com.jogo.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsController { // TODO: Implementar opções (música?)
    @FXML
    private Button backButton;

    @FXML
    private void onBackPress() throws IOException {
        App.setRoot("main-menu");
    }

    @FXML
    private void initialize() {
        // Hint: initialize() will be called when the associated FXML has been completely loaded.
    }
}