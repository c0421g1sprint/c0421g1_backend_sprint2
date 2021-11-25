//package com.codegym.controller;
//
//
//import com.codegym.dto.EmployeeDto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class EmployeeRestController_createEmployee {
//
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createEmployee_name_13() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName(null);
//        employeeDto.setEmployeeAddress("Huế");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createEmployee_address_14() throws Exception {
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Phu");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void createEmployee_name_15() throws Exception {
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("123");
//        employeeDto.setEmployeeAddress("Huế");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void createEmployee_name_16() throws Exception {
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("phu");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void createEmployee_name_17() throws Exception {
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("qưeqwewqeqweqweqwewqeqweqweqwewqewqewqewqwqwqewqwqa");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createEmployee_18() throws Exception {
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Nguyễn Khắc Phục");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//
//    }
//
//
//
//
//
//
//
//
//}
