package com.admin.dto.abstracts;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDto implements Serializable {

    private Long id;

}
