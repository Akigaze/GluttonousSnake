package entity;

import static constant.GameConstant.STAR_COLOR;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Star extends Egg {

  public Star(int x, int y){
    super(x, y);
    this.setColor(STAR_COLOR);
    this.setScore(2);
  }
}
