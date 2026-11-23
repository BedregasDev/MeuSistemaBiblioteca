package projetoBiblioteca;
import java.util.List;

public interface SistemaBiblioteca {
    public boolean cadastrarLivro(Livro novoLivro) throws LivroJaCadastradoException;
    public void removerLivro(String titulo, String autor) throws LivroNaoEncontradoException;
    public List<Livro> pesquisarLivrosPeloTitulo(String titulo);
    public List<Livro> pesquisarLivrosDoAutor(String autor);
    public List<Livro> pesquisarLivrosDoGenero(String genero);
    public boolean verificarSeTemDisponibilidade(String titulo,String autor) throws LivroNaoEncontradoException;
    public boolean emprestarLivro(String titulo,String autor) throws LivroNaoEncontradoException;
    public void devolverLivro(String titulo, String autor) throws LivroNaoEncontradoException;
}
