package com.group.libraryapp.domain;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa레포지토리 상속하는 것 만으로 스프링빈이 됨
public interface UserRepository extends JpaRepository<User, Long> {
    //자동으로 함수이름가지고 쿼리문 만들어서 함수 정의 안해줘도 알아서 함수만들어짐
    //select * from User where name=? => 데이터 없으면 그냥 널로 반환 되겟죠
    User findByName(String name);


}
