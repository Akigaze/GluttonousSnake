package game;

import method.Constant;

import java.awt.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Grid {
    private int blockSize;
    private Color background;
    private Color foreground;
    private int width;
    private int height;
    public Grid(){
        blockSize= Constant.BLOCK_SIZE;
        width=Constant.WIDTH;
        height=Constant.HEIGHT;
        background=Color.BLACK;
        foreground=Color.DARK_GRAY;
    }
    public void drwn(Graphics g){
        Color c=g.getColor();
        g.setColor(background);
        g.fillRect(0,0,width,height);
        g.setColor(foreground);
        int blockNO=1;
        int top=0;
        int left=0;
        while (blockNO*blockSize<width||blockNO*blockSize<height){
            top+=blockSize;
            left+=blockSize;
            g.drawLine(left,0,left,height);
            g.drawLine(0,top,width,top);
            blockNO++;
        }
        g.setColor(c);
    }
}
