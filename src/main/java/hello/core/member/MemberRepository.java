package hello.core.member;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public interface MemberRepository {

    void save(Member member);

    Member findMyId(Long memberId);

}
