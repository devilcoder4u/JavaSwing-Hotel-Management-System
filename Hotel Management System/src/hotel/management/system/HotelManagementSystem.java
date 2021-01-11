package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

   HotelManagementSystem(){
       setBounds(100,70,1200,565);
      // setSize(400,400);
      // setLocation(500,300);
       
       ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/first.jpg"));
       JLabel l1=new JLabel(I1);
       l1.setBounds(0,0,1200,565);
       add(l1);
       
       JLabel l2=new JLabel("Hotel Management System");
       l2.setBounds(20,430,1000,90);
       l2.setForeground(Color.white);
       l2.setFont(new Font("serif",Font.PLAIN,50));
       l1.add(l2);
       
       JButton b1=new JButton("Next");
       b1.setBackground(Color.white);
       b1.setForeground(Color.black);
       b1.setFont(new Font("tahoma",Font.BOLD,20));
       b1.setBounds(1000,450,150,50);
       b1.addActionListener(this);
       l1.add(b1);
       
       setLayout(null);
       setVisible(true);
       while(true){
           l2.setVisible(false);
           try{
               Thread.sleep(500);
           }catch(Exception e){
               
           }
           l2.setVisible(true);
           try{
                Thread.sleep(500);
           }
           catch(Exception e){}
       }
       
   }
   
   public void actionPerformed(ActionEvent ae){
       new Login().setVisible(true);
       this.setVisible(false);
   }
    
    public static void main(String[] args) {
       HotelManagementSystem hotelManagementSystem=new HotelManagementSystem();
    }
     
}
