package br.mack.modeloEntidade;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Cliente {
    private String nome, endereco, cpf, email, telefone;
    private int login, senha;
    private boolean status; //True para ativo, false para inativo
    
    public void setNome(String name) {nome = name;}
    public void setEndereco(String end) {endereco = end;}
    public void setCPF(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String tel) {telefone = tel;}
    public void setLogin(int log) {login = log;}
    public void setSenha(int password) {senha = password;}
    public boolean getStatus() {
        return status;
    }
    public boolean statusCliente(Cliente cliente) {
        return cliente.getStatus();
    }
}
