package com.example;

@MyAnnotation("custom")
public class Book {

    @MyAnnotation
    private static String B = "BOOK";

    private static final String C = "BOOK";

    @AnotherAnnotation
    private String a = "a";

    public String d = "d";

    protected String e = "e";

    // @MyAnnotation - Target에 포함되지 않아 컴파일 에러 발생
    public Book() {
    }

    @AnotherAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
