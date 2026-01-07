package autoboxing;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer boxed = Integer.valueOf(10); // preffered but unnecessary since Java 5
        Integer deprecatedBoxed = new Integer(10); // Deprecated way since Java 9
        int unboxed = boxed.intValue(); // Unboxing

        // Automatic boxing
        Integer autoBoxed = 20; // Automatic boxing
        int autoUnboxed = autoBoxed; // Automatic unboxing
        System.out.println(autoBoxed.getClass().getName());

        Double resultBoxed = getLiteralDoublePrimitive(); // Automatic boxing
        double resultUnboxed = getDoubleObject(); // Automatic unboxing

        Integer[] wrapperArray = new Integer[3];
        wrapperArray[0] = 10; // Automatic boxing
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] charArray = {'A', 'B', 'C'}; // Automatic boxing
        System.out.println(Arrays.toString(charArray));

        var ourList = getList(1, 2, 3, 4, 5); // Automatic boxing
        System.out.println(ourList);
    }

    private static ArrayList<Integer> getList(int... varargs) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : varargs) {
            list.add(value); // Automatic boxing
        }
        return list;
    }

    private static int returnAnInt(Integer value) {
        return value; // Automatic unboxing
    }

    private static Integer returnAnInteger(int value) {
        return value; // Automatic boxing
    }

    private static Double getDoubleObject() {
        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {
        return 100.00;
    }

}
