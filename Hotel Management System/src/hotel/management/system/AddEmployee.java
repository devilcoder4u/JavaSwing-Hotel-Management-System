package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee(){
        JLabel name=new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age=new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        
        JLabel gender=new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(200, 130, 70, 30);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(280, 130, 70, 30);
        r2.setBackground(Color.white);
        add(r2);
        
        JLabel job=new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);
        
        String str[]= {"Front Desk Clerks","Housekeeping","Room Service","Security Guard","Manager","Cleaner"};
        c1 = new JComboBox(str);
        c1.setBounds(200,180,130,30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("Tahoftta",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        
        JLabel phone=new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);
        
        JLabel adhar=new JLabel("AADHAR");
        adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        adhar.setBounds(60,330,120,30);
        add(adhar);
        
        t5 = new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);
        
        JLabel email=new JLabel("E-MAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(200, 430, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        
       ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Icons/tenth.jpg"));
       Image I2=I1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
       ImageIcon I3=new ImageIcon(I2);
       JLabel l1=new JLabel(I3);
       l1.setBounds(380, 60, 400, 400);
       add(l1);
       
       JLabel l2= new JLabel("ADD EMPLOYEE DETAILS");
       l2.setForeground(Color.blue);
       l2.setBounds(420,30,400,30);
       l2.setFont(new Font("tahoma",Font.PLAIN,30));
       add(l2);
        
       getContentPane().setBackground(Color.white);
       
       setLayout(null);
       setBounds(320,150,850,540);
       setVisible(true);
    }
    
    public static void main(String [] args){
        new AddEmployee().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String adhar=t5.getText();
        String email=t6.getText();
        
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }else if(r2.isSelected()){
            gender="Female";
        }
        String job = (String)c1.getSelectedItem();
        
        conn c=new conn();
        String str = "insert into Employee value('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
        
        try{
            
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
            
        }catch(Exception ex){}
    }
}