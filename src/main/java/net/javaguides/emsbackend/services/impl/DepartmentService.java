package net.javaguides.emsbackend.services.impl;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.DepartmentDto;
import net.javaguides.emsbackend.entities.Department;
import net.javaguides.emsbackend.exceptions.ResourceNotFoundException;
import net.javaguides.emsbackend.mapper.DepartmentMapper;
import net.javaguides.emsbackend.repositories.IDepartmentRepository;
import net.javaguides.emsbackend.services.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id" + departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id" + departmentId));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());

        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id" + departmentId));

        departmentRepository.deleteById(departmentId);
    }
}
