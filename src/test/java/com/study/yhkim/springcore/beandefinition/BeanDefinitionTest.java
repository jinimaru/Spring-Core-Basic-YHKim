package com.study.yhkim.springcore.beandefinition;

import com.study.yhkim.springcore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
BeanDefinition 은 빈 설정 메타정보이다. (interface. 추상화)
- AnnotationConfigApplicationContext 는 AnnotationBeanDefinitionReader 를 통해 AppConfig.class 를 읽고 BeanDefinition 을 생성
- GenericXmlApplicationContext 는 XmlBeanDefinitionReader 를 통해 appConfig.xml 을 읽고 BeanDefinition 을 생성
*/
public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext gc = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("Annotation 빈 설정 메타정보 확인")
    void findAnnotationApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "\n beanDefinition = " + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("XML 빈 설정 메타정보 확인")
    void findGenericXmlApplicationBean() {
        String[] beanDefinitionNames = gc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = gc.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        "\n beanDefinition = " + beanDefinition);
            }
        }
    }
}
