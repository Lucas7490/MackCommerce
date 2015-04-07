package br.mack.modeloEntidade;

import br.mack.dao.ProdutoDAO;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Carrinho {
    private int identificador;
    
    //Get
    public int getID() {return identificador;}
    //Set
    public void setID(int id) {identificador = id;}
    
    //public <<TYPE>> comprarBoleto()
    //public <<TYPE>> comprarDebito()
    //public <<TYPE>> comprarPayPal()
    public double compararProdutos(Produto p, Produto p2) {
        return 0;
    }
    /**
     * Verificar possibilidade de colocar um DAO para comentários
     * gerais vinculados ao identificador do Produto, Pedido ou outro
     * @param p
     * @return 
     */    
    public String verComentario(Produto p) {
        return "Comentario do produto..";
    }
}
