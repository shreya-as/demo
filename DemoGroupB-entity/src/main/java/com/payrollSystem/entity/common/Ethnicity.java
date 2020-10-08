
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractProfile;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@Entity
@Table(name="ETHNICITY")
public class Ethnicity extends AbstractProfile{

}
