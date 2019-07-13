package game;

import method.GridConstant;

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

  public Grid() {
    blockSize = GridConstant.BLOCK_SIZE;
    width = GridConstant.WIDTH;
    height = GridConstant.HEIGHT;
    background = GridConstant.BACKGROUND_COLOR;
    foreground = GridConstant.FOREGROUND_COLOR;
  }

  public void drawn(Graphics g) {
    Color c = g.getColor();
    g.setColor(this.background);
    g.fillRect(0, 0, this.width, this.height);
    g.setColor(this.foreground);
    this.drawHorizontalLines(g);
    this.drawVerticalLines(g);
    g.setColor(c);
  }

  private void drawVerticalLines(Graphics g) {
    int lineNumber = 1;
    int left = 0;
    while (lineNumber * this.blockSize < this.width ) {
      left += this.blockSize;
      g.drawLine(left, 0, left, this.height);
      lineNumber++;
    }
  }

  private void drawHorizontalLines(Graphics g) {
    int lineNumber = 1;
    int top = 0;
    while (lineNumber * this.blockSize < this.height) {
      top += this.blockSize;
      g.drawLine(0, top, this.width, top);
      lineNumber++;
    }
  }
}
