package com.sincere;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@MyAnnotation(hello = "classLevel", world = "USA")
public class Player {
    @Deprecated
    @MyAnnotation(hello = "methodLevel", world = "Edison")
    @TargetTest//move this to class level to see
    public void playerMethod() {
        System.out.println("print anything");
    }


    public static void main(String[] args) throws Exception {
        Player p = new Player();
//        p.playerMethod();
        Class clazz = Class.forName("Algorithm.Player");
        Method playerMethod = clazz.getMethod("playerMethod");
        System.out.println("here");
//        System.out.println(playerMethod.isAnnotationPresent(MyAnnotation.class));
        if (playerMethod.isAnnotationPresent(MyAnnotation.class)) {
            playerMethod.invoke(p);
        }
        MyAnnotation myAnnotation = playerMethod.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation);
        System.out.println(myAnnotation.hello());
        System.out.println(myAnnotation.world());
        System.out.println(playerMethod.getName());
    }


}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String hello() default "Hello, I'm default";

    String world();
}

@Target(ElementType.METHOD)
@interface TargetTest{
    String value() default "can only used on method";
}

