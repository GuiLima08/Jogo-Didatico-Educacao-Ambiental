package com.jogo.Controller;

import com.jogo.App;
import com.jogo.Model.Event;
import com.jogo.Model.EventLibrary;
import com.jogo.Model.Option;
import com.jogo.Model.Player;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class GameController {
    @FXML private AnchorPane root;
    @FXML private AnchorPane healthPane;
    @FXML private AnchorPane naturePane;
    @FXML private AnchorPane waterPane;
    @FXML private AnchorPane peoplePane;
    @FXML private AnchorPane moneyPane;
    @FXML private VBox choiceVBox;
    @FXML private VBox resultVBox;
    @FXML private Label resultLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label titleLabel;
    @FXML private Button continueButton;
    @FXML private Button optionALabel;
    @FXML private Button optionBLabel;
    @FXML private ProgressBar hpBar;
    @FXML private ProgressBar natureBar;
    @FXML private ProgressBar waterBar;
    @FXML private ProgressBar peopleBar;
    @FXML private ProgressBar moneyBar;

    private Player player; 
    private Event event;
    private Option optA;
    private Option optB;
    private Random rand;

    private final String deathHealthText = "placeholder health death";
    private final String deathNatureText = "placeholder nature death";
    private final String deathWaterText = "placeholder water death";
    private final String deathPeopleText = "placeholder people death";
    private final String deathMoneyText = "placeholder money death";

    private boolean alive;

    @FXML
    private void initialize() {
        player = new Player();
        rand = new Random();
        alive = true;
        hpBar.progressProperty().bind(
            player.healthProperty().divide(100.0)
        );
        natureBar.progressProperty().bind(
            player.natureProperty().divide(100.0)
        );
        waterBar.progressProperty().bind(
            player.waterProperty().divide(100.0)
        );
        peopleBar.progressProperty().bind(
            player.peopleProperty().divide(100.0)
        );
        moneyBar.progressProperty().bind(
            player.moneyProperty().divide(100.0)
        );

        disableVBox(choiceVBox);
        disableVBox(resultVBox);
        setNewEvent();
    }

    
    @FXML
    private void onOptAPress(){
        setResultScreen(optA);
    }
    
    @FXML
    private void onOptBPress(){
        setResultScreen(optB);
    }

    @FXML
    private void onContinuePress() throws IOException{
        if (alive)
        {
            if (player.getHealth() <= 0){
                setDead(deathHealthText);

                return;
            } else if (player.getNature() <= 0){
                setDead(deathNatureText);
                
                return;
            } else if (player.getWater()  <= 0){
                setDead(deathWaterText);
                
                return;
            } else if (player.getPeople() <= 0){
                setDead(deathPeopleText);
                
                return;
            } else if (player.getMoney()  <= 0){
                setDead(deathMoneyText);
                
                return;
            }
            setNewEvent();
            return;
        }

        App.setRoot("main-menu");
    }

    /**
     * Marca o jogo como perdido, colocando mensagem de "morte" e trocando a cor.
     * @param deathMsg Mensagen de morte, específico pra cada tipo de morte.
     */
    private void setDead(String deathMsg){
        resultLabel.setText(deathMsg);
        alive = false;
        setDeathColors();
    }

    /**
     * Habilita uma VBox.
     * @param vBox resultVBox ou choiceVBox.
     */
    private void enableVBox(VBox vBox){
        vBox.disableProperty().set(false);
        vBox.visibleProperty().set(true);
    }

    /**
     * Desabilita uma VBox.
     * @param vBox resultVBox ou choiceVBox.
     */
    private void disableVBox(VBox vBox){
        vBox.disableProperty().set(true);
        vBox.visibleProperty().set(false);
    }

    /**
     * Muda para tela de resultado.
     * @param option optA ou optB.
     */
    private void setResultScreen(Option option){
        disableVBox(choiceVBox);

        resultLabel.setText(option.getResult());
        player.addStats(option.getStats());

        enableVBox(resultVBox);
    }

    /**
     * Coloca cor vermelha (morte).
     */
    private void setDeathColors(){
        root            .getStyleClass().add("root-death");
        resultLabel     .getStyleClass().add("label-death");
        continueButton  .getStyleClass().add("button-death");
        continueButton  .getStyleClass().add("button-death:hover"); // TODO: Consertar
    }

    /**
     * Remove cor vermelha.
     */
    private void removeDeathColors(){
        root.getStyleClass().remove("root-death");
        resultLabel.getStyleClass().remove("label-death");
        continueButton.getStyleClass().remove("button-death");
        continueButton.getStyleClass().remove("button-death:hover"); // TODO: Consertar
    }
    
    /**
     * Gera um novo evento e coloca na tela.
     */
    private void setNewEvent(){
        disableVBox(resultVBox);
        removeDeathColors();
        
        int eventId = rand.nextInt(EventLibrary.values().length);
        event = EventLibrary.buscarPorId(eventId);
        // TODO: Tratar do ID 0 quando adicionar mais eventos
        optA = event.getOptA();
        optB = event.getOptB();
        
        titleLabel.setText(event.getTitle());
        descriptionLabel.setText(event.getDesc());
        optionALabel.setText(optA.getDesc());
        optionBLabel.setText(optB.getDesc());

        enableVBox(choiceVBox);
    }
}
