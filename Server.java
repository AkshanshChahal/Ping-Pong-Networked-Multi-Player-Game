
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;
import static jdk.nashorn.tools.ShellFunctions.input;

public class Server extends JFrame
{
    private JTextField userText;
    private JTextArea chatWindow;	
    public String data;
    private String ip[];
    private int port[];
    private String sip;
    private int sport;
    ServerSocket receiver;
    Socket soc;
    Socket in;
    Socket outt;
    int key;
    String name;
    private int count;
    public Runnable conn;
    public Runnable inpt;
    public Runnable out;
    public Server(int i)
    {
        
        super("Server");
        data=null;
        name="SERVER -";
        userText = new JTextField();
		userText.setEditable(true);
		userText.addActionListener(
				new ActionListener(){
				public void actionPerformed(ActionEvent event){
					chatsendM(name+event.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300, 150); //Sets the window size
		setVisible(true);
        
        count=0;
        key=i;
        ip=new String[4];
        port=new int[4];
        sport=7780;
    
    }


    public void chatinpt()
    {
        while(true){
            
            try {
                in=receiver.accept();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            ObjectInputStream input=null;

            try {
                input = new ObjectInputStream(in.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            String n="";

            try {
                n=(String)input.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            showMessage(n);

            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }



    public void inpt()
    {
        DatagramSocket datagramSocket=null;
        try {
            datagramSocket = new DatagramSocket(sport);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }


        while(true){

            try {
            
            byte[] buffer = new byte[10000];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            datagramSocket.receive(packet);
            buffer = packet.getData();  
            String dat=new String(buffer);
            data=dat;
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void conn(int n, String st, String no)
    {
        for(int j=0;j<n;j++)
              {
            try {
                Socket s=receiver.accept();;
                System.out.println("Connected");
                for(int i=0;i<count;i++)
                {
                    System.out.println(port[i]);
                }
                
                ip[count]=s.getInetAddress().toString();
                port[count]=sport+count+1;
                
                try {
                    ObjectOutputStream output;
                    output = new ObjectOutputStream(s.getOutputStream());
                    output.writeInt(count);
                    output.flush();
                    output.writeInt(n-j-1);
                    output.flush();
                    output.writeObject(st);
                    output.flush();
                    output.writeObject(no);
                    output.flush();
                    for(int i=0;i<count;i++)
                    {
                        System.out.println(ip[i]);
                        output.writeObject(ip[i]);
                        output.flush();
                    }
                    count++;
                    output.flush();
                    output.close();
                    System.out.println("Connected");
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }


    public String receiveD()
    {
    	
    	return data;
    }


    public void chatsendM(String n)
    {
        showMessage(n);
        for(int i=0;i<count;i++)
        {
            try{
                Socket oi;
                oi=new Socket(InetAddress.getByName(ip[i].substring(1)),port[i]);
                ObjectOutputStream o=new ObjectOutputStream(oi.getOutputStream());
                o.writeObject(n);
                o.flush();
                o.close();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               
    }



    public void sendMessage(String n){
        for(int i=0;i<count;i++)
        {
            try {
               
                DatagramSocket datagramSocket = new DatagramSocket();
    
                byte[] buffer =n.getBytes();
                InetAddress receiverAddress = InetAddress.getLocalHost();
                
                DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length, InetAddress.getByName(ip[i].substring(1)), port[i]);
                datagramSocket.send(packet);
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }




    public void inputt()
    {
        inpt();
    }



    public void host(int portAdd, int n, String s, String no)
    {
        try {
            sport=portAdd;
            receiver=new ServerSocket(portAdd,9);
            System.out.println("serverhosted");
            conn(n,s,no);
            System.out.println("now");
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



    private void showMessage(final String message){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append("\n"+message);
				}
			}
		);
	}

    
}