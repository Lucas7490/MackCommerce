package br.mack.dao;

import br.mack.modeloEntidade.Cliente;
import java.util.Set;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 */
public class ClienteDAO extends DAO<Object>{

    @Override
    public void create(Object el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Set<Cliente> readAll() {return null;}
}
