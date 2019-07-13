package constant;

import java.awt.*;

import static constant.GameConstant.DEFAULT_EGG_COLOR;
import static constant.GameConstant.STAR_COLOR;
import static constant.GameConstant.SUN_COLOR;

public enum EggType {
  EGG(DEFAULT_EGG_COLOR, 1, Integer.MAX_VALUE),
  STAR(STAR_COLOR, 2, 100),
  SUN(SUN_COLOR, 4, 50);

  private Color color;
  private int score;
  private int hp;

  EggType(Color color, int score, int hp) {
    this.color = color;
    this.score = score;
    this.hp = hp;
  }

  public Color getColor() {
    return color;
  }

  public int getScore() {
    return score;
  }

  public int getHp() {
    return hp;
  }
}
