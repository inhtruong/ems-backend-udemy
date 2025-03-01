package net.javaguides.emsbackend.services;

import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    List<EmployeeDto> getAllEmployees();

    //Update Employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto);

    //Delete Employee
    void deleteEmployee(Long employeeId);
}
