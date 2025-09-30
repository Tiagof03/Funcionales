package Actividad_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        List<Producto> productosMayorPrecio = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        Map<String, Integer> stockCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.summingInt(Producto::getStock)));

        String productosString = productos.stream()
                .map(p -> p.getNombre() + ":" + p.getPrecio())
                .collect(Collectors.joining("; "));

        OptionalDouble promedioPrecios = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average();

        Map<String, Double> promedioPrecioCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,Collectors.averagingDouble(Producto::getPrecio)));

    }
}
