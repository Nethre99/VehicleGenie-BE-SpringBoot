package com.ncgroup.vehiclegenie.dto.models;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IPAddress {
    private BigInteger IP_Id;
    private String Ip_Address;
    private BigInteger Client_Id;
}
