/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.payrollSystem.entity.common.Branch;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface BranchDao extends StatusableDao<Branch> {

    public Branch getByBranchName(String branchName);

}
