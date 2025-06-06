package modelo;
import java.util.*;

public class Curso {
    private String nombre, disciplina, horario;
    private int edadMin, edadMax;
    private Entrenador entrenador;
    private List<Participante> inscritos;

    public Curso(String nombre, String disciplina, String horario, int edadMin, int edadMax, Entrenador entrenador) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.horario = horario;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.entrenador = entrenador;
        this.inscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public boolean inscribir(Participante p){
        if (inscritos.size() < 30 && p.getEdad() >= edadMin && p.getEdad() <= edadMax){
            inscritos.add(p);
            return true;
        }
        return false;
    }

    public void mostrarInscritos(){
        System.out.println("----- CURSOS ----- " + "\nNombre: " + nombre + "\nDisciplina: " + disciplina);
        for (Participante p:inscritos){
            p.mostrarDatos();
        }
    }
}
