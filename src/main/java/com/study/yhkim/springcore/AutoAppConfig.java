package com.study.yhkim.springcore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //일반적으로 Configuration 설정 정보를 컴포넌트 스캔 대상에서 제외하지 않음
        //기존 예재 코드를 최대한 남기고 유지하기 위해 @Configuration 설정 정보를 예외 필터링
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
