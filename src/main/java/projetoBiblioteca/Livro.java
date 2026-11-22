package projetoBiblioteca;

import java.util.Objects;

public class Livro {
    private String titulo;
    private String autor;
    private String genero; // adicionei esse atributo a mais
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, String genero, int anoPublicacao, boolean disponivel){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = disponivel;
    }
    public Livro(){
        this("","","",0,true);
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }
    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    public boolean getDisponivel(){
        return this.disponivel;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor);
    }
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
    @Override
    public String toString() {
        return "Livro: " + this.titulo + ", do(a) autor(a): " + this.autor + ", de gênero "+
                this.genero + ", ano: " + this.anoPublicacao +
                ", disponível: " + this.disponivel;
    }
}