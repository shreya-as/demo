/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.abstracts.AbstractUserDto;
import static com.admin.mapper.AbstractBlockUnblockHelperMapper.convertCommonBlockUnblockParameters;
import com.payrollSystem.entity.abstracts.AbstractUser;

/**
 *
 * @author sanjeena
 */
public abstract class AbstractUserMapper extends AbstractBlockUnblockHelperMapper{
         protected static <T extends AbstractUserDto, K extends AbstractUser> void convertCommonUserParameters(T abstractUserDto, K abstractUser) {
              abstractUserDto.setUsername(abstractUser.getUsername());
               abstractUserDto.setPassword(abstractUser.getPassword());
                 abstractUserDto.setImagePath(abstractUser.getImagePath());
           convertCommonBlockUnblockParameters(abstractUserDto, abstractUser);
         }
}
