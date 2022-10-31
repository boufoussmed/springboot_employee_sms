package com.boufoussmed.springboot.service;


import com.boufoussmed.springboot.entity.Office;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public interface OfficeService {
    Office saveOffice(Office office);

    List<Office> getAllOffices();

    Office getOfficeById(Long id);

    void deleteOneOffice(Long id);
}
