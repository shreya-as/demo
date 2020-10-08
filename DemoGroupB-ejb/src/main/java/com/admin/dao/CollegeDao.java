package com.admin.dao;

import com.admin.dto.CollegeDto;
import com.payrollSystem.entity.common.College;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author paawan.bhatt
 */
@Local
public interface CollegeDao extends StatusableDao<College> {

    boolean checkCollegeCodeExists(CollegeDto collegeDto);
    
    boolean checkCollegeCodeExistsForUpdate(CollegeDto collegeDto);
    
    List<College> getCollegeFromIds(List<CollegeDto> collegeDtos);
    
}
