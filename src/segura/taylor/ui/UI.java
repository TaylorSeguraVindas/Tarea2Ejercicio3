package segura.taylor.ui;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * La clase UI se usa para permitir la interacción del usuario con
 * la aplicación mediante el uso de la consola
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class UI {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\\n");

    /**
     * Este método se usa para mostrar un mensaje por consola
     * sin saltar de linea
     * @param  mensaje  un String que contiene el mensaje que se desea mostrar
     */
    public void imprimir(String mensaje){
        output.print(mensaje);
    }
    /**
     * Este método se usa para mostrar un mensaje por consola
     * con salto de linea
     * @param  mensaje  un String que contiene el mensaje que se desea mostrar
     */
    public void imprimirLinea(String mensaje){
        output.println(mensaje);
    }

    /**
     * Este método se usa para leer una cadena de caracteres de la consola
     * @return la cadena de caracteres que el usuario ingresa
     */
    public String leerLinea(){
        return input.next();
    }
    /**
     * Este método se usa para leer un numero entero de la consola
     * @return el entero que el usuario ingresa
     */
    public int leerEntero(){
        return input.nextInt();
    }
    /**
     * Este método se usa para leer un numero decimal de la consola
     * @return el numero decimal que el usuario ingresa
     */
    public double leerDouble(){
        return input.nextDouble();
    }
}

