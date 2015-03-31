package br.mack.modeloEntidade;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Cliente {
    private String nome, endereco, cpf, email, telefone;
    private int login, senha;
    private boolean status; //True para ativo, false para inativo
    
    public boolean getStatus() {
        return status;
    }
    public boolean statusCliente(Cliente cliente) {
        return cliente.getStatus();
    }
}
