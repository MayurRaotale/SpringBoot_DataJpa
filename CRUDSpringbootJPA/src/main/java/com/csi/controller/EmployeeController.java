package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId,@RequestBody Employee employee){
            return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
        }
    @DeleteMapping("/deletedata/{empId}")
            public  ResponseEntity<String>deleteAllData(@PathVariable int empId){
            employeeServiceImpl.deleteData(empId);
            return ResponseEntity.ok("Data Successfully Deleted");
        }
    @GetMapping("/getdatabyname/{empFirstName}")
    public ResponseEntity<List<Employee>>getDataByName(@PathVariable String empFirstName){
        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empFirstName));
    }
    @GetMapping("/getdatabycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee>getDataByContactNumber(@PathVariable long empContactNumber){

        return ResponseEntity.ok(employeeServiceImpl.getDataByContactNumber(empContactNumber));
    }
    @GetMapping("/getdatabyemailid/{empEmailId}")
    public ResponseEntity<Employee>getDataByEmailID(@PathVariable String empEmailId){

        return ResponseEntity.ok(employeeServiceImpl.getByDataEmpEmailId(empEmailId));
    }
}
