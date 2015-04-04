package br.mack.modeloEntidade;

import java.sql.Date;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Pagamento {
    public int identificador;
    public Date data;
    public double valor;
    
    //Set
    public void setID(int id) {identificador = id;}
    public void setData(Date date) {data = date;}
    public void setValor(double val) {valor = val;}
}
