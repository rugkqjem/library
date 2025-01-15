package com.group.libraryapp.domain;
import javax.persistence.*;

@Entity
public class User {
    @Id //primary key간주
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 생성
    private Long id=null;


    //테이블 열이름이랑 같으면 name=" " 생략가능
    //칼럼 어노테이션도 생략가능함 (numllable,length) 이런거 따로 제약 없다면 , ,
    @Column(nullable = false,length=20)
    private String name; //이름은 null이되면 안됨 -> 예외처리
    private Integer age; //나이는 null이 가능해 int -> Integer


    protected User() {}

    public User(String name,Integer age){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 이름(%s)이 들어왔습니다.",name));
        }
        this.name=name;
        this.age=age;

    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Long getId() {return id;}
    public void updateName(String name){this.name=name;}
}
