package com.codegym.dto;

import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Level;
import com.codegym.entity.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private Integer employeeId;

    @NotNull(message = "Họ và tên  không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Họ và tên không được nhập số hoặc ký tự đặc biệt")
    @Size(min = 5, max = 50, message = "Họ và tên phải lớn hơn 5 và nhỏ hơn 50 kí tự")
    private String employeeName;


    @NotNull(message = "Địa chỉ không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Địa chỉ không được nhập số hoặc ký tự đặc biệt")
    @Size(min = 5, message = "Địa chỉ phải nhỏ hơn 50")
    private String employeeAddress;


    @Pattern(regexp = "^(09[0|3])+([0-9]{7})\\b$", message = "Số điện thoại sai định dạng." + "\n VD:090xxxxxxx, x gồm 7 chữ số")
    private String employeePhone;

    @NotNull(message = "Địa chỉ không được để trống")
    private String employeeImage;
    private Byte employeeGender;

    @NotBlank(message = "Ngày sinh không được để trống.")
    private String employeeBirthday;


    @NotNull(message = "Vui lòng điền thông tin.")
    @Min(value = 0,message = "lương phải là số dương.")
    private double employeeSalary;
    private boolean deleteFlag;


    @NotNull(message = "Tên đăng nhập  không được để trống")
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Tên đăng nhập không được nhập số hoặc ký tự đặc biệt")
    @Size(min = 4, max = 15, message = "Tên đăng nhập phải lớn hơn 4 và nhỏ hơn 15 kí tự")
    private String accountName;


    private Level level;

    private Account account;

    private Set<Orders> ordersSet;



}
