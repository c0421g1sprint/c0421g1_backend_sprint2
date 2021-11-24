//package com.codegym.controller;
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
//public class EmployeeRestController_editEmployee {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void editEmployee_name_19() throws Exception {
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
//        employeeDto.setEmployeeId(2);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/updateEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editEmployee_address_20() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Nguyễn Thị Thanh Hà");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("nguyenha");
//
//        employeeDto.setEmployeeId(2);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/updateEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editEmployee_address_21() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("123");
//        employeeDto.setEmployeeAddress("Huees");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("nguyenha");
//
//        employeeDto.setEmployeeId(2);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/updateEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editEmployee_address_22() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Nguyễn Thị Thanh Hà");
//        employeeDto.setEmployeeAddress("Huees");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("nguyenha");
//
//        employeeDto.setEmployeeId(2);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/updateEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editEmployee_address_23() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Nguyễn Thị Thanh Hà");
//        employeeDto.setEmployeeAddress("qưeqwewqeqweqweqwewqeqweqweqwewqewqewqewqwqwqewqwqa");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("nguyenha");
//
//        employeeDto.setEmployeeId(2);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/updateEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editEmployee_name_24() throws Exception {
//
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeName("Nguyễn Thị Thanh Hà");
//        employeeDto.setEmployeeAddress("");
//        employeeDto.setEmployeePhone("0905448128");
//        employeeDto.setEmployeeImage("anh1.png");
//        employeeDto.setEmployeeGender((byte) 0);
//        employeeDto.setEmployeeBirthday("16-10-2000");
//        employeeDto.setEmployeeSalary(1000000);
//        employeeDto.setAccountName("kapu");
//
//        employeeDto.setEmployeeId(2);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee/createEmployee")
//                .content(this.objectMapper.writeValueAsString(employeeDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
