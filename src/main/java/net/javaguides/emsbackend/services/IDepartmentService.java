package net.javaguides.emsbackend.services;

import net.javaguides.emsbackend.dto.DepartmentDto;

import java.util.List;

public interface IDepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);
}
