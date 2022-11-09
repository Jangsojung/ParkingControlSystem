package com.project.parkingcontrolsystem.dao;

import com.project.parkingcontrolsystem.domain.system.System;
import com.project.parkingcontrolsystem.mapper.SystemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SystemDao {
    private final SystemMapper mapper;

    public void entryNotice(int parkingLot_id, String license_plate) {
        mapper.entryNotice(parkingLot_id, license_plate);
    }

    public void updateMember_id(String member_id, String license_plate) {
        mapper.updateMember_id(member_id, license_plate);
    }

    public void exitNotice(String license_plate) {
        mapper.exitNotice(license_plate);
    }

    public System getSystem(String license_plate) {
        return mapper.getSystem(license_plate);
    }

    public System getSystemByEmail(String email) {
        return mapper.getSystemByEmail(email);
    }

    public int getPLid(String license_plate) {
        return mapper.getPLid(license_plate);
    }

    public void setPrice(int price, String license_plate) {
        mapper.setPrice(price, license_plate);
    }
}