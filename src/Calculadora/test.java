package Calculadora;

import org.junit.Assert;
import org.junit.Test;

public class test {
    Calculadora calculadora = new Calculadora(1, 1);

    @Test
    public void testSumar() {
        Assert.assertEquals(2, calculadora.sumar());
    }
    @Test
    public void testRestar() {
        Assert.assertEquals(0, calculadora.restar());
    }
    @Test
    public void testMultiplicar() {
        Assert.assertEquals(1, calculadora.multiplicar());
    }
    @Test
    public void testDividir() {
        Assert.assertEquals(1, calculadora.dividir());
    }
}
