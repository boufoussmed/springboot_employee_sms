package com.boufoussmed.springboot.service;

import com.boufoussmed.springboot.entity.Office;
import com.boufoussmed.springboot.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office saveOffice(Office office) {
        return this.officeRepository.save(office);
    }

    @Override
    public List<Office> getAllOffices() {
        return this.officeRepository.findAll();
    }

    /**
     *
     * @param id
     * @return Office or null
     */
    @Override
    public Office getOfficeById(Long id) {
        Optional<Office> office = this.officeRepository.findById(id);
        if (office.isPresent()) {
            return office.get();
        }
        return null;
    }

    @Override
    public void deleteOneOffice(Long id) {
        this.officeRepository.deleteById(id);
    }
}
