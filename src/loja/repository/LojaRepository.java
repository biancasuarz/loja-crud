package loja.repository;

import loja.model.Produto;

public interface LojaRepository {

    public void procurarPorCodigo(int codigo);
    public void listarTodos();
    public void cadastrar(Produto produto);
    public void atualizar(Produto produto);
    public void excluir(int codigo);

}
