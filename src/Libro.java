public class Libro {

    private String titulo;
    private String autor;
    private int codigo;
    private String genero;
    private int publicacion;
    private  int copiasDisponibles;


    public Libro (String titulo, String autor, int codigo, String genero, int publicacion, int copiasDisponibles){

        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.genero = genero;
        this.publicacion = publicacion;
        this.copiasDisponibles = copiasDisponibles;

    }

    public String getTitulo(){
        return titulo;

    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;

    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getCodigo(){
        return codigo;

    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getGenero(){
        return genero;

    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getPublicacion(){
        return publicacion;

    }

    public void setPublicación(int publicacion){
        this.publicacion = publicacion;
    }

    public int getCopiasDisponibles(){
        return copiasDisponibles;

    }

    public void setCopiasDisponibles(int copiasDisponibles){
        this.copiasDisponibles = copiasDisponibles;
    }

    public String toString (){
        return "Título: " + titulo +
                ", Autor: " + autor +
                ", Código: " + codigo +
                ", Género: " + genero +
                ", Publicación: " + publicacion +
                ", Copias disponibles: " + copiasDisponibles;


    }
}

