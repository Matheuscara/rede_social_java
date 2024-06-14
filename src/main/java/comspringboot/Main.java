package comspringboot;

import comspringboot.model.Comunidade;
import comspringboot.model.Grupo;
import comspringboot.model.Pessoal;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Criando usuários
        Pessoal usuario1 = new Pessoal("Elian", "elian@javeiros.com", "123", "999.999.999-99");
        Pessoal usuario2 = new Pessoal("Ana Amélia", "ana.amelia@javeiros.com", "123", "888.888.888-88");
        Pessoal usuario3 = new Pessoal("José Neto", "jose.neto@javeiros.com", "123", "777.777.777-77");
        System.out.print("Digite o nome do usuário 4: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do usuário 4: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha do usuário 4: ");
        String senha = scanner.nextLine();
        System.out.print("Digite o CPF do usuário 4: ");
        String cpf = scanner.nextLine();
        Pessoal usuario4 = new Pessoal(nome, email, senha, cpf);

        // Criando grupos
        Grupo grupo1 = new Grupo();
        grupo1.setNome("Javeiros, guerreiros, destruidores");
        grupo1.setDescricao("Javeiros de corpo e alma");
        Grupo grupo2 = new Grupo();
        grupo2.setNome("C raiz");
        grupo2.setDescricao("Por que qualquer outra coisa é overhead");

        // Adicionando usuários aos grupos
        grupo1.adicionarMembro(usuario1);
        grupo1.adicionarMembro(usuario2);
        grupo2.adicionarMembro(usuario1);
        grupo2.adicionarMembro(usuario3);

        // Criando comunidade
        Comunidade comunidade = new Comunidade();
        comunidade.setNome("Programadores do Iraque");
        comunidade.setDescricao("Programadores nascidos e criados em Irajá.");
        comunidade.adicionarGrupo(grupo1);
        comunidade.adicionarGrupo(grupo2);

        // Enviando mensagem
        usuario1.notificar(comunidade, "Salve, salve, galera!");
        usuario2.notificar(comunidade, "Salve, teste, galera!");

        // Exportando dados dos grupos para CSV
        grupo1.exportarCSV();
        grupo2.exportarCSV();

        // Imprimindo a quantidade de membros na comunidade
        System.out.println("Quantidade de membros na comunidade: " + comunidade.quantidadeMembros());
    }
}