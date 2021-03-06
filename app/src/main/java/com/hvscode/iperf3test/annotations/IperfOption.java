package com.hvscode.iperf3test.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IperfOption {

    String name() default "";
    String command();
    boolean withValue();
    String[] valuesAllowed() default {};



}
