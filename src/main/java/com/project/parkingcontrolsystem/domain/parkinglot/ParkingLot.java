package com.project.parkingcontrolsystem.domain.parkinglot;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ParkingLot {
    int id;
    String name;
    String address;
    int max;
    int default_minutes;
    int default_rate;
    int additional_minutes;
    int additional_rate;
}