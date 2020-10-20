package hello.core.order;

/**
 * @author 이승환
 * @since 2020-10-20
 */
public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
