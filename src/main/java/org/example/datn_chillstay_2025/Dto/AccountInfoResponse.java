package org.example.datn_chillstay_2025.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoResponse {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Integer accountTypeId;
    private String accountTypeName;
    private Boolean accountStatus;
}