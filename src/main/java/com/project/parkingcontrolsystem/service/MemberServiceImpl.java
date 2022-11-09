package com.project.parkingcontrolsystem.service;

import com.project.parkingcontrolsystem.dao.MemberDao;
import com.project.parkingcontrolsystem.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberDao memberDao;

    @Override
    public void join(String email, String password, String license_plate) {
        memberDao.join(email, password, license_plate);
    }

    @Override
    public Member login(String email, String password) {
        Member member = memberDao.findMemberByEmail(email);

        if (!password.equals(member.getPassword())) {
            return null;
        }

        return member;
    }
}