package projetoBiblioteca;

import java.util.List;
import java.util.ArrayList;

public class MeuSistemaBiblioteca implements SistemaBiblioteca{
    private List<Livro> livros;

    public MeuSistemaBiblioteca(){
        this.livros = new ArrayList<Livro>();
    }
    public boolean cadastrarLivro(Livro novoLivro){
        for(Livro l : this.livros){
            if(l.equals(novoLivro)){
                return false;
            }
        }
        this.livros.add(novoLivro);
        return true;
    }
    public void removerLivro(String titulo, String autor){
        for (Livro l : this.livros){
            if(l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)){
                this.livros.remove(l);
            }
        }
    }
    public List<Livro> pesquisarLivrosPeloTitulo(String titulo){
        List<Livro> livrosPesq = new ArrayList<>();
        for(Livro l : this.livros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                livrosPesq.add(l);
            }
        }return livrosPesq;
    }
    public List<Livro> pesquisarLivrosDoAutor(String autor){
        List<Livro> livrosPesq = new ArrayList<>();
        for(Livro l : this.livros){
            if(l.getAutor().equalsIgnoreCase(autor)){
                livrosPesq.add(l);
            }
        }return livrosPesq;
    }
    public List<Livro> pesquisarLivrosDoGenero(String genero){
        List<Livro> livrosPesq = new ArrayList<>();
        for(Livro l : this.livros){
            if(l.getGenero().equalsIgnoreCase(genero)){
                livrosPesq.add(l);
            }
        }return livrosPesq;
    }
    public boolean verificarSeTemDisponibilidade(String titulo,String autor){
        for(Livro l : this.livros){
            if(l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)){
                return l.getDisponivel();
            }
        }return false;
    }
    public boolean emprestarLivro(String titulo, String autor) {
        for (Livro l : this.livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                if (l.getDisponivel()) {
                    l.setDisponivel(false);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public void devolverLivro(String titulo, String autor) {
        for (Livro l : this.livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                l.setDisponivel(true);
            }
        }
    }
}

