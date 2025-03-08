package net.javaguides.emsbackend.services;

import net.javaguides.emsbackend.dto.DepartmentDto;

public interface IDepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
}
