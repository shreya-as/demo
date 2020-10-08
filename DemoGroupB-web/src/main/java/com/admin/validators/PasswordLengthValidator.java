/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.admin.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author paawan.bhatt
 */
public class PasswordLengthValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String passwordValue    = (String) value;
        try{
            Integer.parseInt(passwordValue);
        }catch(Exception ex){
            FacesMessage message = new FacesMessage();
            message.setDetail("Value must be numeric");
            message.setSummary("Value must be numeric");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(message);
        }               
    }

}
