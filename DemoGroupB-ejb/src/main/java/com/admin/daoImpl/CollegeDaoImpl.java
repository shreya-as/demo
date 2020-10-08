package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.CollegeDao;
import com.admin.dto.CollegeDto;
import javax.ejb.Stateless;
import com.payrollSystem.entity.common.College;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CollegeDaoImpl extends StatusableDaoImpl<College> implements CollegeDao {

    private Logger log = LoggerFactory.getLogger(CollegeDaoImpl.class);

    public CollegeDaoImpl() {
        super(College.class);
    }

    @Override
    public boolean checkCollegeCodeExists(CollegeDto collegeDto) {
        return (Long) getEntityManager().createQuery("SELECT COUNT(c.id) FROM College c WHERE c.code=:code")
                .setParameter("code", collegeDto.getCode())
                .getSingleResult() > 0;
    }

    @Override
    public boolean checkCollegeCodeExistsForUpdate(CollegeDto collegeDto) {
        return (Long) getEntityManager().createQuery("SELECT COUNT(c.id) FROM College c WHERE c.code=:code AND c.id<>:id")
                .setParameter("code", collegeDto.getCode())
                .setParameter("id", collegeDto.getId())
                .getSingleResult() > 0;
    }

    public List<College> getCollegeFromIds(List<CollegeDto> collegeDtos) {
        List<Long> collegeIdList = new ArrayList<>();
        for (CollegeDto collegeDto : collegeDtos) {
            collegeIdList.add(collegeDto.getId());
        }
        return getEntityManager().createQuery("SELECT c FROM College c WHERE c.id in (:collegeIdList) AND c.status.statusDesc NOT IN (:deletedStatusList)")
                .setParameter("collegeIdList", collegeIdList)
                .setParameter("deletedStatusList", StatusConstants.deleteStatusList())
                .getResultList();
    }

}
