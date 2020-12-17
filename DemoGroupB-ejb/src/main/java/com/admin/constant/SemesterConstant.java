/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.constant;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author fox
 */
@Getter
@AllArgsConstructor

public enum  SemesterConstant {
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Fifth(5),
    Sixth(6),
    Seventh(7),
    Eigth(8);
    private final Integer semester;
    
    public static List<Integer> semesterList(){
        return Arrays.asList(One.getSemester(),Two.getSemester(),Three.getSemester(),Four.getSemester(),Fifth.getSemester(),Sixth.getSemester(),Seventh.getSemester(),Eigth.getSemester()
);
    }



}
