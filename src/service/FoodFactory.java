package service;

import constant.GridConstant;
import entity.Egg;
import entity.Node;
import entity.Snake;
import entity.Star;

public class FoodFactory {
  public Egg birth(Snake snake){
    Egg food;
    do {
      int _x = (int) (Math.random() * (GridConstant.X_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      int _y = (int) (Math.random() * (GridConstant.Y_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      food = Math.random() < 0.4 ? new Star(_x, _y) : new Egg(_x, _y);
    }while (this.isOverlap(snake, food));
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
