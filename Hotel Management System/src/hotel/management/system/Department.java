package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    Department(){
        
        t1 = new JTable();
        t1.setBounds(0,50,700,350);
        add(t1);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(100,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(500,10,100,20);
        add(l4);
        
        
        b1 = new JButton("Load Data");
        b1.setBounds(150,400,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(350,400,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(340,150,700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try{
                String str = "select * from department";
                conn c = new conn();
                ResultSet rs;
                rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                
                
            }catch(Exception e){System.out.println(e);}
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new Department().setVisible(true);
    }
    
}

