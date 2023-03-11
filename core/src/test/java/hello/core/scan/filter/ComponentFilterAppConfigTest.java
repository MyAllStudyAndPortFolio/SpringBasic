package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        /**
         * ac.getBean("beanB",BeanB.class); 를 하면
         * Exclude 를 하였기 때문에 스캔 대상에 빠져버려 따로 스캔 하지 않는다.
         *
         * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'beanB' available
         * */

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB",BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters ={ @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class)},
            excludeFilters ={ @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
            /**
             * 만약 BeanA도 빼고 싶다면
             * @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE , classes= BeanA.class)
             * 를 하면 된다.
             * */
            }
    )
    static class ComponentFilterAppConfig{

    }
}
