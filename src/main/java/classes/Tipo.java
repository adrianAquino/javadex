/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Tipo {


    String nome;
    private List<Tipo> fraquezas;
    private List<Tipo> resistencias;

    public Tipo(String nome) {
        this.nome = nome;
    }

    public Tipo(String nome, Tipo fraqueza, Tipo resistencia) {
        this.nome = nome;
        this.fraquezas = new ArrayList();
        this.fraquezas.add(fraqueza);
        this.resistencias = new ArrayList();
        this.resistencias.add(resistencia);
    }

    public String getNome() {
        return this.nome;
    }

    public void setFraquezas(List<Tipo> fraquezas) {
        this.fraquezas = new ArrayList();
        for (Tipo t : fraquezas) {
            this.fraquezas.add(t);
        }
    }

    public void addFraqueza(List<Tipo> fraquezas) {
        for (Tipo t : fraquezas) {
            this.fraquezas.add(t);
        }
    }

    public String getFraquezas() {
        String fraquezas = "";
        for (Tipo arnaldo : this.fraquezas) {
            fraquezas += arnaldo.getNome() + "";
        }
        return fraquezas;
    }

    public void setResistencias(List<Tipo> resistencias) {
        this.resistencias = new ArrayList();
        for (Tipo t : resistencias) {
            this.resistencias.add(t);
        }
    }

    public void addResistencias(List<Tipo> resistencias) {
        for (Tipo t : resistencias) {
            this.resistencias.add(t);
        }
    }

    public String getResistencias() {
        String resistencias = "";
        for (Tipo arnaldo : this.resistencias) {
            resistencias += arnaldo.getNome() + "";
        }
        return resistencias;
    }
    
    //////////////////////////////////////////////////////
    //Sobrecarga de método para criar add fraqueza e resistencia sem precisar de criar lista
    public void addFraqueza(Tipo tipo) {
        if (this.fraquezas == null) {
            this.fraquezas = new ArrayList<>();
        }
        this.fraquezas.add(tipo);
    }

    public void addResistencia(Tipo tipo) {
        if (this.resistencias == null) {
            this.resistencias = new ArrayList<>();
        }
        this.resistencias.add(tipo);
    }
    //////////////////////////////////////////////////////

}
