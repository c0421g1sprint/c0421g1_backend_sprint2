package com.codegym.dto;

import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Level;
import com.codegym.entity.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Validator {
//PhucNK
    private Integer employeeId;

    @NotNull(message = "Tên nhân viên không được để trống.")
    @NotBlank(message = "Tên nhân viên không được để trống.")
    @Size(min = 3, max = 50, message = "Tên nhân viên tối thiểu phải có 3 kí tự,tối đa 50 kí tự.")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀẾỂưạảấầẩẫậắằẳẵặẹẻẽềếểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s ]*$", message = "Tên nhân viên không được chứa ký tự đặc biệt và số.")
    private String employeeName;

    @NotNull(message = "Địa chỉ không được để trống")
    @NotBlank(message = "Địa chỉ không được để trống")
    @Pattern(regexp = "^\\s?\\S+(?: \\S+)*\\s?$", message = "Địa chỉ không được nhập nhiều khoảng trắng.")
    private String employeeAddress;

    @NotNull(message = "Số điện thoại không dc để trống.")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$")
    private String employeePhone;

    @NotNull(message = "Hình không được để trống.")
    @NotBlank(message = "Hình không được để trống.")
    private String employeeImage;

    @NotNull(message = "Vui lòng chọn giới tính của nhân viên.")
    private Byte employeeGender;

    @NotNull(message = "Ngày sinh không được để trống.")
    @NotBlank(message = "Ngày sinh không được để trống.")
    private String employeeBirthday;

    @NotNull(message = "Vui lòng điền thông tin.")
    @Min(value = 1, message = "lương phải là số dương.")

    private double employeeSalary;
    private boolean deleteFlag;

    @NotNull(message = "Tên đăng nhập  không được để trống")
    @Pattern(regexp = "^[A-Za-z_]\\w*$", message = "Tên đăng nhập không bắt đầu là số,không có dấu,kí tự đặc biệt và không có khoảng trắng.")
    @Size(min = 6, max = 50, message = "Tên đăng nhập phải lớn hơn 6 và nhỏ hơn 50 kí tự")

    private String accountName;
    private Level level;
    private Account account;
    private Set<Orders> ordersSet;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
         EmployeeDto employeeDto=(EmployeeDto)target;

         if(employeeDto.getEmployeeSalary()%100000!=0){
          errors.rejectValue("employeeSalary","","Lương phải là bội của 100 000 vnd.");
         }


    }
}
