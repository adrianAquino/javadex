package com.mycompany.javadex2;

import classes.Pokemon;
import classes.Tipo;
import database.Database;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Image obj;
    private ImageView iv;
    private Button tipo1Btn;
    private Button tipo2Btn;
    @Override
    public void start(Stage stage) {
       
        Database bd = new Database();
        bd.inicialize();
            
        poke = new Label("00 - Tela Inicial");
        tipos = new Label("Tipos vem aqui");
        evolucao = new Label("Evolucao vem aqui");
        
        tipo1Btn = new Button();
        tipo2Btn = new Button();
        tipo1Btn.setVisible(false); // Inicialmente escondidos
        tipo2Btn.setVisible(false);
        tipo1Btn.setMinWidth(100);
        tipo2Btn.setMinWidth(100);

  
        VBox listaDePokemons = new VBox();
        listaDePokemons.setAlignment(Pos.CENTER);
        listaDePokemons.setSpacing(3);
        for(int i = 1; i <=151; i++){
            Pokemon laco_repeticao =bd.buscaPokemon(i);
            Button botao = new Button(laco_repeticao.getNome());
            botao.setOnAction(e->atualizacao(laco_repeticao));
            botao.setMinWidth(120);
            listaDePokemons.getChildren().add(botao);
        }
        
        
        ScrollPane scroll_lista = new ScrollPane();
        scroll_lista.setContent(listaDePokemons);
        scroll_lista.setMinWidth(200);
        
        obj = new Image(getClass().getResourceAsStream("/image/poke_nada.png"));
        iv = new ImageView(obj);
        iv.setFitWidth(300);
        iv.setPreserveRatio(true);
        
        HBox tela_principal = new HBox();
        tela_principal.getChildren().add(scroll_lista);
        VBox apresentacao = new VBox();
        apresentacao.setMinWidth(340);
        apresentacao.setAlignment(Pos.TOP_CENTER);
        apresentacao.getChildren().add(poke);
        apresentacao.getChildren().add(iv);
        
        
        HBox informacoes = new HBox(60);
        VBox tipos_tela = new VBox(5);
       
        tipos_tela.setPadding(new Insets(0, 0, 0, 10));
        tipos_tela.getChildren().addAll(tipos, tipo1Btn, tipo2Btn);
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
        iv.setImage(new Image(getClass().getResourceAsStream("/image/" + String.format("%03d",p.getNumero())+ ".png")));
       
       
        tipos.setVisible(false);
        tipos.setManaged(false);
        
        List<Tipo> tiposPokemon = p.getTipos();
        
         tipo1Btn.setVisible(false);
         tipo2Btn.setVisible(false);
         
                if (tiposPokemon != null && !tiposPokemon.isEmpty()) {
               // Mostra o primeiro tipo
               tipo1Btn.setText("Tipo 1: " + tiposPokemon.get(0).getNome());
               tipo1Btn.setVisible(true);
               tipo1Btn.setMinWidth(120);
               tipo1Btn.setAlignment(Pos.CENTER);

               // Se tiver dois tipos, mostra o segundo
               if (tiposPokemon.size() > 1) {
                   tipo2Btn.setText("Tipo 2: " + tiposPokemon.get(1).getNome());
                   tipo2Btn.setVisible(true);
                   tipo2Btn.setMinWidth(120);
                   tipo2Btn.setAlignment(Pos.CENTER);
               }
            }
        
       
        evolucao.setText(p.getEvoluiPara() == null ? " " : "Evolui para: " + p.getEvoluiPara().getNome());
    }

}