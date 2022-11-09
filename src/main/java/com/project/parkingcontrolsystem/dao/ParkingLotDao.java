package com.project.parkingcontrolsystem.dao;

import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import com.project.parkingcontrolsystem.mapper.ParkingLotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingLotDao {
    private final ParkingLotMapper mapper;

    public ParkingLotFormMR getPriceRateInfo(int id) {
        return mapper.getPriceRateInfo(id);
    }
}