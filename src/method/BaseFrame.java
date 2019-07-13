package method;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class BaseFrame extends Frame {
  protected final static int DEFAULT_SPEED = 80;
  protected int speed = DEFAULT_SPEED;

  class MoveThreas extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          sleep(speed);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        repaint();
      }
    }
  }

  private Image offScreenImage = null;

  public void update(Graphics g) {
    if (offScreenImage == null) {
      offScreenImage = this.createImage(GridConstant.WIDTH, GridConstant.HEIGHT);
    }
    Graphics gOff = offScreenImage.getGraphics();
    //paint(g);
    paint(gOff);
    g.drawImage(offScreenImage, 0, 0, null);
  }

  public void launch() {
    setLocation(GridConstant.X, GridConstant.Y);
    setSize(GridConstant.WIDTH, GridConstant.HEIGHT);
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
