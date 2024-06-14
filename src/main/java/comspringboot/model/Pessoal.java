package comspringboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoal extends Usuario {
    private String cpf;

    public Pessoal(String nome, String email, String senha, String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }
}
