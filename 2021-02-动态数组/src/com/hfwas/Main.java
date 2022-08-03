package com.hfwas;

/**
 * @ClassName Main
 * @Description TODO
 * @Author hfwas
 * @Date: 10:49 下午
 * @Version: 1.0
 **/
public class Main {
    public static void main(String[] args) {
//        System.out.println("");
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("s");
//        System.out.println(strings.toString());
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("dd1","ddd1"));
        list.add(new Person("dd2","ddd2"));
        list.add(new Person("dd3","ddd3"));
        System.out.println(list);

        list.clear();
        //
        System.gc();
        list.add(new Person("aa1","aaa1"));
        System.out.println(list.get(1));
    }
}
