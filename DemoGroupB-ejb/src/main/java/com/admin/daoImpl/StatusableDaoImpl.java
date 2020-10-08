package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.StatusableDao;
import com.admin.dto.CollegeDto;
import java.util.List;

public class StatusableDaoImpl<T> extends GenericDaoImpl<T> implements StatusableDao<T> {

    public StatusableDaoImpl() {
    }

    public StatusableDaoImpl(Class<T> persistenceClass) {
        super(persistenceClass);
    }

    @Override
    public List<T> findAllByNotInStatus(List<String> statusNames) {
        return getEntityManager()
                .createQuery("SELECT x FROM " + getPersistenceClass().getSimpleName() + " x where x.status.statusDesc NOT IN (:statusNames)")
                .setParameter("statusNames", statusNames)
                .getResultList();

    }

    @Override
    public List<T> findAllByInStatus(List<String> statusNames) {
        return getEntityManager()
                .createQuery("SELECT x FROM " + getPersistenceClass().getSimpleName() + " x where x.status.statusDesc IN (:statusNames)")
                .setParameter("statusNames", statusNames)
                .getResultList();
    }

    @Override
    public Long getTotalCount() {
        return (Long) getEntityManager().createQuery("SELECT COUNT(en) FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.status.statusDesc NOT IN (:deletedStatusList)")
                .setParameter("deletedStatusList", StatusConstants.deleteStatusList())
                .getSingleResult();
    }

    @Override
    public T getById(Long id) {
        return (T) getEntityManager().createQuery("SELECT en FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.id =:id AND en.status.statusDesc NOT IN (:deletedStatus)")
                .setParameter("id", id)
                .setParameter("deletedStatus", StatusConstants.deleteStatusList())
                .getSingleResult();

    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("SELECT en FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.status.statusDesc NOT IN (:deletedStatusList)")
                .setParameter("deletedStatusList", StatusConstants.deleteStatusList())
                .getResultList();
    }

    @Override
    public T getByStatusDesc(String statusDesc) {
        return (T) getEntityManager().createQuery("SELECT x FROM " + getPersistenceClass().getSimpleName() + " x WHERE x.status.statusDesc = ?1")
                .setParameter(1, statusDesc)
                .getSingleResult();
    }

    @Override
    public List<T> findAllExceptBlockedAndDeleted() {
        return getEntityManager().createQuery("SELECT en FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.status.statusDesc NOT IN (:deletedStatusList)")
                .setParameter("deletedStatusList", StatusConstants.deleteAndBlockedStatusList())
                .getResultList();
    }
    
    public List<T> findAllByCollegeId(CollegeDto collegeDto) {
        return getEntityManager().createQuery("SELECT en FROM " + getPersistenceClass().getSimpleName() + " en WHERE en.status.statusDesc NOT IN (:deletedStatusList) and en.createdByAdmin.college.id=:collegeId")
                .setParameter("deletedStatusList", StatusConstants.deleteStatusList())
                .setParameter("collegeId", collegeDto.getId())
                .getResultList();
    }   
}
