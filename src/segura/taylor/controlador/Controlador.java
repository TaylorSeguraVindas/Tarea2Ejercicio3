package segura.taylor.controlador;

import segura.taylor.bl.entidades.Cliente;
import segura.taylor.bl.entidades.Factura;
import segura.taylor.bl.entidades.Linea;
import segura.taylor.bl.entidades.Producto;
import segura.taylor.bl.gestor.Gestor;
import segura.taylor.ui.UI;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controlador {
    private UI ui = new UI();
    private Gestor gestor = new Gestor();

    public void iniciarPrograma(){
        int opcion = 0;

        do{
            ui.imprimirLinea("Bienvenido!");
            ui.imprimirLinea("1. Registrar producto");
            ui.imprimirLinea("2. Listar productos");
            ui.imprimirLinea("3. Registrar cliente");
            ui.imprimirLinea("4. Listar clientes");
            ui.imprimirLinea("5. Crear factura");
            ui.imprimirLinea("6. Listar facturas");
            ui.imprimirLinea("7. Salir");
            ui.imprimir("Su opcion: ");
            opcion = ui.leerEntero();
            procesarOpcion(opcion);
        } while(opcion != 7);
    }

    private void procesarOpcion(int opcion){
        switch(opcion){
            case 1:
                registrarProducto();
                break;
            case 2:
                listarProductos();
                break;
            case 3:
                registrarCliente();
                break;
            case 4:
                listarClientes();
                break;
            case 5:
                crearFactura();
                break;
            case 6:
                listarFacturas();
                break;
            case 7:
                ui.imprimirLinea("Adios");
                break;
            default:
                ui.imprimirLinea("Opcion invalida");
                break;
        }
    }
    private int calcularEdad(LocalDate fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);

        return period.getYears();
    }

    private Producto registrarProducto(){
        //String codigo, String descripcion, float precio
        ui.imprimirLinea("\n\nRegistro de producto");
        ui.imprimir("Codigo: ");
        String codigo = ui.leerLinea();
        ui.imprimir("Descripcion: ");
        String descripcion = ui.leerLinea();
        ui.imprimir("Precio: ");
        double precio = ui.leerDouble();

        boolean resultado = gestor.registrarProducto(codigo, descripcion, precio);
        if(resultado){
            ui.imprimirLinea("Producto registrado correctamente");
            return gestor.buscarProducto(codigo);
        } else {
            ui.imprimirLinea("ERROR: no se pudo registrar el producto porque ya ha sido registrado antes");
        }
        return null;
    }
    private void listarProductos(){
        ui.imprimirLinea("\n\nLista de productos");
        ArrayList<Producto> productos = gestor.listarProductos();
        for(Producto objProducto: productos){
            ui.imprimirLinea(objProducto.toString());
        }
    }

    private Cliente registrarCliente(){
        ui.imprimirLinea("\n\nRegistro de cliente");
        ui.imprimir("Nombre: ");
        String nombre = ui.leerLinea();
        ui.imprimir("Identificacion: ");
        String identificacion = ui.leerLinea();

        ui.imprimirLinea("Seleccione un genero: ");
        ui.imprimirLinea("1. Masculino");
        ui.imprimirLinea("2. Femenino");
        ui.imprimir("Su opcion: ");
        int opcionGenero = ui.leerEntero();
        Cliente.Genero genero;

        switch (opcionGenero){
            case 1:
                genero = Cliente.Genero.MASCULINO;
                break;
            case 2:
                genero = Cliente.Genero.FEMENINO;
                break;
            default:
                genero = Cliente.Genero.SIN_ESPECIFICAR;
        }

        ui.imprimirLinea("\nFecha de nacimiento");
        ui.imprimir("Numero Dia: ");
        int dia = ui.leerEntero();
        ui.imprimir("Numero mes: ");
        int mes = ui.leerEntero();
        ui.imprimir("Año: ");
        int anno = ui.leerEntero();

        LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
        int edad = calcularEdad(fechaNacimiento);

        boolean resultado = gestor.registrarCliente(nombre, identificacion, genero, fechaNacimiento, edad);
        if(resultado){
            ui.imprimirLinea("Cliente registrado correctamente");
            return gestor.buscarCliente(identificacion);
        } else {
            ui.imprimirLinea("ERROR: no se pudo registrar el cliente porque ya ha sido registrado antes");
        }
        return null;
    }
    private void listarClientes(){
        ui.imprimirLinea("\n\nLista de clientes");
        ArrayList<Cliente> clientes = gestor.listarClientes();
        for(Cliente objCliente: clientes){
            ui.imprimirLinea(objCliente.toString());
        }
    }

    private Factura crearFactura(){
        Factura facturaActual;

        ui.imprimirLinea("\nCreacion de factura");
        ui.imprimirLinea("Numero: ");
        String numero = ui.leerLinea();

        Cliente cliente;
        do{
            ui.imprimirLinea("Identificacion del cliente: ");
            String idCliente = ui.leerLinea();

            //Primero busca un cliente con ese id.
            cliente = gestor.buscarCliente(idCliente);

            //Si no se encuentra entonces se crea uno nuevo.
            if(cliente == null){
                ui.imprimirLinea("No se ha encontrado ningun cliente con esa identificacion. Que desea hacer?");
                ui.imprimirLinea("1. Registrar un nuevo cliente");
                ui.imprimirLinea("2. Intentar con otra identificacion");
                ui.imprimirLinea("3. Cancelar factura");
                ui.imprimir("Su opcion: ");
                int opcionCliente = ui.leerEntero();

                switch(opcionCliente){
                    case 1:
                        //Crear nuevo cliente
                        cliente = registrarCliente();
                        break;
                    case 3:
                        //Salir del proceso
                        return null;
                    default:
                        //No hacer nada para volver a intentarlo
                        break;
                }
            }
        }while (cliente == null);

        ui.imprimirLinea("\nFecha actual");
        ui.imprimir("Numero de dia: ");
        int dia = ui.leerEntero();
        ui.imprimir("Numero de mes: ");
        int mes = ui.leerEntero();
        ui.imprimir("Año: ");
        int anno = ui.leerEntero();

        facturaActual = gestor.crearFactura(numero, cliente, dia, mes, anno);

        int opcion = 0;
        do{
            ui.imprimirLinea("Que desea hacer con la factura?");
            ui.imprimirLinea("1. Agregar linea de detalle");
            ui.imprimirLinea("2. Terminar factura");
            ui.imprimir("Su opcion: ");
            opcion = ui.leerEntero();

            if(opcion == 1){
                //Agregar nueva linea
                Linea nuevaLinea = crearLinea();
                facturaActual.agregarLinea(nuevaLinea);
            }
        }while(opcion != 2);

        boolean resultado = gestor.registrarFactura(facturaActual);

        if(resultado){
            ui.imprimirLinea("Factura registrada correctamente");
            ui.imprimirLinea(facturaActual.toString());
            return gestor.buscarFactura(numero);
        } else {
            ui.imprimirLinea("ERROR: no se pudo registrar la factura porque ya ha sido registrada antes");
        }
        return null;
    }
    private void listarFacturas(){
        ui.imprimirLinea("\n\nLista de facturas");
        ArrayList<Factura> facturas = gestor.listarFacturas();
        for(Factura objFactura: facturas){
            ui.imprimirLinea("\n\n" + objFactura.toString());
        }
    }
    private Linea crearLinea(){
        //float pCantidad, Producto pProducto
        Producto producto;

        ui.imprimirLinea("\nCreacion de linea de detalle");

        do {
            ui.imprimir("Codigo del producto: ");
            String codigoProducto = ui.leerLinea();

            //Primero busca un producto que tenga ese codigo
            producto = gestor.buscarProducto(codigoProducto);

            //Si no lo encuentra se da la opcion de crear uno nuevo
            if(producto == null){
                ui.imprimirLinea("No se ha encontrado ningun producto con ese codigo. Que desea hacer?");
                ui.imprimirLinea("1. Registrar un nuevo producto");
                ui.imprimirLinea("2. Intentar con otro codigo");
                ui.imprimirLinea("3. Cancelar linea");
                ui.imprimir("Su opcion: ");
                int opcionCliente = ui.leerEntero();

                switch(opcionCliente){
                    case 1:
                        //Crear nuevo producto
                        producto = registrarProducto();
                        break;
                    case 3:
                        //Salir del proceso
                        return null;
                    default:
                        //No hacer nada para volver a intentarlo
                        break;
                }
            }
        } while(producto == null);

        ui.imprimir("Cantidad: ");
        int cantidad = ui.leerEntero();

        Linea nuevaLinea = new Linea(cantidad, producto);
        return nuevaLinea;
    }
}
