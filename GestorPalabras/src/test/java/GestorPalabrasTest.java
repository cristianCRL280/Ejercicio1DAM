import com.dam.Excepciones.*;
import com.dam.gestorpalabras.GestorPalabras;
import static junit.framework.TestCase.*;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class GestorPalabrasTest {

    @Test
    public void esPalindromoFrase() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo("allí ves sevilla"));
    }

    @Test
    public void esPalindromoPalabra() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo("ana"));
    }

    @Test
    public void noEsPolindromoFrase() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(false, gp.esPalindromo("allí ves sevila"));
    }

    @Test
    public void noEsPolindromoPalabra() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(false, gp.esPalindromo("ordenador"));
    }

    @Test(expected = TooShortWordException.class)
    public void palabraCorta() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo("la"));
    }

    @Test(expected = Exception.class)
    public void noPalabra() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo(""));
    }

    @Test(expected = Exception.class)
    public void numeroEsPalindromo() throws TooShortWordException, NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo("1111"));
        assertTrue(gp.esPalindromo("hol4"));
    }

    @Test(expected = Exception.class)
    public void simbolosEsPalindromo() throws SymbolException, TooShortWordException, NoNumberException {
        GestorPalabras gp = new GestorPalabras();
        assertTrue(gp.esPalindromo("%hloafs"));
    }

    @Test
    public void contarVocalesPalabra() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(4, gp.contarVocales("ordenador"));
    }

    @Test
    public void contarVocalesFrase() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(7, gp.contarVocales("el ordenador va mal"));
    }

    @Test
    public void contarVocalesConOSinTildes() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(2, gp.contarVocales("árbol"));
        assertEquals(6, gp.contarVocales("allí ves sevilla"));
    }

    @Test(expected = Exception.class)
    public void numeroContarVocales() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(true, gp.contarVocales("1111"));
        assertEquals(true, gp.contarVocales("hol4"));
    }

    @Test(expected = Exception.class)
    public void simbolosContarVocales() throws SymbolException, NoNumberException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(true,gp.contarVocales("&&%fodh"));
    }

    @Test
    public void invertirPalabras() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals("aloh", gp.invertirPalabra("hola"));
        assertEquals("lobrá", gp.invertirPalabra("árbol"));
    }

    @Test
    public void invertirFrase() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals("oinotnA omall em", gp.invertirPalabra("me llamo Antonio"));
        assertEquals("etnemlaer és on", gp.invertirPalabra("no sé realmente"));
    }

    @Test(expected = Exception.class)
    public void numeroInvertirPalabras() throws NoNumberException, SymbolException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(true, gp.contarVocales("hol4 m3 ll4m0 4nt0n10"));
        assertEquals(true, gp.contarVocales("hol4"));
    }
    
    @Test(expected = Exception.class)
    public void simbolosInvertirPalabras() throws SymbolException, NoNumberException {
        GestorPalabras gp = new GestorPalabras();
        assertEquals(true,gp.contarVocales("/ fua % ud$"));
    }

}


//• @Test: Esta es la anotacion mas comun en JUnit y se utiliza para marcar un metodo como una prueba
//unitaria. El metodo anotado con @Test se ejecutar´a como una prueba.

//• @Before: Esta anotacion se utiliza para marcar un m´etodo que se ejecutara antes de cada metodo de
//prueba en la clase. Se utiliza comunmente para configurar el estado inicial necesario para las pruebas.

//• @After: Esta anotaci´on se utiliza para marcar un m´etodo que se ejecutar´a despu´es de cada m´etodo de
//prueba en la clase. Se utiliza com´unmente para limpiar y liberar recursos despu´es de las pruebas.

//• @BeforeClass: Esta anotaci´on se utiliza para marcar un m´etodo que se ejecutar´a una vez antes de que se
//ejecuten todas las pruebas en la clase. Se utiliza para la configuraci´on de clase.

//• @AfterClass: Esta anotacion se utiliza para marcar un m´etodo que se ejecutar´a una vez despu´es de que
//se hayan ejecutado todas las pruebas en la clase. Se utiliza para la limpieza de clase.
//Entornos de desarrollo 5
//Diseno y realizacion de pruebas
//Tambien se pueden establecer anotaciones para las excepciones o limite de tiempo estableciendo dichos
//par´ametros en la anotaciones.

//• @Test(expected = Exception.class): Esta anotaci´on se utiliza para indicar que se espera que un
//m´etodo de prueba arroje una excepci´on espec´ıfica. Si la excepci´on no se arroja durante la ejecuci´on
//de la prueba, la prueba fallar´a.

//• @Test(timeout = 100): Esta anotaci´on se utiliza para especificar un l´ımite de tiempo en milisegundos
//para la ejecuci´on de un m´etodo de prueba. Si el m´etodo de prueba tarda m´as tiempo en ejecutarse que el
//tiempo especificado, la prueba fallara.

//
// assertEquals, assertTrue, assertFalse, assertNotNull, y assertNull



//github