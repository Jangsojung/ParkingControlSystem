package com.project.parkingcontrolsystem.domain.system.form;

import lombok.Data;

@Data
public class SystemFormDtoS {
    int parkingLot_id;
    String entry_time;
    String exit_time;
    int price;
}