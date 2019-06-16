package com.sincere.mapper;

import javax.swing.*;

public class Player {
    public static void main(String[] args) {
        String set1 = " 1  3  5  7\n 9 11 13 15\n17 19 21 23\n25 27 29 31";
        String set2 = " 2  3  6  7\n10 11 14 15\n18 19 22 23\n26 27 30 31";
        String set3 = "  4  5  6  7\n12 13 14 15\n20 21 22 23\n28 29 30 31";
        String set4 = " 8  9 10 11\n12 13 14 15\n24 25 26 27\n28 29 30 31";
        String set5 = "16 17 18 19\n20 21 22 23\n24 25 26 27\n28 29 30 31";

        int day = 0;

        int answer = JOptionPane.showConfirmDialog(null,
                "Is your birthday in thess numbers\n" + set1);
        if (answer == JOptionPane.YES_OPTION)
            day += 1;

        answer = JOptionPane.showConfirmDialog(null,
                "Is your birthday in thess numbers\n" + set2);
        if (answer == JOptionPane.YES_OPTION)
            day += 2;

        answer = JOptionPane.showConfirmDialog(null,
                "Is your birthday in thess numbers\n" + set3);
        if (answer == JOptionPane.YES_OPTION)
            day += 4;

        answer = JOptionPane.showConfirmDialog(null,
                "Is your birthday in thess numbers\n" + set4);
        if (answer == JOptionPane.YES_OPTION)
            day += 8;

        answer = JOptionPane.showConfirmDialog(null,
                "Is your birthday in thess numbers\n" + set5);
        if (answer == JOptionPane.YES_OPTION)
            day += 16;

        JOptionPane.showMessageDialog(null, "your birthday is " + day);
    }
}