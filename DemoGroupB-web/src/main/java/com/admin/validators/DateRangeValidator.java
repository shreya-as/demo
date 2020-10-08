/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class DateRangeValidator implements Validator {


    public DateRangeValidator() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");

        Date fromDate = (Date) value;

        UIInput confirmComponent = (UIInput) component.getAttributes().get("toDate");
        String toDate = (String) confirmComponent.getSubmittedValue();
        try {
            if (fromDate != null && toDate != null) {
                if (fromDate.after(dateFormat.parse(toDate))) {
                    FacesMessage message = new FacesMessage();
                    message.setDetail("From Date must be before To Date");
                    message.setSummary("From Date must be before To Date");
                    message.setSeverity(FacesMessage.SEVERITY_INFO);
                    throw new ValidatorException(message);
                }
            }

        } catch (ParseException ex) {
            ex.getMessage();
        }
    }
}
