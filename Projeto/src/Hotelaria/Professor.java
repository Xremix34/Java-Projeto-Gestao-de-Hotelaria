package Hotelaria;

import java.io.Serializable;
import java.util.ArrayList;


public class Professor implements Serializable {

    private String nome;
    private double salario;
    private static int ultimo = 0;
    private int num;
    private ArrayList<Disciplina> disciplinasLecionadas;

    
    public Professor() {
        ultimo++;
        num = ultimo;
        nome = "";
        this.salario = salario;
        disciplinasLecionadas = new ArrayList<Disciplina>();

    }

    public ArrayList<Disciplina> getDisciplinasLecionadas() {
        return disciplinasLecionadas;
    }

    public void setDisciplinasLecionadas(ArrayList<Disciplina> disciplinasLecionadas) {
        this.disciplinasLecionadas = disciplinasLecionadas;
    }


    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int a) {
        Professor.ultimo = a;
    }

    public long getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString() {
        String s = "Numero de Professor: " + num + "\nNome: " + nome + "\nDisciplinas: "+disciplinasLecionadas+"\nGanha: " + salario + "€";
        return s;
    }


    public void aumentaSal(double aumento) {
        salario = salario + salario * aumento / 100;
    }

    public String TodosProf() {
        String s = "";
        System.out.printf("%-16s", s + num);
        System.out.printf("%-35s", s + "| " + nome);
        System.out.printf("%-35s", s + "| " + salario);
        
        for (int i = 0; i < disciplinasLecionadas.size(); i++) {
            System.out.printf("%-10s", s + "| " + disciplinasLecionadas.get(i).getNome());
        }

        return (s);
    }

}
