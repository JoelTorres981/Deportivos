package modelo;

public class Entrenador extends Persona{
    private String disciplina;

    public Entrenador(String nombre, String cedula, int edad, String disciplina) {
        super(nombre, cedula, edad);
        this.disciplina = disciplina;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("------ ENTRENADOR -----"+"\n Nombre: "+ nombre+"\n Disciplina: "+ disciplina);
    }
}
