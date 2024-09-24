package com.sonu.order.beans.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String customerId;
    private String customerName;
    private LocalDate customerDOB;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Address> addresses;
}
