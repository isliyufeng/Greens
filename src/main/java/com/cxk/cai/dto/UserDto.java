package com.cxk.cai.dto;


import lombok.Data;

/**
 * @author 喜闻乐见i
 */
@Data

public class UserDto {
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
