package comspringboot.model;

public class UsuarioExcecao extends Exception {
    public UsuarioExcecao(String mensagem) {
        super(mensagem);
    }

    public static void validarNome(String nome) throws UsuarioExcecao {
        if (nome == null || nome.isEmpty()) {
            throw new UsuarioExcecao("Nome não pode ser vazio ou nulo.");
        }
    }

    public static void validarEmail(String email) throws UsuarioExcecao {
        if (email == null || email.isEmpty()) {
            throw new UsuarioExcecao("Email não pode ser vazio ou nulo.");
        }
    }

    public static void validarSenha(String senha) throws UsuarioExcecao {
        if (senha == null || senha.isEmpty()) {
            throw new UsuarioExcecao("Senha não pode ser vazia ou nula.");
        }
    }
}