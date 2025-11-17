import modelo.BaseDeDatos;
import vista.InventarioVista;
import controlador.ControladorInventario;

public class app {
    public static void main(String[] args) {
        BaseDeDatos baseDatos = new BaseDeDatos();
        InventarioVista vista = new InventarioVista();
        ControladorInventario controlador = new ControladorInventario(baseDatos, vista);

        controlador.iniciar();
    }
}
