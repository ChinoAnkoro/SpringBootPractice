package com.example.demo.dto;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContactDTO {
    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String phone;

    private String zipCode;

    private String address;

    private String buildingName;

    private String contactType;

    private String body;
    
    private LocalDateTime updateDate;
    
    private LocalDateTime createDate;
}
