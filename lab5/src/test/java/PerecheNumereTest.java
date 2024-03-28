import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import ex2.PerecheNumere;

public class PerecheNumereTest {
    //minimum 3 tests for each method from PerecheNumere.java

    @Test
    public void test1_isFibonacci() {
        PerecheNumere p = new PerecheNumere(1, 2);
        assertTrue(p.isFibonacci());
    }

    @Test
    public void test2_isFibonacci() {
        PerecheNumere p = new PerecheNumere(3, 5);
        assertTrue(p.isFibonacci());
    }

    @Test
    public void test3_isFibonacci() {
        PerecheNumere p = new PerecheNumere(9, 12);
        assertTrue(p.isFibonacci());
    }

    @Test
    public void test1_cmmdc() {
        PerecheNumere p = new PerecheNumere(4, 5);
        assertEquals(1, p.cmmdc());
    }

    @Test
    public void test2_cmmdc() {
        PerecheNumere p = new PerecheNumere(2, 2);
        assertTrue(p.cmmdc() == 2);
    }

    @Test
    public void test3_cmmdc() {
        PerecheNumere p = new PerecheNumere(3, 7);
        assertFalse(p.cmmdc() != 1);
    }

    @Test
    public void test1_isSumOfDigitsEqual() {
        PerecheNumere p = new PerecheNumere(15, 123);
        assertTrue(p.isSumOfDigitsEqual());
    }

    @Test
    public void test2_isSumOfDigitsEqual() {
        PerecheNumere p = new PerecheNumere(2, 2);
        assertTrue(p.isSumOfDigitsEqual());
    }

    @Test
    public void test3_isSumOfDigitsEqual() {
        PerecheNumere p = new PerecheNumere(3, 7);
        assertFalse(p.isSumOfDigitsEqual());
    }

    @Test
    public void test1_hasEqualNumberOfEvenDigits() {
        PerecheNumere p = new PerecheNumere(234, 135786);
        assertTrue(p.hasEqualNumberOfEvenDigits());
    }

    @Test
    public void test2_hasEqualNumberOfEvenDigits() {
        PerecheNumere p = new PerecheNumere(2, 2);
        assertTrue(p.hasEqualNumberOfEvenDigits());
    }

    @Test
    public void test3_hasEqualNumberOfEvenDigits() {
        PerecheNumere p = new PerecheNumere(3, 7);
        assertTrue(p.hasEqualNumberOfEvenDigits());
    }
}
