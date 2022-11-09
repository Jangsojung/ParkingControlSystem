package com.project.parkingcontrolsystem.mapper;

import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkingLotMapper {
    ParkingLotFormMR getPriceRateInfo(int id);
}