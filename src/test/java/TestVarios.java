import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productos.Combo;
import productos.ProductoSimple;

public class TestVarios {

    @Test
    public void testDePreciosDeUnCombo(){
        ProductoSimple casco = new ProductoSimple(300.0,5);
        ProductoSimple guante = new ProductoSimple(100.0,2);

        Combo comboSimple = new Combo();

        comboSimple.agregarProductos(casco,guante);

        Assertions.assertEquals(400.0,comboSimple.precio());

    }
}
