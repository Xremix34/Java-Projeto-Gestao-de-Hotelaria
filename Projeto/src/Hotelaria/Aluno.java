package Hotelaria;

import java.io.Serializable;
import java.util.ArrayList;

//Importante ter o serializable para os objetos serem guardados nos ficheiros
public class Aluno implements Serializable {

    private String nome;
    private int numero;
    private static int ultimoAluno = 0; //contador que vai adicionar novos alunos
    private int media;
    private String nomeCurso;

    public Aluno() {
        ultimoAluno++;
        this.nome = nome;
        numero = ultimoAluno;
        this.media = (int) (Math.random()*20);
        nomeCurso = "";

    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static int getUltimoAluno() {
        return ultimoAluno;
    }

    public static void setUltimoAluno(int a) {
        ultimoAluno = a;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;

    }

    public String toString() {
        String s = "Numero de Aluno:" + numero + "\nNome:" + nome + "\nCurso: " + nomeCurso + "\nMedia: " + media;
        return s;
    }

    public String TodosAluno() {
        String s = "";
        System.out.printf("%-12s", s + numero);
        System.out.printf("%-35s", s + "| " + nome);
        System.out.printf("%-35s", s + "| " + nomeCurso);
        System.out.printf("%-35s", s + "| " + media);

        return (s);
    }
    
}
