/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.util.List;
import java.util.ArrayList;



/**
 *
 * @author pedro
 */
public class Pokemon {

    
    private int numero;
    private String nome;
    private List<Tipo> tipos;
    private Pokemon evoluiPara; //objeto Pokemon, próximo na linha evolutiva
    //evoluiPara pode ser nulo;
    private int evoluiEm; //Nível pokemon passa para o próxima evolução
    private boolean lendario; //Para especie raras de pokemon
    
    public Pokemon() {
    }
    
    public Pokemon(int numero, String nome,
            List<Tipo> tipos, 
            Pokemon evoluiPara, int evoluiEm, boolean lendario){
        this.numero = numero;
        this.nome = nome;
        this.tipos = new ArrayList();
        for(Tipo t: tipos){
            this.tipos.add(t);
        }
        if(evoluiPara != null){
        this.evoluiPara = new Pokemon();
        this.evoluiPara = evoluiPara;
        this.evoluiEm = evoluiEm;
        
        }
        this.lendario = lendario;
    }
        //Sobrecarga do construtor
     public Pokemon(int numero, String nome,
            List<Tipo> tipos, 
             boolean lendario){
        this.numero = numero;
        this.nome = nome;
        this.tipos = new ArrayList();
        for(Tipo t:tipos){
            this.tipos.add(t);
        }
        this.lendario = lendario;
        
        
    }
    
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setTipos(List<Tipo> tipos){
        this.tipos = new ArrayList();
        for(Tipo tipo: tipos){
            this.tipos.add(tipo);
        }
    }
    
    public String getTipoFraquezas(){
        String aux= "";
        for(Tipo t: this.tipos){
            aux += t.getFraquezas();
        }
        return aux;
    }
    public String getTipoResistencias(){
        String tipos = "";
        for(Tipo t:this.tipos){
            tipos += t.getResistencias();
        }
        return tipos;
    }
    
    public List<Tipo> getTipos(){
         return this.tipos;
    }
    
    public Pokemon getEvoluiPara(){
        return this.evoluiPara;
    }
    public int getEvoluiEm(){
        return this.evoluiEm;
    }
    
    public boolean isLendario(){
        return this.lendario;
    }
    
    public void setEvoluiPara(Pokemon pokemon){
        this.evoluiPara = new Pokemon();
        this.evoluiPara = pokemon;
    }
    
    public void setEvoluiEm(int nivel){
        this.evoluiEm = nivel;
    }
    
    public void setLendario( boolean lendario){
        this.lendario = lendario;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return this.nome + " - " + this.numero;
    }
    
    
}



