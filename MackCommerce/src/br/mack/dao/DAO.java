package br.mack.dao;

import jdbc.DataSource;
/**
 *
 * @author Grupo 01 - Tema: Loja virtual
 * @param <T>
 */
public abstract class DAO<T> {
    private DataSource dataSource;
    
    public abstract void create(T el);
    public abstract T read(T key);
    public abstract T delete(T key);
    public abstract void update(T key);
}
