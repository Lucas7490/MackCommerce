package br.mack.modeloEntidade;

import java.util.GregorianCalendar;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Pedido {
    private int numero;
    private double valor, frete;
    private String enderecoEntrega, comentario;
    private GregorianCalendar dataPedido, dataEntrega;
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
}
