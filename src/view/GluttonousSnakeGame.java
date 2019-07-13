package view;

import entity.Egg;
import entity.Grid;
import entity.Snake;
import service.EggFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class GluttonousSnakeGame extends BaseFrame {
  class KeyboardMonitor extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (!isStop()) {
        getSnake().directionChange(keyCode);
        speedChange(keyCode);
      }
      stop(keyCode);
      restart(e);
    }
  }

  enum SpeedMonitor{
    UP(KeyEvent.VK_A, 5),
    CUT(KeyEvent.VK_D, -5),
    DEFAULT(0, 0);

    private int keyCode;
    private int change;

    SpeedMonitor(int keyCode, int change) {
      this.keyCode = keyCode;
      this.change = change;
    }

    public static int getChange(int keyCode){
      SpeedMonitor monitor = Arrays.stream(SpeedMonitor.values())
        .filter(c -> c.keyCode == keyCode).findFirst().orElse(DEFAULT);
      return monitor.change;
    }
  }

  private static Grid grid = new Grid();
  private Snake snake;
  private Egg egg;
  private boolean stop;
  private boolean gameOver;

  public GluttonousSnakeGame() {
    this.snake = new Snake();
    this.egg = new Egg();
  }

  private void speedChange(int key) {
    this.speed += SpeedMonitor.getChange(key);
  }

  private void stop(int key) {
    if (key == KeyEvent.VK_SPACE) {
      this.stop = !this.stop;
    }
  }

  private void restart(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      this.stop = false;
      this.gameOver = false;
      this.speed = DEFAULT_SPEED;
      this.snake = new Snake();
    }
  }

  @Override
  public void launch() {
    super.addKeyListener(new KeyboardMonitor());
    super.launch();
  }

  @Override
  public void paint(Graphics g) {
    GluttonousSnakeGame.grid.drawn(g);
    if (!this.gameOver && !this.stop) {
      if (this.snake.isDead()) {
        this.gameOver = true;
      } else {
        this.snake.move();
        if (this.snake.isEating(this.egg)) {
          this.snake.growUp(this.egg);
          this.egg = EggFactory.birth(this.snake);
        }
      }
    }

    this.snake.draw(g);
    this.egg.draw(g);
    if (this.gameOver) {
      this.printOverMessage(g);
    }
    this.printScore(g);
  }

  private void printScore(Graphics g) {
    Color c = g.getColor();
    g.setColor(Color.WHITE);
    g.drawString("得分：" + (this.snake.getSize() - 1), 50, 50);
    g.setColor(c);
  }

  private void printOverMessage(Graphics g) {
    Font f = g.getFont();
    Color c = g.getColor();
    g.setColor(Color.WHITE);
    g.setFont(new Font("黑体", Font.BOLD, 80));
    g.drawString("GAME OVER!", 200, 200);
    g.drawString("分数：" + this.snake.getSize(), 240, 300);
    g.setFont(f);
    g.setColor(c);
  }

  private Snake getSnake() {
    return snake;
  }

  private boolean isStop() {
    return stop;
  }
}
