// RM: [Seu RM] - Nome: [Seu Nome]
package br.com.fiap.view;

import javax.swing.JOptionPane;
import br.com.fiap.controller.FilmeController;

public class FilmeView {

    public static void main(String[] args) {
        FilmeController controller = new FilmeController();
        String option;

        do {
            String menu = "Escolha uma opção:\n" +
                          "1. Inserir Filme\n" +
                          "2. Alterar Filme\n" +
                          "3. Excluir Filme\n" +
                          "4. Listar Filmes\n" +
                          "5. Sair";
            option = JOptionPane.showInputDialog(menu);

            if (option == null) {
                option = "5";
            }

            switch (option) {
                case "1":
                    String titulo = JOptionPane.showInputDialog("Título do Filme:");
                    String genero = JOptionPane.showInputDialog("Gênero do Filme:");
                    String produtora = JOptionPane.showInputDialog("Produtora do Filme:");
                    controller.inserirFilme(titulo, genero, produtora);
                    System.out.println("Filme inserido com sucesso!");
                    break;
                case "2":
                    int codigoAlterar = Integer.parseInt(JOptionPane.showInputDialog("Código do Filme a ser alterado:"));
                    String novoTitulo = JOptionPane.showInputDialog("Novo Título:");
                    String novoGenero = JOptionPane.showInputDialog("Novo Gênero:");
                    String novaProdutora = JOptionPane.showInputDialog("Nova Produtora:");
                    controller.alterarFilme(codigoAlterar, novoTitulo, novoGenero, novaProdutora);
                    System.out.println("Filme alterado com sucesso!");
                    break;
                case "3":
                    int codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog("Código do Filme a ser excluído:"));
                    controller.excluirFilme(codigoExcluir);
                    System.out.println("Filme excluído com sucesso!");
                    break;
                case "4":
                    String listaFilmes = controller.listarTodosFilmes();
                    JOptionPane.showMessageDialog(null, listaFilmes);
                    break;
                case "5":
                    System.out.println("Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (!option.equals("5"));

        controller.fecharConexao();
    }
}
