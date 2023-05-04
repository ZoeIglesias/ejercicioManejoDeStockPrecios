package productos;

import java.util.*;


public class Combo extends Producto{
    private List<ProductoSimple> productos; //coleccion de productos

    public Combo(){ //Instancio mi coleccion
        this.productos = new ArrayList<>();
    }

    /*public void agregarProducto(ProductoSimple nuevoProducto){
        this.productos.add(nuevoProducto);
    }*/
    //Con parametros variables

    public void agregarProductos(ProductoSimple ... nuevoProducto){ //recibe un array primitivo
        Collections.addAll(this.productos,nuevoProducto);
    }

    @Override
    public double precio(){
        return this.productos.stream().mapToDouble(producto -> producto.precio()).sum();
    }
    //"Los objetos de las colecciones no pertenezcan a las colecciones sino a un objeto llamado stream"

    @Override
    public int stock(){                                                //Producto::stock es un llamado a metodo
        return Collections.min(this.productos, Comparator.comparing(Producto::stock)).stock();
        //llamamos a la clase collections al metodo min que tiene dos parametros:
        //-la coleccion donde queresmo encontrar el minimo
        //-la forma de comprarlos (queremos compararlos segun el stock) entonces llamamos a la clase producto el metodo stock
        //nos devuleve el producto por lo que le preguntamos el stock del mismo
    }

    //como lo pense yo
    public int stock2(){
        OptionalInt minStock = this.productos.stream().mapToInt(producto -> producto.stock()).min();
        return  minStock.orElse(0);
    }



}

