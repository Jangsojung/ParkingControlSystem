package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.dao.ParkingLotDao;
import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService{
    private final ParkingLotDao parkingLotDao;

    @Override
    public ParkingLotFormMR getPriceRateInfo(int id) {
        return parkingLotDao.getPriceRateInfo(id);
    }
}