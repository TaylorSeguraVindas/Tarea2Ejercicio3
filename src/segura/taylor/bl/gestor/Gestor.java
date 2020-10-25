package segura.taylor.bl.gestor;

import segura.taylor.bl.entidades.Cliente;
import segura.taylor.bl.entidades.Factura;
import segura.taylor.bl.entidades.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase Gestor se encarga de toda la lógica base de la aplicación
 * es donde se interactúa directamente con los objetos que se almacenan
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class Gestor {
    /* Variables */
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Factura> facturas = new ArrayList<Factura>();


    /* Constructores */
    public Gestor(){}


    /* Metodos */

    /**
     * Este metodo se usa para registrar un producto nuevo
     * @param codigo un String que contiene el codigo del producto
     * @param descripcion un String que contiene la descripcion del producto
     * @param precio un double que contiene el precio del producto
     * @return true si el registro es correcto, false si el producto ya existe
     * @see Producto
     */
    public boolean registrarProducto(String codigo, String descripcion, double precio){
        Producto nuevoProducto = new Producto(codigo, descripcion, precio);
        if(!productos.contains(nuevoProducto)){
            productos.add(nuevoProducto);
            return true;
        }

        return false;
    }

    /**
     * Este metodo se usa para obtener la lista de productos guardada
     * @return un ArrayList que contiene los productos guardados
     * @see Producto
     * @see ArrayList
     */
    public ArrayList<Producto> listarProductos(){
        return this.productos;
    }

    /**
     * Este metodo se usa para buscar un producto basado en un codigo enviado como parametro
     * @param pCodigo el codigo por el cual se va a buscar el producto
     * @return un objeto de la clase Producto si es encontrado, null si el codigo no coincide con ningún producto
     * @see Producto
     */
    public Producto buscarProducto(String pCodigo){
        for (Producto objProducto: productos){
            if(objProducto.getCodigo().equals(pCodigo)){
                return objProducto;
            }
        }

        return null;
    }

    /**
     * Este metodo se usa para registrar un cliente nuevo
     * @param nombre un String que contiene el nombre del cliente
     * @param identificacion un String que contiene la identificacion del cliente
     * @param genero el valor de un Enumerador que define el genero del cliente
     * @param fechaNacimiento un objeto LocalDate que define la fecha de nacimiento del cliente
     * @param edad un entero que define la edad del cliente
     * @return true si el registro es correcto, false si el cliente ya existe
     */
    public boolean registrarCliente(String nombre, String identificacion, Cliente.Genero genero, LocalDate fechaNacimiento, int edad){
        Cliente nuevoCliente = new Cliente(nombre, identificacion, genero, fechaNacimiento, edad);
        if(!clientes.contains(nuevoCliente)){
            clientes.add(nuevoCliente);
            return true;
        }

        return false;
    }

    /**
     * Este metodo se usa para obtener la lista de clientes guardados
     * @return un ArrayList que contiene los clientes guardados
     * @see Cliente
     * @see ArrayList
     */
    public ArrayList<Cliente> listarClientes(){
        return this.clientes;
    }

    /**
     * Este metodo se usa para buscar un cliente basado en una identificacion enviada como parametro
     * @param identificacion la identificacion por la que se va a buscar el cliente
     * @return un objeto de la clase Cliente si es encontrado, null si la identificacion no coincide con ningún cliente
     */
    public Cliente buscarCliente(String identificacion){
        for(Cliente objCliente: clientes){
            if(objCliente.getIdentificacion().equals(identificacion)){
                return objCliente;
            }
        }

        return null;
    }

    /**
     * Este metodo se usa para crear una factura nueva
     * @param numero un String que contiene el número o código de la factura
     * @param cliente un objeto de la clase Cliente que define el cliente que realiza la factura
     * @param dia un entero que define el dia de la fecha actual
     * @param mes un entero que define el mes de la fecha actual
     * @param anno un entero que define el año de la fecha actual
     * @return un objeto de la clase Factura que se acaba de crear
     * @see Factura
     * @see Cliente
     */
    public Factura crearFactura(String numero, Cliente cliente, int dia, int mes, int anno){
        Factura nuevaFactura = new Factura(numero, cliente, dia, mes, anno);
        return nuevaFactura;
    }

    /**
     * Este metodo se usa para guardar una factura enviada como parametro
     * @param nuevaFactura la factura que se desea guardar
     * @return true si el registro es correcto, false si la factura ya existe
     */
    public boolean registrarFactura(Factura nuevaFactura){
        if(!facturas.contains(nuevaFactura)){
            facturas.add(nuevaFactura);
            return true;
        }
        return false;
    }

    /**
     * Este metodo se usa para obtener la lista de facturas guardada
     * @return un ArrayList que contiene las facturas guardadas
     * @see Factura
     * @see ArrayList
     */
    public ArrayList<Factura> listarFacturas(){
        return this.facturas;
    }

    /**
     * Este metodo se usa para buscar una factura basado en el numero o codigo enviado como parámetro
     * @param pNumero el numero por el que se va a buscar una factura
     * @return un objeto de la clase Factura si es encontrado, null si el numero no coincide con ninguna factura
     */
    public Factura buscarFactura(String pNumero){
        for(Factura objFactura: facturas){
            if(objFactura.getNumero().equals(pNumero)){
                return objFactura;
            }
        }

        return null;
    }
}
