package hello.core.member;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
