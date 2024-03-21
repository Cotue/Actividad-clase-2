import org.junit.Test;
import static org.junit.Assert.*;


public class ListaTest {

    @Test
    public void testAgregar() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        assertEquals(1, lista.tamaño());
    }

    @Test
    public void testAgregarListaVacia() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        assertEquals(2, lista.tamaño());
    }

    @Test
    public void testAgregarListaNoVacia() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        Lista<Integer> lista2 = new Lista<>();
        lista2.agregar(2);
        lista2.agregar(3);
        lista.insertarLista(lista2);
        assertEquals(3, lista.tamaño());
    }

    @Test
    public void testSubLista() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        Lista<Integer> subLista = lista.subLista(1, 2);
        assertEquals(2, subLista.tamaño());
    }

    @Test
    public void testSubListaInicioFueraDeRango() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        Lista<Integer> subLista = lista.subLista(5, 2);
        assertEquals(0, subLista.tamaño());
    }

    @Test
    public void testSubListaTamañoMayorQueLista() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        Lista<Integer> subLista = lista.subLista(1, 5);
        assertEquals(2, subLista.tamaño());
    }

    @Test
    public void testInvertir() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.invertir();
        assertEquals(3, (int) lista.subLista(0, 1).iterator().next());
    }

    @Test
    public void testInvertirListaVacia() {
        Lista<Integer> lista = new Lista<>();
        lista.invertir();
        assertEquals(0, lista.tamaño());
    }

    @Test
    public void testInvertirListaUnElemento() {
        Lista<Integer> lista = new Lista<>();
        lista.agregar(1);
        lista.invertir();
        assertEquals(1, (int) lista.subLista(0, 1).iterator().next());
    }
}

