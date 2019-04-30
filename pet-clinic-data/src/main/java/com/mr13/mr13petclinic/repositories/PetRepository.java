package com.mr13.mr13petclinic.repositories;

import com.mr13.mr13petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
