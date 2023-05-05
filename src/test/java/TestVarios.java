import aplicables.Desceunto;
import aplicables.Packaging;
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
    Desceunto desceuntoFijo;
    Packaging packaging;

    @BeforeEach
    public void init(){
        this.casco = new ProductoSimple(300.0,5);
        this.guante = new ProductoSimple(100.0,2);
        this.comboSimple = new Combo();
        this.comboDoble = new Combo();
        comboSimple.agregarProductos(casco,guante);

        this.desceuntoFijo = new Desceunto(comboSimple,50);
        this.packaging = new Packaging(comboSimple, 100);


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
    @Test
    @DisplayName("Prueba de precio de un combo aplicandole un desceunto fijo")
    public void testPrecioComobo350(){

        Assertions.assertEquals(350, desceuntoFijo.precio());
    }
    @Test
    @DisplayName("Prueba de precio de un combo sumandole un packaging")
    public void testPrecioCombo500(){
        Assertions.assertEquals(500, packaging.precio());
    }

    @Test
    @DisplayName("Prueba de descuanto sobre descuento sobre un producto")
    public void tetsDePrecioSobreProductoConDescuento260(){

        Desceunto descuentoFijoSobreProducto = new Desceunto(casco , 20);
        Desceunto descuentoFijoSobreProducto2 = new Desceunto(descuentoFijoSobreProducto,20);

        Assertions.assertEquals(260, descuentoFijoSobreProducto2.precio());

    }

}
