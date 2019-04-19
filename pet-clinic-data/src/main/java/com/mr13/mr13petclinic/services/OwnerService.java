package com.mr13.mr13petclinic.services;

import com.mr13.mr13petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
