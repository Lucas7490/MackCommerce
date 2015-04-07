package br.mack.modeloEntidade;

import java.sql.Date;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Pagamento {
    private int identificador;
    private Date data;
    private double valor;
    
    //Get
    public int getID() {return identificador;}
    //Set
    public void setID(int id) {identificador = id;}
    public void setData(Date date) {data = date;}
    public void setValor(double val) {valor = val;}
}
