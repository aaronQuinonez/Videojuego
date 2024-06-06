package Laboratorio6;
public class Libro {
    private String titulo;
    private String autor;
    private int ejemplares;
    private int prestados;

    public Libro() {}

    public Libro(String titulo, String autor, int ejemplares, int prestados){ 
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
        this.prestados = prestados;
    }
    public String getAutor() {
        return autor;
    }   
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getEjemplares() {
        return ejemplares;
    }
    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
    public int getPrestados() {
        return prestados;
    }
    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean prestamo() {
        if (prestados < ejemplares) {
            prestados++;
            return true;
        } 
        return false;
    }

    public boolean devolucion() {
        if (prestados != 0) {
            prestados--;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nEjemplares: " + ejemplares + "\nPrestados: " + prestados; 
    }
}