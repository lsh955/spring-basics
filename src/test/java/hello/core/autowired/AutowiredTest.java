package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * @author 이승환
 * @since 2020-11-08
 */
public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

//        @Autowired(required = true)
//        public void setNoBean1(Member noBean1) {
//            System.out.println("noBean1 = " + noBean1);
//        }

        /**
         * Member는 스프링 빈이 아니기에 setNoBean2는 @Autowired(required = false) 이르로 호출 자체가 안된다.
         * @param noBean2
         */
        @Autowired(required = false)    // required = false는 의존관계 메소드가 없으면 호출이 안된다.
        public void setNoBean2(Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(@Nullable  Member noBean3) { // @Nullable은 자동 주입할 대상이 없으면 null이 입력된다.
            System.out.println("noBean3 = " + noBean3);
        }

        @Autowired
        public void setNoBean4(Optional<Member> noBean4) {  // 자동 주입할 대상이 없으면 Optional.empty가 입력된다.
            System.out.println("noBean4 = " + noBean4);
        }

    }

}
