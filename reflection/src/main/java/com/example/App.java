package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

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
        /*
         * Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> { try {
         * f.setAccessible(true); System.out.printf("%s %s\n", f, f.get(book)); } catch
         * (IllegalAccessException e) { e.printStackTrace(); } });
         */

        // 메서드 조회하기. 상속받은 메서드도 모두 출력됨
        // Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        // 생성자 조회하기
        // Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 슈퍼 클래스 조회하기
        // System.out.println(MyBook.class.getSuperclass());

        // 구현한 인터페이스 조회하기
        // Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        // 필드의 정보를 조회하기. 접근 제어자, 함수의 리턴 타입, 어노테이션 등 많은 정보를 알아낼 수 있다.
        /*
         * Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> { int modifiers =
         * f.getModifiers(); System.out.println(f);
         * System.out.println(Modifier.isPrivate(modifiers));
         * System.out.println(Modifier.isStatic(modifiers)); });
         */

        // 어노테이션 조회
        // Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        // @Inherited를 선언한 어노테이션은 자식들에서도 조회가 가능하다.
        // MyBook은 자신에게 선언된 AnotherAannotation과 Book에 선언된 MyAnnotation이 모두 조회된다.
        // Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        // 자신에게 선언된 어노테이션만 조회
        // Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        // 필드에 붙은 어노테이션들을 출력하기
        /*
         * Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
         * Arrays.stream(f.getAnnotations()).forEach(System.out::println); });
         */
        /*
         * Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
         * Arrays.stream(f.getAnnotations()).forEach(a -> { if (a instanceof
         * MyAnnotation) { MyAnnotation myAnnotation = (MyAnnotation) a;
         * System.out.println(myAnnotation.value());
         * System.out.println(myAnnotation.number()); } }); });
         */

        // 리플렉션을 활용해 기본 생성자로 객체 생성하기
        /*
         * Class<?> bookClass1 = Class.forName("com.example.Book"); Constructor<?>
         * constructor = bookClass1.getConstructor(null); Book book1 = (Book)
         * constructor.newInstance();
         */

        // argument를 갖는 생성자를 가져와서 객체 생성하기
        /*
         * Constructor<?> constructor2 = bookClass1.getConstructor(String.class); Book
         * book2 = (Book) constructor2.newInstance("MyBook"); System.out.println(book2);
         */

        // A는 static이기 때문에 특정 인스턴스 없이 값을 가져오고 수정할 수 있다.
        /*
         * Field a = Book.class.getDeclaredField("A"); System.out.println(a.get(null));
         * a.set(null, "AAAAAA"); System.out.println(a.get(null));
         */

        // B는 인스턴스 변수이기 때문에 해당 클래스의 인스턴스에 접근하여 가져오고 수정할 수 있다.
        // 이때 private인 경우 setAccessible(true)를 해야 접근할 수 있다.
        /*
         * Field b = Book.class.getDeclaredField("B"); b.setAccessible(true);
         * System.out.println(b.get(book)); b.set(book, "BBBBBB");
         * System.out.println(b.get(book));
         */

        // c는 private 메서드이기 때문에 역시 setAccessible(true)를 해주어야 한다.
        // 함수는 invoke()로 실행할 수 있다. 인스턴스 메서드면 해당 클래스의 인스턴스를 넘겨줘야 한다.
        /*
         * Method c = Book.class.getDeclaredMethod("c"); c.setAccessible(true);
         * c.invoke(book);
         */
        
        // 해당 함수에 인자가 필요하면 인자도 넣어주면 된다.
        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invokedResult = (int) d.invoke(book, 1, 2);
        System.out.println(invokedResult);
    }
}
