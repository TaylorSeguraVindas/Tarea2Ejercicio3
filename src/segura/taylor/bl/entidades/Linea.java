package segura.taylor.bl.entidades;

public class Linea {
    /* Variables */
    private float cantidad;
    private String codigo;
    private String descripcion;
    private float precio;

    /* Propiedades */
    /* Constructores */
    public Linea(){}
    public Linea(float pCantidad, String pCodigo, String pDescripcion, float pPrecio){
        this.cantidad = pCantidad;
        this.codigo = pCodigo;
        this.descripcion = pDescripcion;
        this.precio = pPrecio;
    }

    /* Metodos */
    /* Costo de una linea (cantidad por el precio) */
    public float calcularCosto(){
        return (cantidad * precio);
    }

    /* Version en texto con todos los datos de la linea */
    public String toString(){
        String msg = "";
        msg += cantidad + "\t";
        msg += codigo + "\t";
        msg += descripcion + "\t";
        msg += precio + "\t";
        msg += calcularCosto() + "\t";
        return msg;
    }
}
