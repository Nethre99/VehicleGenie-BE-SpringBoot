package com.ncgroup.vehiclegenie.dto.models;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserHistory {
    private int uv_id;
    private int Client_Id;
    private int Vehicle_Id;

}
