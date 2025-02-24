package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) { // psvm
//        AppConfig appConfig = new AppConfig(); // appconfig 객체 생성
//        MemberService memberService = appConfig.memberService(); // AppConfig 속 memberService 가져와서 연결

//        MemberService memberService = new MemberServiceImpl(); // impl의 틀로 memberService 틀 만들기

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); // 하나의 객체 member을 만들어줌, 이를 회원가입
        memberService.join(member);

        Member findMember = memberService.findMember(1L); // 회원가입한 객체를 찾음, 근데 이를 findMember의 틀에 넣음
        System.out.println("new member = " + member.getName()); // 회원가입한 member, 찾은 객체 findMember을 출력
        System.out.println("find Member = " + findMember.getName());

    }
}
