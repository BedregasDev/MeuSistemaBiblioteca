package projetoBiblioteca;

import java.util.List;
import java.util.ArrayList;

public class MeuSistemaBiblioteca implements SistemaBiblioteca{
    private List<Livro> livros;

    public MeuSistemaBiblioteca(){
        this.livros = new ArrayList<Livro>();
    }
    public boolean cadastrarLivro(Livro novoLivro) throws LivroJaCadastradoException{
        for(Livro l : this.livros){
            if(l.equals(novoLivro)){
                throw new LivroJaCadastradoException("Livro já cadastrado: "
                        + novoLivro.getTitulo() + ", de " + novoLivro.getAutor());
            }
        }
        this.livros.add(novoLivro);
        return true;
    }
    public void removerLivro(String titulo, String autor) throws LivroNaoEncontradoException {
        for (Livro l : this.livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                this.livros.remove(l);
                return;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado: " + titulo + ", de " + autor);
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
    public boolean verificarSeTemDisponibilidade(String titulo,String autor) throws LivroNaoEncontradoException{
        for(Livro l : this.livros){
            if(l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)){
                return l.getDisponivel();
            }
        }throw new LivroNaoEncontradoException("Livro não encontrado: " + titulo + ", de " + autor);
    }
    public boolean emprestarLivro(String titulo, String autor) throws LivroNaoEncontradoException{
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
        throw new LivroNaoEncontradoException("Livro não encontrado: " + titulo + ", de " + autor);
    }
    public void devolverLivro(String titulo, String autor) throws LivroNaoEncontradoException {
        for (Livro l : this.livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) &&
                    l.getAutor().equalsIgnoreCase(autor)) {
                l.setDisponivel(true);
            }
        }throw new LivroNaoEncontradoException("Livro não encontrado: " + titulo + ", de " + autor);
    }
}