package chapter13;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) throws InterruptedException {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();
        System.out.println("isInterrupted():" + th1.isInterrupted());

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + " 입니다.");
        th1.interrupt();

        Thread.sleep(2000);
        System.out.println("isInterrupted():" + th1.isInterrupted());
    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
