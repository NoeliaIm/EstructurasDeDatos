import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Conjuntos {
    public static void main(String[] args) {

        // Los conjuntos no añaden métodos nuevos respecto a Collection,
        // pero su característica principal es que no admiten duplicados.
        // Tienes tres implementaciones con comportamientos distintos:

        // HashSet — sin orden garantizado


        HashSet<Integer> conjunto = new HashSet<>();

        conjunto.add(5);
        conjunto.add(3);
        conjunto.add(8);
        conjunto.add(3); // duplicado → se ignora silenciosamente

        System.out.println(conjunto.size());        // 3, no 4
        System.out.println(conjunto.contains(8));   // true
        System.out.println(conjunto.contains(99));  // false

        conjunto.remove(3);
        System.out.println(conjunto.size());        // 2

        // El orden de salida NO está garantizado, puede salir cualquier orden
        for (Integer n : conjunto) {
            System.out.println(n);
        }

        // LinkedHashSet — respeta el orden de inserción


        LinkedHashSet<String> nombres = new LinkedHashSet<>();

        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Beatriz");
        nombres.add("Ana"); // duplicado → ignorado

        // Siempre saldrá en el orden en que se insertaron
        for (String nombre : nombres) {
            System.out.println(nombre); // Carlos, Ana, Beatriz
        }

        // TreeSet — ordena automáticamente por valor

        TreeSet<Integer> numeros = new TreeSet<>();

        numeros.add(40);
        numeros.add(10);
        numeros.add(30);
        numeros.add(20);

        // Aunque insertamos desordenado, sale ordenado de menor a mayor
        for (Integer n : numeros) {
            System.out.println(n); // 10, 20, 30, 40
        }

        // TreeSet tiene métodos extra muy útiles
        System.out.println(numeros.first()); // 10 → el menor
        System.out.println(numeros.last());  // 40 → el mayor


        TreeSet<Integer> A = new TreeSet<>();
        A.add(1); A.add(2); A.add(3); A.add(4);

        HashSet<Integer> B = new HashSet<>();
        B.add(3); B.add(4); B.add(5); B.add(6);

        // UNIÓN — añade todos los de B en A (sin duplicados)
        A.addAll(B);
        // A ahora contiene: 1, 2, 3, 4, 5, 6

        // INTERSECCIÓN — se queda solo con los que están en ambos
        A.retainAll(B);
        // A ahora contiene: 3, 4, 5, 6

        // DIFERENCIA — elimina de A los que están en B
        A.removeAll(B);
        // A ahora contiene: 1, 2

    }
}
