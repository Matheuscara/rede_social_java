package comspringboot.interfaces;

public interface Emissor {
    void notificar(Ouvinte ouvinte, String mensagem);
}
