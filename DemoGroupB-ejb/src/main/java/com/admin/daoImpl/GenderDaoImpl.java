/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.GenderDao;
import com.payrollSystem.entity.common.Gender;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class GenderDaoImpl extends StatusableDaoImpl<Gender> implements GenderDao{
    
        public GenderDaoImpl() {
        super(Gender.class);
    }
    @Override
    public Gender getByGenderName(String name){
         try {
            return (Gender) getEntityManager()
                    .createQuery("SELECT g FROM " + getPersistenceClass().getSimpleName() + " g WHERE g.name = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
