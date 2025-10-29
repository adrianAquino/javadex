package com.mycompany.javadex2;

import classes.Pokemon;
import database.Database;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private Label label2;
    private List<Pokemon> pokemons;
    private Pokemon pokemonEscolhido;
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        Database bd = new Database();
        bd.inicialize();
        //pokemons = bd.pokemons;
            

        Button pikachu = new Button(bd.buscaPokemon(25).getNome());
        pikachu.setOnAction(e-> atualizacao());
        Label raichu = new Label(bd.buscaPokemon(26).getNome());
        label2 = new Label("Hellow Word");
        
        StackPane pilha = new StackPane(pikachu);
        ScrollPane tela = new ScrollPane();
        /*
        HBox horizontal = new HBox();
        horizontal.getChildren().add(pikachu);
        horizontal.getChildren().add(raichu);
        horizontal.getChildren().add(label2);
        */
        VBox listaDePokemons = new VBox();
        for(int i = 1; i <=151; i++){
            listaDePokemons.getChildren().add(new Label(bd.buscaPokemon(i).getNome()));
        }
        
        tela.setContent(listaDePokemons);
        
        //vertical.getChildren().add(label2);
        //vertical.getChildren().add(horizontal);
        var scene = new Scene(tela, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void atualizacao(){
        System.out.println("Botão");
    }

}