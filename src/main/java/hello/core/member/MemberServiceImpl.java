package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 이승환
 * @since 2020-10-20
 * <p>
 * 클래스명 뒤 Impl 키워드는 구현체가 1개 있을때 관례상 넣어준다고 한다.
 */
@Component
public class MemberServiceImpl implements MemberService {

    /**
     * DIP를 잘 지키고 있는가?
     * 이런 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음.
     */
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     * @param member
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 사용자 찾기
     *
     * @param memberId
     * @return
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findMyId(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
       return memberRepository;
    }

}
