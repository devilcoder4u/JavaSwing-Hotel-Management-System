
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;
    
    Login(){
        
        l3=new JLabel("User Login");
        l3.setFont(new Font("tahoma",Font.BOLD,18));
        l3.setBounds(120,10,100,30);
        add(l3);
        
        l1=new JLabel("Username");
        l1.setBounds(40, 50, 100, 30);
        add(l1);
        
        l2=new JLabel("Password");
        l2.setBounds(40, 90, 100, 30);
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(150, 50, 150, 30);
        add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(150, 90, 150, 30);
        add(t2);
        
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(40,190,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(180,190,120,30);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/second.jpg"));
        Image I2=I1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l3=new JLabel(I3);
        l3.setBounds(350, 10, 200, 200);
        add(l3);
                
        getContentPane().setBackground(Color.white);
        
        
        setLayout(null);
        setBounds(450,200,600,300);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String username=t1.getText();
            String password=t2.getText();
            conn c=new conn();
            
            String str="select* from login where username = '"+username+"' and password = '"+password+"'";
            try{
              ResultSet rs =  c.s.executeQuery(str);
              if(rs.next()){
                  new Dashboard().setVisible(true);
                  this.setVisible(false);
              }else
              {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  new HotelManagementSystem().setVisible(true);
                  this.setVisible(false);
              }
            }catch(Exception e){}
            
            
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    
}
