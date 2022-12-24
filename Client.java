//Client program
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.System.out;

public class Client extends JFrame
{
     //for gui
    public JLabel heading=new JLabel("Client");
    public JTextArea msgbox =new  JTextArea();
    public JTextField msginput=new JTextField();
    public Font font =new Font("Roboto",Font.PLAIN,20);
      
    public void gui()
    {
        this.setTitle("CHAT APPLICATION");
       
        this.setSize(400,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       heading.setFont(font);
       msgbox.setFont(font);
        msginput.setFont(font);
        this.setLayout(new BorderLayout());
        this.add(heading,BorderLayout.NORTH);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
       
        heading.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.add(msgbox,BorderLayout.CENTER);
        msgbox.setEnabled(false);
        this.add(msginput,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void eventhandler()
    {
        msginput.addKeyListener(new KeyListener()
        {
           
            public void keyTyped (KeyEvent e)
            {
               
            }
           
            public void keyPressed (KeyEvent e)
            {
 
            }
           
            public void keyReleased (KeyEvent e)
            {
                //for debugging
               // System.out.println("keyreleased "+e.getKeyCode());
               if(e.getKeyCode()==10)
               {
                    String contentToSend =msginput.getText();
                    msgbox.append("ME: "+contentToSend+"\n");
                    System.out.println(contentToSend);
                    write.println(contentToSend);
                    write.flush();
                    out.flush();
                    msginput.setText("");
                    msginput.requestFocus();
               }
            }
        });
    }
    //
    Socket socket;
    BufferedReader read;// for reading
    PrintWriter write;// for Writing

    public void start_read()
    {
        //creating threads
        Runnable r1=()->{
            while(true)
            {
            try {
                
                String msg=read.readLine();
                if(msg.equals("exit"))
                {
                    System.out.println("CHAT ENDED(server)");
                    
                    System.out.println("[SESSION TERMINATED]");
                    
                    msginput.setEnabled(false);
                    socket.close();
                    System.exit(0);
                    break;
                }
                System.out.println("Server: "+msg);
                msgbox.append("Server: "+msg+"\n");
            }
             catch(Exception e) {
                //e.printStackTrace();
		System.exit(0);
		
            }
            }
            
        };
        new Thread(r1).start();
    }
    public void start_write()
    {
        Runnable r2=()->{
             while(true)
            {
            try {
                BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
                String content= console.readLine();
                write.println(content);
                write.flush();
                
            }
             catch(Exception e) {
                e.printStackTrace();
            }
            }
        };
        new Thread(r2).start();
    }

    
    public Client()
    {
        try{
            System.out.println("[SENT REQUEST]");
            socket=new Socket("127.0.0.1",1230);
            System.out.println("[connected]");
            read= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            write= new PrintWriter(socket.getOutputStream());
            gui();
            eventhandler();
            start_read();
            start_write();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("[Client Started]");
        new Client();
    }
}
