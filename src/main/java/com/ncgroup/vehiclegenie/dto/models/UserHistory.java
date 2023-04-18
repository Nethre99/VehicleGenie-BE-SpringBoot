package com.ncgroup.vehiclegenie.dto.models;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserHistory {
    private BigInteger Client_Id;
    private BigInteger Vehicle_Id;

}
