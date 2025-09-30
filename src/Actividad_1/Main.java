package Actividad_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();

        Alumno a1 = new Alumno("Juan Perez", 8.5, "Historia");
        alumnos.add(a1);
        Alumno a2 = new Alumno("Ana Gomez", 6.2, "Matematicas");
        alumnos.add(a2);
        Alumno a3 = new Alumno("Luis Ramirez", 9.0, "Historia");
        alumnos.add(a3);
        Alumno a4 = new Alumno("Maria Lopez", 7.5, "Matematicas");
        alumnos.add(a4);
        Alumno a5 = new Alumno("Carlos Sanchez", 5.9, "Historia");
        alumnos.add(a5);
        Alumno a6 = new Alumno("Laura Torres", 8.1, "Ciencias");
        alumnos.add(a6);
        Alumno a7 = new Alumno("Pedro Morales", 4.3, "Ciencias");
        alumnos.add(a7);
        Alumno a8 = new Alumno("Sofia Diaz", 9.5, "Matematicas");
        alumnos.add(a8);
        Alumno a9 = new Alumno("Jorge Ruiz", 7.0, "Ciencias");
        alumnos.add(a9);
        Alumno a10 = new Alumno("Marta Gil", 6.8, "Historia");
        alumnos.add(a10);


        List<String> nombresAprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        Map<String, Double> top3Promedios = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso, Collectors.averagingDouble(Alumno::getNota)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
