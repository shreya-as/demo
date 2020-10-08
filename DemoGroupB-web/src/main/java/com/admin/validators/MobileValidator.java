/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author brajen
 */
public class MobileValidator implements Validator {

    public MobileValidator() {
    }

    private String MOBILE_REGEX = "^[9][8][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Pattern mask = null;
        mask = Pattern.compile(MOBILE_REGEX);

        String currMobileNumber = (String) value;
        if (currMobileNumber != null && !currMobileNumber.trim().isEmpty()) {
            Matcher matcher = mask.matcher(currMobileNumber);

            if (!matcher.matches()) {
                FacesMessage message = new FacesMessage();
                message.setDetail("Please enter valid mobile number.");
                message.setSummary("Please enter valid mobile number.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }

    }
}
