import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesTest {
    
    
    @Test
    public void testCapitalizarAlterna() {
        String cadena = "zaPaTo";
        assertEquals("ZAPato", Utilidades.capitalizarAlterna(cadena));
        cadena = "pez";
        assertEquals("PEZ", Utilidades.capitalizarAlterna(cadena));
        cadena = "vaso";
        assertEquals("VASo", Utilidades.capitalizarAlterna(cadena));
        cadena = "armario";
        assertEquals("ARMariO", Utilidades.capitalizarAlterna(cadena));
    }


    @Test
    public void testCapitalizarAlternaV2() {
        String cadena = "zaPaTo";
        assertEquals("ZAPato", Utilidades.capitalizarAlternaV2(cadena));
        cadena = "pez";
        assertEquals("PEZ", Utilidades.capitalizarAlternaV2(cadena));
        cadena = "vaso";
        assertEquals("VASo", Utilidades.capitalizarAlternaV2(cadena));
        cadena = "armario";
        assertEquals("ARMariO", Utilidades.capitalizarAlternaV2(cadena));
    }
    @Test
    public void testTieneLetrasRepetidas() {
        String cadena = "quebrantos";
        assertFalse(Utilidades.tieneLetrasRepetidas(cadena));
        cadena = "semanA";
        assertTrue(Utilidades.tieneLetrasRepetidas(cadena));
        cadena = "de";
        assertFalse(Utilidades.tieneLetrasRepetidas(cadena));
        cadena = "y";
        assertFalse(Utilidades.tieneLetrasRepetidas(cadena));
        cadena = "abcedfghH";
        assertTrue(Utilidades.tieneLetrasRepetidas(cadena));
    }

    @Test
    public void testTieneLetrasRepetidasV2() {
        String cadena = "quebrantos";
        assertFalse(Utilidades.tieneLetrasRepetidasV2(cadena));
        cadena = "semanA";
        assertTrue(Utilidades.tieneLetrasRepetidasV2(cadena));
        cadena = "de";
        assertFalse(Utilidades.tieneLetrasRepetidasV2(cadena));
        cadena = "y";
        assertFalse(Utilidades.tieneLetrasRepetidasV2(cadena));
        cadena = "abcedfghH";
        assertTrue(Utilidades.tieneLetrasRepetidasV2(cadena));
    }
     
}

