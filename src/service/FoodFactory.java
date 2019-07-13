package service;

import constant.EggType;
import constant.GridConstant;
import entity.Egg;
import entity.Node;
import entity.Snake;

public class FoodFactory {
  public Egg birth(Snake snake){
    EggType type = Math.random() < 0.1 ? EggType.SUN : Math.random() < 0.4 ? EggType.STAR : EggType.EGG;
    Egg food;
    do {
      int _x = (int) (Math.random() * (GridConstant.X_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      int _y = (int) (Math.random() * (GridConstant.Y_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      food = new Egg(_x, _y);
    }while (this.isOverlap(snake, food));
    food.setScore(type.getScore());
    food.setColor(type.getColor());
    food.setHp(type.getHp());
    return food;
  }

  private boolean isOverlap(Snake snake, Node node){
    Node body = snake.getHead();
    while (body != null){
      if (body.toRectangle().intersects(node.toRectangle())){
        return true;
      }
      body = body.getNext();
    }
    return false;
  }
}
