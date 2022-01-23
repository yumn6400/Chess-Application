import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
enum Pieces_color{BLACK,WHITE};
enum Pieces_type{KING,QUEEN,HOOK,BISHOP,KNEIGHT,PAWN};
interface ChessPieces
{
public void setPieces_color(Pieces_color pieces_color);
public Pieces_color getPieces_color();
public void setPieces_type(Pieces_type pieces_type);
public Pieces_type getPieces_type();
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy);
}
class Pawn_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
if(this.pieces_color==Pieces_color.WHITE)
{
if(initial_pos.x==1)
{
if((final_pos.x!=2)&&(final_pos.x!=3))return false;
if(final_pos.x==3)if(initial_pos.y!=final_pos.y)return false;
}
else
{
if(final_pos.x!=(initial_pos.x+1))return false;
}
if(final_pos.x==(initial_pos.x+1))
{
if(enemy)
{
if((final_pos.y!=(initial_pos.y-1))&&(final_pos.y!=(initial_pos.y+1)))return false;
}
else
{
if(final_pos.y!=(initial_pos.y))return false;
}
}
}
else if(this.pieces_color==Pieces_color.BLACK)
{
if(initial_pos.x==6)
{
if((final_pos.x!=5)&&(final_pos.x!=4))return false;
if(final_pos.x==4)if(initial_pos.y!=final_pos.y)return false;
}
else
{
if(final_pos.x!=(initial_pos.x-1))return false;
}
if(final_pos.x==(initial_pos.x-1))
{
if(enemy)
{
if((final_pos.y!=(initial_pos.y-1))&&(final_pos.y!=(initial_pos.y+1)))return false;
}
else
{
if(final_pos.y!=(initial_pos.y))return false;
}
}
}
return true;
}
}
class Hook_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
if((final_pos.x!=initial_pos.x)&&(final_pos.y!=initial_pos.y))return false;
Point p;
int x;
if(initial_pos.x==final_pos.x)
{
if(initial_pos.y<final_pos.y)
{
x=initial_pos.y;
x++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x,x);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
else
{
x=final_pos.y;
x++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x,x);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
}
else if(initial_pos.y==final_pos.y)
{


if(initial_pos.x<final_pos.x)
{
x=initial_pos.x;
x++;
while(x<final_pos.x)
{
p=new Point(x,final_pos.y);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
else
{
x=final_pos.x;
x++;
while(x<initial_pos.x)
{
p=new Point(x,initial_pos.y);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
}
return true;
}
}
class Kneight_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
if(final_pos.x!=(initial_pos.x-2)&&final_pos.x!=(initial_pos.x-1)&&final_pos.x!=(initial_pos.x+1)&&final_pos.x!=(initial_pos.x+2))
{
return false;
}
if((final_pos.x==(initial_pos.x-1))||(final_pos.x==(initial_pos.x+1)))
{
if((final_pos.y!=(initial_pos.y-2))&&(final_pos.y!=(initial_pos.y+2)))return false;
}
else if((final_pos.x==(initial_pos.x-2))||(final_pos.x==(initial_pos.x+2)))
{
if((final_pos.y!=(initial_pos.y-1))&&(final_pos.y!=(initial_pos.y+1)))return false;
}
return true;
}
}
class Bishop_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
if((initial_pos.x==final_pos.x)||(initial_pos.y==final_pos.y))return false;
int x=final_pos.x-initial_pos.x;
int y=final_pos.y-initial_pos.y;
if(x<0)x=-x;
if(y<0)y=-y;
if(x!=y)return false;

x=0;
y=0;
Point p;
if(final_pos.x>initial_pos.x)
{
if(final_pos.y>initial_pos.y)
{
x=initial_pos.y;
x++;
y++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x+y,initial_pos.y+y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
else
{
x=final_pos.y;
x++;
y++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x+y,initial_pos.y-y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
}
else
{

if(final_pos.y>initial_pos.y)
{
x=initial_pos.y;
x++;
y++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x-y,initial_pos.y+y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
else
{
x=final_pos.y;
x++;
y++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x-y,initial_pos.y-y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
}
return true;
}
}
class King_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
int x=final_pos.x-initial_pos.x;
int y=final_pos.y-initial_pos.y;
if((x!=-1)&&(x!=0)&&(x!=1))return false;
if((y!=-1)&&(y!=0)&&(y!=1))return false;
return true;
}
}
class Queen_chessPieces implements ChessPieces
{
private Pieces_color pieces_color;
private Pieces_type pieces_type;
public void setPieces_color(Pieces_color pieces_color)
{
this.pieces_color=pieces_color;
}
public Pieces_color getPieces_color()
{
return this.pieces_color;
}
public void setPieces_type(Pieces_type pieces_type)
{
this.pieces_type=pieces_type;
}
public Pieces_type getPieces_type()
{
return this.pieces_type;
}
public boolean Process(Point initial_pos,Point final_pos,Map<Point,ChessPieces> pieces_identity,boolean enemy)
{
Point p;
int x=0;
int y=0;
if((initial_pos.x==final_pos.x)||(initial_pos.y==final_pos.y))
{
if(initial_pos.x==final_pos.x)
{
if(initial_pos.y<final_pos.y)
{
x=initial_pos.y;
x++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x,x);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
else
{
x=final_pos.y;
x++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x,x);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
}
else if(initial_pos.y==final_pos.y)
{
if(initial_pos.x<final_pos.x)
{
x=initial_pos.x;
x++;
while(x<final_pos.x)
{
p=new Point(x,final_pos.y);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
else
{
x=final_pos.x;
x++;
while(x<initial_pos.x)
{
p=new Point(x,initial_pos.y);
if(pieces_identity.containsKey(p))return false;
x++;
}
}
}
}
else
{
x=final_pos.x-initial_pos.x;
y=final_pos.y-initial_pos.y;
if(x<0)x=-x;
if(y<0)y=-y;
if(x!=y)return false;
x=0;
y=0;
if(final_pos.x>initial_pos.x)
{
if(final_pos.y>initial_pos.y)
{
x=initial_pos.y;
x++;
y++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x+y,initial_pos.y+y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
else
{
x=final_pos.y;
x++;
y++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x+y,initial_pos.y-y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
}
else
{
if(final_pos.y>initial_pos.y)
{
x=initial_pos.y;
x++;
y++;
while(x<final_pos.y)
{
p=new Point(initial_pos.x-y,initial_pos.y+y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
else
{
x=final_pos.y;
x++;
y++;
while(x<initial_pos.y)
{
p=new Point(initial_pos.x-y,initial_pos.y-y);
if(pieces_identity.containsKey(p))return false;
x++;
y++;
}
}
}
}
return true;
}
}
class ChessUI extends JFrame implements ActionListener
{
private Container container;
private JButton[][] button;
private Map<Point,ChessPieces> pieces_identity;
private ChessPieces chessPieces;
private boolean turn_white_pieces=true;
private int i_pieces=0;
private ImageIcon king_black_icon;
private ImageIcon king_white_icon;
private ImageIcon queen_black_icon;
private ImageIcon queen_white_icon;
private ImageIcon bishop_black_icon;
private ImageIcon bishop_white_icon;
private ImageIcon hook_black_icon;
private ImageIcon hook_white_icon;
private ImageIcon kneight_black_icon;
private ImageIcon kneight_white_icon;
private ImageIcon pawn_black_icon;
private ImageIcon pawn_white_icon;
private Point prev_position;
private Point new_position;
public Pieces_color pieces_color;
public Pieces_type pieces_type;
private ChessPieces c1=null;
private ChessPieces c2=null;
private Icon icon1=null;
private Icon icon2=null;


ChessUI()
{
initialize();

pieces_identity=new HashMap<>();
button = new JButton[8][8];
container=getContentPane();
container.setLayout(new GridLayout(8,8));
for(int i=0;i<=7;i++)
{
for(int j=0;j<=7;j++)
{
if(i==0)
{
if(j==0||j==7)
{
button[i][j]=new JButton(hook_white_icon);
chessPieces=new Hook_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.HOOK);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==1||j==6)
{
button[i][j]=new JButton(kneight_white_icon);
chessPieces=new Kneight_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.KNEIGHT);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==2||j==5)
{
button[i][j]=new JButton(bishop_white_icon);
chessPieces=new Bishop_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.BISHOP);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==3)
{
button[i][j]=new JButton(queen_white_icon);
chessPieces=new Queen_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.QUEEN);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==4)
{
button[i][j]=new JButton(king_white_icon);
chessPieces=new King_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.KING);
pieces_identity.put(new Point(i,j),chessPieces);
}
}
else if(i==1)
{
button[i][j]=new JButton(pawn_white_icon);
chessPieces=new Pawn_chessPieces();
chessPieces.setPieces_color(Pieces_color.WHITE);
chessPieces.setPieces_type(Pieces_type.PAWN);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(i==6)
{
button[i][j]=new JButton(pawn_black_icon);
chessPieces=new Pawn_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.PAWN);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(i==7)
{
if(j==0||j==7)
{
button[i][j]=new JButton(hook_black_icon);
chessPieces=new Hook_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.HOOK);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==1||j==6)
{
button[i][j]=new JButton(kneight_black_icon);
chessPieces=new Kneight_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.KNEIGHT);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==2||j==5)
{
button[i][j]=new JButton(bishop_black_icon);
chessPieces=new Bishop_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.BISHOP);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==3)
{
button[i][j]=new JButton(queen_black_icon);
chessPieces=new Queen_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.QUEEN);
pieces_identity.put(new Point(i,j),chessPieces);
}
else if(j==4)
{
button[i][j]=new JButton(king_black_icon);
chessPieces=new King_chessPieces();
chessPieces.setPieces_color(Pieces_color.BLACK);
chessPieces.setPieces_type(Pieces_type.KING);
pieces_identity.put(new Point(i,j),chessPieces);
}
}
else button[i][j]=new JButton(new String("   "));

button[i][j].addActionListener(this);

if(i%2==0)
{
if(j%2==0)button[i][j].setBackground(Color.WHITE);
else button[i][j].setBackground(new Color(50,205,50));
}
else
{
if(j%2==0)button[i][j].setBackground(new Color(50,205,50));
else button[i][j].setBackground(Color.WHITE);
}
container.add(button[i][j]);
}
}
setLocation(100,100);
setSize(600,600);
setVisible(true);
}
public void initialize()
{
king_black_icon=new ImageIcon("c:/chess/chess_pieces/king_black.png");
king_white_icon=new ImageIcon("c:/chess/chess_pieces/king_white.png");
queen_black_icon=new ImageIcon("c:/chess/chess_pieces/queen_black.png");
queen_white_icon=new ImageIcon("c:/chess/chess_pieces/queen_white.png");
hook_black_icon=new ImageIcon("c:/chess/chess_pieces/hook_black.png");
hook_white_icon=new ImageIcon("c:/chess/chess_pieces/hook_white.png");
kneight_black_icon=new ImageIcon("c:/chess/chess_pieces/kneight_black.png");
kneight_white_icon=new ImageIcon("c:/chess/chess_pieces/kneight_white.png");
bishop_black_icon=new ImageIcon("c:/chess/chess_pieces/bishop_black.png");
bishop_white_icon=new ImageIcon("c:/chess/chess_pieces/bishop_white.png");
pawn_black_icon=new ImageIcon("c:/chess/chess_pieces/pawn_black.png");
pawn_white_icon=new ImageIcon("c:/chess/chess_pieces/pawn_white.png");
}

public void actionPerformed(ActionEvent ev)
{
int row=0;
int col=0;
Point p;
for (row = 0; row<=7; row++) 
{
for (col = 0; col<=7; col++) 
{
if (button[row][col] == ev.getSource())
{
p=new Point(row,col);
if(pieces_identity.containsKey(p))
{
i_pieces++;
}
if(i_pieces==0)
{
return;
}
else if(i_pieces==1)
{
chessPieces=pieces_identity.get(p);
if(chessPieces==null)
{
return;
}
if(chessPieces!=null&&chessPieces.getPieces_color()==Pieces_color.WHITE)
{
if(turn_white_pieces==false)
{
i_pieces=0;
return;
}
else 
{
i_pieces++;
}
}
else if(chessPieces!=null&&chessPieces.getPieces_color()==Pieces_color.BLACK)
{
if(turn_white_pieces==true)
{
i_pieces=0;
return;
}
else
{
i_pieces++;
}
}
prev_position=p;
}
else if(i_pieces==2||i_pieces==3)
{
new_position=p;
icon1=button[prev_position.x][prev_position.y].getIcon();
icon2=button[new_position.x][new_position.y].getIcon();
c1=pieces_identity.get(new Point(prev_position.x,prev_position.y));
c2=pieces_identity.get(new Point(new_position.x,new_position.y));
if(i_pieces==3&&(c1.getPieces_color()==c2.getPieces_color()))
{
icon1=null;
icon2=null;
i_pieces=0;
prev_position=null;
new_position=null;
return;
}
boolean enemy=false;
if(i_pieces==3)enemy=true;
if(!c1.Process(prev_position,new_position,pieces_identity,enemy))
{
icon1=null;
icon2=null;
i_pieces=0;
prev_position=null;
new_position=null;
return;
}
if(button[new_position.x][new_position.y].getIcon()==null)
{
pieces_identity.remove(prev_position);
pieces_identity.put(new_position,c1);
button[prev_position.x][prev_position.y].setIcon(icon2);
button[new_position.x][new_position.y].setIcon(icon1);
} 
else
{
button[new_position.x][new_position.y].setIcon(icon1);
button[prev_position.x][prev_position.y].setIcon(null);
pieces_identity.remove(prev_position);
pieces_identity.remove(new_position);
pieces_identity.put(new_position,c1);
}  
turn_white_pieces=!turn_white_pieces;
i_pieces=0;
prev_position=null;
new_position=null;
}

}
}
}
}


public static void main(String gg[])
{
ChessUI chessUI=new ChessUI();
}
}