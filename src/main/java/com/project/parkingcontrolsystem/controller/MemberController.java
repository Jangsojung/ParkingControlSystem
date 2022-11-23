package com.project.parkingcontrolsystem.controller;

import com.project.parkingcontrolsystem.domain.member.Member;
import com.project.parkingcontrolsystem.domain.parkinglot.form.ParkingLotFormMR;
import com.project.parkingcontrolsystem.domain.system.System;
import com.project.parkingcontrolsystem.domain.system.form.SystemFormDtoS;
import com.project.parkingcontrolsystem.service.MemberService;
import com.project.parkingcontrolsystem.service.ParkingLotService;
import com.project.parkingcontrolsystem.service.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final SystemService systemService;
    private final ParkingLotService parkingLotService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

    @GetMapping("/join")
    public String joinForm() {
        return "/login/joinForm";
    }

    @PostMapping("/join")
    public String join(@RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("license_plate") String license_plate) {
        memberService.join(email, password, license_plate);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        Member authUser;

        try {
            authUser = memberService.login(email, password);
        } catch (Exception e) {
            log.info("!Exception: {}", e.toString());
            return "/login/loginForm";
        }

        if (authUser == null) {
            log.info("!authUser == null");
            return "/login/loginForm";
        }

        log.info("authUser: {}", authUser);
        request.getSession().setAttribute("authUser", authUser);

        System system = systemService.getSystemByEmail(authUser.getEmail());
        log.info("login System: {}", system);

        if (system != null) {
            ParkingLotFormMR parkingLotFormMR = parkingLotService.getPriceRateInfo(system.getParkingLot_id());
            SystemFormDtoS systemFormDtoS = makeDtoS(system);

            request.getSession().setAttribute("mySystem", systemFormDtoS);
            request.getSession().setAttribute("plInfo", parkingLotFormMR);

            return "redirect:/";
        }

        return "redirect:/";
    }

    @RequestMapping("/auth/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();

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