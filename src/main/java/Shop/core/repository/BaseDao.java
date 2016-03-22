package Shop.core.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class BaseDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public BaseDao() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void create(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public T findById(int id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
    }

}