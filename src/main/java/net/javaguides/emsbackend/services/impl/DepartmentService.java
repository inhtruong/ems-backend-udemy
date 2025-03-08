package net.javaguides.emsbackend.services.impl;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.entities.Department;
import net.javaguides.emsbackend.mapper.DepartmentMapper;
import net.javaguides.emsbackend.repositories.IDepartmentRepository;
import net.javaguides.emsbackend.services.IDepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }
}
