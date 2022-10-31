package com.boufoussmed.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class
EmployeeModel {
    private String firstname;
    private String lastname;
    private String email;
    private EmployeeModel employeeModel;

    @ModelAttribute
    public EmployeeModel employeeModel() {

        if (this.employeeModel == null) {
            this.employeeModel = new EmployeeModel();
        }

        return this.employeeModel;
    }

}
