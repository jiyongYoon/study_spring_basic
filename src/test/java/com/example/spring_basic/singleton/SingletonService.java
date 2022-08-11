package com.example.spring_basic.singleton;

public class SingletonService {

    // 1. static 영역에 객체 1개 생성해둠. 그러면 여기 인스턴스에 객체 참조주소를 넣어놓음.
    private static final SingletonService instance = new SingletonService();

    // 2. getInstance메서드를 실행하면 이미 static에 있는 객체 반환.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자가 private이기 때문에 외부에서 생성자 사용 불가 -> 외부에서 new가 호출되지 않음.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
