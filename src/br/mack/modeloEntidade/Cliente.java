package br.mack.modeloEntidade;

/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class Cliente {
    private String nome, endereco, cpf, email, telefone;
    private int login, senha;
    private boolean status; //True para ativo, false para inativo
    
    public String getNome() {return nome;}
    public String getEndereco() {return endereco;}
    public String getCpf() {return cpf;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    public int getLogin() {return login;}
    public int getSenha() {return senha;}
    
    //Set
    public void setNome(String name){nome = name;}
    public void setEndereco(String end) {endereco = end;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setTelefone(String tel) {telefone = tel;}
    public void setLogin(int log) {login = log;}
    public void setSenha(int password) {senha = password;}
    public void setStatus(boolean state) {status = state;}
    
    public boolean getStatus() {
        return status;
    }
    public boolean statusCliente(Cliente cliente) {
        return cliente.getStatus();
    }
}
