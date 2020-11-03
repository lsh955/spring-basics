package hello.core.scan;

import hello.core.scan.filter.BeanA;
import hello.core.scan.filter.BeanB;
import hello.core.scan.filter.MyExcludeComponent;
import hello.core.scan.filter.MyIncludeComponent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

/**
 * @author 이승환
 * @since 2020-11-03
 */
public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(
            // type = FilterType.ANNOTATION는 기본값이라 지워도 똑같이 작동한다.
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class), // beanA가 스프링빈에 등록된다.
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)  // beanB는 스프링빈에 등록되지 않는다.
    )
    static class ComponentFilterAppConfig {

    }

}
