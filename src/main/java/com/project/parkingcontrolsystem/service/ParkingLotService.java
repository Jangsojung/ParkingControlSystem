package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;

public interface ParkingLotService {
    ParkingLotFormMR getPriceRateInfo(int id);
}