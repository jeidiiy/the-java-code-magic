package com.example;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException {

        // 클래스 정보를 가져오는 방법

        // 1. 클래스 로딩 시 힙에 생성되는 Book을 통해 조회
        Class<Book> bookClass = Book.class;

        // 2. 만들어져 있는 인스턴스에서 조회
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // 3. Class.forName()에 FQCN를 입력하여 조회
        Class<?> aClass1 = Class.forName("com.example.Book");

        // public 필드 출력하기
        // Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // 작성된 모든 필드와 값 가져오기
/*         Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }); */

        // 메서드 조회하기. 상속받은 메서드도 모두 출력됨
        // Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        // 생성자 조회하기
        // Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 슈퍼 클래스 조회하기
        // System.out.println(MyBook.class.getSuperclass());

        // 구현한 인터페이스 조회하기
        // Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        // 필드의 정보를 조회하기. 접근 제어자, 함수의 리턴 타입, 어노테이션 등 많은 정보를 알아낼 수 있다.
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
    }
}
