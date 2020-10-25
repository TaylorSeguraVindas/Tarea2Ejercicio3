package segura.taylor.bl.entidades;

import java.util.Objects;

public class Producto {
    /* Variables */
    private String codigo;
    private String descripcion;
    private double precio;

    /* Propiedades */
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /* Constructores */
    public Producto(){}
    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio, precio) == 0 &&
                Objects.equals(codigo, producto.codigo) &&
                Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion, precio);
    }
}
