package game;

import method.Constant;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Snake {
    Node head;
    Node tail;
    Color color=Color.GRAY;
    int speed;
    int size=1;
    public static java.util.List<Color> palette=new ArrayList<>();
    static {
        palette.add(Color.BLACK);
        palette.add(Color.BLUE);
        palette.add(Color.CYAN);
        palette.add(Color.GRAY);
        palette.add(Color.GREEN);
        palette.add(Color.RED);
        palette.add(Color.YELLOW);
        palette.add(Color.ORANGE);
        palette.add(Color.WHITE);
        palette.add(Color.MAGENTA);
        palette.add(Color.PINK);
        palette.add(Color.DARK_GRAY);
        palette.add(Color.LIGHT_GRAY);
    }
    public Snake(){
        head=new Node(2* Constant.BLOCK_SIZE,2*Constant.BLOCK_SIZE);
        speed=Constant.BLOCK_SIZE;

        tail=head;
    }
    public boolean isMealTime(Egg egg){
        Rectangle eggRect=new Rectangle(egg.node.x,egg.node.y,egg.node.size,egg.node.size);
        Rectangle headRect=new Rectangle(head.x,head.y,head.size,head.size);
        return headRect.intersects(eggRect);
    }
    public void move(){
        int _x=head.getX();
        int _y=head.getY();
        switch (head.getDir()){
            case down:_y+=speed;break;
            case up:_y-=speed;break;
            case left:_x-=speed;break;
            case right:_x+=speed;break;
        }
        Node tempHead=new Node(_x,_y);
        tempHead.setDir(head.getDir());
        if(size==1){
            head=tempHead;
            tail=tempHead;
        }else {
            Node tempTail=tail.pre;
            tempHead.next=head;
            head.pre=tempHead;
            head=tempHead;
            tempTail.next=null;
            tail=tempTail;
        }

    }

    public void directionChange(KeyEvent e){
        int key=e.getKeyCode();
        switch (key){
            case 37: {
                if(head.getDir()!= Node.direction.right)
                head.setDir(Node.direction.left);
            } ;break;
            case 38: {
                if(head.getDir()!= Node.direction.down)
                head.setDir(Node.direction.up);
            } ;break;
            case 39: {
                if(head.getDir()!= Node.direction.left)
                head.setDir(Node.direction.right);
            } ;break;
            case 40: {
                if(head.getDir()!= Node.direction.up)
                head.setDir(Node.direction.down);
            } ;break;
        }
    }
    public void eat(Egg egg){
        Node temp=new Node();
        temp.y=egg.node.y;
        temp.x=egg.node.x;
        temp.setDir(head.getDir());
        head.pre=temp;
        temp.next=head;
        head=temp;
        size++;
    }
    public boolean isFail(){
        boolean fail=false;
        if(head.x<0||head.y<0||head.x+head.size>Constant.WIDTH||head.y+head.size>Constant.HEIGHT){
            fail=true;
        }
        if(size>4){
            Rectangle headRect=new Rectangle(head.x,head.y,head.size,head.size);
            Node temp=head.next.next.next.next;
            Rectangle tempRect=null;
            while (temp!=null){
                tempRect=new Rectangle(temp.x,temp.y,temp.size,temp.size);
                if(headRect.intersects(tempRect)){
                    fail=true;
                    break;
                }
                temp=temp.next;
            }
        }
        return fail;
    }
    public void draw(Graphics g){
        Node no=head;
        Color c=g.getColor();
        g.setColor(color);
        while (no!=null){
            int index=(int)(Math.random()*palette.size());
            g.fillRect(no.getX(),no.getY(),no.getSize(),no.getSize());
            g.setColor(palette.get(index));
            g.drawRect(no.getX(),no.getY(),no.getSize(),no.getSize());
            no=no.next;
        }
        g.setColor(c);
    }
}
