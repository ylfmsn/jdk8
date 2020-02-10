package com.ylf.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");
        JButton jButton1 = new JButton("My JButton1");

        /**
         * 匿名内部类
         */
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed!");
            }
        });

        /**
         * lambda表达式
         */
        jButton1.addActionListener(e -> {
            System.out.println("Button Pressed!");
        });

        jframe.add(jButton);
        jframe.add(jButton1);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
