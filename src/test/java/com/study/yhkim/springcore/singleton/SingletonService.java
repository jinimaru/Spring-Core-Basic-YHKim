package com.study.yhkim.springcore.singleton;

/*
클래스의 객체 인스턴스가 1개만 생됭되는 것을 보장하는 디자인 패턴
그래서 객체 인스턴스가 2개 이상 생성되지 못하도록 막아야 함
private 생성자를 통해 외부에서 객체 인스턴스가 생성되지 못하도록 제한
*/
public class SingletonService {

    /*
    static 영역에 객체를 딱 1개만 생성해둔다.
    - private: 외부 접근 불가
    - static: 외부에서 객체 인스턴스 생성하지 않고 JVM 실행될 때 static 영역에 미리 객체 생성
    - final: 생성된 객체 변경 불가
    */
    private static final SingletonService instance = new SingletonService();

    /*
    private 생성자
    **/
    private SingletonService() { }

    /*
    싱글톤 객체 인스턴스를 외부에서 접근 가능하도록 허용한 Getter method
    - 이 getInstance()를 호출하면 항상 같은 인스턴스를 반환한다.
    */
    public static SingletonService getInstance() {
        return instance;
    }

    /*
    테스트 method
    */
    public void logic() {
        System.out.println("Singleton 객체 로직 호출");
    }

}
