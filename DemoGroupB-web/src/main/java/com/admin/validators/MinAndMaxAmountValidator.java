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
public class MinAndMaxAmountValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        Double amountMin = (Double) value;
        UIInput amountMincheckComponent = (UIInput) component.getAttributes().get("maxFixDepositAmount");
        if (amountMincheckComponent != null && !String.valueOf(amountMincheckComponent.getSubmittedValue()).isEmpty()) {
            Double amountMax = Double.parseDouble(String.valueOf(amountMincheckComponent.getSubmittedValue()));
            if (amountMin != 0.0 && amountMax != 0.0) {
                if (amountMin > amountMax) {
                    FacesMessage message = new FacesMessage();
                    message.setDetail("Amount Max must be greater than Amount Min.");
                    message.setSummary("Amount Max must be greater than Amount Min");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }else if(amountMin == amountMax){
                    FacesMessage message = new FacesMessage();
                    message.setDetail("Max fix deposit amount and Min fix deposit amount should not be equal.");
                    message.setSummary("Max fix deposit amount and Min fix deposit amount should not be equal.");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
            }

        }
        
        
    }
    
}
