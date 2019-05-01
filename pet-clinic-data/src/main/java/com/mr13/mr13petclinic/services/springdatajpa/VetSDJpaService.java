package com.mr13.mr13petclinic.services.springdatajpa;

import com.mr13.mr13petclinic.model.Vet;
import com.mr13.mr13petclinic.repositories.VetRepository;
import com.mr13.mr13petclinic.services.VetService;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Profile("sprigdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
