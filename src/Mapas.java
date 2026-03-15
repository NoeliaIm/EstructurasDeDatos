import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mapas {
    public static void main(String[] args) {

        /*
         * Un mapa es una estructura que almacena pares clave-valor,
         * donde cada clave es única y sirve para acceder a su valor asociado.
         * La analogía perfecta es un diccionario: buscas una palabra (clave) y obtienes su definición (valor).
         *
         * A diferencia de las colecciones que hemos visto,
         * Map no extiende la interfaz Collection, es una jerarquía aparte.
         * Aun así, tiene tres implementaciones principales que se
         * comportan igual que sus equivalentes en conjuntos:
         * HashMap, LinkedHashMap y TreeMap.
         */

        // Los dos tipos genéricos son: <TipoClave, TipoValor>
        HashMap<String, Integer> edades = new HashMap<>();

        // Métodos principales
        // put — insertar o actualizar

        edades.put("Ana", 25);
        edades.put("Carlos", 30);
        edades.put("Beatriz", 28);

        // Si la clave ya existe, reemplaza el valor y devuelve el anterior
        Integer anterior = edades.put("Ana", 26); // anterior = 25
        System.out.println(edades.get("Ana"));    // 26

        // get y containsKey — consultar

        // get → obtiene el valor asociado a una clave, o null si no existe
        System.out.println(edades.get("Carlos"));   // 30
        System.out.println(edades.get("Pedro"));    // null

        // containsKey → comprueba si una clave existe antes de acceder
        if (edades.containsKey("Beatriz")) {
            System.out.println("Beatriz tiene " + edades.get("Beatriz") + " años");
        }

        // containsValue → comprueba si un valor existe en el mapa
        System.out.println(edades.containsValue(30)); // true

        // remove — eliminar por clave
        // remove devuelve el valor que tenía la clave eliminada
        Integer eliminado = edades.remove("Carlos"); // eliminado = 30
        System.out.println(edades.size());           // 2
        System.out.println(edades.remove("NoExiste")); // null

        // size, isEmpty y clear
        System.out.println(edades.size());    // número de pares
        System.out.println(edades.isEmpty()); // false
        edades.clear();
        System.out.println(edades.isEmpty()); // true

        // Las tres implementaciones comparadas

        // HashMap — sin orden garantizado

        HashMap<String, String> capitales = new HashMap<>();
        capitales.put("España", "Madrid");
        capitales.put("Francia", "París");
        capitales.put("Italia", "Roma");

        // El orden de salida NO está garantizado
        for (String pais : capitales.keySet()) {
            System.out.println(pais + " → " + capitales.get(pais));
        }

        // LinkedHashMap — respeta el orden de inserción

        LinkedHashMap<String, String> capitalesLinked = new LinkedHashMap<>();
        capitalesLinked.put("España", "Madrid");
        capitalesLinked.put("Francia", "París");
        capitalesLinked.put("Italia", "Roma");

        // Siempre saldrá en el orden insertado: España, Francia, Italia
        for (String pais : capitalesLinked.keySet()) {
            System.out.println(pais + " → " + capitalesLinked.get(pais));
        }

        // TreeMap — ordena las claves automáticamente

        TreeMap<String, String> capitalesTreeMap = new TreeMap<>();
        capitalesTreeMap.put("España", "Madrid");
        capitalesTreeMap.put("Francia", "París");
        capitalesTreeMap.put("Italia", "Roma");
        capitalesTreeMap.put("Alemania", "Berlín");

        // Las claves salen ordenadas alfabéticamente: Alemania, España, Francia, Italia
        for (String pais : capitalesTreeMap.keySet()) {
            System.out.println(pais + " → " + capitalesTreeMap.get(pais));
        }


        // Cómo recorrer un mapa
        // Los mapas no tienen iterador directo, pero ofrecen dos métodos para convertirlos en algo iterable.
        // Con keySet() — recorrer solo las claves

        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("manzanas", 50);
        stock.put("peras", 30);
        stock.put("naranjas", 20);

        // keySet() devuelve un Set con todas las claves
        for (String fruta : stock.keySet()) {
            System.out.println(fruta + ": " + stock.get(fruta) + " unidades");
        }


        // Con entrySet() — recorrer clave y valor a la vez
        // Es más eficiente que keySet() porque no necesitas llamar a get() por cada clave:

        // entrySet() devuelve un Set de pares clave-valor (Map.Entry)
        for (Map.Entry<String, Integer> entrada : stock.entrySet()) {
            String clave = entrada.getKey();
            Integer valor = entrada.getValue();
            System.out.println(clave + ": " + valor + " unidades");
        }
    }
}
