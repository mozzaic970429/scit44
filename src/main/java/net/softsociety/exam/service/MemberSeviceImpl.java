package net.softsociety.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@Service
public class MemberSeviceImpl implements MemberService {

    @Autowired
    MemberDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    @Override
    public void insertMember(Member m) {
        // 비밀번호 암호화
        String pw = passwordEncoder.encode(m.getMemberpw());
        m.setMemberpw(pw);

        dao.insertMember(m);
    }

   

}
