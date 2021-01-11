
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    
    AddRooms(){
        
        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("tahoma",Font.BOLD,18));
        l1.setBounds(150,20,100,20);
        add(l1);
        
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("tahoma",Font.BOLD,16));
        room.setBounds(60,80,120,30);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("tahoma",Font.BOLD,16));
        available.setBounds(60,130,120,30);
        add(available);
        
        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(200,130,150,30);
        c1.setBackground(Color.white);
        add(c1);
        
        
        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("tahoma",Font.BOLD,16));
        status.setBounds(60,180,120,30);
        add(status);
        
        c2 = new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,180,150,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("tahoma",Font.BOLD,16));
        price.setBounds(60,230,120,30);
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(200,230,120,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("tahoma",Font.BOLD,16));
        type.setBounds(60,280,120,30);
        add(type);
        
        c3 = new JComboBox(new String[] {"Single","Double"});
        c3.setBounds(200,280,150,30);
        c3.setBackground(Color.white);
        add(c3);
        
        b1 = new JButton("Add Room");
        b1.setBounds(60,350,130,30);
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220,350,130,30);
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/twelve.jpg"));
        Image I2=I1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l4=new JLabel(I3);
        l4.setBounds(400, 30, 450, 350);
        add(l4);
        
        getContentPane().setBackground(Color.white);
        
        setBounds(250,150,900,500);
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args){
        
        new AddRooms().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1)){
            
            String room=t1.getText();
            String available=(String)c1.getSelectedItem();
            String status=(String)c2.getSelectedItem();
            String price=t2.getText();
            String type=(String)c3.getSelectedItem();
            
            conn c=new conn();
            try{
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource().equals(b2)){
            this.setVisible(false);
        }
    }
    
}
