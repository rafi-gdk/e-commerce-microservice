package com.sonu.customer.beans.request;

import lombok.Data;

@Data
public class AuthRequest {

    private String userName;
    private String password;
}