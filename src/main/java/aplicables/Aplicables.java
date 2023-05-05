package aplicables;

import productos.Producto;

public abstract class Aplicables extends Producto{
    protected Producto producto;

    public Aplicables(Producto producto){
        this.producto = producto;
    }

    @Override //los aplicables no afectan al stock
    public int stock(){
        return this.producto.stock();
    }
    public abstract double precio();
}
