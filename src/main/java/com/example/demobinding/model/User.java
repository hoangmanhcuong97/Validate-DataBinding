package com.example.demobinding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "Name is empty")
    private String name;
    @NotEmpty(message = "Address is empty")
    private String address;
    @NotEmpty(message = "Phone number is empty")
    @Pattern(regexp = "^0.*$", message = "Phone number must start with 0", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
