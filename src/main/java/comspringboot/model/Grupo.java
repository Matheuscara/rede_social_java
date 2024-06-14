package comspringboot.model;


import comspringboot.interfaces.Ouvinte;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Grupo implements Ouvinte {
    private String nome;
    private String descricao;
    private List<Usuario> membros;

    public Grupo() {
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Usuario membro) {
        membros.add(membro);
    }

    public void removerMembro(Usuario membro) {
        membros.remove(membro);
    }

    public void exportarCSV() {
        try (FileWriter writer = new FileWriter("output/" + nome + ".csv")) {
            for (Usuario membro : membros) {
                writer.write(membro.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importarCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("output/" + nome + ".csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("\n");
                String nome = dados[0];
                String email = dados[1];
                String senha = dados[2];

                Usuario usuario = new Usuario(nome, email, senha);
                adicionarMembro(usuario);
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receber(String mensagem) {
        for (Usuario membro : membros) {
            membro.receber(mensagem);
        }
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
