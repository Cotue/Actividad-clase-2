import java.util.Iterator;
import java.util.NoSuchElementException;

class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
class Lista<T> implements Iterable<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    Lista() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }
    public int tamaño() {
        return tamaño;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator<T> {
        private Nodo<T> actual;

        IteradorLista() {
            actual = cabeza;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T dato = actual.dato;
            actual = actual.siguiente;
            return dato;
        }
    }

    public void insertarLista(Lista<T> lista) {
        if (lista.tamaño() > 0) {
            Nodo<T> ultimo = cabeza;
            while (ultimo.siguiente != null) {
                ultimo = ultimo.siguiente;
            }
            for (T dato : lista) {
                ultimo.siguiente = new Nodo<>(dato);
                ultimo = ultimo.siguiente;
            }
            tamaño += lista.tamaño();
        }
    }

    public Lista<T> subLista(int inicio, int tamaño) {
        Lista<T> sublista = new Lista<>();
        Nodo<T> actual = cabeza;
        int contador = 0;
        while (actual != null && contador < inicio + tamaño) {
            if (contador >= inicio) {
                sublista.agregar(actual.dato);
            }
            actual = actual.siguiente;
            contador++;
        }
        return sublista;
    }

    public void invertir() {
        Nodo<T> previo = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = previo;
            previo = actual;
            actual = siguiente;
        }
        cabeza = previo;
    }


    public void imprimir() {
        for (T dato : this) {
            System.out.print(dato + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
        Lista<Integer> original = new Lista<>();
        original.agregar(1);
        original.agregar(2);
        original.agregar(3);
        original.agregar(4);

        Lista<Integer> porAnexar = new Lista<>();
        porAnexar.agregar(5);
        porAnexar.agregar(6);
        porAnexar.agregar(7);
        porAnexar.agregar(8);

        original.insertarLista(porAnexar);
        original.imprimir();

        Lista<Integer> sublista = original.subLista(1, 2);
        sublista.imprimir();
        original.invertir();
        original.imprimir();
    }
}
