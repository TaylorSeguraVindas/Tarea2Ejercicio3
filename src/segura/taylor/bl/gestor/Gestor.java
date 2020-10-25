package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Cliente;
import segura.taylor.bl.entidades.Factura;
import segura.taylor.bl.entidades.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor {
    /* Variables */
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Factura> facturas = new ArrayList<Factura>();


    /* Constructores */
    public Gestor(){}


    /* Metodos */
    public boolean registrarProducto(String codigo, String descripcion, double precio){
        Producto nuevoProducto = new Producto(codigo, descripcion, precio);
        if(!productos.contains(nuevoProducto)){
            productos.add(nuevoProducto);
            return true;
        }

        return false;
    }
    public ArrayList<Producto> listarProductos(){
        return this.productos;
    }
    public Producto buscarProducto(String pCodigo){
        for (Producto objProducto: productos){
            if(objProducto.getCodigo().equals(pCodigo)){
                return objProducto;
            }
        }

        return null;
    }


    public boolean registrarCliente(String nombre, String identificacion, Cliente.Genero genero, LocalDate fechaNacimiento, int edad){
        Cliente nuevoCliente = new Cliente(nombre, identificacion, genero, fechaNacimiento, edad);
        if(!clientes.contains(nuevoCliente)){
            clientes.add(nuevoCliente);
            return true;
        }

        return false;
    }
    public ArrayList<Cliente> listarClientes(){
        return this.clientes;
    }
    public Cliente buscarCliente(String identificacion){
        for(Cliente objCliente: clientes){
            if(objCliente.getIdentificacion().equals(identificacion)){
                return objCliente;
            }
        }

        return null;
    }


    public Factura crearFactura(String numero, Cliente cliente, int dia, int mes, int anno){
        Factura nuevaFactura = new Factura(numero, cliente, dia, mes, anno);
        return nuevaFactura;
    }
    public boolean registrarFactura(Factura nuevaFactura){
        if(!facturas.contains(nuevaFactura)){
            facturas.add(nuevaFactura);
            return true;
        }
        return false;
    }
    public ArrayList<Factura> listarFacturas(){
        return this.facturas;
    }
    public Factura buscarFactura(String pNumero){
        for(Factura objFactura: facturas){
            if(objFactura.getNumero().equals(pNumero)){
                return objFactura;
            }
        }

        return null;
    }
}
