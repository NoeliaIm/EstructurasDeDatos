import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listas {

    // añaden métodos nuevos a los existentes en la interfaz Collection
    // acceso posicional, búsqueda por posición, sublistas..

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Java");      // posición 0
        lista.add("Python");    // posición 1
        lista.add("C++");       // posición 2

        // get → obtener elemento por posición
        System.out.println(lista.get(0)); // "Java"
        System.out.println(lista.get(2)); // "C++"

        // set → reemplazar el elemento en una posición
        lista.set(1, "Kotlin");
        System.out.println(lista.get(1)); // "Kotlin"

        // add con posición → inserta empujando los demás a la derecha
        lista.add(1, "TypeScript");
        // lista: Java, TypeScript, Kotlin, C++

        // add en la primera posición
        lista.addFirst("Go");
        // lista: Go, Java, TypeScript, Kotlin, C++

        // add en la última posición
        lista.addLast("Rust");
        // lista: Go, Java, TypeScript, Kotlin, C++, Rust

        // remove por posición
        lista.remove(1); // elimina "TypeScript"
        // lista: Java, TypeScript, Kotlin, C++

        // añadimos  un elemento repetido
        lista.add("Kotlin");
        // lista: Go, TypeScript, Kotlin, C++, Rust, Kotlin
        System.out.println(lista);

        lista.removeFirst();
        // lista: TypeScript, Kotlin, C++, Rust, Kotlin

        lista.remove("Kotlin"); // elimina la primera ocurrencia de "Kotlin"
        // lista: TypeScript, C++, Rust, Kotlin
        System.out.println(lista);

        lista.removeLast();
        // lista: TypeScript, C++, Rust
        System.out.println(lista);


        // MÉTODOS DE BÚSQUEDA

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("manzana");   // 0
        frutas.add("pera");      // 1
        frutas.add("naranja");   // 2
        frutas.add("pera");      // 3  ← duplicado permitido en listas

        // indexOf → primera aparición
        System.out.println(frutas.indexOf("pera"));      // 1
        System.out.println(frutas.indexOf("uva"));       // -1 (no existe)

        // lastIndexOf → última aparición
        System.out.println(frutas.lastIndexOf("pera"));  // 3

        // Combinación clásica: buscar y reemplazar
        frutas.set(frutas.indexOf("naranja"), "mango");
        // lista: manzana, pera, mango, pera


        // Sublistas con sublist
        // La clave aquí es que subList(from, to) incluye from pero excluye to.
        // Además, la sublista es una vista de la lista original, no una copia, así que los cambios en una afectan a la otra.
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        // subList(1, 4) → posiciones 1, 2 y 3 (el 4 no se incluye)
        System.out.println(numeros.subList(1, 4)); // [20, 30, 40]

        // Al hacer clear sobre la sublista, también afecta a la lista original
        List<Integer> subList =  numeros.subList(0, 2);
        subList.clear();
        // numeros ahora: [30, 40, 50]
        System.out.println(numeros);
        System.out.println(subList); // [] (la sublista también se vació)

        // Ojo, lo mismo si hacemos numeros.subList(0, 2).clear();

        // si queremos una copia independiente de la sublista
        // ArrayList<Integer> subListIndependiente = new ArrayList<>(numeros.subList(0, 2));

        // LinkedList como cola (FIFO) y como pila (LIFO)
        // —─ Como COLA (Queue) —─ el primero en entrar es el primero en salir
        LinkedList<String> cola = new LinkedList<>();

        cola.offer("cliente 1"); // añade al final
        cola.offer("cliente 2");
        cola.offer("cliente 3");

        System.out.println(cola.peek()); // "cliente 1" → mira sin eliminar
        System.out.println(cola.poll()); // "cliente 1" → saca y elimina
        System.out.println(cola.poll()); // "cliente 2"
        // queda: cliente 3

        // —─ Como PILA (Stack) —─ el último en entrar es el primero en salir
        LinkedList<String> pila = new LinkedList<>();

        pila.push("página 1"); // añade al principio
        pila.push("página 2");
        pila.push("página 3");

        System.out.println(pila.peek()); // "página 3" → mira sin eliminar
        System.out.println(pila.pop());  // "página 3" → saca y elimina
        System.out.println(pila.pop());  // "página 2"
        // queda: página 1

    }

}
