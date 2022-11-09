package com.project.parkingcontrolsystem.domain.system;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class System {
    String member_id;
    int parkingLot_id;
    String license_plate;
    Date entry_time;
    Date exit_time;
    int price;
}