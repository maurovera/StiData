package fpuna.sti.base.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {
    public T save(T t) throws Throwable;
    public T update(T t) throws Throwable;
    public T remove(T t) throws Throwable;
    public T find(PK pk) throws Throwable;
    public List<T> findAll(String namedQuery) throws Throwable;
}
