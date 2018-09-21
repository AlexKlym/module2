package arraylist;

import arraylist.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("three");
        list.add("four");
        list.add("one", 1);
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }

}
