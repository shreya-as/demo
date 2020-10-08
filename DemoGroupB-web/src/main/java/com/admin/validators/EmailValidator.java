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
public class EmailValidator implements Validator {

    public EmailValidator() {

    }

    private String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]+)";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Pattern mask = null;
        mask = Pattern.compile(EMAIL_REGEX);

        String currEmail = (String) value;

        if (currEmail != null && !currEmail.trim().isEmpty()) {
            Matcher matcher = mask.matcher(currEmail);

            if (!matcher.matches()) {
                FacesMessage message = new FacesMessage();
                message.setDetail("Please enter valid email address.");
                message.setSummary("Please enter valid email address.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }

    }
}
