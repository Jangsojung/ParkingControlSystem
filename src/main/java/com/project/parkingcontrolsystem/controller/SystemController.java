package com.project.parkingcontrolsystem.controller;

import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import com.project.parkingcontrolsystem.domain.system.System;
import com.project.parkingcontrolsystem.domain.system.form.SystemFormDtoS;
import com.project.parkingcontrolsystem.service.ParkingLotService;
import com.project.parkingcontrolsystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SystemController {
    private final SystemService systemService;
    private final ParkingLotService parkingLotService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

    @GetMapping("/auth/entryNotice")
    public String entryNotice(@RequestParam("parkingLot_id") int parkingLot_id, @RequestParam("license_plate") String license_plate, HttpServletRequest request) {
        systemService.entryNotice(parkingLot_id, license_plate);
        systemService.updateMember_id(license_plate);

        System system = systemService.getSystem(license_plate);
        ParkingLotFormMR parkingLotFormMR = parkingLotService.getPriceRateInfo(parkingLot_id);

        SystemFormDtoS systemFormDtoS = makeDtoS(system);

        request.getSession().setAttribute("mySystem", systemFormDtoS);
        request.getSession().setAttribute("plInfo", parkingLotFormMR);

        return "redirect:/";
    }

    @GetMapping("/auth/exitNotice")
    public String exitNotice(@RequestParam("license_plate") String license_plate, HttpServletRequest request) {
        systemService.exitNotice(license_plate);

        System system = systemService.getSystem(license_plate);

        int parkingLot_id = system.getParkingLot_id();
        ParkingLotFormMR parkingLotFormMR = parkingLotService.getPriceRateInfo(parkingLot_id);

        int price = systemService.getPrice(system, parkingLotFormMR);
        systemService.setPrice(price, license_plate);

        system.setExit_time(system.getExit_time());
        system.setPrice(price);

        SystemFormDtoS systemFormDtoS = makeDtoS(system);

        request.getSession().setAttribute("mySystem", systemFormDtoS);
        request.getSession().setAttribute("plInfo", parkingLotFormMR);

        return "redirect:/";
    }

    private SystemFormDtoS makeDtoS(System system) {
        SystemFormDtoS systemFormDtoS = new SystemFormDtoS();

        systemFormDtoS.setEntry_time(sdf.format(system.getEntry_time()));
        if(system.getExit_time() != null) {
            systemFormDtoS.setExit_time(sdf.format(system.getExit_time()));
        }
        systemFormDtoS.setParkingLot_id(system.getParkingLot_id());
        systemFormDtoS.setPrice(system.getPrice());

        return systemFormDtoS;
    }
}