package com.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTP extends BaseModel{

    private String code;

    private String sentToNumber;

    public static OTP make(String phoneNumber) {
        Random rand = new Random();
        Integer code = rand.nextInt(9000) + 1000;
        return OTP.builder().code(code.toString()).sentToNumber(phoneNumber).build();
    }

}
