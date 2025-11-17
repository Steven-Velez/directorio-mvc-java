package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

  
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: // Agregar
                    Producto nuevo = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(nuevo);
                    vista.mostrarMensaje("Producto agregado correctamente.");
                    break;
                case 2: // Buscar por SKU
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 3: // Mostrar todos
                    List<Producto> todos = baseDatos.buscarTodos();
                    vista.mostrarProductos(todos);
                    break;
                case 4: // Eliminar
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Producto eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("Producto no encontrado. No se eliminó.");
                    }
                    break;
                case 5: // Salir
                    salir = true;
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
