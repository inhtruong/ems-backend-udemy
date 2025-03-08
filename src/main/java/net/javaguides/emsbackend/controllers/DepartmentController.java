package net.javaguides.emsbackend.controllers;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.services.impl.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    // Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto newDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }
}
