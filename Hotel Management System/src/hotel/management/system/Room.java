package hotel.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    Room(){
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/eight.jpg"));
        Image I2=I1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l1=new JLabel(I3);
        l1.setBounds(500, 0, 500, 600);
        add(l1);
        
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(10,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Availability");
        l3.setBounds(120,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Status");
        l4.setBounds(230,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Price");
        l5.setBounds(330,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(410,10,100,20);
        add(l6);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(220,70,1020,600);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new Room().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                
            }
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
}
