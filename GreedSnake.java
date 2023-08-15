import java.awt.*; 
import java.awt.event.*;

//(c) 2020 Little Xian. All rights Reserved.

/**
 * 创建于2018年7月7日
 * 初次完成于2018年7月30日
 * 最后完成于2020年1月30日
 */
public class GreedSnake
{ 
/** 
* @param args 
*/ 
public static void main(String[] args) { 
// TODO Auto-generated method stub 
new Window(); 
} 
} 
@SuppressWarnings("serial")

class NewPanel extends Panel implements KeyListener,Runnable 
{ 

Button Snk[]; 
boolean op=true; //输出
boolean t=true; //开始和结束
public static int X=0; //分数
int f[];  //食物
int Face=0; //方向
int x=0,y=0; //蛇的位置
static int fx,fy; //食物的位置
public static int v=15; //速度
Thread thread;
NewPanel() 
{ 
setLayout(null);
f=new int [100000]; 
Snk=new Button[100000]; 
thread=new Thread(this);

for(int n=0;n<100000;n++) 
{ 
f[n]=(int)(Math.random()*100);
} 
fx=(int)(f[0]*0.1)*60; 
fy=(int)(f[0]%10)*45; 
for(int m=0;m<100000;m++) 
{ 
Snk[m]=new Button(); 
} 

add(Snk[0]); 
Snk[0].setBackground(Color.black);
Snk[0].setBounds(0,0,15,15); //基本单位
Snk[0].addKeyListener(this);
setBackground(Color.gray); //可以改背景颜色
} 

public void run() 
{ 

while(t) //控制
{ 

if(Face==0)
{ 
try 
{ 
x+=v; 
Snk[0].setLocation(x, y);

if(x==fx&&y==fy)
{ 
X++;fx=(int)(f[X]*0.1)*60;fy=(int)(f[X]%10)*45;
Snk[X].setBounds(Snk[X-1].getBounds()); repaint();add(Snk[X]);
} 
Thread.sleep(100); 
} 
catch(Exception e){} 
} 
else if(Face==1)
{ 
try 
{ 
x-=v; 
Snk[0].setLocation(x, y); 
if(x==fx&&y==fy) 
{ 
X++;fx=(int)(f[X]*0.1)*60;fy=(int)(f[X]%10)*45;
Snk[X].setBounds(Snk[X-1].getBounds()); repaint(); add(Snk[X]); 
} 

Thread.sleep(100); 
} 
catch(Exception e){} 
} 
else if(Face==2)
{ 
try 
{ 
y-=v; 
Snk[0].setLocation(x, y); 
if(x==fx&&y==fy) 
{ 
X++;fx=(int)(f[X]*0.1)*60;fy=(int)(f[X]%10)*45;
Snk[X].setBounds(Snk[X-1].getBounds()); repaint(); add(Snk[X]); 
} 
Thread.sleep(100); 
} 
catch(Exception e){} 
} 
else if(Face==3)
{ 
try 
{ 

y+=v; 
Snk[0].setLocation(x, y); 
if(x==fx&&y==fy) 
{ 
X++;fx=(int)(f[X]*0.1)*60;fy=(int)(f[X]%10)*45;
Snk[X].setBounds(Snk[X-1].getBounds()); repaint(); add(Snk[X]); 
} 
Thread.sleep(100);  
} 
catch(Exception e){} 
} 
int Y=X; 
while(Y>1)  //尾巴
{ 
if(Snk[Y].getBounds().x==Snk[0].getBounds().x&&Snk[Y].getBounds().y==Snk[0].getBounds().y) 
{ 
t=false; 
op=false; 
repaint(); 
} 
Y--; 
} 
if(x<0||x>=this.getWidth()||y<0||y>=this.getHeight()) //墙
{ 
t=false; 
op=false; 
repaint(); 
} 
int Z=X; 
while(Z>0) 
{ 
Snk[Z].setBounds(Snk[Z-1].getBounds()); 
Z--; 
} 

if(X==100000)    //可以改胜利条件 
{ 
t=false; 
op=true; 
repaint(); 
} 
} 

} 
public void keyPressed(KeyEvent e) //键盘输入
{ 
if(e.getKeyCode()==KeyEvent.VK_RIGHT)
{ 
if(Face!=1)
Face=0; 

} 
else if(e.getKeyCode()==KeyEvent.VK_LEFT) 
{ if(Face!=0) 
Face=1; 

} 
else if(e.getKeyCode()==KeyEvent.VK_UP) 
{ if(Face!=3) 
Face=2; 

} 
else if(e.getKeyCode()==KeyEvent.VK_DOWN) 
{ if(Face!=2) 
Face=3; 

} 
} 

public void keyTyped(KeyEvent e) 
{ 

} 
public void keyReleased(KeyEvent e) 
{ 

} 
public void paint(Graphics g)
{ 
int x1=this.getWidth()-1; 
int y1=this.getHeight()-1; 
g.setColor(Color.white);       //可以改食物颜色
g.drawString("Your Score:"+X, 325, 50);
g.drawString("Tips:After starting,please press the Tab key to select the snake,then control the snake by direction keys.", 100, 20);
g.drawString("Jul 30,2018.", 1290, 640);
g.drawString("Jan 30,2020.", 1287, 650);
g.drawString("(c) 2020 Little Xian. All rights Reserved.", 1150, 660);
g.setColor(Color.orange);
g.fillOval(fx, fy, 15, 15);
g.drawRect(0, 0, x1, y1);
g.drawString("        +++++++++++++++++        ",1000,240);
g.drawString("    +++++++++++++++++++++    ",1000,250);
g.drawString("  +++++    +++++++++    +++++  ",1000,260);
g.drawString("++++++    +++++++++    ++++++",1000,270);
g.drawString("+++++++++++++++++++++++++",1000,280);
g.drawString("+++++++++++++++++++++++++",1000,290);
g.drawString("+++++     +++++++++++     +++++",1000,300);
g.drawString("++++++     +++++++++     ++++++",1000,310);
g.drawString("+++++++     +++++++     +++++++",1000,320);
g.drawString("  +++++++                     +++++++  ",1000,330);
g.drawString("    +++++++++++++++++++++    ",1000,340);
g.drawString("        +++++++++++++++++        ",1000,350);
g.drawString("Thanks for testing me!",1025,400);
if(t==false&&op==false) 
g.drawString("Game Over!Your score:"+X, 300, 200);
if(t==false&&op==true) 
g.drawString("You win!", 300, 200);
} 
} 
@SuppressWarnings("serial")
class Window extends Frame implements ActionListener
{ 
NewPanel my; 
Button btn; 
Button ys;
Panel panel;
int count=0;
Window() 
{ 
super("GreedSnake"+"  --By Little Xian"); 
my=new NewPanel(); 
btn=new Button("Start Game");
panel=new Panel(); 
btn.addActionListener(this);
panel.add(btn);
ys=new Button("I'm No Use");
panel.add(ys);
add(panel,BorderLayout.NORTH); 
add(my,BorderLayout.CENTER); 
setBounds(50,50,750,597); //更改面板大小
setVisible(true); 
validate(); 
addWindowListener(new WindowAdapter() 
{ 
public void windowClosing(WindowEvent e) 
{ 
System.exit(0); 
} 
}); 
} 
protected void methodys() {
	// TODO 自动生成的方法存根
	
}
public void actionPerformed(ActionEvent e) 
{ 

if(e.getSource()==btn) 
{ 
try 
{ 
my.thread.start(); 
my.validate(); 
} 
catch(Exception ee){} 
} 
} 
}

   //这是我的第一个Java实例，或许也是最后一个了。
	//2023.8.15 令人感叹XD
