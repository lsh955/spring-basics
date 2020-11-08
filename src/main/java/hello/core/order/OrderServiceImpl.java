package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 이승환
 * @since 2020-10-20
 */
@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     * 필드주입식 @Autowired는 사용하지 말자!
     * 코드가 간결해서 보기가 좋으나 외부에서 변경이 불가능해서 테스트 하기 힘들다는 단점이 있다.
     */
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    /**
     * @RequiredArgsConstructor 롬복 어노테이션 적용으로, 아래의 클래스 생성자를 자동으로 생성.
     * 이로서 아래의 생성자는 명시적으로 작성할 필요가 없다.
     */
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문생성
     *
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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
