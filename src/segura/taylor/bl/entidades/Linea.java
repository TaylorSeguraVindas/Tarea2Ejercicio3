package segura.taylor.bl.entidades;

public class Linea {
    /* Variables */
    private float cantidad;
    private Producto producto;

    /* Propiedades */
    /* Constructores */
    public Linea(){}

    /**
     * Metodo constructor de la clase Linea
     * @param pCantidad entero que define la cantidad de un producto
     * @param pProducto objeto de la clase Producto
     * @see Producto
     */
    public Linea(float pCantidad, Producto pProducto){
        this.cantidad = pCantidad;
        this.producto = pProducto;
    }

    /* Metodos */
    /**
     *  Costo de una linea (cantidad por el precio)
     * @return un double que contiene el costo de esta linea
     *  */
    public double calcularCosto(){
        return (cantidad * producto.getPrecio());
    }

    /**
     *  Version en texto con todos los datos de la linea
     *  */
    public String toString(){
        String msg = "";
        msg += cantidad + "\t";
        msg += producto.toString() + "\t";
        msg += calcularCosto() + "\t";
        return msg;
    }

    /**
     * Version de texto final para usar en la factura
     * @return String que contiene la version final del texto para la factura
     */
    public String stringParaFactura(){
        String msg = cantidad + "\t" + producto.getCodigo() + "\t" + producto.getDescripcion() +
                "\t" + producto.getPrecio() + "\t" + producto.getPrecio();
        return msg;
    }
}
