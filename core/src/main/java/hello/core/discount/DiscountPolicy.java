package hello.core.discount;

import hello.core.member.Member;

// discount 정책 함수들
// interface란 추상 클래스이다.
public interface DiscountPolicy   {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
