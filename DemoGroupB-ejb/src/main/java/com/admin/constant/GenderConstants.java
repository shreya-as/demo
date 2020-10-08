/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author sanjeena
 */
@Getter
@AllArgsConstructor
public enum GenderConstants {
    Male("Male"),
    Female("Female");

    private final String name; 
}
