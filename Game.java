
 import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.lang.Math;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
 

 public class Game extends JComponent implements KeyListener,ActionListener{
 	
 	private Ellipse2D.Double ball = new Ellipse2D.Double(100, 100, 15, 15 );
        private Ellipse2D.Double ball2 = new Ellipse2D.Double(100, 100, 15, 15 );
        private Ellipse2D.Double ball3 = new Ellipse2D.Double(100, 100, 15, 15 );
 	private RoundRectangle2D.Double bat = new RoundRectangle2D.Double(200, 15, 100, 15, 9, 9);
	private RoundRectangle2D.Double cbat = new RoundRectangle2D.Double(200, 15, 100, 15, 9, 9);
	private RoundRectangle2D.Double cbat_left = new RoundRectangle2D.Double(200, 15, 15, 100, 9, 9);
	private RoundRectangle2D.Double cbat_right = new RoundRectangle2D.Double(200, 15, 15, 100, 9, 9);
	private RoundRectangle2D.Double line = new RoundRectangle2D.Double(10, 100, 1000, 7, 9, 9);
        private RoundRectangle2D.Double corner1 = new RoundRectangle2D.Double(10,10,15,15,0,0);
        private RoundRectangle2D.Double corner2 = new RoundRectangle2D.Double(10,0,15,15,0,0);
        private RoundRectangle2D.Double corner3 = new RoundRectangle2D.Double(0,0,15,15,0,0);
        private RoundRectangle2D.Double corner4 = new RoundRectangle2D.Double(0,0,15,15,0,0);
        private Image img1 = Toolkit.getDefaultToolkit().getImage("images.jpg");
        private Image img2 = Toolkit.getDefaultToolkit().getImage("comp.jpg");
        private Image img3 = Toolkit.getDefaultToolkit().getImage("addu.jpg");
	public int[] lives = new int[4];
	private int myint;
 	private RoundRectangle2D.Double batd;
        private RoundRectangle2D.Double batd2;
        private RoundRectangle2D.Double batd3;
	
 	private double speed = 5.0;
	public double padspeed = 0;
	private double maxspeed = 5.0;
        private double mymaxspeed= 5.0;
	private double exp1;
	private double exp2;
	private double exp3;
	private double exp4;
	private int counte[];
	//private double padaccerelation = 1.0;   // ************************************************
	
        private double xDirectionBall = 0.6;
	private double yDirectionBall = 0.4;
        private double xDirectionBall2 = 0.0;
	private double yDirectionBall2 = 0.0;
        private double xDirectionBall3 = 0.0;
	private double yDirectionBall3 = 0.0;
 	private boolean checkIntersection = true;
	private boolean checkIntersection2 = true;
	private boolean checkIntersection3 = true;
	private boolean checkIntersection4 = true;
        private boolean checkIntersection5 = true;
	private boolean checkIntersection6 = true;
	private boolean checkIntersection7 = true;
	private boolean checkIntersection8 = true;
	private boolean checkposx = true;
	private boolean checkposy1 = true;
	private boolean checkposy2 = true;
	private boolean needRandom = true;
        private boolean b1 = true;
	private boolean b2 = true;
	private boolean b3 = true;
	private boolean b4 = true;
    private double lastx=0;
    private String message;
    private String bit = "0";
    private String receiveMsg;
    private String[] s;
    private double d;
    private boolean source = false;
    private int counter=0;
    private double scaling1;
    private double scaling2;
    private double slope1;
    private double slope2;
    private int won = 4;
    private int wonx = 10;
    private boolean lifeLost = false;
    private int counterblink;
    private boolean[] deads = new boolean[4];
    private boolean blink = false;
    private double v1, v2, v3;
    private boolean[] bdead = new boolean[4];
    public boolean power1 = false;
        public int pcounter1 = 0;
        private boolean check= false;
        public boolean power2 = false;
        public int pcounter2 = 0;
        private boolean check2= false;
        public boolean power3 = false;
        public int pcounter3 = 0;
        private boolean check3= false;
    public int gametypex;
  	public String difficulty0x;
  	public String difficulty;
  	public String difficulty1x;
        public String numofball;
  	public String whattodox = "";
  	public String ipx = "";
  	public String npx = "";
  	 
        
        
   // private Timer timer;
    //timer = new Timer(20, this);
        
 	private BufferedImage buffer;
 	Server server;
 	Client client;
 	public Runnable net;
        public Runnable chat;
 	
		
 	public void startS()
    {
        
            System.out.println(gametypex+" "+whattodox);
 		if(gametypex == 1){
 			if(whattodox.equals("connect")){
                            
                                System.out.println(ipx);
 				client.host(ipx, 4002);
 				difficulty = client.rdif();
                                numofball = client.getn();
                                if(numofball.equals("2"))
                                    
                                    
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                }
                if(numofball.equals("3"))
                    
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                    xDirectionBall3 = 0.6;
	            yDirectionBall3 = 0.6;
                }
                                if(difficulty.equals("easy")){					
 	    			speed=4.0;
                                maxspeed=3.0;
                                mymaxspeed=5.0;        
 	    		}
 	    		else if(difficulty.equals("medium")){
 	    			speed=6.0;
                                maxspeed=5.0;
                                mymaxspeed=5.0; 
 	    		}
 	    		else{
 	    			speed=8.0;
                                maxspeed=8.0;
                                mymaxspeed=8.0;
 	    		}
 	 	 		myint=client.getC();
 	 	    	new Thread(net).start();
 		        new Thread(chat).start();
 				
 				
 			}
 			else{
                            source = true;
                                System.out.println(npx);
 				server.host(4002,Integer.parseInt(npx)-1,difficulty1x,numofball);
 				myint=0;
 				new Thread(net).start();
                                new Thread(chat).start();
 			}
 			
 		}
 		else
                {
 			
 		}
                
                
    }
 	public Game( int a, String b, String c, String d, String e, String f,String g) {
            
            
            
            for(int i=0;i<4;i++){
               bdead[i] = false;
            }
 		
 		
            for(int i=0;i<4;i++){
 			deads[i] = false;
 		}
 		gametypex = a;
 		difficulty0x = b;
 		difficulty1x = c;
 		whattodox = d;
 		ipx = e;
 		npx = f;
                if((gametypex == 0) ||((gametypex == 1) &&(whattodox.equals("host"))))
                        {
 		numofball = g;
                        }
                
 		
 		
 		counte=new int[4];
 		counte[0]=0;
 		counte[1]=0;
 		counte[2]=0;
 		counte[3]=0;
 		
 		
 		
 		System.out.println("YoYoYo");
 		
 		
 		
 		setFocusable(true);
 		addKeyListener(this);
 		if(gametypex == 1){				// MultiPlayer
 			
 			if(whattodox.equals("connect")){
 				
 				client=new Client(0);
 	            net=new Runnable()
 		        {
 		           public void run()
 		           {
 		              client.inpt();
 		 		   }
 		        };
                    chat=new Runnable()
 		        {
 		           public void run()
 		           {
 		              client.chatinpt();
 		 		   }
 		        };
 				
 				
 				
 				
 				
 			}
 			else{			// host
 				
 				if(difficulty1x.equals("easy")){					
 	    			speed=4.0;
                                maxspeed=3.0;
                                mymaxspeed=5.0; 
 	    		}
 	    		else if(difficulty1x.equals("medium")){
 	    			speed=6.0;
                                maxspeed=5.0;
                                mymaxspeed=5.0; 
 	    		}
 	    		else{
 	    			speed=8.0;
                                maxspeed=8.0;
                                mymaxspeed=8.0; 
 	    		}
 				
 				server =new Server(0);
 	            net=new Runnable()
 		        {
 		           public void run()
 		           {
 		              server.inpt();
 		 		   }
 		        };
                    chat=new Runnable()
 		        {
 		           public void run()
 		           {
 		              server.chatinpt();
 		 		   }
 		        };
 		        
                        if(numofball.equals("2"))
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                }
                if(numofball.equals("3"))
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                    xDirectionBall3 = 0.6;
	            yDirectionBall3 = 0.6;
                }
 			}
 			
 		}
                
                
 		else{
 			
 			if(difficulty0x.equals("easy")){					// Single Player
    			speed=4.0;
                        maxspeed=3.0;
                        mymaxspeed=5.0; 
    		}
    		else if(difficulty0x.equals("medium")){
    			speed=6.0;
                                maxspeed=5.0;
                                mymaxspeed=5.0; 
    		}
    		else{
    			speed=8.0;
                        maxspeed=8.0;
                        mymaxspeed=8.0; 
    		}
                if(numofball.equals("2"))
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                }
                if(numofball.equals("3"))
                {
                    xDirectionBall2 = 0.8;
	            yDirectionBall2 = 0.8;
                    xDirectionBall3 = 0.6;
	            yDirectionBall3 = 0.6;
                }
 			
 		}
 		
 		
        
 		for(int i=0;i<4;i++){
 			lives[i] = 6;
 		}
 		addComponentListener(new ComponentAdapter(){
 			@Override
 			public void componentResized(ComponentEvent e) {
 				buffer = null;
 			}
 		});
// 		
 	}
 	
 	
 	
		
 
 	
 	protected void paintComponent(Graphics g) {
 		
 		if(buffer == null){
 			buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
 		}
 		
 		Graphics2D g2 = (Graphics2D) buffer.getGraphics();
 		
 		g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
 		
                if(pcounter2<1000)
                {
                    
                    pcounter2++;
                   
                }
                else
                {
                    check2 = true;
                    power2 = true;
                    pcounter2=-2000;
                }
                if(pcounter3<200)
                {
                    
                    pcounter3++;
                   
                }
                else
                {
                    check3 = true;
                    power3 = true;
                    pcounter3=-2000;
                }
                
                if(pcounter1<2000)
                {
                    
                    pcounter1++;
                   System.out.println(pcounter1);
                }
                else
                {
                    check = true;
                    power1 = true;
                    pcounter1=-1000;
                }
                System.out.println(power1);
 		if(blink){
 			g2.setColor(Color.white);
 	 		g2.fillRect(0,0,getWidth(), getHeight());
 	 		blink = false;
 		}
 		else{
 			g2.setColor(Color.black);
 	 		g2.fillRect(0,0,getWidth(), getHeight());
 		}
 		if(gametypex==0)
                {
                if(power1 == true)
                {
                    
                    g2.drawImage(img1, 300,300, this);
                    g2.finalize();
                    
                }
                
                if(power2 == true)
                {
                    
                    g2.drawImage(img2, 200,200, this);
                    g2.finalize();
                    
                }
                if(power3 == true)
                {
                    
                    g2.drawImage(img3, 350,350, this);
                    g2.finalize();
                    
                }
                
                if((check == true) && (power1 == false))
                {
                   if(batd == bat)
                   {
                       bat.setRoundRect(bat.x, bat.y, 200, 15, 9, 9);
                   }
                   if(batd == cbat)
                   {
                       cbat.setRoundRect(cbat.x,cbat.y, 200, 15, 9, 9);
                   }
                   if(batd == cbat_left)
                   {
                       cbat_left.setRoundRect(cbat_left.x, cbat_left.y, 15, 200, 9, 9);
                   }if(batd == cbat_right)
                   {
                       cbat_right.setRoundRect(cbat_right.x, cbat_right.y, 15, 200, 9, 9);
                   }
                   
                }
                else
                {
                    if(batd == bat)
                   {
                       bat.setRoundRect(bat.x, bat.y, 100, 15, 9, 9);
                   }
                   if(batd == cbat)
                   {
                       cbat.setRoundRect(cbat.x,cbat.y, 100, 15, 9, 9);
                   }
                   if(batd == cbat_left)
                   {
                       cbat_left.setRoundRect(cbat_left.x, cbat_left.y, 15, 100, 9, 9);
                   }if(batd == cbat_right)
                   {
                       cbat_right.setRoundRect(cbat_right.x, cbat_right.y, 15, 100, 9, 9);
                   }
                }
                
                if((check3 == true) && (power3 == false))
                {if(source||gametypex == 0)
                {
                   if(batd3 == bat)
                   {
                       lives[0]+=1;
                       check3 = false;
                   }
                   if(batd3 == cbat)
                   {
                       lives[1]+=1;
                       check3= false;
                   }
                   if(batd3 == cbat_left)
                   {
                       lives[3]+=1;
                       check3= false;
                   }if(batd3 == cbat_right)
                   {
                       lives[2]+=1;
                       check3= false;
                   }
                }
                }
                
                if((check2 == true) && (power2 == false))
                {
                   if(batd2 == bat)
                   {
                       bat.setRoundRect(bat.x, bat.y, 50, 15, 9, 9);
                   }
                   if(batd2 == cbat)
                   {
                       cbat.setRoundRect(cbat.x,cbat.y, 50, 15, 9, 9);
                   }
                   if(batd2 == cbat_left)
                   {
                       cbat_left.setRoundRect(cbat_left.x, cbat_left.y, 15, 50, 9, 9);
                   }if(batd2 == cbat_right)
                   {
                       cbat_right.setRoundRect(cbat_right.x, cbat_right.y, 15, 50, 9, 9);
                   }
                   
                }
                else
                {
                    if(batd2 == bat)
                   {
                       bat.setRoundRect(bat.x, bat.y, 100, 15, 9, 9);
                   }
                   if(batd2 == cbat)
                   {
                       cbat.setRoundRect(cbat.x,cbat.y, 100, 15, 9, 9);
                   }
                   if(batd2 == cbat_left)
                   {
                       cbat_left.setRoundRect(cbat_left.x, cbat_left.y, 15, 100, 9, 9);
                   }if(batd2 == cbat_right)
                   {
                       cbat_right.setRoundRect(cbat_right.x, cbat_right.y, 15, 100, 9, 9);
                   }
                }}
 		g2.setColor(Color.red);
 		g2.fill(ball);
 		if(numofball.equals("2"))
                        {
                            g2.setColor(Color.red);
 		            g2.fill(ball2);
                        }
                
                if(numofball.equals("3"))
                        {
                            g2.setColor(Color.red);
 		            g2.fill(ball2);
                            g2.setColor(Color.red);
 		            g2.fill(ball3);
                        }
 		if(!deads[0]){
 			g2.setColor(Color.blue);
 	 		g2.fill(bat);
 		}
 		
 		
 		if(!deads[1]){
 			g2.setColor(Color.ORANGE);
 			g2.fill(cbat);
 		}
        
 		if(!deads[3]){
 			g2.setColor(Color.GREEN);
 	        g2.fill(cbat_left);
 		}
        
 		if(!deads[2]){
 			g2.setColor(Color.PINK);
 	        g2.fill(cbat_right);
 		}
        
                g2.setColor(Color.GRAY);
        g2.fill(corner1);
        
        g2.setColor(Color.GRAY);
        g2.fill(corner2);
        
        g2.setColor(Color.GRAY);
        g2.fill(corner3);
        
        g2.setColor(Color.GRAY);
        g2.fill(corner4);
        
 		g.drawImage(buffer, 0, 0, null);	
 		
 	}
 	
 	
 	
 	
    public Double approach(Double incept, Double pos, Double time)
        {
            Double d;
            if(time<10)
                    d=(incept-pos)/2;
            else
                d=(incept-pos);
                    if(Math.abs(d)>maxspeed)
                { if(d<0)
                    d = -1*maxspeed;
                else
                    d=maxspeed;
                }return d;
        }
        public Double compu(int i)
        {
            if(i==2)
            {
                Double incept1[]=simulate(2,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(2,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                if(incept1[1]<incept2[1])
                {
                    return approach(incept1[0],cbat.x+cbat.getWidth()/2,incept1[1]);
                }
                else
                {
                    return approach(incept2[0],cbat.x+cbat.getWidth()/2,incept2[1]);
                }
        }
            else
            {
                Double incept1[]=simulate(2,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(2,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                Double incept3[]=simulate(2,ball3.x,ball3.y,xDirectionBall3,yDirectionBall3);
                if(incept1[1]<incept2[1]&&incept1[1]<incept3[1])
                {
                    return approach(incept1[0],cbat.x+cbat.getWidth()/2,incept1[1]);
                }
                else if(incept2[1]<incept1[1]&&incept2[1]<incept3[1])
                {
                    return approach(incept2[0],cbat.x+cbat.getWidth()/2,incept2[1]);                
                }
                else
                {
                    return approach(incept3[0],cbat.x+cbat.getWidth()/2,incept3[1]);
                }
            }
        }
        public Double compu_down(int i)
        {
            if(i==2)
            {
                Double incept1[]=simulate(1,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(1,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                if(incept1[1]<incept2[1])
                {
                    return approach(incept1[0],bat.x+bat.getWidth()/2,incept1[1]);
                }
                else
                {
                    return approach(incept2[0],bat.x+bat.getWidth()/2,incept2[1]);
                }
        }
            else
            {
                Double incept1[]=simulate(1,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(1,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                Double incept3[]=simulate(1,ball3.x,ball3.y,xDirectionBall3,yDirectionBall3);
                if(incept1[1]<incept2[1]&&incept1[1]<incept3[1])
                {
                    return approach(incept1[0],bat.x+bat.getWidth()/2,incept1[1]);
                }
                else if(incept2[1]<incept1[1]&&incept2[1]<incept3[1])
                {
                    return approach(incept2[0],bat.x+bat.getWidth()/2,incept2[1]);                
                }
                else
                {
                    return approach(incept3[0],bat.x+bat.getWidth()/2,incept3[1]);
                }
            }
        }
        public Double compu_right(int i)
        {
            if(i==2)
            {
                Double incept1[]=simulate(3,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(3,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                if(incept1[1]<incept2[1])
                {
                    return approach(incept1[0],cbat_right.y+cbat_right.getHeight()/2,incept1[1]);
                }
                else
                {
                    return approach(incept2[0],cbat_right.y+cbat_right.getHeight()/2,incept2[1]);
                }
        }
            else
            {
                Double incept1[]=simulate(3,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(3,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                Double incept3[]=simulate(3,ball3.x,ball3.y,xDirectionBall3,yDirectionBall3);
                if(incept1[1]<incept2[1]&&incept1[1]<incept3[1])
                {
                    return approach(incept1[0],cbat_right.y+cbat_right.getHeight()/2,incept1[1]);
                }
                else if(incept2[1]<incept1[1]&&incept2[1]<incept3[1])
                {
                    return approach(incept2[0],cbat_right.y+cbat_right.getHeight()/2,incept2[1]);                
                }
                else
                {
                    return approach(incept3[0],cbat_right.y+cbat_right.getHeight()/2,incept3[1]);
                }
            }
        }
        public Double compu_left(int i)
        {
            if(i==2)
            {
                Double incept1[]=simulate(4,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(4,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                if(incept1[1]<incept2[1])
                {
                    return approach(incept1[0],cbat_left.y+cbat_left.getHeight()/2,incept1[1]);
                }
                else
                {
                    return approach(incept2[0],cbat_left.y+cbat_left.getHeight()/2,incept2[1]);
                }
        }
            else
            {
                Double incept1[]=simulate(4,ball.x,ball.y,xDirectionBall,yDirectionBall);
                Double incept2[]=simulate(4,ball2.x,ball2.y,xDirectionBall2,yDirectionBall2);
                Double incept3[]=simulate(4,ball3.x,ball3.y,xDirectionBall3,yDirectionBall3);
                if(incept1[1]<incept2[1]&&incept1[1]<incept3[1])
                {
                    return approach(incept1[0],cbat_left.y+cbat_left.getHeight()/2,incept1[1]);
                }
                else if(incept2[1]<incept1[1]&&incept2[1]<incept3[1])
                {
                    return approach(incept2[0],cbat_left.y+cbat_left.getHeight()/2,incept2[1]);                
                }
                else
                {
                    return approach(incept3[0],cbat_left.y+cbat_left.getHeight()/2,incept3[1]);
                }
            }
        }
 	public Double[] simulate(int i, Double x, Double y, Double dx, Double dy)
        {
            Double count=0.0;
                while(count<20000)
                {
                    count++;
                    x+=dx;
                    y+=dy;
                    if(x<0)
                    {x=0.0;dx*=-1;if(i==4)return new Double[]{y,count};}
                    if(x>getWidth())
                    {dx*=-1;if(i==3)return new Double[]{y,count};}
                    if(y<0)
                    {y=0.0;dy*=-1;if(i==2)return new Double[]{x,count};}
                    if(y>getHeight())
                    {dy*=-1;if(i==1)return new Double[]{x,count};}
                }
            return (new Double[]{0.0,0.0});
        }
        
    public Double compu()
    {
        Double slope;
        slope = (yDirectionBall/xDirectionBall);
        Double x_incept = ball.x+(-1)*ball.y/slope;
        //System.out.println(cbat.x+"-----"+incept);
        if(ball.y<30){
      
        }
        
        if(x_incept>=0 && x_incept<=getWidth() && yDirectionBall<0){
        	
        	double far = Math.abs(x_incept - cbat.x); 
        	double far1 = far/getWidth();
        	double netspeed = xDirectionBall*xDirectionBall + yDirectionBall*yDirectionBall;
        	double time = ball.y/(yDirectionBall*speed);
        	double r = Math.random();  // Generates a random floating no. bw 0.0 and 1.0
        	double R = 1.0;
        	double deviatex = 0;
        	if(needRandom){
        		R = r;
        		needRandom = false;
        	}
        	//if(Math.abs(ball.y)<100 && Math.abs(ball.y) > 70)
        		//deviatex = deviate(far, netspeed, time);
      
            if(Math.abs(ball.y)<100){
            	exp2 = x_incept-cbat.getBounds().width/2 - cbat.x;
            	if(Math.abs(exp2)>maxspeed)
                { if(exp2<0)
                    exp2 = -1*maxspeed;
                else
                    exp2=maxspeed;
                }return exp2;
            }      
            else{
            	
            	exp1 = (x_incept-(cbat.x+cbat.getBounds().width/2))*0.06;
            	if(Math.abs(exp1)>maxspeed)
                { if(exp1<0)
                    exp1 = -1*maxspeed;
                else
                    exp1=maxspeed;
                }return exp1;
            }     
        }else{   	
        	exp3 = (ball.x-(cbat.x+cbat.getBounds().width/2))*0.01;
        	if(Math.abs(exp3)>maxspeed)
                { if(exp3<0)
                    exp3 = -1*maxspeed;
                else
                    exp3=maxspeed;
                }return exp3  ;
        }
            
    }
    
     
    public Double compu_left()
    {
        Double slope;
        slope = (yDirectionBall/xDirectionBall);
        Double y_incept = ball.y+(-1)*ball.x*slope;
        
        if(y_incept>=0 && Math.abs(y_incept)<=getHeight() && xDirectionBall<0)
            if(ball.x<100){
            	exp1 = (y_incept-cbat_left.getBounds().height/2) - cbat_left.y;
            	if(Math.abs(exp1)>maxspeed)
                { if(exp1<0)
                    exp1 = -1*maxspeed;
                else
                    exp1=maxspeed;
                }
            	return exp1;
            }
                 
            else{
            	exp2 = (y_incept-(cbat_left.y+cbat_left.getBounds().height/2))*0.1;
            	if(Math.abs(exp2)>maxspeed)
                { if(exp2<0)
                    exp2 = -1*maxspeed;
                else
                    exp2=maxspeed;
                }
            	return exp2;
            }
                 
        else{
        	exp3 = (ball.y-(cbat_left.y+cbat_left.getBounds().height/2))*0.02;
        	if(Math.abs(exp3)>maxspeed)
                { if(exp3<0)
                    exp3 = -1*maxspeed;
                else
                    exp3=maxspeed;
                }
            return exp3;
        }    
            
    }
    
    public Double compu_right()
    {
        Double slope;
        slope = (yDirectionBall/xDirectionBall);
        Double y_incept = ball.y+(getWidth() + (-1)*ball.x)*slope;
        
        if(y_incept>=0 && Math.abs(y_incept)<=getHeight() && xDirectionBall>0)
            if(getWidth()-ball.x<30){
            	exp1 = y_incept-cbat_right.getBounds().height/2 - cbat_right.y;
            	if(Math.abs(exp1)>maxspeed)
                { if(exp1<0)
                    exp1 = -1*maxspeed;
                else
                    exp1=maxspeed;
                }return exp1;
            }
                 
            else{
            	exp2 = (y_incept-(cbat_right.y+cbat_right.getBounds().height/2))*0.1;
            	if(Math.abs(exp2)>maxspeed)
                { if(exp2<0)
                    exp2 = -1*maxspeed;
                else
                    exp2=maxspeed;
                }return exp2;
            }
                 
        else{
        	exp3 = (ball.y-(cbat_right.y+cbat_right.getBounds().height/2))*0.009;
        	if(Math.abs(exp3)>maxspeed)
                { if(exp3<0)
                    exp3 = -1*maxspeed;
                else
                    exp3=maxspeed;
                } return exp3;
        	
        }
           
    }
    
    
    public Double compu_down()
    {
        Double slope;
        slope = (yDirectionBall/xDirectionBall);
        Double x_incept = ball.x+(getHeight()+(-1)*ball.y)/slope;
        //System.out.println(cbat.x+"-----"+incept);
        if(ball.y<30){
      
        }
        
        if(x_incept>=0 && x_incept<=getWidth() && yDirectionBall>0){
        	
        	double far = Math.abs(x_incept - cbat.x); 
        	double far1 = far/getWidth();
        	double netspeed = xDirectionBall*xDirectionBall + yDirectionBall*yDirectionBall;
        	double time = ball.y/(yDirectionBall*speed);
        	double r = Math.random();  // Generates a random floating no. bw 0.0 and 1.0
        	double R = 1.0;
        	double deviatex = 0;
        	if(needRandom){
        		R = r;
        		needRandom = false;
        	}
        	//if(Math.abs(ball.y)<100 && Math.abs(ball.y) > 70)
        		//deviatex = deviate(far, netspeed, time);
      
            if(Math.abs(getHeight() - ball.y)<100){
            	exp2 = x_incept-bat.getBounds().width/2 - bat.x;
            	if(Math.abs(exp2)>maxspeed)
                { if(exp2<0)
                    exp2 = -1*maxspeed;
                else
                    exp2=maxspeed;
                }return exp2;
            }      
            else{
            	
            	exp1 = (x_incept-(bat.x+bat.getBounds().width/2))*0.06;
            	if(Math.abs(exp1)>maxspeed)
                { if(exp1<0)
                    exp1 = -1*maxspeed;
                else
                    exp1=maxspeed;
                }return exp1;
            }     
        }else{   	
        	exp3 = (ball.x-(bat.x+bat.getBounds().width/2))*0.01;
        	if(Math.abs(exp3)>maxspeed)
                { if(exp3<0)
                    exp3 = -1*maxspeed;
                else
                    exp3=maxspeed;
                }return exp3  ;
        }
            
    }
    
    
    
    
    
    
 		///////////////////////////////// 		///////////////////////////////// 		///////////////////////////////// 		/////////////////////////////////
 	public void update(){
 		
            slope1 = getHeight()/getWidth();
 		slope2 = -slope1;
 		
        corner1.x = 0;
        corner1.y = 0;
        
        corner2.x = getWidth() - 15;
        corner2.y = 0;
        
        corner3.x = 0;
        corner3.y = getHeight() - 15;
        
        corner4.x = getWidth() - 15;
        corner4.y = getHeight() - 15;
            
        if(!deads[0]){
 				bat.y = getHeight() - 15;
 			}
 			if(!deads[1]){
 				cbat.y = 0;
 			}
 			if(!deads[2]){
 				cbat_right.x = getWidth() - cbat_right.getBounds().width;
 			}
 			if(!deads[3]){
 				cbat_left.x = 0;
 			}
 		if(gametypex == 0){					// SinglePlayer
 			bat.x += padspeed;
 			
 			if(numofball.equals("1"))
                        {
 			cbat.x += compu();}
                        else
                        {
                          cbat.x += compu(Integer.parseInt(numofball));  
                        }
                        if(numofball.equals("1"))
                        {
 			cbat_left.y += compu_left();}
                        else
                        {
                          cbat_left.y += compu_left(Integer.parseInt(numofball));  
                        }
 			if(numofball.equals("1"))
                        {
 			cbat_right.y += compu_right();}
                        else
                        {
                          cbat_right.y += compu_right(Integer.parseInt(numofball));  
                        }
 			
 			
 			ball.x += xDirectionBall*speed;
 			ball.y += yDirectionBall*speed;
                        ball2.x += xDirectionBall2*speed;
 			ball2.y += yDirectionBall2*speed;
                        ball3.x += xDirectionBall3*speed;
 			ball3.y += yDirectionBall3*speed;
 			
 		}
 		else{							// MultiPlayer
 			
 			if(whattodox.equals("connect")){	// I am a host
 				receiveMsg = client.receiveD();
 				}
 			else
 			{
 				receiveMsg = server.receiveD();
 			}
 			
 			if(myint==2)
 	        	cbat_right.y += padspeed;
 	               if(myint==1)
	        	cbat.x += padspeed;
 	      if(myint==0)
	        	bat.x += padspeed;
              else if(myint==3)
 	        	cbat_left.y+=padspeed;
 	 		
 			
 			System.out.println("-->"+receiveMsg);
 	                
 	                if(receiveMsg == null){
 	                    
 	                    
 	                    System.out.println("null received");
 	                }
 	                else{
 	                    s = receiveMsg.split(" ");		
 			
 	                    
 	                    if(s[1].equals("0")&&counte[0]<150)        
 	            			{bat.x = Double.parseDouble(s[2]);
 	                    	System.out.println(bat.x);}
 	                    	
 	                    
 	                    else if(s[1].equals("1")&&counte[1]<150)
 	                       	{cbat.x = Double.parseDouble(s[2]);}
 	                    
 	                    else if(s[1].equals("2")&&counte[2]<150)	
 	                      	{cbat_right.y = Double.parseDouble(s[2]);}
 	                    else if(s[1].equals("3")&&counte[3]<150)	
 	                      	{cbat_left.y = Double.parseDouble(s[2]);
 	                    	
 	                    	//System.out.println( Double.parseDouble(s[2]));
 	                    	}
 	                    
 	                    
 	                    if(source){
 	                    	ball.x += xDirectionBall*speed;
 	            			ball.y += yDirectionBall*speed;
                                        ball2.x += xDirectionBall2*speed;
 	            			ball2.y += yDirectionBall2*speed;
                                        ball3.x += xDirectionBall3*speed;
 	            			ball3.y += yDirectionBall3*speed;
 	                    }
 	                    else{
 	                    
 	             			if(s[0].equals("1")){
 	             				
 	             				ball.x = Double.parseDouble(s[3]);
 	                 			ball.y = Double.parseDouble(s[4]);
 	                 			xDirectionBall = Double.parseDouble(s[5]);
 	                 			yDirectionBall = Double.parseDouble(s[6]);
                                                if(Integer.parseInt(numofball)==2||Integer.parseInt(numofball)==3)
                                                {
                                                ball2.x = Double.parseDouble(s[11]);
 	                 			ball2.y = Double.parseDouble(s[12]);
 	                 			xDirectionBall2 = Double.parseDouble(s[13]);
 	                 			yDirectionBall2 = Double.parseDouble(s[14]);
                                                if(Integer.parseInt(numofball)==3)
                                                {
                                                ball3.x = Double.parseDouble(s[15]);
 	                 			ball3.y = Double.parseDouble(s[16]);
 	                 			xDirectionBall3 = Double.parseDouble(s[17]);
 	                 			yDirectionBall3 = Double.parseDouble(s[18]);
                                                }
                                                }
 	             			}
 	                    }	
 	         
 	             			if(counte[0]>50&&myint!=0)
  	                           bat.x+=compu_down();
 	             			if(counte[1]>50&&myint!=1)
 	                           cbat.x+=compu();
 	                       if(counte[2]>50&&myint!=2)
 	                           cbat_right.y+=compu_right();
 	                      if(counte[3]>50&&myint!=3)
 	                    	 cbat_left.y+=compu_left();
 	                      for(int i=0;i<4;i++)
 	                     {
 	                         if(!s[1].equals(Integer.toString(i)))
 	                         {if(myint!=i&&counte[i]<100)
 	                             counte[i]++;
 	                         }else
 	                        	 counte[i]=0;
 	                     }

 	                
 	                int f=1;
 	                for(int i=0;i<myint;i++)
 	                {
 	                    if(s[1].equals(Integer.toString(i)))
 	                        f=0;
 	                }
 	                if(f==1)
 	                    counter++;
 	                else counter=0;
 	                if(counter>150)
 	                    source=true;
 	                }
 	                String bal2=Double.toString(ball2.x) + " " + Double.toString(ball2.y) + " " + Double.toString(xDirectionBall2)  + " " +
                                        Double.toString(yDirectionBall2)+" ";
                        String bal3=Double.toString(ball3.x) + " " + Double.toString(ball3.y) + " " + 
                                                Double.toString(xDirectionBall3)  + " " + Double.toString(yDirectionBall3)+" ";
 	                if(Integer.parseInt(numofball)==1)
                        {
                            bal2=" ";
                            bal3=" ";
                        }
                        else if(Integer.parseInt(numofball)==2)
                        {
                            bal3=" ";
                        }
 	                
 String help = " " + Double.toString(ball.x) 
                                        + " " + Double.toString(ball.y) + " " + Double.toString(xDirectionBall)  + " " + Double.toString(yDirectionBall)+
                                        " " + String.valueOf(lives[0]) + " "+String.valueOf(lives[1]) 
                           +" "+String.valueOf(lives[2])+" "+String.valueOf(lives[3])+" "+bal2+bal3;	                
 if(source){
 	           if(myint==2)
 	                	message = "1" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat_right.y) +help;
 	           else if(myint==1)
 	           message = "1" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat.x) + 
                           help;
 	          else if(myint==0)
 	 	           message = "1" + " "+ Integer.toString(myint)+" "+ Double.toString(bat.x) +
                                  help;
 	         else if(myint==3)
 	 	           message = "1" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat_left.y) +
                                   help;
 	                }
 	                else{
 	           if(myint==2)
 	                	message = "0" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat_right.y) +
                                       help;
 	           else if(myint==1)
 	           message = "0" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat.x) +
                           help;
 	          else if(myint==0)
	 	           message = "0" + " "+ Integer.toString(myint)+" "+ Double.toString(bat.x) + 
                                  help;
	         else if(myint==3)
	 	           message = "0" + " "+ Integer.toString(myint)+" "+ Double.toString(cbat_left.y) + 
                                   help;               
                   
 	                }
 System.out.println("--->>"+message);
 if(whattodox.equals("connect")){	// I am a host
 	            	  client.sendMessage(message);
 	   				}
 	   			else
 	   			{
 	   				server.sendMessage(message);
 	   			}          
 		}
 			
 	        
 	                
 	     			
		
		//cbat.x+=compu();
		
//		cbat_left.x = 0;
//		cbat_left.y += compu_left();
//		
//		
//		cbat_right.x = getWidth() - cbat_right.getBounds().width; 
//		//cbat_right.y += compu_right();
		
                Double[] Ball=new Double[]{xDirectionBall};
                Double[] Ball1=new Double[]{yDirectionBall};
		Double[] Ball2;
                Double[] Ball3;
                Double[] Ball4;
                Double[] Ball5;
                if(Integer.parseInt(numofball)==2||Integer.parseInt(numofball)==3)
                {
                    Ball2=new Double[]{xDirectionBall2};
                        Ball3=new Double[]{yDirectionBall2};
                        ballupd(ball2,Ball2,Ball3);
                        xDirectionBall2=Ball2[0];
                yDirectionBall2=Ball3[0];
                
                    if(Integer.parseInt(numofball)==3)
                    {
                        Ball4=new Double[]{xDirectionBall3};
                        Ball5=new Double[]{yDirectionBall3};
                        ballupd(ball3,Ball4,Ball5);
                        xDirectionBall3=Ball4[0];
                yDirectionBall3=Ball5[0];
                
                    }
                }        
		ballupd(ball,Ball,Ball1);
                xDirectionBall=Ball[0];
                yDirectionBall=Ball1[0];
                
 		
 		
 		if(bat.x<15){
 			bat.x = 15;
 		}else if(bat.x > getWidth() - bat.getBounds().width - 15){
 			bat.x = getWidth() - bat.getBounds().width -15;
 		}
 		
 		if(cbat.x<15){
 			cbat.x = 15;
 		}else if(cbat.x > getWidth() - cbat.getBounds().width -15){
 			cbat.x = getWidth() - cbat.getBounds().width - 15;
 		}
 		
 		if(cbat_left.y<15){
 			cbat_left.y = 15;
 		}else if(cbat_left.y > getHeight() - cbat_left.getBounds().height - 15){
 			cbat_left.y = getHeight() - cbat_left.getBounds().height - 15;
 		}
 		
 		if(cbat_right.y<15){
 			cbat_right.y = 15;
 		}else if(cbat_right.y > getHeight() - cbat_right.getBounds().height - 15){
 			cbat_right.y = getHeight() - cbat_right.getBounds().height - 15;
 		}
 		
 		
 		
 		
 		
 		
 		
 		
		
 		repaint();
 		
 	}
        
        public void ballupd(Ellipse2D.Double ballc,Double[] xDirection,Double[] yDirection )
        {  
            if((power1 == true)&&(ballc.getCenterX()>300)&&(ballc.getCenterX()<330)&&(ballc.getCenterY()>300)&&(ballc.getCenterY()<330))
            {
                power1 = false;
            }
            
            if(ballc.intersects(cbat.getBounds2D())){
 			if(checkIntersection){
                            if(power1 == true) {batd = cbat;}
                            if(power2 == true) {batd2 = cbat;}
                            if(power3 == true) {batd3 = cbat;}}}
            if((power3 == true)&&(ballc.getCenterX()>350)&&(ballc.getCenterX()<380)&&(ballc.getCenterY()>350)&&(ballc.getCenterY()<380))
            {
                power3 = false;
            }
            
            if(ballc.intersects(bat.getBounds2D())){
			if(checkIntersection2){
				if(power1 == true) {batd = bat;}
                                if(power2 == true) {batd2 = bat;}
                                if(power3 == true) {batd3 = bat;}}
            
            }
            if((power2 == true)&&(ballc.getCenterX()>200)&&(ballc.getCenterX()<230)&&(ballc.getCenterY()>200)&&(ballc.getCenterY()<230))
            {
                power2 = false;
            }
            if(ballc.intersects(cbat_left.getBounds2D())){
			if(checkIntersection2){
				if(power1 == true) {batd = cbat_left;}
                                if(power2 == true) {batd2 = cbat_left;}
                                if(power3 == true) {batd3 = cbat_left;}}}
            if(ballc.intersects(cbat_right.getBounds2D())){
			if(checkIntersection4){
                            if(power1 == true) {batd = cbat_right;}
                            if(power2 == true) {batd2 = cbat_right;}
                            if(power3 == true) {batd3 = cbat_right;}}}
            if(source||(gametypex == 0))
        {   
            
            if(ballc.x < 0 ){
               xDirection[0]*= -1;
                if(ball.getCenterY() > 15 &&  ball.getCenterY() < getHeight() - 15)
                {
			
			
			if(lives[3] == 1){
				//JOptionPane.showMessageDialog(null, "OMG !! PLAYER 4 IS DEAD");
				deads[3] = true;
				wonx -= 4;
				won--;
			}
			lives[3] -= 1;
			if(lives[3]<=0){
				lives[3] = 0;
				cbat_left.x = -100;
			}
			else{
				blink = true;
			}}
			System.out.println("player 4 life lost");
 			ballc.x = 0;
 		}
 		else if(ballc.x > getWidth() - ballc.getBounds().width   ){
                    xDirection[0]*= -1;
                    if(ball.getCenterY() > 15 &&  ball.getCenterY() < getHeight() - 15){
			
			if(lives[2] == 1){
				deads[2] = true;
				//JOptionPane.showMessageDialog(null, "OMG !! PLAYER 3 IS DEAD");
				wonx -= 3;
				won--;
			}
			lives[2] -= 1;
			if(lives[2]<=0){
				lives[2] = 0;
				cbat_right.x = -100;
			}
			else{
				blink = true;
			}}
			System.out.println("player 3 life lost");
 			ballc.x = getWidth() - ballc.getBounds().width;
 		}
 		if(won == 1){					// Game Over
 			switch(wonx) {
 				case 1:
 					JOptionPane.showMessageDialog(null, "PLAYER 1 HAS WON, PARTY !!");
 					break;
 					
 				case 2:
 					JOptionPane.showMessageDialog(null, "PLAYER 2 HAS WON, PARTY !!");
 					break;
 					
 				case 3:
 					JOptionPane.showMessageDialog(null, "PLAYER 3 HAS WON, PARTY !!");
 					break;
 					
 				case 4:
 					JOptionPane.showMessageDialog(null, "PLAYER 4 HAS WON, PARTY !!");
 					break;
 					
 				default:	
 				
 			}
 			
 		}
 		
 		if(ballc.y < 0  ){
                    yDirection[0]*=-1;
                    if(ball.getCenterX() >15 && ball.getCenterX() < getWidth() - 15 ) {
			
			if(lives[1] == 1){
				deads[1] = true;
				//JOptionPane.showMessageDialog(null, "OMG !! PLAYER 2 IS DEAD");
				wonx -= 2;
				won--;
			}
			lives[1] -= 1;
			if(lives[1]<=0){
				lives[1] = 0;
				cbat.y = -100;
			}
			else{
				blink = true;
			}}
			System.out.println("player 2 life lost");
 			ballc.y = 0;
 		}
 		else if(ballc.y > getHeight() - ballc.getBounds().height ){
                    yDirection[0]*= -1;
                    if(ball.getCenterX() >15 && ball.getCenterX() < getWidth() - 15 ){
			
			if(lives[0] == 1){
				deads[0] = true;
				//JOptionPane.showMessageDialog(null, "OMG !! PLAYER 1 IS DEAD");
				won--;
				wonx -= 1;
			}
			lives[0] -= 1;
			if(lives[0]<=0){
				lives[0] = 0;
				bat.y = -100;
			}
			else{
				blink = true;
			}}
			System.out.println("player 1 life lost");
 			ballc.y = getHeight() - ballc.getBounds().height;
 		}
 		if(won == 1){					// Game Over
 			switch(wonx) {
 				case 1:
 					JOptionPane.showMessageDialog(null, "PLAYER 1 HAS WON, PARTY !!");
 					break;
 					
 				case 2:
 					JOptionPane.showMessageDialog(null, "PLAYER 2 HAS WON, PARTY !!");
 					break;
 					
 				case 3:
 					JOptionPane.showMessageDialog(null, "PLAYER 3 HAS WON, PARTY !!");
 					break;
 					
 				case 4:
 					JOptionPane.showMessageDialog(null, "PLAYER 4 HAS WON, PARTY !!");
 					break;
 					
 				default:	
 				
 			}
 			
 		}
		
		if(ballc.intersects(corner1.getBounds2D())){
 			if(checkIntersection5){
                                if(cbat_left.y < 20 || cbat.x < 20){
                                    
                                    System.out.println(" PLEASE BHAI THEEK HOJA");
                                    v1 = 1.0;
                                    v3 = 2*v1;
                                    v2 = Math.sqrt(v1*v1 + v3*v3);
                                    xDirection[0] = v3/v2;
                                    yDirection[0] = v1/v2;
                                }
                                else{
 				
 				if(slope1*ballc.getCenterX() < ballc.getCenterY()){
 					yDirection[0] = -yDirection[0];
 					ballc.x += 3*xDirection[0]*speed;
 		 			ballc.y += 3*yDirection[0]*speed;
 				}
 				else{
 					xDirection[0] = -xDirection[0];
 					ballc.x += 3*xDirection[0]*speed;
 		 			ballc.y += 3*yDirection[0]*speed;
 				}}
 				checkIntersection5 = false;
 			}
 		}
 		else{
 			checkIntersection5 = true;
 		}
 		
 		
 		if(ballc.intersects(corner2.getBounds2D())){
 			if(checkIntersection6){
                            if(cbat_right.y < 20 || cbat.x > getWidth() -  20){
                                    
                                   
                                    v1 = 1.0;
                                    v3 = -2*v1;
                                    v2 = Math.sqrt(v1*v1 + v3*v3);
                                    xDirection[0] = v3/v2;
                                    yDirection[0] = v1/v2;
                                }else{
                            
 				if(getHeight() + slope2*ballc.getCenterX() > ballc.getCenterY()){
 					yDirection[0] = -yDirection[0];
 					ballc.x += xDirection[0]*speed;
 		 			ballc.y += yDirection[0]*speed;
 				}
 				else{
 					xDirection[0] = -xDirection[0];
 					ballc.x += xDirection[0]*speed;
 		 			ballc.y += yDirection[0]*speed;
 				}}
 				checkIntersection6 = false;
 			}
 		}
 		else{
 			checkIntersection6 = true;
 		}
 		
 		if(ballc.intersects(corner3.getBounds2D())){
 			if(checkIntersection7){
                            
                            if(cbat_left.y > getHeight() -  20 || bat.x < 20){
                                    
                                    
                                    v1 = -1.0;
                                    v3 = -2*v1;
                                    v2 = Math.sqrt(v1*v1 + v3*v3);
                                    xDirection[0] = v3/v2;
                                    yDirection[0] = v1/v2;
                                }
                            else{
 				if(getHeight() + slope2*ballc.getCenterX() < ballc.getCenterY()){
 					yDirection[0] = -yDirection[0];
 					ballc.x += xDirection[0]*speed;
 		 			ballc.y += yDirection[0]*speed;
 				}
 				else{
 					xDirection[0] = -xDirection[0];
 					ballc.x += xDirection[0]*speed;
 		 			ballc.y += yDirection[0]*speed;
 				}}
 				checkIntersection7 = false;
 			}
 		}
 		else{
 			checkIntersection7 = true;
 		}
 		
 		
 		if(ballc.intersects(corner4.getBounds2D())){
 			
 			if(checkIntersection8){
                            
                            if(cbat_right.y > getHeight() -  20 || bat.x > getWidth() - 20){
                                    
                                    
                                    v1 = -1.0;
                                    v3 = 2*v1;
                                    v2 = Math.sqrt(v1*v1 + v3*v3);
                                    xDirection[0] = v3/v2;
                                    yDirection[0] = v1/v2;
                                }
                            else{
 				if(slope1*ballc.getCenterX() > ballc.getCenterY()){
 					yDirection[0] = -yDirection[0];
 					//ballc.x += xDirection[0]*speed;
 		 			//ballc.y += yDirection[0]*speed;
 				}
 				else{
 					xDirection[0] = -xDirection[0];
 					//ballc.x += xDirection[0]*speed;
 		 			//ballc.y += yDirection[0]*speed;
 					
 				}}
 				checkIntersection8 = false;
 			}
 		}
 		else{
 			checkIntersection8 = true;
 		}
 		
 		
 	
 		
 		if(ballc.intersects(cbat.getBounds2D())){
 			if(checkIntersection){
                           
                            if(yDirection[0] <0){
 				yDirection[0] = -yDirection[0];}
 				v1 = ballc.getCenterX();
 				v2 = cbat.getCenterX();
 				v3 = Math.abs(yDirection[0])*(2*(v1 - v2))/cbat.getWidth();
 				v1 = yDirection[0];
 				v2 = Math.sqrt(v1*v1 + v3*v3);
 				xDirection[0] = v3/v2;
 				yDirection[0] = v1/v2;
                //xDirection = Math.abs(Math.abs(padspeed)-Math.abs(xDirection))*0.005*padspeed + xDirection;
 				checkIntersection = false;
 				
 			}
 		}
 		else{
 			checkIntersection = true;
 			
 		}
 		
	
        if(ballc.intersects(bat.getBounds2D())){
			if(checkIntersection2){
				
                            if(yDirection[0]>0)
                            {yDirection[0] = -yDirection[0];}
 				v1 = ballc.getCenterX();
 				v2 = bat.getCenterX();
 				v3 = Math.abs(yDirection[0])*(2*(v1 - v2))/bat.getWidth();
 				v1 = yDirection[0];
 				v2 = Math.sqrt(v1*v1 + v3*v3);
 				xDirection[0] = v3/v2;
 				yDirection[0] = v1/v2;
				
				//xDirection = Math.abs(Math.abs(padspeed)-Math.abs(xDirection))*0.005*padspeed + xDirection;
				checkIntersection2 = false;
				needRandom = true;
			}
		}
		else{
			checkIntersection2 = true;
		}
        
        if(ballc.intersects(cbat_left.getBounds2D())){
			if(checkIntersection3){
                            
                            if(xDirection[0]<0)
                            {xDirection[0] = -xDirection[0];}
				v1 = ballc.getCenterY();
 				v2 = cbat_left.getCenterY();
 				v3 = Math.abs(xDirection[0])*(2*(v1 - v2))/cbat_left.getHeight();
 				v1 = xDirection[0];
 				v2 = Math.sqrt(v1*v1 + v3*v3);
 				xDirection[0] = v1/v2;
 				yDirection[0] = v3/v2;
				
                                
                checkIntersection3 = false;
			}
		}
		else{
			checkIntersection3 = true;
		}
        
        if(ballc.intersects(cbat_right.getBounds2D())){
			if(checkIntersection4){
                            
                                if(xDirection[0]>0)
                                {xDirection[0] = -xDirection[0];}
				v1 = ballc.getCenterY();
 				v2 = cbat_right.getCenterY();
 				v3 = Math.abs(xDirection[0])*(2*(v1 - v2))/cbat_right.getHeight();
 				v1 = xDirection[0];
 				v2 = Math.sqrt(v1*v1 + v3*v3);
 				xDirection[0] = v1/v2;
 				yDirection[0] = v3/v2;
                checkIntersection4 = false;
			}
		}
		else{
			checkIntersection4 = true;
		}
        }
        else
                if(s!=null){
            for(int i=0;i<4;i++){
                lives[i] = Integer.parseInt(s[i+7]);
                if(lives[i]==0){
                    if(!bdead[i]){
                        deads[i] = true;
                        bdead[i] = true;
                        blink = true;
                        won--;
                        wonx -= (i+1);
                    }
                }
                
            }
                }
            if(won==1){
                JOptionPane.showMessageDialog(null, "PLAYER " + Integer.toString(wonx) + " HAS WON, PARTY !!");
            }
            
            
            
            
        
        }
 
 	@Override
 	public void update(Graphics g) {
 		paint(g);
 	}
 	
 	public void actionPerformed(ActionEvent e) {
		
		
	}
 	
 	@Override
 	public void keyPressed(KeyEvent e){
			
			int key = e.getKeyCode();
			System.out.println("pressed");
			switch(key){
			
			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				padspeed = mymaxspeed;
				break;
			
			case KeyEvent.VK_LEFT:
				System.out.println("left");
				padspeed = -1*mymaxspeed;
				break;
				
			default :
				System.out.println("default");
				//padspeed = 0.0;
				break;
				
			}
			
		}
	@Override	
 	public void keyReleased(KeyEvent e){
			System.out.println("realesed");
 		int key = e.getKeyCode();
		
		switch(key){
		
		case KeyEvent.VK_RIGHT:
			//System.out.println("right");
			padspeed = 0.0;
			break;
		
		case KeyEvent.VK_LEFT:
			//System.out.println("left");
			padspeed = 0.0;
			break;
			
		default :
			//System.out.println("default");
			//padspeed = 0.0;
			break;
			
		}
			
	}
        
        @Override	
 	public void keyTyped(KeyEvent e){
        }
 	
 
 }
