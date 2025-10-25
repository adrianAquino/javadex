package com.mycompany.javadex2;

import classes.Pokemon;
import database.Database;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        Database bd = new Database();
            bd.inicialize();
            

        var pikachu = new Label(bd.buscaPokemon(25).getNome());
        var raichu = new Label(bd.buscaPokemon(26).getNome());
        var label2 = new Label("Hellow Word");
        //StackPane pilha = new StackPane(pikachu);
        VBox vertical = new VBox();
        HBox horizontal = new HBox();
        
        horizontal.getChildren().add(pikachu);
        horizontal.getChildren().add(raichu);
        
        
        vertical.getChildren().add(label2);
        vertical.getChildren().add(horizontal);
        var scene = new Scene(vertical, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}