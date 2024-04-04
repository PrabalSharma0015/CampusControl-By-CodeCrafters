package University.UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;

    Splash(){
        setTitle("Campus Control");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Bennett1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        t = new Thread(this);
        t.start();
        setResizable(false);
        setVisible(true);


        int x=1;
        for(int i=2;i<=600;i+=4,x+=1){
            setLocation(600-((i + x)/2),350-(i/2));
            setSize(i+3*x,i+x/2);
        }
        
        try {
            Thread.sleep(5000);
            
        } catch (Exception e) {
            
        }
    }

    public void run(){
        try {
            Thread.sleep(5000);
            setVisible(false);
            
            // Next class
            new Login();

            
        } catch (Exception e) {
            
        }
    }


    public static void main(String[] args) {
        new Splash();
    }
}
