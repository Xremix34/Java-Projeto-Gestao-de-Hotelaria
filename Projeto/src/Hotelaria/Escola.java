package Hotelaria;

import java.io.IOException;
import java.util.ArrayList;
import myinputs.Ler;

public class Escola {

    private static ArrayList<Professor> alProfessor;
    private static ArrayList<Aluno> alAluno;
   // private static ArrayList<Curso> hotelaria;

    public static void main(String[] args) throws IOException {

        //Os Cursos Criados a seguir sao apenas para testes. Podendo ser alterados apagados ou rescriados
        // arrayList de cursos 
        ArrayList<Curso> hotelaria = new ArrayList<>();

        
        //hotelaria.get(0) --> é o curso criado
        Curso turismo = new Curso();

        //adicionar uma disciplina ao curso criado
        turismo.setNome("Turismo");
        Disciplina es= new Disciplina("Espanhol");
        es.setDiaSemana("Terça");
        es.setHoraInicio(10);
        es.setHoraFim(12);
        turismo.addDisciplinas(es);
        
        Disciplina hi = new Disciplina("Historia");
        hi.setDiaSemana("Quinta");
        hi.setHoraInicio(10);
        hi.setHoraFim(12);
        turismo.addDisciplinas(hi);
       
        Disciplina ti = new Disciplina("Turismo Internacional");
        ti.setDiaSemana("Quinta");
        ti.setHoraInicio(10);
        ti.setHoraFim(12);
        turismo.addDisciplinas(ti);

        
        hotelaria.add(turismo);


        Curso hotel = new Curso();
        hotel.setNome("Hotelaria");
        Disciplina ho = new Disciplina("Ingles");
        ho.setDiaSemana("Terça");
        ho.setHoraInicio(10);
        ho.setHoraFim(12);
        hotel.addDisciplinas(ho);

        Disciplina ge = new Disciplina("Gestao Hoteleira");
        ge.setDiaSemana("Quinta");
        ge.setHoraInicio(10);
        ge.setHoraFim(12);
        hotel.addDisciplinas(ge);

        Disciplina ec = new Disciplina("Economia");
        ec.setDiaSemana("Sexta");
        ec.setHoraInicio(14);
        ec.setHoraFim(16);
        hotel.addDisciplinas(ec);
        hotelaria.add(hotel);

        // Curso Restauração e a criação das suas 3 disciplinas
        Curso restauração = new Curso();

        restauração.setNome("Restauracao");

        Disciplina ca = new Disciplina("Controlo Alimentar");
        ca.setDiaSemana("Segunda");
        ca.setHoraInicio(9);
        ca.setHoraFim(11);
        restauração.addDisciplinas(ca);

        Disciplina ta = new Disciplina("Tecnologia Alimentar");
        ta.setDiaSemana("Terça");
        ta.setHoraInicio(13);
        ta.setHoraFim(15);
        restauração.addDisciplinas(ta);

        Disciplina sr = new Disciplina("Servicos e Restauracao");
        sr.setDiaSemana("Quinta");
        sr.setHoraInicio(11);
        sr.setHoraFim(13);
        restauração.addDisciplinas(sr);

        hotelaria.add(restauração);

       // Auxiliares.saveToFileCu(hotelaria);
        // Instanciar e inicializar a ArrayList 
        alProfessor = new ArrayList<Professor>();
        alProfessor = Auxiliares.ReadFromFilePr();

        alAluno = new ArrayList<Aluno>();
        alAluno = Auxiliares.ReadFromFileAl();

        //alCurso = new ArrayList<Curso>();
        hotelaria = Auxiliares.ReadFromFileCu();

        int op;
        do {
            // Auxiliares.clearScreen();
            System.out.println("");
            System.out.println("  *------------------*");
            System.out.println("--| Escola Hotelaria |-- ");
            System.out.println("  *------------------*");
            System.out.println("");
            System.out.println("Escolha a sua opção:");
            System.out.println("");
            System.out.println("1: Professor");
            System.out.println("2: Aluno");
            System.out.println("3: Curso");
            System.out.println("0: Sair");

            System.out.print("\n -->  ");
            op = myinputs.Ler.umInt();

            switch (op) {
                case 1:
                    menuProfessor(hotelaria);

                    break;
                case 2:
                    menuAluno(hotelaria);
                    break;
                case 3:
                    menuCurso(hotelaria);
                    break;

            }

        } while (op != 0);

        Auxiliares.saveToFilePr(alProfessor);
        Auxiliares.saveToFileAl(alAluno);
        Auxiliares.saveToFileCu(hotelaria);

    }

    //tem de receber a arrayList de cursos 
    public static void menuAluno(ArrayList<Curso> hotelaria) {
        int op;
        int numA;
        Aluno a1;

        String nome;

        do {
            System.out.println("*-------------------------------*");
            System.out.println("|  MENU ALUNO                   |"); 
            System.out.println("*-------------------------------*\n");
            System.out.println("");
            System.out.println("O que pretende fazer:  ");
            System.out.println("1: Criar aluno");
            System.out.println("2: Consultar");
            System.out.println("3: Modificar um aluno");
            System.out.println("4: Apagar um aluno");
            System.out.println("5: Consultar todos os alunos");
            System.out.println("6: Melhor Aluno");

            System.out.print("\n -->  ");
            op = myinputs.Ler.umInt();
            a1 = new Aluno();
            switch (op) {
                case 1:
                    Auxiliares.clearScreen();
                    System.out.println("-- Novo Aluno --");

                    System.out.print("Nome : ");
                    a1.setNome(Ler.umaString());

                    System.out.println("\n*----------------------------------------------------------------------------------*");
                    System.out.println("  |  ESCOLHA UM DOS SEGUINTES CURSOS ESCREVENDO O NOME EXATAMENTE COMO ESTA INDICADO |");
                    System.out.println("  *----------------------------------------------------------------------------------*");
                    for (Curso objetoCurso : hotelaria) {
                        System.out.println(" --> " + objetoCurso.getNome());
                    }
                    System.out.println("");

                    boolean valido = false;
                    String nomeCurso = "";

                    while (!valido) {
                        System.out.print("Curso : ");
                        nomeCurso = myinputs.Ler.umaString();

                        //for que vai comparar o nome inserido com todos os cursos
                        for (int i = 0; i < hotelaria.size(); i++) {
                            //se o nome for igual a nomeCurso passa a ser verdade
                            if (hotelaria.get(i).getNome().equals(nomeCurso)) {
                                valido = true;
                            }
                        }
                    }

                    a1.setNomeCurso(nomeCurso);
                    alAluno.add(a1);
                    System.out.println(a1.toString());

                    //ADICIONAR O CURSO
                    break;
                case 2:
                    Auxiliares.clearScreen();
                    System.out.println("*------------------*");
                    System.out.println("| ALUNOS INSCRITOS |");
                    System.out.println("*------------------*\n");

                    for (Aluno objetoAluno : alAluno) {
                        System.out.println("Nº" + objetoAluno.getNumero() + " Nome: " + objetoAluno.getNome());
                    }
                    System.out.print("\nIndique o numero de Aluno a consultar: ");
                    numA = Ler.umInt();

                    a1 = Auxiliares.verificaAluno(numA, alAluno);
                    if (a1 != null) {
                        System.out.println(a1.toString());
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;

                case 3:
                    //MODIFICAR
                    System.out.println("*------------------*");
                    System.out.println("| ALUNOS INSCRITOS |");
                    System.out.println("*------------------*\n");

                    for (Aluno objetoAluno : alAluno) {
                        System.out.println("Nº" + objetoAluno.getNumero() + " Nome: " + objetoAluno.getNome());
                    }

                    System.out.println("");
                    System.out.print("Nº de Aluno: ");
                    int nAluno = myinputs.Ler.umInt();

                    a1 = Auxiliares.verificaAluno(nAluno, alAluno);
                    if (a1 != null) {

                        System.out.println("\n" + a1.toString() + "\n");

                        Auxiliares.clearScreen();
                        System.out.println("*------------------*");
                        System.out.println("|CURSOS DISPONIVEIS|");
                        System.out.println("*------------------*\n");

                        //for iach (por cada curso na hotelaria)
                        for (Curso objetoCurso : hotelaria) {
                            System.out.println("Cod: " + objetoCurso.getCodigo() + " --> " + objetoCurso.getNome());
                        }

                        System.out.print("\nNovo curso: ");

                        valido = false;
                        nomeCurso = "";

                        while (!valido) {
                            System.out.print("Curso : ");
                            nomeCurso = myinputs.Ler.umaString();
                            //for que vai comparar o nome inserido com todos os cursos
                            for (int i = 0; i < hotelaria.size(); i++) {
                                //se o nome for igual a nomeCurso passa a ser verdade
                                if (hotelaria.get(i).getNome().equals(nomeCurso)) {
                                    valido = true;
                                }
                            }
                        }
                        a1.setNomeCurso(nomeCurso);
                        System.out.println(a1.toString());
                    }

                    break;

                case 4:
                    Auxiliares.clearScreen();
                    System.out.println("*------------------*");
                    System.out.println("| ALUNOS INSCRITOS|");
                    System.out.println("*------------------*\n");
                    for (Aluno objetoAluno : alAluno) {
                        System.out.println("Nº" + objetoAluno.getNumero() + " Nome: " + objetoAluno.getNome());
                    }
                    System.out.println("");
                    System.out.print("Numero de Aluno que pretende apagar: ");
                    numA = Ler.umInt();
                    a1 = Auxiliares.verificaAluno(numA, alAluno);
                    if (a1 != null) {
                        Auxiliares.clearScreen();
                        System.out.println(a1.toString());
                        System.out.println("Aluno eliminado !");
                        alAluno.remove(a1);
                    } else {
                        System.out.println("Aluno não encontrado");
                    }

                    break;

                case 5:
                    Auxiliares.clearScreen();
                    System.out.println("_______________________________________________________________________________________________________________________");
                    System.out.println("Nº DE ALUNO | NOME                             | CURSO                            | MEDIA");
                    System.out.println("____________|__________________________________|__________________________________|____________________________________");
                    for (int i = 0; i < alAluno.size(); i++) {
                        System.out.println(alAluno.get(i).TodosAluno());
                    }
                    break;

                case 6:
                    Auxiliares.clearScreen();
                    /* INVOCAR A FUNÇÃO DO MELHOR ALUNO */
                    System.out.println("O melhor aluno é: " + melhorAluno());
                    break;

            }
        } while (op != 0);

    }

    public static void menuProfessor(ArrayList<Curso> hotelaria) {
        int numP;
        Professor p1;
        int inserido;

        String nome;
        int salario;

        do {
            System.out.println("*--------------------------------------*");
            System.out.println("|  MENU PROFESSOR                      |");
            System.out.println("*--------------------------------------*\n");
            System.out.println("O que pretende fazer:  ");
            System.out.println("1: Inserir");
            System.out.println("2: Consultar");
            System.out.println("3: Modificar");
            System.out.println("4: Apagar");
            System.out.println("5: Consultar todos os Professores");

            System.out.print("\n -->  ");
            inserido = myinputs.Ler.umInt();

            switch (inserido) {
                case 1:
                    Auxiliares.clearScreen();
                    System.out.println("\nNovo Professor");
                    p1 = new Professor();
                    System.out.print("Nome : ");
                    p1.setNome(Ler.umaString());

                    System.out.println("*------------------*");
                    System.out.println("|CURSOS DISPONIVEIS|");
                    System.out.println("*------------------*\n");

                    //for (por cada curso na hotelaria)
                    for (Curso objetoCurso : hotelaria) {
                        System.out.println("Cod: " + objetoCurso.getCodigo() + " --> " + objetoCurso.getNome());
                    }

                    System.out.print("\nNumero do Curso em que o professor leciona: ");
                    int nCurso = myinputs.Ler.umInt();
                    Curso c1 = Auxiliares.verificaCurso(nCurso, hotelaria);
                    System.out.println(c1.toStringConsulta());

                    if (c1 != null) {
                        p1.setDisciplinasLecionadas(c1.getDisciplina());
                    } else {
                        System.out.println("Curso nao Encontrado");
                    }

                    System.out.print("Salario: ");
                    p1.setSalario(Ler.umDouble());

                    alProfessor.add(p1);
                    Auxiliares.clearScreen();

                    System.out.println("Prof criado");
                    System.out.println(p1.toString());

                    break;
                case 2:
                    Auxiliares.clearScreen();
                    System.out.println("Indique o numero de Professor a consultar:");
                    numP = Ler.umInt();

                    p1 = Auxiliares.verificaProfessor(numP, alProfessor);
                    if (p1 != null) {
                        System.out.println(p1.toString());
                    } else {
                        System.out.println("Professor não encontrado");
                    }

                    break;
                case 3:
                    Auxiliares.clearScreen();
                    System.out.print("Numero de Professor ?  ");

                    numP = Ler.umInt();
                    p1 = Auxiliares.verificaProfessor(numP, alProfessor);
                    if (p1 != null) {
                        System.out.print("Insira a % do salário ? ");
                        int n = myinputs.Ler.umInt();
                        p1.aumentaSal(n);
                        System.out.println("Cadeiras lecionadas:");
                        System.out.println(p1.getDisciplinasLecionadas().toString());
                        System.out.println("Deseja:");
                        System.out.println(" 1 - Adicionar Cadeiras , 2 - Retirar cadeiras");
                        int escolha = Ler.umInt();
                        if (escolha == 1) {

                            System.out.println("Qual a cadeira a adicionar?");
                            System.out.print("Nome:");
                            String nomeNova = Ler.umaString();
                            Disciplina nova = new Disciplina(nomeNova);

                            System.out.println("Que dia da semana será?");
                            nova.setDiaSemana(Ler.umaString());
                            System.out.println("Hora de incio:");
                            nova.setHoraInicio(Ler.umInt());
                            System.out.println("Hora de fim:");
                            nova.setHoraFim(Ler.umInt());

                            p1.getDisciplinasLecionadas().add(nova);
                        } else if (escolha == 2) {
                            System.out.println("Qual a cadeira a retirar?");
                            System.out.println("(Escolha a cadeira pela sua posição começando por 0)");
                            int posicao = Ler.umInt();
                            System.out.println(p1.getDisciplinasLecionadas().remove(posicao));
                        } else {
                            System.out.println("Por favor escolha estre 1 e 2");
                        }

                    } else {
                        System.out.println("Professor não encontrado");
                    }

                    break;
                case 4:

                    Auxiliares.clearScreen();
                    System.out.print("Numero de Professor que pretende apagar: ");
                    numP = Ler.umInt();
                    p1 = Auxiliares.verificaProfessor(numP, alProfessor);
                    if (p1 != null) {
                        System.out.println(p1.toString());
                        System.out.println("\nProfessor eliminado !");
                        alProfessor.remove(p1);
                    } else {
                        System.out.println("Professor não encontrado");
                    }

                    break;

                case 5:
                    Auxiliares.clearScreen();
                    System.out.println("___________________________________________________________________________________________________________________________________________________");
                    System.out.println("Nº DE PROFESSOR | NOME                             | SALARIO(€)                       | DISCIPLINAS   ");
                    System.out.println("________________|__________________________________|__________________________________|____________________________________________________________");
                    for (int i = 0; i < alProfessor.size(); i++) {
                        System.out.println(alProfessor.get(i).TodosProf());
                    }
                    break;

                default:
                    System.out.println("Adeus");
                    break;
            }
        } while (inserido != 0);

    }

    public static void menuCurso(ArrayList<Curso> hotelaria) {

        Curso c1;
        int inserido;
        do {

            System.out.println("");
            System.out.println("*------------------------------*");
            System.out.println("|MENU CURSO                    |");
            System.out.println("*------------------------------*");
            System.out.println("O que pretende fazer:  ");
            System.out.println("1: Inserir");
            System.out.println("2: Consultar");
            System.out.println("3: Modificar");
            System.out.println("4: Apagar");
            System.out.println("5: Consultar todos os cursos");
            System.out.println("6: Horarios");

            System.out.print("\n -->  ");
            inserido = myinputs.Ler.umInt();

            switch (inserido) {
                case 1:
                    c1 = new Curso();
                    Auxiliares.clearScreen();
                    //ADICIONAR CURSO

                    System.out.println("\nNovo Curso");

                    System.out.print("Numero de disciplinas : ");
                    int numeroDeDisciplinas = myinputs.Ler.umInt();

                    System.out.print("Nome do Curso : ");
                    //ADICIONAR O NOME DO CURSO
                    c1.setNome(Ler.umaString());

                    //ADICIONAR AS DISCIPLINAS NECESSARIAS
                    for (int j = 0; j < numeroDeDisciplinas; j++) {
                        System.out.print("Disciplinas : ");
                        String nomeDis = Ler.umaString();
                        Disciplina teste = new Disciplina(nomeDis);

                        System.out.println("Que dia da semana será?");
                        teste.setDiaSemana(Ler.umaString());
                        System.out.println("Hora de incio:");
                        teste.setHoraInicio(Ler.umInt());
                        System.out.println("Hora de fim:");
                        teste.setHoraFim(Ler.umInt());

                        c1.addDisciplinas(teste);

                    }

                    //GUARDAR O CURSO NOVO PARA SEMPRE NO FICHEIRO
                    hotelaria.add(c1);
                    Auxiliares.saveToFileCu(hotelaria);
                    Auxiliares.clearScreen();
                    System.out.println("-- Curso criado --");
                    System.out.println(c1.toStringConsulta());

                    break;
                case 2:

                    System.out.print("Indique o codigo do Curso a consultar: ");
                    int nCurso = myinputs.Ler.umInt();

                    c1 = Auxiliares.verificaCurso(nCurso, hotelaria);

                    if (c1 != null) {
                        Auxiliares.clearScreen();
                        System.out.println(c1.toString());
                    } else {
                        System.out.println("Curso não encontrado");
                    }
                    break;

                case 3:
                    int modDis;

                    Auxiliares.clearScreen();
                    System.out.println("*------------------*");
                    System.out.println("|CURSOS DISPONIVEIS|");
                    System.out.println("*------------------*\n");

                    //for (por cada curso na hotelaria)
                    for (Curso objetoCurso : hotelaria) {
                        System.out.println("Cod: " + objetoCurso.getCodigo() + " --> " + objetoCurso.getNome());
                    }

                    System.out.print("\nNumero do Curso que pretende modificiar: ");
                    nCurso = myinputs.Ler.umInt();
                    c1 = Auxiliares.verificaCurso(nCurso, hotelaria);
                    if (c1 != null) {
                        System.out.println("\n-- Modificar Curso -- ");
                        System.out.println(" 1 --> Adicionar uma disciplina ");
                        System.out.println(" 2 --> Remover uma disciplina ");
                        System.out.println(" 3 --> Remover todas as disciplinas ");
                        System.out.print(" --> ");
                        modDis = myinputs.Ler.umInt();
                        if (modDis == 1) {

                            System.out.print("\nNome da disciplina nova: ");
                            String nomeDis = Ler.umaString();
                            Disciplina teste = new Disciplina(nomeDis);

                            System.out.println("Que dia da semana será?");
                            teste.setDiaSemana(Ler.umaString());
                            System.out.println("Hora de incio:");
                            teste.setHoraInicio(Ler.umInt());
                            System.out.println("Hora de fim:");
                            teste.setHoraFim(Ler.umInt());

                            c1.addDisciplinas(teste);
                        }
                        if (modDis == 2) {

                            System.out.println("");
                            System.out.println(c1);
                            System.out.println("\nIndex* da disciplina que pretende remover: ");
                            System.out.println("Nota: Index* significa a posição da disciplina, começando do zero");
                            System.out.print(" --> ");
                            int dis = myinputs.Ler.umInt();

                            c1.getDisciplina().remove(dis);
                        }

                        if (modDis == 3) {
                            System.out.println("");
                            c1.getDisciplina().removeAll(c1.getDisciplina());
                            System.out.println("-- Foram removidas todas as disciplinas do curso --");
                        }

                    }

                    break;
                case 4:

                    System.out.print("Numero do Curso que pretende eliminar: ");
                    nCurso = myinputs.Ler.umInt();
                    c1 = Auxiliares.verificaCurso(nCurso, hotelaria);
                    if (c1 != null) {
                        System.out.println("Curso Eliminado !");
                        hotelaria.remove(c1);

                    } else {
                        System.out.println("Curso não encontrado");
                    }
                    break;

                case 5:
                    Auxiliares.clearScreen();
                    System.out.println("*------------------*");
                    System.out.println("|CURSOS DISPONIVEIS|");
                    System.out.println("*------------------*\n");

                    //for (por cada curso na hotelaria)
                    for (Curso objetoCurso : hotelaria) {
                        System.out.println(objetoCurso.toString());
                    }

                    break;

                case 6:

                    Auxiliares.clearScreen();
                    System.out.println("*------------------*");
                    System.out.println("|CURSOS DISPONIVEIS|");
                    System.out.println("*------------------*\n");

                    //for (por cada curso na hotelaria)
                    for (Curso objetoCurso : hotelaria) {
                        System.out.println("Cod: " + objetoCurso.getCodigo() + " --> " + objetoCurso.getNome());
                    }

                    System.out.print("\nNumero do Curso que pretende Mostrar o horario: ");
                    nCurso = myinputs.Ler.umInt();

                    c1 = Auxiliares.verificaCurso(nCurso, hotelaria);

                    if (c1 != null) {

                        double numeroDisciplinas = hotelaria.get(nCurso - 1).getDisciplina().size();
                        System.out.println("____________________________________________________________________________________________________________");
                        System.out.println("DISCIPLINA                     | DIA DA SEMANA                    | INICIO                           | FIM  ");
                        System.out.println("_______________________________|__________________________________|__________________________________|______");

                        for (int i = 0; i < numeroDisciplinas; i++) {
                            Disciplina paraHorario = c1.getDisciplina().get(i);

                            String s = "";

                            String nomeDisciplina = paraHorario.getNome();
                            String diaDaSemana = paraHorario.getDiaSemana();
                            double horadeInicio = paraHorario.getHoraInicio();
                            double horadeFim = paraHorario.getHoraFim();

                            System.out.printf("%-30s", s + nomeDisciplina);
                            System.out.printf("%-35s", s + " | " + diaDaSemana);
                            System.out.printf("%-35s", s + " | " + horadeInicio);
                            System.out.printf("%-35s", s + " | " + horadeFim);

                            System.out.println(s);
                        }
                    } else {
                        System.out.println("Curso não encontrado");
                    }

                    break;
            }

        } while (inserido != 0);

    }

    public static String melhorAluno() {
        int maior = 0;
        int melhorAluno = 0;
        String info = "";

        //percorrer os alunos todos
        for (int i = 0; i < alAluno.size(); i++) {
            //se a media de um aluno for maior que maior
            if (alAluno.get(i).getMedia() > maior) {
                //atribuir o maior ao aluno
                maior = alAluno.get(i).getMedia();
                //numero do melhor aluno;
                melhorAluno = alAluno.get(i).getNumero();

                String nomemelhorAluno = alAluno.get(i).getNome();
                String nomeCursoMA = alAluno.get(i).getNomeCurso();
                info = "numero: " + melhorAluno + " Nome: " + nomemelhorAluno + " Curso: " + nomeCursoMA;
            }

        }
        //retorna a string com numero, nome e curso do melhor aluno
        return info;
    }

}
