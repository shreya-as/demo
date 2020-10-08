/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.admin.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author paawan.bhatt
 */
@FacesConverter("com.admin.validators.BlankSpaceValidator")
public class BlankSpaceValidator implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value != null ? value.trim() : null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }

}
