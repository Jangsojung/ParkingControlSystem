package com.project.parkingcontrolsystem.mapper;

import com.project.parkingcontrolsystem.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void join(String email, String password, String license_plate);

    Member selectByEmail(String email);

    String findEmailByLicense(String license_plate);
}