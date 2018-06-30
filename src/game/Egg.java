package game;

import method.Constant;

import java.awt.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Egg {
    Node node;
    Color color;
    public Egg(){
        int x=5*Constant.BLOCK_SIZE;
        int y=5*Constant.BLOCK_SIZE;
        node=new Node(x,y);
        node.setSize(Constant.BLOCK_SIZE);
        color=Color.orange;
    }
    public void draw(Graphics g){
        Color c=g.getColor();
        g.setColor(color);
        g.fillRect(node.getX(),node.getY(),node.getSize(),node.getSize());
        g.setColor(c);
    }
    public void reappear(Snake s){
        node.x=(int)(Math.random()*(Constant.X_COUNT-4)+2)*Constant.BLOCK_SIZE;
        node.y=(int)(Math.random()*(Constant.Y_COUNT-4)+2)*Constant.BLOCK_SIZE;
    }
}
