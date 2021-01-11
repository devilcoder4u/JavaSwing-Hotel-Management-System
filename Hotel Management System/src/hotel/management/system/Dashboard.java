
package hotel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
   
    Dashboard(){
        mb = new JMenuBar();
        add(mb);
        
        m1= new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2= new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        mb.add(m2);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVER");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0,0,1366,30);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/third.jpg"));
        Image I2=I1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l1=new JLabel(I3);
        l1.setBounds(0, 0, 1366, 768);
        add(l1);
        
        JLabel l2=new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setBounds(350, 50, 800, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("tahoma",Font.BOLD,40));
        l1.add(l2);
        
        setLayout(null);
        setBounds(0,0,1366,768);
        setVisible(true);
        
        
    }
    
    public static void main(String[] args)
    {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        } else if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver().setVisible(true);
        }
    }
}
