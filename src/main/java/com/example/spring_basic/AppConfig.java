package com.example.spring_basic;

import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.discount.FixDiscountPolicy;
import com.example.spring_basic.discount.RateDiscountPolicy;
import com.example.spring_basic.member.MemberRepository;
import com.example.spring_basic.member.MemberService;
import com.example.spring_basic.member.MemberServiceImpl;
import com.example.spring_basic.member.MemoryMemberRepository;
import com.example.spring_basic.order.OrderService;
import com.example.spring_basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 객체 주입을 여기서 다 하자! service 클래스에서는 service 하는것만 집중하도록!
@Configuration
public class AppConfig {

    @Bean
    public static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }

    // 여기서 주입시키는 객체가 -> Service의 생성자로 들어가서 객체로 주입됨.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }
}
