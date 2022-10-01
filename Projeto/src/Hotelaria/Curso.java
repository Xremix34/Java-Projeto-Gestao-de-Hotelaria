package Hotelaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable {

  
    private ArrayList<Disciplina> disciplina;
    private static int ultimoCurso;
    private int codigo;
    private String nome;

    public Curso() {

        disciplina = new ArrayList<>();
        ultimoCurso++;
        codigo = ultimoCurso;
        this.nome = "none";

    }

    public String toString() {

        String s = "Codigo: "+codigo+"\nCurso: " +  nome + "\nDisciplinas: " + disciplina.toString().replace("[", "").replace("]", "") + "\n";
        return s;
    }

    public String toStringConsulta(){
        String s = "Curso: "+nome+"\nDisciplinas: "+disciplina ;
        return s;
    }

    public String toStringDis(){
        String s = "\nDisciplinas: " + disciplina.toString().replace("[", "").replace("]", "") + "\n";
        return s;
    }

    public static int getUltimoCurso() {
        return ultimoCurso;
    }

    public static void setUltimoCurso(int a) {
        ultimoCurso = a;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.disciplina = (ArrayList<Disciplina>)disciplina.clone();
    }
    
 
    public void addDisciplinas(Disciplina disciplina){
        if(!this.disciplina.contains(disciplina))
            this.disciplina.add(disciplina);
        
    }
    
    public void removeDis(Disciplina disciplina){
        this.disciplina.remove(disciplina);
    }
    
  

}
