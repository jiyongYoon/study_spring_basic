package com.example.spring_basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 인터페이스에 대한 구현체가 하나만 있을 경우 뒤에 Impl이라고 보통 붙인다. (컨벤션)
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Autowired // 생성자에 붙여주면, ComponentScan 할 때 여기 와서 자동으로 객체 주입하게 됨.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
