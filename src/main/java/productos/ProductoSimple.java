package productos;


import lombok.Setter;

public class ProductoSimple extends Producto{
    @Setter private double precio;
    private int stock;

    //Hacemos un constructor para asignar valores iniciales (ej: para utilizar en un test)
    public  ProductoSimple(double precio , int stock){
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public double precio(){
        return this.precio;
    }
    @Override
    public int stock(){
        return this.stock;
    }

}
