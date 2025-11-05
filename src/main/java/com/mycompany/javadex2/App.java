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
    private Label tipos;
    private Label evolucao;
    private Pokemon pokemonEscolhido;
    @Override
    public void start(Stage stage) {
       
        Database bd = new Database();
        bd.inicialize();
            
        poke = new Label("00 - Tela Inicial");
        tipos = new Label("Tipos vem aqui");
        evolucao = new Label("Evolucao vem aqui");
  
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
        VBox apresentacao = new VBox();
        tela_principal.getChildren().add(scroll_lista);
        apresentacao.getChildren().add(poke);
        apresentacao.getChildren().add(iv);
        
        HBox informacoes = new HBox();
        VBox tipos_tela = new VBox();
        tipos_tela.getChildren().add(tipos);
        VBox evolucao_tela = new VBox();
        evolucao_tela.getChildren().add(evolucao);
        
        
        
        
        informacoes.getChildren().add(tipos_tela);
        informacoes.getChildren().add(evolucao_tela);
        apresentacao.getChildren().add(informacoes);
        tela_principal.getChildren().add(apresentacao);
        var scene = new Scene(tela_principal, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void atualizacao(Pokemon p){
        poke.setText(p.getNumero() + " - " +p.getNome());
        tipos.setText(p.getTipoFraquezas());
        evolucao.setText(p.getEvoluiPara() == null ? " " : p.getEvoluiPara().getNome());
    }

}