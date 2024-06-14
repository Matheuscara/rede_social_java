package comspringboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comercial extends Usuario {
    private String cnpj;

    public Comercial(String nome, String email, String senha, String cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }
}
