package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.domain.member.Member;

public interface MemberService {
    void join(String email, String password, String license_plate);

    Member login(String email, String password);
}