package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.StatusDao;
import com.admin.dto.StatusDto;
import com.admin.mapper.StatusMapper;
import com.payrollSystem.entity.common.Status;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class StatusDaoImpl extends GenericDaoImpl<Status> implements StatusDao {

    public StatusDaoImpl() {
        super(Status.class);
    }

    @Override
    public Status getByDesc(String name) {
        try {
            return (Status) getEntityManager()
                    .createQuery("SELECT st FROM " + getPersistenceClass().getSimpleName() + " st WHERE st.statusDesc = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }

    @Override
    public List<String> getAllDesc() {
        return getEntityManager().createQuery("SELECT s.name FROM " + getPersistenceClass().getSimpleName() + " s")
                .getResultList();
    }

    public List<StatusDto> getAllForUserSearch() {
        List<Status> statuses = getEntityManager().createQuery("SELECT s FROM " + getPersistenceClass().getSimpleName() + " s WHERE s.name IN (:statusName)")
                .setParameter("statusName", StatusConstants.getUserSearchStatusList())
                .getResultList();
        return StatusMapper.convertToDtos(statuses);
    }

}
