package com.lilu.swordFingerOffer.Question_02.test;

import com.lilu.swordFingerOffer.Question_02.Singleton4;

import java.io.*;

public class test4 extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton4.getInstance().hashCode());
    }

    public static void main(String[] args) {
        // 多线程测试
        test4[] test4s = new test4[10];
        for (int i = 0; i < test4s.length; i++) {
            test4s[i] = new test4();
        }
        for (int i = 0; i < test4s.length; i++) {
            test4s[i].start();
        }

        Singleton4 singleton4 = Singleton4.getInstance();
        File file = new File("serializable.txt");
        // 序列化测试
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singleton4);
            fos.close();
            oos.close();
            System.out.println(singleton4.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化测试
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Singleton4 s4 = (Singleton4)ois.readObject();
            fis.close();
            ois.close();
            System.out.println(s4.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
