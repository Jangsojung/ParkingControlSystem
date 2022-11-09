package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.dao.MemberDao;
import com.project.parkingcontrolsystem.dao.SystemDao;
import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import com.project.parkingcontrolsystem.domain.system.System;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SystemServiceImpl implements SystemService{
    private final SystemDao systemDao;
    private final MemberDao memberDao;

    @Override
    public void entryNotice(int parkingLot_id, String license_plate) {
        systemDao.entryNotice(parkingLot_id, license_plate);
    }

    @Override
    public void updateMember_id(String license_plate) {
        String member_id = memberDao.findEmailByLicense(license_plate);

        systemDao.updateMember_id(member_id, license_plate);
    }

    @Override
    public void exitNotice(String license_plate) {
        systemDao.exitNotice(license_plate);
    }

    @Override
    public System getSystem(String license_plate) {
        return systemDao.getSystem(license_plate);
    }

    @Override
    public System getSystemByEmail(String email) {
        return systemDao.getSystemByEmail(email);
    }

    @Override
    public int getPrice(System system, ParkingLotFormMR parkingLotFormMR) {
        long diffMin = (system.getExit_time().getTime() - system.getEntry_time().getTime()) / 60000;
        long base = diffMin - parkingLotFormMR.getDefault_minutes();
        if(base <= 0) {
            return parkingLotFormMR.getDefault_rate();
        }
        else {
            long share = base / parkingLotFormMR.getAdditional_minutes();
            long remainder = base % parkingLotFormMR.getAdditional_minutes();
            if(remainder == 0) {
                return (int) (parkingLotFormMR.getDefault_rate() + share * parkingLotFormMR.getAdditional_rate());
            }
            else {
                return (int) (parkingLotFormMR.getDefault_rate() + (share + 1) * parkingLotFormMR.getAdditional_rate());
            }
        }
    }

    @Override
    public void setPrice(int price, String license_plate) {
        systemDao.setPrice(price, license_plate);
    }
}