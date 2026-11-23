package projetoBiblioteca;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String msg) {
        super(msg);
    }
}
