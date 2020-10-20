package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * 주문생성
     * @param memberId  사용자아이디
     * @param itemName  아이템이름
     * @param itemPrice 아이템가격
     * @return
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findMyId(memberId);    // 회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에 회원정보를 넘긴다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
