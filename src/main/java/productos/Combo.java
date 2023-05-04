package productos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Combo extends Producto{
    private List<ProductoSimple> productos; //coleccion de productos

    public Combo(){ //Instancio mi coleccion
        this.productos = new ArrayList<>();
    }

    /*public void agregarProducto(ProductoSimple nuevoProducto){
        this.productos.add(nuevoProducto);
    }*/
    //Con parametros variables

   public void agregarProductos(ProductoSimple ... nuevoProducto){
       Collections.addAll(this.productos,nuevoProducto);
    }

    @Override
    public double precio(){
        return this.productos.stream().mapToDouble(producto -> producto.precio()).sum();
    }
    //"Los objetos de las colecciones no pertenezcan a las colecciones sino a un objeto llamado stream"

    @Override
    public int stock(){
        return 0;
    }



}
