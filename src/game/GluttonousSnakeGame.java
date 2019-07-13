package game;

import method.BaseFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class GluttonousSnakeGame extends BaseFrame {
  class KeyboardMoniter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      if (!stop) {
        she.directionChange(e);
        speedChange(e);
      }
      stop(e);
      restart(e);

    }
  }

  static Grid grid = new Grid();
  Snake she;
  Egg egg;
  boolean stop;
  boolean gameOver;

  public GluttonousSnakeGame() {
    she = new Snake();
    egg = new Egg();
  }

  public void speedChange(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A) {
      this.gameSpeed += 5;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      this.gameSpeed -= 5;
    }
  }

  public void stop(KeyEvent e) {
    if (e.getKeyCode() == 32) {
      stop = !stop;
    }

  }

  public void over(Graphics g) {
    Font f = g.getFont();
    Color c = g.getColor();
    g.setColor(Color.WHITE);
    g.setFont(new Font("黑体", Font.BOLD, 80));
    g.drawString("GAME OVER!", 200, 200);
    g.drawString("分数：" + she.size, 240, 300);
    g.setFont(f);
    g.setColor(c);
  }

  public void restart(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      stop = false;
      gameOver = false;
      gameSpeed = 80;
      she = new Snake();
    }
  }

  @Override
  public void launch() {
    addKeyListener(new KeyboardMoniter());
    super.launch();
  }

  @Override
  public void paint(Graphics g) {
    grid.drwn(g);
    if ((!gameOver) && (!stop)) {
      if (she.isFail()) {
        gameOver = true;
      } else {
        she.move();
        if (she.isMealTime(egg)) {
          she.eat(egg);
          egg.reappear(she);
        }
      }
    }

    she.draw(g);
    egg.draw(g);
    if (gameOver) {
      over(g);
    }
    Color c = g.getColor();
    g.setColor(Color.WHITE);
    g.drawString("得分：" + (she.size - 1), 50, 50);
    g.setColor(c);

  }

}
