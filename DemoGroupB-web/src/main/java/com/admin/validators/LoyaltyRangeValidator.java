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
public class LoyaltyRangeValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        Double amountFrom = (Double) value;
        UIInput amountFromcheckComponent = (UIInput) component.getAttributes().get("amountTo");
        if(amountFromcheckComponent != null && !String.valueOf(amountFromcheckComponent.getSubmittedValue()).isEmpty()){
            Double amountTo = Double.parseDouble(String.valueOf(amountFromcheckComponent.getSubmittedValue()));
            if(amountFrom != 0.0 && amountTo != 0.0){
                if (amountFrom >= amountTo) {
                FacesMessage message = new FacesMessage();
                message.setDetail("Amount To must be greater than Amount From.");
                message.setSummary("Amount To must be greater than Amount From");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
            
        }
        
        
    }
    
}
