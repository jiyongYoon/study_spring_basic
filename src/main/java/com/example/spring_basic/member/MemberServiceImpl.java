package com.example.spring_basic.member;

// 인터페이스에 대한 구현체가 하나만 있을 경우 뒤에 Impl이라고 보통 붙인다. (컨벤션)
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    // 생성자를 통해서 객체를 주입시키기
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
