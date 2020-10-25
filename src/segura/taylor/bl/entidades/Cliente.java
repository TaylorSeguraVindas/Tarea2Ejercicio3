package segura.taylor.bl.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Cliente {
    /* Enums */
    public enum Genero{
        MASCULINO,
        FEMENINO,
        SIN_ESPECIFICAR
    }

    /* Variables */
    private String nombre;
    private String identificacion;
    private Genero genero;
    private LocalDate fechaNacimiento;
    private int edad;

    /* Propiedades */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        this.edad = calcularEdad();
        return edad;
    }

    /* Constructores */
    public Cliente(){}
    public Cliente(String nombre, String identificacion, Genero genero, LocalDate fechaNacimiento, int edad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    /* Metodos*/

    /* Para calcular la edad cuando sea necesario */
    private int calcularEdad(){
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);

        return period.getYears();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", genero=" + genero +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return edad == cliente.edad &&
                Objects.equals(nombre, cliente.nombre) &&
                Objects.equals(identificacion, cliente.identificacion) &&
                genero == cliente.genero &&
                Objects.equals(fechaNacimiento, cliente.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, identificacion, genero, fechaNacimiento, edad);
    }
}
