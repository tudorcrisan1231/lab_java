import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import ex1.Calculator;

public class TestCalc {
    @Test
    public void test1_suma() {
        Calculator c=new Calculator(4,5);
        assertEquals(9, c.suma());
    }
    @Test
    public void test2_suma() {
        Calculator c=new Calculator(2,2);
        assertTrue(c.suma()==4);
    }
    @Test
    public void test3_suma() {
        Calculator c=new Calculator(3,7);
        assertFalse(c.suma()!=10);
    }
}
