package com.project.parkingcontrolsystem.domain.parkinglot.form;

import lombok.Data;

@Data
public class ParkingLotFormMR {
    int default_minutes;
    int default_rate;
    int additional_minutes;
    int additional_rate;
}