package comspringboot.model;
import comspringboot.interfaces.Emissor;
import comspringboot.interfaces.Ouvinte;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Getter
@Setter
public class Usuario implements Emissor, Ouvinte {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        try {
            setNome(nome);
            setEmail(email);
            setSenha(senha);
        } catch (UsuarioExcecao e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notificar(Ouvinte ouvinte, String mensagem) {
        ouvinte.receber(mensagem);
        logMensagem(this, ouvinte, mensagem);
    }

    @Override
    public void receber(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }

    private void logMensagem(Emissor emissor, Ouvinte ouvinte, String mensagem) {
        try (FileWriter fw = new FileWriter("output/log.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(java.time.LocalDateTime.now() + " - " + emissor + " -> " + ouvinte + ": " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws UsuarioExcecao {
        UsuarioExcecao.validarNome(nome);
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UsuarioExcecao {
        UsuarioExcecao.validarEmail(email);
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws UsuarioExcecao {
        UsuarioExcecao.validarSenha(senha);
        this.senha = senha;
    }
}

