package aplicables;

import productos.Producto;

public class Packaging extends Aplicables{
    private double precio;

    public Packaging(Producto producto, double precio){
        super(producto);
        this.precio = precio;
    }

    public double precio(){
        return super.producto.precio() + this.precio;
    }

}
