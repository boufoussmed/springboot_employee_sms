package com.boufoussmed.springboot.controller;

import com.boufoussmed.springboot.entity.Office;
import com.boufoussmed.springboot.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;


    @GetMapping
    public String showOfficeList(Model model) {

        List<Office> offices = officeService.getAllOffices();

        model.addAttribute("officeList", offices);

        return "officeListView";
    }

    @GetMapping("/add")
    public String showAddOffice(Model office) {
        office.addAttribute("office", new Office());

        return "addOfficeView";
    }

    @PostMapping("/save")
    public String saveOffice(@ModelAttribute("office") Office office) {

        try {
            officeService.saveOffice(office);
        } catch (Exception ex) {
            return "redirect:/office?msg=error&errorName="+ex.getCause();
        }

        return "redirect:/office?msg=success";
    }

    @GetMapping("/save/{id}")
    public String saveEditedOffice(@PathVariable("id") Long id, @ModelAttribute("office") Office office) {

        Office office1 = officeService.getOfficeById(id);

        if (!Objects.isNull(office1)) {
            officeService.saveOffice(office);

            return "redirect:/office?msg=success";
        }
        return "redirect:/office?msg=error";
    }

    @GetMapping("/edit/{id}")
    public String showEditedOffice(@PathVariable("id") Long id, Model model) {
        model.addAttribute("office", officeService.getOfficeById(id));

        return "editOfficeView";
    }

    @GetMapping("/delete/{id}")
    public String deleteOffice(@PathVariable("id") Long id) {
        Office office = this.officeService.getOfficeById(id);

        if (!Objects.isNull(office) && id != null) {
            officeService.deleteOneOffice(id);
            return "redirect:/office?deleted=true";
        }
        return "redirect:/office?deleted=false";
    }
}
