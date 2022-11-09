package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import com.project.parkingcontrolsystem.domain.system.System;

public interface SystemService {
    void entryNotice(int parkingLot_id, String license_plate);

    void updateMember_id(String license_plate);

    void exitNotice(String license_plate);

    System getSystem(String license_plate);

    System getSystemByEmail(String email);

    int getPrice(System system, ParkingLotFormMR parkingLotFormMR);

    void setPrice(int price, String license_plate);
}