package main;
import modelo.Curso;
import modelo.Entrenador;
import modelo.Participante;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        String nombre, cedula, disciplinaCurso, horarioCurso;
        int edad, opcion, edadMinCurso, edadMaxCurso;
        Scanner scanner = new Scanner(System.in);
        List<Participante> participantes = new ArrayList<>();
        List<Curso> cursosDisponibles = new ArrayList<>();

        Entrenador e1 = new Entrenador("Juan Perez", "1234567890", 35, "Natacion");
        Entrenador e2 = new Entrenador("Maria Garcia", "0987654321", 28, "Futbol");

        cursosDisponibles.add(new Curso("Futbol", "Futbol", "M-J 16:00", 13, 18, e2));
        cursosDisponibles.add(new Curso("Natacion", "Natacion", "L-M 18:00", 13, 18, e1));

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Registrar Participante");
            System.out.println("2. Ver Cursos Disponibles por Edad");
            System.out.println("3. Inscribir en Curso");
            System.out.println("4. Ver Inscritos por Curso");
            System.out.println("5. Ver Horarios de Canchas");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("\n----- REGISTRAR PARTICIPANTE -----");
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Cedula: ");
                    cedula = scanner.nextLine();
                    System.out.print("Edad: ");
                    edad = scanner.nextInt();
                    scanner.nextLine();
                    Participante nuevoParticipante = new Participante(nombre, cedula, edad);
                    participantes.add(nuevoParticipante);
                    System.out.println("Participante registrado");
                    break;
                case 2:
                    System.out.println("\n----- CURSOS DISPONIBLES POR EDAD -----");
                    if (participantes.isEmpty()) {
                        System.out.println("No hay participantes registrados para filtrar cursos por edad");
                    } else {
                        System.out.print("Ingrese la edad del participante para buscar cursos: ");
                        int edadBusqueda = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("\nCursos disponibles para edad " + edadBusqueda + ":");
                        boolean foundCourses = false;
                        for (Curso curso : cursosDisponibles) {
                            if (edadBusqueda >= curso.getEdadMin() && edadBusqueda <= curso.getEdadMax()) {
                                System.out.println("- " + curso.getNombre() + " (" + curso.getDisciplina() + ") - Horario: " + curso.getHorario() + " - Entrenador: " + curso.getEntrenador().getNombre());
                                foundCourses = true;
                            }
                        }
                        if (!foundCourses) {
                            System.out.println("No se encontraron cursos para la edad especificada");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n----- INSCRIBIR EN CURSO -----");
                    if (participantes.isEmpty()) {
                        System.out.println("No hay participantes registrados. Registre un participante primero");
                        break;
                    }
                    if (cursosDisponibles.isEmpty()) {
                        System.out.println("No hay cursos disponibles para inscribir");
                        break;
                    }

                    System.out.println("Participantes disponibles:");
                    for (int i = 0; i < participantes.size(); i++) {
                        System.out.println((i + 1) + ". " + participantes.get(i).getNombre());
                    }
                    System.out.print("Seleccione el numero del participante a inscribir: ");
                    int participanteIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (participanteIndex < 1 || participanteIndex > participantes.size()) {
                        System.out.println("Seleccion de participante invalida");
                        break;
                    }
                    Participante participanteAInscribir = participantes.get(participanteIndex - 1);

                    System.out.println("\nCursos disponibles:");
                    for (int i = 0; i < cursosDisponibles.size(); i++) {
                        System.out.println((i + 1) + ". " + cursosDisponibles.get(i).getNombre() + " (" + cursosDisponibles.get(i).getDisciplina() + ")");
                    }
                    System.out.print("Seleccione el numero del curso para inscribir: ");
                    int cursoIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (cursoIndex < 1 || cursoIndex > cursosDisponibles.size()) {
                        System.out.println("Seleccion de curso invalida");
                        break;
                    }
                    Curso cursoAInscribir = cursosDisponibles.get(cursoIndex - 1);

                    if (cursoAInscribir.inscribir(participanteAInscribir)) {
                        System.out.println(participanteAInscribir.getNombre() + " inscrito exitosamente en " + cursoAInscribir.getNombre());
                    } else {
                        System.out.println("No se pudo inscribir a " + participanteAInscribir.getNombre() + " en " + cursoAInscribir.getNombre() + " Puede que el cupo este lleno o la edad no sea la adecuada");
                    }
                    break;
                case 4:
                    System.out.println("\n----- VER INSCRITOS POR CURSO -----");
                    if (cursosDisponibles.isEmpty()) {
                        System.out.println("No hay cursos registrados para ver inscritos");
                        break;
                    }
                    System.out.println("Cursos disponibles:");
                    for (int i = 0; i < cursosDisponibles.size(); i++) {
                        System.out.println((i + 1) + ". " + cursosDisponibles.get(i).getNombre() + " (" + cursosDisponibles.get(i).getDisciplina() + ")");
                    }
                    System.out.print("Seleccione el numero del curso para ver los inscritos: ");
                    int verInscritosIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (verInscritosIndex < 1 || verInscritosIndex > cursosDisponibles.size()) {
                        System.out.println("Seleccion de curso invalida");
                        break;
                    }
                    cursosDisponibles.get(verInscritosIndex - 1).mostrarInscritos();
                    break;
                case 5:
                    System.out.println("\n----- VER HORARIOS DE CANCHAS -----");
                    if (cursosDisponibles.isEmpty()) {
                        System.out.println("No hay cursos registrados con horarios.");
                    } else {
                        for (Curso curso : cursosDisponibles) {
                            System.out.println("- Curso: " + curso.getNombre() + " | Disciplina: " + curso.getDisciplina() + " | Horario: " + curso.getHorario());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }while (opcion != 6);
    }
}