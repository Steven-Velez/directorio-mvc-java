package controlador;

public class Producto {
    private String nombre;
    private String sku;
    private int cantidad;
    private double precio;

    public Producto(String nombre, String sku, int cantidad, double precio) {
        this.nombre = nombre;
        this.sku = sku;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getSku() {
        return sku;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("SKU: %s | Nombre: %s | Cantidad: %d | Precio: %.2f",
                sku, nombre, cantidad, precio);
    }
}
