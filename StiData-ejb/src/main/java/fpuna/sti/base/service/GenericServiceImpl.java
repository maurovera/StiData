package fpuna.sti.base.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
 
	@PersistenceContext(unitName="postgresPU")
    protected EntityManager em;
    protected Class<T> clazz;

    public GenericServiceImpl(Class<T> clazz) {
        this.clazz = clazz;
    }
    @Override
    public T save(T t) throws Throwable {
        em.persist(t);
        em.flush();
        return t;
    }
    @Override
    public T remove(T t) throws Throwable {
        em.remove(t);
        em.flush();
        return t;
    }
    @Override
    public T update(T t) throws Throwable {
        em.merge(t);
        em.flush();
        return t;
    }
    @Override
    public T find(PK pk) throws Throwable {
        return (T) em.find(clazz, pk);
    }
    @Override
    public List<T> findAll(String aQuery) throws Throwable {
        TypedQuery<T> query = em.createQuery(aQuery, clazz);
        return query.getResultList();
    }
}