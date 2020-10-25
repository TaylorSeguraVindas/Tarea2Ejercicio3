package segura.taylor.bl.entidades;

public class Linea {
    /* Variables */
    private float cantidad;
    private Producto producto;

    /* Propiedades */
    /* Constructores */
    public Linea(){}
    public Linea(float pCantidad, Producto pProducto){
        this.cantidad = pCantidad;
        this.producto = pProducto;
    }

    /* Metodos */
    /* Costo de una linea (cantidad por el precio) */
    public float calcularCosto(){
        return (cantidad * producto.getPrecio());
    }

    /* Version en texto con todos los datos de la linea */
    public String toString(){
        String msg = "";
        msg += cantidad + "\t";
        msg += producto.toString() + "\t";
        msg += calcularCosto() + "\t";
        return msg;
    }
}
