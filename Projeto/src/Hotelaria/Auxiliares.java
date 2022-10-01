package Hotelaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Auxiliares {

    //Criar a pasta 'data'
    public static final String FILE_PATH = "./data/";

    public static void saveToFilePr(ArrayList<Professor> al) {
        if (al != null) {
            try {
                FileOutputStream file = new FileOutputStream(FILE_PATH + "professor.ser");
                ObjectOutputStream outStream = new ObjectOutputStream(file);
                outStream.writeInt(Professor.getUltimo());
                outStream.writeObject(al);
                outStream.flush();
                outStream.close();
                file.close();
            } catch (IOException e) {
                System.out.println("Erro a gravar ficheiro de professores!\n" + e.getCause());
            } catch (Exception e) {
                System.out.println("Erro a desconhecido ao gravar ficheiro de professores!\n" + e.getMessage());
            }
        }
    }

    public static void saveToFileAl(ArrayList<Aluno> al) {
        if (al != null) {
            try {
                FileOutputStream file = new FileOutputStream(FILE_PATH + "aluno.ser");
                ObjectOutputStream outStream = new ObjectOutputStream(file);
                outStream.writeInt(Aluno.getUltimoAluno());
                outStream.writeObject(al);
                outStream.flush();
                outStream.close();
                file.close();
            } catch (IOException e) {
                System.out.println("Erro a gravar ficheiro de alunos!\n" + e.getCause());
            } catch (Exception e) {
                System.out.println("Erro a desconhecido ao gravar ficheiro de alunos!\n" + e.getMessage());
            }
        }
    }

    public static void saveToFileCu(ArrayList<Curso> al) {
        if (al != null) {
            try {
                FileOutputStream file = new FileOutputStream(FILE_PATH + "curso.ser");
                ObjectOutputStream outStream = new ObjectOutputStream(file);
                outStream.writeInt(Curso.getUltimoCurso());
                outStream.writeObject(al);
                outStream.flush();
                outStream.close();
                file.close();
            } catch (IOException e) {
                System.out.println("Erro a gravar ficheiro de cursos! :" + e.getCause());
            } catch (Exception e) {
                System.out.println("Erro a desconhecido ao gravar ficheiro de cursos!\n" + e.getMessage());
            }
        }
    }

    public static ArrayList<Professor> ReadFromFilePr() {
        ArrayList<Professor> al = new ArrayList<Professor>();
        int ultimo = 0;
        try {
            FileInputStream file = new FileInputStream(FILE_PATH + "professor.ser");
            ObjectInputStream inStream = new ObjectInputStream(file);
            ultimo = (int) inStream.readInt();
            al = (ArrayList<Professor>) inStream.readObject();
            inStream.close();
            file.close();
        } catch (Exception e) {
            
        }
        Professor.setUltimo(ultimo);
        return (al);
    }
//tranformar aluno em arraylist

    public static ArrayList<Aluno> ReadFromFileAl() {
        ArrayList<Aluno> al = new ArrayList<Aluno>();
        int ultimo = 0;
        try {
            FileInputStream file = new FileInputStream(FILE_PATH + "aluno.ser");
            ObjectInputStream inStream = new ObjectInputStream(file);
            ultimo = (int) inStream.readInt();
            al = (ArrayList<Aluno>) inStream.readObject();
            inStream.close();
            file.close();
        } catch (Exception e) {
        }
        Aluno.setUltimoAluno(ultimo);
        return (al);
    }

    public static ArrayList<Curso> ReadFromFileCu() {
        ArrayList<Curso> al = new ArrayList<Curso>();
        int ultimo = 0;
        try {
            FileInputStream file = new FileInputStream(FILE_PATH + "curso.ser");
            ObjectInputStream inStream = new ObjectInputStream(file);
            ultimo = (int) inStream.readInt();
            al = (ArrayList<Curso>) inStream.readObject();
            inStream.close();
            file.close();
        } catch (Exception e) {
        }
        Curso.setUltimoCurso(ultimo);
        return (al);
    }

    public static Professor verificaProfessor(int num, ArrayList<Professor> al) {
        for (int i = 0; i < al.size(); i++) {
            if (num == al.get(i).getNum()) {
                return al.get(i);
            }
        }
        return (null);
    }

    public static Curso verificaCurso(int numeroCurso, ArrayList<Curso> al) {
        for (int i = 0; i < al.size(); i++) {
            if (numeroCurso == al.get(i).getCodigo()) {
                return al.get(i);
            }
        }
        return (null);
    }

    
    public static Aluno verificaAluno(int numAluno, ArrayList<Aluno> al) {
        for (int i = 0; i < al.size(); i++) {
            if (numAluno == al.get(i).getNumero()) {
                return al.get(i);
            }
        }
        return (null);
    }
    
     public static void clearScreen() {  
        for (int i = 0; i < 64; i++) {
            System.out.println("");
            
        }
   }

}
