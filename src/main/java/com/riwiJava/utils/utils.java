package com.riwiJava.utils;

import javax.swing.*;
import java.util.List;

public class utils {
    public static <T> T selectOption(List<T> list) {
        T[] array = (T[]) new Object[list.size()];

        int i = 0;
        for (T temp : list) {
            array[i++] = temp;
        }

        return (T) JOptionPane.showInputDialog(
                null,
                "Choose a " + array.getClass().getSimpleName() + ": ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                array,
                array[0]
        );
    }

}
