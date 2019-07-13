package entity;

import constant.GridConstant;

import java.awt.*;

import static constant.GameConstant.DEFAULT_EGG_COLOR;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Egg extends Node {
  private int score = 1;
  private int hp;

  public Egg() {
    this(5 * GridConstant.BLOCK_SIZE, 5 * GridConstant.BLOCK_SIZE);
  }

  public Egg(int x, int y){
    super(x, y);
    this.setColor(DEFAULT_EGG_COLOR);
  }

  public boolean die(){
    return this.hp <= 0;
  }

  public void draw(Graphics g) {
    Color c = g.getColor();
    if (this.hp < 40){
      this.setColor(this.getColor().darker());
    }
    g.setColor(this.getColor());
    super.draw(g);
    g.setColor(c);
    this.hp -- ;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
}
