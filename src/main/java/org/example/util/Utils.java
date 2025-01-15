package org.example.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static void print(String value) {
        System.out.println(value);
    }

    public static boolean  isEmpty(String value){
        return  value != null && !value.isEmpty();
    }


    //Listdagi ma'lumotni javal qilib chiqarish
    public static <T> void printListAsTable(List<T> list) {
        CommandLineTable st = new CommandLineTable();
//        st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeader(Arrays.stream(list.get(0).getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList()));//optional - if not used then there will be no header and horizontal lines
        st.addRows(list);
        st.print();
    }
}
