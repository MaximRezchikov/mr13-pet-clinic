package com.mr13.mr13petclinic.services.map;

import com.mr13.mr13petclinic.model.Owner;
import com.mr13.mr13petclinic.model.Pet;
import com.mr13.mr13petclinic.services.OwnerService;
import com.mr13.mr13petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {


    private final PetTypeMapService petTypeMapService;
    private final PetService petService;

    public OwnerMapService(PetTypeMapService petTypeMapService, PetService petService) {
        this.petTypeMapService = petTypeMapService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
        .stream()
        .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
        .findFirst()
        .orElse(null);

    }
}
