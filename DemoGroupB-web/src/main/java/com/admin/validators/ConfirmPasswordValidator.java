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
public class ConfirmPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String password = (String) value;
        UIInput confirmPasswordCompoent = (UIInput) component.getAttributes().get("confirmPassword");
        String confirmPassword = (String) confirmPasswordCompoent.getSubmittedValue();
        if (confirmPassword != null) {
            if (confirmPassword.length() > 0) {
                if (!password.equals(confirmPassword)) {
                    FacesMessage message = new FacesMessage();
                    message.setDetail("New password and Confirm Password are not matching");
                    message.setSummary("New password And confirm Password Are Not Matching");
                    message.setSeverity(FacesMessage.SEVERITY_INFO);
                    throw new ValidatorException(message);
                }
            }
        }
    }
}
