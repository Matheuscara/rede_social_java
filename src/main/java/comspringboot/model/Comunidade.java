package comspringboot.model;

import comspringboot.interfaces.Ouvinte;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Comunidade implements Ouvinte {
    private String nome;
    private String descricao;
    private List<Grupo> grupos;

    public Comunidade() {
        this.grupos = new ArrayList<>();
    }

    public void adicionarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void removerGrupo(Grupo grupo) {
        grupos.remove(grupo);
    }

    public int quantidadeMembros() {
        List<Usuario> todosMembros = new ArrayList<>();
        for (Grupo grupo : grupos) {
            for (Usuario membro : grupo.getMembros()) {
                if (!todosMembros.contains(membro)) {
                    todosMembros.add(membro);
                }
            }
        }
        return todosMembros.size();
    }

    @Override
    public void receber(String mensagem) {
        for (Grupo grupo : grupos) {
            grupo.receber(mensagem);
        }
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
