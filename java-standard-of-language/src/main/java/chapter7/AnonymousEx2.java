package chapter7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousEx2 {
    public static void main(String[] args) {
        Button b = new Button("Start");

        // using class.
        b.addActionListener(new EventHandler());

        // using anonymous class.
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!");
            }
        });

        // using lambda.
        b.addActionListener(e -> System.out.println("ActionEvent occurred!"));
    }
}

class EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent occurred!");
    }
}