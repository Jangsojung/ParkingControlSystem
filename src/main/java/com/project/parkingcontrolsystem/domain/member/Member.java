package com.project.parkingcontrolsystem.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Member {
    private String email;
    private String password;
    private String license_plate;
}