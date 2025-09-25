// RM: [Seu RM] - Nome: [Seu Nome]
package br.com.fiap.controller;

import java.util.ArrayList;

import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

public class FilmeController {

    private FilmeDAO filmeDAO = new FilmeDAO();

    public void inserirFilme(String titulo, String genero, String produtora) {
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        filmeDAO.inserir(filme);
    }

    public void alterarFilme(int codigo, String titulo, String genero, String produtora) {
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        filmeDAO.alterar(filme);
    }

    public void excluirFilme(int codigo) {
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filmeDAO.excluir(filme);
    }

    public String listarTodosFilmes() {
        ArrayList<Filme> filmes = filmeDAO.listarTodos();
        String listaFilmes = "";
        for (Filme filme : filmes) {
            listaFilmes += String.format("Código: %s\nTítulo: %s\nGênero: %s\nProdutora: %s\n--------------------\n", filme.getCodigo(), filme.getTitulo(), filme.getGenero(), filme.getProdutora());
        }
        return listaFilmes;
    }

    public void fecharConexao() {
        filmeDAO.fecharConexao();
    }
}
