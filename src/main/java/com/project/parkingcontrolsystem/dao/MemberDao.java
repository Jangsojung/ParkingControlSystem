package com.project.parkingcontrolsystem.dao;

import com.project.parkingcontrolsystem.domain.member.Member;
import com.project.parkingcontrolsystem.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper mapper;

    public void join(String email, String password, String license_plate) {
        mapper.join(email, password, license_plate);
    }

    public Member findMemberByEmail(String email) {
        return mapper.selectByEmail(email);
    }

    public String findEmailByLicense(String license_plate) {
        return mapper.findEmailByLicense(license_plate);
    }
}