package segura.taylor.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
    /* Variables */
    private String numero;
    private Cliente cliente;
    private LocalDate fecha;
    private ArrayList<Linea> detalle;

    /* Propiedades */

    /* Constructores */
    public Factura(){
        this.fecha = LocalDate.now();
        this.detalle = new ArrayList<Linea>();
    }
    public Factura(String numero, Cliente cliente, int dia, int mes, int anno) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = LocalDate.of(anno, mes, dia);
        this.detalle = new ArrayList<Linea>();
    }

    /* Metodos */
    /* Subtotal de la factura, i.e. el total sin impuesto */
    private float calcularSubtotal(){
        float subtotal = 0;
        for (Linea lineaDetalle: detalle) {
            subtotal += lineaDetalle.calcularCosto();
        }
        return subtotal;
    }

    /* Impuesto de la factura (13% del subtotal) */
    private float calcularImpuesto(){
        float impuesto = calcularSubtotal() * (13/100);
        return impuesto;
    }

    /* Total de la factura (subtotal + impuesto) */
    public float calcularTotal(){
        float total;
        total = calcularSubtotal() + calcularImpuesto();
        return total;
    }

    /* Agregar una linea de detalle a la factura */
    public void agregarLinea(int pCantidad, Producto pProducto){
        this.detalle.add(new Linea(pCantidad, pProducto));
    }

    /* Version en texto de todos los datos de la factura */
    @Override
    public String toString(){
        String msg = "";
        msg = "================================"+ "\n";
        msg = msg + "Joyeria la Perla";
        msg = msg + "\t\t" + "No. " + numero + "\n";
        msg = msg + "cliente: " + cliente.toString() + " ";
        msg = msg + "\t" + fecha.toString() + "\n";
        msg = msg + "------------------------------------------" + "\n";
        msg = msg + "cant" + "\t"+ "codigo" + "\t"+ "descrip" +
                "\t"+ "precio" + "\t"+ "costo" + "\n";
        for (Linea objLinea: detalle) {
            msg += objLinea.toString() + "\n";
        }

        msg = msg + "\t\t\t\t" + "----------" + "\n";
        msg = msg + "\t\t\t" + "subtotal:"+this.calcularSubtotal()+"\n";
        msg = msg + "\t\t\t" + "impuesto:"+this.calcularImpuesto()+"\n";
        msg = msg + "\t\t\t" + "total :"+this.calcularTotal()+"\n";
        msg = msg + "========================" + "\n";
        return msg;
    }
}
