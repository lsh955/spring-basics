package hello.core.member;

/**
 * @author 이승환
 * @since 2020-10-20
 *
 * 클래스명 뒤 Impl 키워드는 구현체가 1개 있을때 관례상 넣어준다고 한다.
 */
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     * @param member
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 사용자 찾기
     * @param memberId
     * @return
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findMyId(memberId);
    }

}
