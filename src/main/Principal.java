package main;
import modelo.Curso;
import modelo.Entrenador;
import modelo.Participante;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        String nombre, cedula;
        int edad, opcion;

        Scanner scanner = new Scanner(System.in);
        List<Participante> participantes = new ArrayList<>();

        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Registrar Participante\n" +
                    "2. Ver Cursos Disponibles por Edad\n" +
                    "3. Inscribir en Curso\n" +
                    "4. Ver Inscritos por Curso\n" +
                    "5. Ver Horarios de Canchas\n" +
                    "6. Salir\n");
            System.out.printf("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("----- PARTICIPANTE -----");
                    System.out.printf("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.printf("Cedula: ");
                    cedula = scanner.nextLine();
                    System.out.printf("Edad: ");
                    edad = scanner.nextInt();
                    Participante p = new Participante(nombre,cedula,edad);
                    participantes.add(p);
                case 2:

            }
        }while (opcion != 6);
    }
}