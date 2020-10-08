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
public class RangeFromToValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Double fromRange = (Double) value;
        UIInput inputedToRange = (UIInput) component.getAttributes().get("toRange");
        if (inputedToRange != null && String.valueOf(inputedToRange.getSubmittedValue()) != null && !String.valueOf(inputedToRange.getSubmittedValue()).isEmpty()) {
            Double toRange = Double.parseDouble(String.valueOf(inputedToRange.getSubmittedValue()));
            if (fromRange != 0.0 && toRange != 0.0) {
                if (fromRange >= toRange) {
                    FacesMessage message = new FacesMessage();
                    message.setDetail("To Range must be greater than From Range.");
                    message.setSummary("To Range must be greater than From Range.");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
            }

        }
    }
}
