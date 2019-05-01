package com.mr13.mr13petclinic.services.springdatajpa;

import com.mr13.mr13petclinic.model.Speciality;
import com.mr13.mr13petclinic.repositories.SpecialtyRepository;
import com.mr13.mr13petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
