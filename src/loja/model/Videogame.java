package loja.model;

public class Videogame extends Produto {

    private int voltagem;

    public Videogame (int codigo, String nome, String descricao, double preco, int quantidade) {
        super(codigo, nome, descricao, preco, quantidade);
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Voltagem: " + this.voltagem);
    }
}
