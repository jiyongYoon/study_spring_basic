package com.example.spring_basic.order;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.Member;
import com.example.spring_basic.member.MemberRepository;
import com.example.spring_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // 정책이 바뀌는 상황마다 이 객체를 바꿔서 주입해주어야 함.
    // 할인정책이 바뀌는데 OrderServiceImpl의 코드를 바꿔야 하는게 마땅한가?
//     private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
