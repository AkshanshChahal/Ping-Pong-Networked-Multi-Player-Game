




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

public class Client extends JFrame
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
    String dif;
    String no;
    private int count;
    public Runnable conn;
    public Runnable inpt;
    public Runnable out;
    public Client(int i)
    {
    	data=null;
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
		setSize(300, 150); 
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

        while(true){try {
            
            
            byte[] buffer = new byte[10000];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            datagramSocket.receive(packet);
            buffer = packet.getData();  
            String dat=new String(buffer);
            data=dat;
            showMessage(data);

            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public String getn()
    {
        return no;
    }



    public void chatsendM(String n)
    {
        showMessage(n);
        for(int i=0;i<count;i++)
        {
                try {
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
        //showMessage(n);
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
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }



    public void conn(int h)
    {
        for(int k=0;k<h;k++)
        {
            try {
                Socket s;
                s=receiver.accept();
                ObjectInputStream i=new ObjectInputStream(s.getInputStream());
                port[count]=i.readInt();
                ip[count]=s.getInetAddress().toString();
                count++;
                System.out.println("Connected");
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    

    }



    public String receiveD()
    {
    	return data;
    }

    public int getC()
    {
    	return sport-port[0];
    }

    public void host(String ipp,int portAdd)
    {
        try {
            ip[0]=ipp;
            ip[0]="/"+ipp;
            port[0]=portAdd;
            count++;
            soc=new Socket(InetAddress.getByName(ipp),portAdd);
            System.out.println("Connected");
            ObjectInputStream in=new ObjectInputStream(soc.getInputStream());
            int por=in.readInt();
            int kj=in.readInt();
            dif=(String)in.readObject();
            no=(String)in.readObject();
            sport=portAdd+por+1;
            name="CLIENT "+(por+1)+" ";
            for(int i=0;i<por;i++)
            {
                ip[i+1]=(String)in.readObject();
                
                port[i+1]=portAdd+i+1;
                System.out.println("-->"+port[i+1]);
                count++;
            }
            receiver=new ServerSocket(sport,9);
            System.out.println(sport);
            sendToAll();
            conn(kj-por);
            
            System.out.println("now");
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public String rdif()
    {
    	return dif;
    }

    public void sendToAll() throws IOException
    {
        for(int i=0;i<count-1;i++)
        {
            Socket s;
            System.out.println(ip[i+1].substring(1));
            s=new Socket(InetAddress.getByName(ip[i+1].substring(1)),port[0]+i+1);
            ObjectOutputStream o=new ObjectOutputStream(s.getOutputStream());
            o.writeInt(sport);
            o.flush();
            o.close();
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