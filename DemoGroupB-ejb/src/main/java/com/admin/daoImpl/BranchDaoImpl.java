/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.BranchDao;
import com.payrollSystem.entity.common.Branch;
import javax.ejb.Stateless;

/**
 *
 * @author sanjeena
 */
@Stateless
public class BranchDaoImpl extends StatusableDaoImpl<Branch> implements BranchDao {

    public BranchDaoImpl() {
        super(Branch.class);
    }

    @Override
    public Branch getByBranchName(String branchName) {
        try {
            return (Branch) getEntityManager()
                    .createQuery("SELECT br FROM " + getPersistenceClass().getSimpleName() + " br WHERE br.branchName = :branchName")
                    .setParameter("branchName", branchName)
                    .getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

}
}
