package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDeDatos {
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

   
    public Producto buscarProductoSku(String sku) {
        if (sku == null) return null;
        String skuNormalized = sku.trim().toLowerCase();
        for (Producto p : productos) {
            if (p.getSku() != null && p.getSku().trim().toLowerCase().equals(skuNormalized)) {
                return p;
            }
        }
        return null;
    }

    
    public List<Producto> buscarTodos() {
        return productos;
    }

    public boolean eliminarProducto(String sku) {
        if (sku == null) return false;
        String skuNormalized = sku.trim().toLowerCase();
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getSku() != null && p.getSku().trim().toLowerCase().equals(skuNormalized)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
