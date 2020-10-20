package hello.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public class MemoryMemberRepository implements MemberRepository {

    // HashMap은 동시성이슈?가 발생하므로 ConcurrentHashMap을 쓰기를 권장한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member ) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findMyId(Long memberId) {
        return store.get(memberId);
    }

}
