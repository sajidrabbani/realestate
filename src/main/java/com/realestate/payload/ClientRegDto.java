package com.realestate.payload;

import lombok.Data;

@Data
public class ClientRegDto {

    private Long clientId;
    private String clientName;
    private String clientAddress;
    private String phoneNumber;
    private String email;
    private String gender;
    private String username;
    private String password;
}
