package com.ncgroup.vehiclegenie.dto.models;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private BigInteger Client_Id;
    private String Email;
    private String Name;
}
