package net.javaguides.emsbackend.controllers;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.services.impl.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
s
    // Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto newDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // Build Get All Department REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto departmentDto) {
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department deleted successfully!.", HttpStatus.OK);
    }
}
