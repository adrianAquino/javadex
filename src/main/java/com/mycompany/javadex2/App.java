package com.mycompany.javadex2;

import classes.Pokemon;
import classes.Tipo;
import database.Database;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;


/**
 * JavaFX App
 */
public class App extends Application {
    //Variaveis Globais
    private Label poke;
    private Pokemon pokemonEscolhido;
    @Override
    public void start(Stage stage) {
       
        Database bd = new Database();
        bd.inicialize();
            
         poke = new Label("Hellow Word");
        
  
        VBox listaDePokemons = new VBox();
        for(int i = 1; i <=151; i++){
            Pokemon laco_repeticao =bd.buscaPokemon(i);
            Button botao = new Button(laco_repeticao.getNome());
            botao.setOnAction(e->atualizacao(laco_repeticao));
            listaDePokemons.getChildren().add(botao);
        }
        
        
        ScrollPane scroll_lista = new ScrollPane();
        scroll_lista.setContent(listaDePokemons);
        
        Image obj = new Image(getClass().getResourceAsStream("/image/151.png"));
        ImageView iv = new ImageView(obj);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        
        HBox tela_principal = new HBox();
        tela_principal.getChildren().add(scroll_lista);
        VBox apresentacao = new VBox();
        apresentacao.getChildren().add(poke);
        apresentacao.getChildren().add(iv);
        tela_principal.getChildren().add(apresentacao);
        var scene = new Scene(tela_principal, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void atualizacao(Pokemon p){
        poke.setText(p.getNome());
    }

}