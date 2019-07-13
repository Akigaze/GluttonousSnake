package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static constant.GameConstant.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class BaseFrame extends Frame {
  protected final static int DEFAULT_SPEED = 80;

  protected int speed = DEFAULT_SPEED;
  private Image offScreenImage;

  class MoveThread extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          sleep(getSpeed());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        repaint();
      }
    }

  }

  public void update(Graphics g) {
    if (offScreenImage == null) {
      offScreenImage = this.createImage(GRID_WIDTH, GRID_HEIGHT);
    }
    Graphics gOff = offScreenImage.getGraphics();
    paint(gOff);
    g.drawImage(offScreenImage, 0, 0, null);
  }

  public void launch() {
    super.setLocation(POSITION_X, POSITION_Y);
    super.setSize(GRID_WIDTH, GRID_HEIGHT);
    super.setVisible(true);
    super.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    new MoveThread().start();
  }

  private int getSpeed() {
    return this.speed;
  }
}
