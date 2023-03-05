import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask; 
class login extends JFrame implements ActionListener  
{  
    JButton but;  
    JPanel createPanel;  
    JLabel userlabel, passlabel;  
    final JTextField  tfield1, tfield2;  
    login()  
    { 
        userlabel = new JLabel();
        userlabel.setText("    Username :");      
        tfield1 = new JTextField(15);      
        passlabel = new JLabel();  
        passlabel.setText("    Password :");        
        tfield2 = new JPasswordField(8);     
        but = new JButton("   SUBMIT   ");  
        createPanel = new JPanel(new GridLayout(3, 1));  
        createPanel.add(userlabel);     
        createPanel.add(tfield1);  
        createPanel.add(passlabel);    
        createPanel.add(tfield2);   
        createPanel.add(but);          
        add(createPanel, BorderLayout.CENTER);  
        but.addActionListener(this);    
        setTitle("Login Form ");         
    }   
    public void actionPerformed(ActionEvent ae)     
    {  
        String userValue = tfield1.getText();        
        String passValue = tfield2.getText();       
        if(!passValue.equals(""))
            new TestBegin(userValue); 
        else{
            tfield2.setText("Enter Password");
            actionPerformed(ae);
        }
    }     
}  
class TestBegin extends JFrame implements ActionListener  
{  
    JLabel l;  
    JLabel l1;  
    JRadioButton jb[]=new JRadioButton[6];  
    JButton but,b2,log;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    Timer timer = new Timer();  
    TestBegin(String s)  
    {      
        super(s); 
        l=new JLabel();
        l1 = new JLabel();  
        add(l);
        add(l1);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        but=new JButton("Save and Next");  
        b2=new JButton("Save for later");  
        but.addActionListener(this);  
        b2.addActionListener(this);  
        add(but);add(b2);  
        set();  
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,300,20);  
        jb[1].setBounds(50,110,300,20);  
        jb[2].setBounds(50,140,300,20);  
        jb[3].setBounds(50,170,300,20);  
        but.setBounds(95,240,140,30);  
        b2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);     
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 300;
            public void run() {  
                l1.setText("Time left: " + i);
                i--;   
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");                     
                } 
            }
        }, 0, 1000);        
    }  
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==but)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                but.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Save for later"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Score ="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Who developed the Java language?");  
            jb[0].setText("charles Babbage");jb[1].setText("James Gosling");jb[2].setText("M.P.Java");jb[3].setText("Blais Pascal");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: When an array is passed to a method, what does the method receive?");  
            jb[0].setText("The reference of the array");jb[1].setText("A copy of the array");jb[2].setText("Length of the array");jb[3].setText("Copy of first element");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: When is the object created with new keyword?");  
            jb[0].setText("At run time");jb[1].setText("At compile time");jb[2].setText("Depends on the code");jb[3].setText("None");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Who developed the Python language?");  
            jb[0].setText("Zim Den");jb[1].setText("Guido van Rossum");jb[2].setText("Niene Stom");jb[3].setText("Wick van Rossum");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following operators is the correct option for power(ab)?");  
            jb[0].setText("a ^ b");jb[1].setText("a**b");jb[2].setText("a ^ ^ b");jb[3].setText("a ^ * b");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: _____ is used to find and fix bugs in the Java programs.");  
            jb[0].setText("JVM");jb[1].setText("JRE");jb[2].setText("JDK");jb[3].setText("JDB");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: A clustering index defined on the fields which are of type ");  
            jb[0].setText("non-key and ordering");jb[1].setText("non-key and non-ordering");jb[2].setText("key and ordering");  
                        jb[3].setText("key and non-ordering");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: The term 'FAT' is stands for_____");  
            jb[0].setText("File Allocation Tree");jb[1].setText("File Allocation Table");jb[2].setText("File Allocation Graph");  
                        jb[3].setText("All of the above");         
        }  
        if(current==8)  
        {  
            l.setText("Que9:Rectangles in ER diagram represents?");  
            jb[0].setText("Tables");jb[1].setText("Attributes");jb[2].setText("Tuples");jb[3].setText("Entity Sets");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: The Bellmann Ford Algorithm returns __________  value?");  
            jb[0].setText("String");jb[1].setText("Boolean");jb[2].setText("Double");  
                        jb[3].setText("Integer");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[3].isSelected());  
        if(current==6)  
            return(jb[0].isSelected());  
        if(current==7)  
            return(jb[1].isSelected());  
        if(current==8)  
            return(jb[3].isSelected());  
        if(current==9)  
            return(jb[1].isSelected());  
        return false;  
    }    
} 
class Exam  
{  
    public static void main(String args[])  
    {  
        try  
        {  
            login form = new login();  
            form.setSize(400,200);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 