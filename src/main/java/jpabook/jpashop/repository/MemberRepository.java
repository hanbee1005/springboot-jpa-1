package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;  // spring boot 에서는 @PersistenceContext 대신 @Autowired 사용 가능

    /**
     * member 저장
     * @param member
     * @return
     */
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    /**
     * id로 member 조회
     * @param id
     * @return
     */
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    /**
     * 전체 member 조회
     * @return
     */
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    /**
     * name으로 member 조회
     * @param name
     * @return
     */
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
