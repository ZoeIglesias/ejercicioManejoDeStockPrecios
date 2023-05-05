package aplicables;

import productos.Producto;

public class Desceunto extends Aplicables{
    private double valor;

    public Desceunto(Producto producto, double valor){
       super(producto);
       this.valor = valor;
    }

    public double precio(){
        return super.producto.precio() - this.valor;
    }

}
