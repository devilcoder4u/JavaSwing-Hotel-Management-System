package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
    AddDriver(){
        
        JLabel title = new JLabel("Add Drivers");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("tahoma",Font.PLAIN,18));
        add(title);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60,70,100,30);
        name.setFont(new Font("tahoma",Font.PLAIN,16));
        add(name);
        
        t1=new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,110,100,30);
        age.setFont(new Font("tahoma",Font.PLAIN,16));
        add(age);
        
        t2=new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,150,100,30);
        gender.setFont(new Font("tahoma",Font.PLAIN,16));
        add(gender);
        
        c1 = new JComboBox(new String[] {"Male","Female"});
        c1.setBounds(200,150,150,30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel car = new JLabel("CAR");
        car.setBounds(60,190,100,30);
        car.setFont(new Font("tahoma",Font.PLAIN,16));
        add(car);
        
        t3=new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel model = new JLabel("MODEL");
        model.setBounds(60,230,100,30);
        model.setFont(new Font("tahoma",Font.PLAIN,16));
        add(model);
        
        t4=new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(60,270,100,30);
        available.setFont(new Font("tahoma",Font.PLAIN,16));
        add(available);
        
        c2 = new JComboBox(new String[] {"Available","Not Available"});
        c2.setBounds(200,270,150,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel location = new JLabel("LOCATION");
        location.setBounds(60,310,100,30);
        location.setFont(new Font("tahoma",Font.PLAIN,16));
        add(location);
        
        t5=new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        
        
        b1 = new JButton("ADD DRIVER");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CANCEL");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(210,370,130,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/eleven.jpg"));
        Image I2=I1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l1=new JLabel(I3);
        l1.setBounds(400, 0, 350, 400);
        add(l1);
        
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(320,150,800,450);
        setVisible(true);
    }
    
    public static void main(String [] args){
        new AddDriver().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String car = t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String location = t5.getText();
            
            conn c = new conn();
            
            String str="insert into Driver value('"+name+"','"+age+"','"+gender+"','"+car+"','"+brand+"','"+available+"','"+location+"')" ;
           
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully");
                this.setVisible(false);
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource() == b2){
            setVisible(false);
        }
    }
}
