package Hotelaria;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private static int ultimaDis = 0;
    private int cod;
    private String nome;
    private double horaInicio;
    private double horaFim;
    private String diaSemana;

    public Disciplina(String nome) {
        ultimaDis++;
        cod = ultimaDis;
        this.nome = nome;
        diaSemana = "";
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public double getHoraInicio() {
        return horaInicio;
    }

    public double getHoraFim() {
        return horaFim;
    }

    public static void setUltimaDis(int ultimaDis) {
        Disciplina.ultimaDis = ultimaDis;
    }

    public static int getUltimaDis() {
        return ultimaDis;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        String s = " \nCod_" + cod + " UC: " + nome +  "\nHorário: "+ diaSemana +"\n"+ horaInicio + " - " + horaFim ;
        return s;
    }

}
