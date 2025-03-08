package net.javaguides.emsbackend.mapper;

import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.entities.Department;

public class DepartmentMapper {
    // Convert department jpa entity to department dto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    // Convert department dto to department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
