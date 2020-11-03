package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * @author 이승환
 * @since 2020-11-03
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
