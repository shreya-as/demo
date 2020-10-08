/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto;

import com.admin.dto.abstracts.AbstractProfileDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author paawan.bhatt
 */
@Getter
@Setter
public class AdminProfileDto extends AbstractProfileDto {

    private List<AdminDto> adminDtos;

    private String adminProfileCreatedByUsername;

}
