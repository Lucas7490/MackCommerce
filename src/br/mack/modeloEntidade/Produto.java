package br.mack.modeloEntidade;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Produto {
    private String nome, descricao;
    private byte foto; //Criar uma classe para manipular a imagem? Com base nas classes de IO do JAVA
    private double preco;
    
    //Set
    public void setNome(String name) {nome = name;}
    public void setDesc(String desc) {descricao = desc;}
    public void setFoto(byte byteFoto) {foto = byteFoto;}
    public void setPreco(double preco) {this.preco = preco;}
}
