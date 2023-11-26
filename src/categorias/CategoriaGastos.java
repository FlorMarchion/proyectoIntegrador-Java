package categorias;

public abstract class CategoriaGastos {
    private String nombre;

    public CategoriaGastos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
