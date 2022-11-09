package com.project.parkingcontrolsystem.mapper;

import com.project.parkingcontrolsystem.domain.system.System;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemMapper {
    void entryNotice(int parkingLot_id, String license_plate);

    void updateMember_id(String member_id, String license_plate);

    void exitNotice(String license_plate);

    System getSystem(String license_plate);

    System getSystemByEmail(String email);

    int getPLid(String license_plate);

    void setPrice(int price, String license_plate);
}