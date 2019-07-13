package entity;

import constant.GridConstant;

import java.awt.*;

import static constant.GameConstant.DEFAULT_EGG_COLOR;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Egg extends Node {
  private Color color;

  public Egg() {
    this(5 * GridConstant.BLOCK_SIZE, 5 * GridConstant.BLOCK_SIZE);
  }

  public Egg(int x, int y){
    super(x, y);
    this.color = DEFAULT_EGG_COLOR;
  }

  public void draw(Graphics g) {
    Color c = g.getColor();
    g.setColor(color);
    super.draw(g);
    g.setColor(c);
  }
}
