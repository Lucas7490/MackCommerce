package br.mack.modeloEntidade;

import java.sql.Date;


/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Pedido {
    private int numero;
    private double valor, frete;
    private String enderecoEntrega, comentario;
    private Date dataPedido, dataEntrega;
    private boolean status; //Verificar a possibilidade de alterar para State ou mais específico para os diferentes estados (que serão pelo menos três)    
    
    
    public double calcularTotal(int numeroPedido) {
        return 0; //Impl
    }
    public double calcularFrete(String destino) {
        return 0; //Impl
    }
    public boolean statusPedido(int numeroPedido) {
        return true; //Impl
    }

    public int getNumero() {
        return numero;
}

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDtPedido() {
        return dataPedido;
    }

    public void setDtPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDtEntrega() {
        return dataEntrega;
    }

    public void setDtEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
