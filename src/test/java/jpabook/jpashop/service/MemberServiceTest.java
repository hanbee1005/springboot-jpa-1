package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입")
    void join() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        assertThat(memberRepository.find(savedId)).isEqualTo(member);
    }

    @Test
    @DisplayName("중복 회원 예외")
    void exceptionAboutDuplicateMember() {
        // given
        String name = "kim";

        Member member1 = new Member();
        member1.setName(name);

        Member member2 = new Member();
        member2.setName(name);

        // when
        memberService.join(member1);

        // then
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
    }
}