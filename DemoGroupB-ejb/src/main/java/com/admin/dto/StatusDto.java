/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public class StatusDto implements Serializable {

    private Long statusId;
    private String name;
    private String statusDesc;
    private String icon;

}
