package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.service.EmployeeService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.EmployeeResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeRestEndpoint {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResource> getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EmployeeResourceMapper.mapEmployeeToEmployeeResource(employee));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody EmployeeResource employeeResource) {
        employeeService.createEmployee(EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployee(@Valid @RequestBody EmployeeResource employeeResource) {
        employeeService.updateEmployee(EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
