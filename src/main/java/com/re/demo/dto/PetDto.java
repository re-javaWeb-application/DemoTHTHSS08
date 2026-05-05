package com.re.demo.dto;

import com.re.demo.validator.PetCode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PetDto {

    @NotBlank(message = "Không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String petName;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 0, message = "Tuổi phải lớn hơn hoặc bằng 0")
    private Integer age;

    @NotBlank(message = "Không được để trống")
    @PetCode
    private String petCode;

    public PetDto() {
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }
}
