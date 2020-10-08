package com.admin.daoImpl;

import com.admin.dao.GenericDao;
import com.admin.dto.CollegeDto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> persistenceClass;

    @PersistenceContext(unitName = "FEST_PU")
    private EntityManager entityManager;

    private Logger logger;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
        logger = LoggerFactory.getLogger(this.persistenceClass.getClass());
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Boolean save(T entity) {
        try {
            logger.info(" Persisting {0}", getPersistenceClass().getSimpleName());
            getEntityManager().persist(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Could not save", e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean modify(T entity) {
        try {
            logger.info(" Modifying {0}", getPersistenceClass().getSimpleName());
            getEntityManager().merge(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Could not update", e);
            return false;
        }
    }

    @Override
    public T getById(Long id) {
        T entity = (T) getEntityManager()
                .createQuery("Select x FROM " + getPersistenceClass().getSimpleName() + " x where x.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        return entity;
    }

    @Override
    public List<T> findAll() {
        return getEntityManager()
                .createQuery("Select x FROM " + getPersistenceClass().getSimpleName() + " x")
                .getResultList();
    }

    @Override
    public Long totalCount() {
        return (Long) getEntityManager().createQuery("SELECT count(x) FROM " + getPersistenceClass().getSimpleName() + " x").getSingleResult();
    }

    @Override
    public Long getTotalCount() {
        return (Long) getEntityManager().createQuery("SELECT COUNT(x) FROM " + getPersistenceClass().getSimpleName() + " x")
                .getSingleResult();
    }
    
    @Override
    public List<T> findAllByCollegeId(CollegeDto collegeDto) {
        return getEntityManager().createQuery("SELECT en FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.createdByAdmin.college.id=:collegeId")
                .setParameter("collegeId", collegeDto.getId())
                .getResultList();
    }
}
