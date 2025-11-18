package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controlador.Producto;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n====== Inventario - DevSolutions ======");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar un producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción (1-5): ");

        int opcion = -1;
        while (true) {
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Ingrese un número entre 1 y 5: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número entre 1 y 5: ");
            }
        }
        return opcion;
    }

    
    public  Producto pedirDatosUsuario() {
        System.out.println("\n--- Agregar nuevo producto ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("SKU: ");
        String sku = scanner.nextLine().trim();

        int cantidad = 0;
        while (true) {
            System.out.print("Cantidad (entero): ");
            String linea = scanner.nextLine().trim();
            try {
                cantidad = Integer.parseInt(linea);
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }

        double precio = 0.0;
        while (true) {
            System.out.print("Precio unitario (ej:$20.000 pesos): ");
            String linea = scanner.nextLine().trim();
            try {
                precio = Double.parseDouble(linea);
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número ($15.000 pesos).");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

  
    public String pedirSku() {
        System.out.print("\nIngrese el SKU del producto: ");
        return scanner.nextLine().trim();
    }

    
    public void mostrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto.toString());
        }
    }

    
    public void mostrarProductos(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de productos ---");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
