package com.swyg.petdiary.domain;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Member { //회원 객체 (회원 테이블 매핑)
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;

    @OneToMany(mappedBy="member") //Pet Entity의 'member(FK)' 필드에 의해 참조됨
    private List<Pet> pets;
    @OneToMany(mappedBy="member") //Post Entity의 'member(FK)' 필드에 의해 참조됨
    private List<Post> posts;
    @OneToMany(mappedBy="member") //Board Entity의 'member(FK)' 필드에 의해 참조됨
    private List<Board> boards;
    @OneToMany(mappedBy="member") //Comment Entity의 'member(FK)' 필드에 의해 참조됨
    private List<Comment> comments;


    /*==메인 로직==*/
    /*회원 객체 생성 (회원가입)*/
    public void createMember(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = "ROLE_USER";
    }

    /*회원 객체 수정*/
    public void updateMember(String password, String name) {
        this.password = password;
        this.name = name;
    }





}
