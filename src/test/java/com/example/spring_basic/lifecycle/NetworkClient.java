package com.example.spring_basic.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 로그에 출력하는 것으로 예행실습
public class NetworkClient /*implements InitializingBean, DisposableBean*/{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("init start.");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("Bean close.");
        disconnect();
    }

    /*
    // InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
    // DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destory.");
        disconnect();
    }
     */
}
