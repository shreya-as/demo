/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.admin.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author paawan.bhatt
 */
public class ConfirmNormalPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String password = (String) value;
        UIInput confirmPasswordCompoent = (UIInput) component.getAttributes().get("confirmNormalPassword");
        String confirmPassword = (String) confirmPasswordCompoent.getSubmittedValue();
        if (!password.equals(confirmPassword)) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Password and Confirm Normal Password are not matching");
            message.setSummary("Password and Confirm Normal Password are not matching");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(message);
        }
    }
}
