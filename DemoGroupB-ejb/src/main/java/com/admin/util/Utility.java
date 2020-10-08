package com.admin.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author manoj.lamsal
 */
public class Utility {

    public static Object getSessionObject(String managedBeanName) {
        Object obj = FacesContext.getCurrentInstance().getApplication().createValueBinding("#{" + managedBeanName + "}").getValue(FacesContext.getCurrentInstance());
        return obj;
    }
    
    public static void removeSessionBeanJSFDataModelObject(String beanName) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getSessionMap().remove(beanName);
    }
    
}
