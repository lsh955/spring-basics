package hello.core.discount;

import hello.core.member.Member;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public interface DiscountPolicy {

    /**
     * 할인대상 금애
     *
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);

}
