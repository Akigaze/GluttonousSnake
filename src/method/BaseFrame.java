package method;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class BaseFrame extends Frame {
    protected int gameSpeed=80;
    class MoveThreas extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    sleep(gameSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    }
    private Image offScreenImage=null;
    public void update(Graphics g){
        if(offScreenImage==null){
            offScreenImage=this.createImage(Constant.WIDTH,Constant.HEIGHT);
        }
        Graphics gOff=offScreenImage.getGraphics();
        //paint(g);
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }
    public void launch(){
        setLocation(Constant.X,Constant.Y);
        setSize(Constant.WIDTH,Constant.HEIGHT);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new MoveThreas().start();
    }
}
