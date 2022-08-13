package com.example.spring_basic.scan;

import com.example.spring_basic.AutoAppConfig;
import com.example.spring_basic.discount.DiscountPolicy;
import com.example.spring_basic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void getDiscountPolicyBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        System.out.println("discountPolicy = " + discountPolicy);
    }
}
