/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto.abstracts;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public abstract class AbstractProfileDto extends AbstractStatusHelperDto {

    private String name;

    private String description;

}
