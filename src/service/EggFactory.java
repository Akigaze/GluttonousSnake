package service;

import constant.GridConstant;
import entity.Egg;
import entity.Snake;

public class EggFactory {
  public static Egg birth(Snake snake){
    int _x = (int) (Math.random() * (GridConstant.X_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
    int _y = (int) (Math.random() * (GridConstant.Y_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
    return new Egg(_x, _y);
  }
}
