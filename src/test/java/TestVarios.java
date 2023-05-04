import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import productos.Combo;
import productos.ProductoSimple;

public class TestVarios {

    ProductoSimple casco;
    ProductoSimple guante;
    Combo comboSimple;
    Combo comboDoble;

    @BeforeEach
    public void init(){
        this.casco = new ProductoSimple(300.0,5);
        this.guante = new ProductoSimple(100.0,2);
        this.comboSimple = new Combo();
        this.comboDoble = new Combo();
        comboSimple.agregarProductos(casco,guante);

    }

    @Test
    @DisplayName("Prueba de el precio de un combo.")
    public void testDePrecioDeUnComboVale400(){

        Assertions.assertEquals(400.0,comboSimple.precio());

    }

    @Test
    @DisplayName("Prueba de stock de un combo.")
    public void testsDeStockDeUnComboVale2(){

        Assertions.assertEquals(2,comboSimple.stock());

    }
}
