package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
@Inherited
public @interface MyAnnotation {

    // 제한된 멤버를 가질 수 있음. 기본 타입 및 기본 타입들의 래퍼 객체 타입
    String name() default "wscrg";

    int number() default 100;

    // value로 설정하면 어노테이션에 값 설정 시 이름을 작성할 필요 없이 값을 바로 작성 가능
    String value() default "default";
}
