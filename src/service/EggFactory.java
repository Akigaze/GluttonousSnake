package service;

import constant.GridConstant;
import entity.Egg;
import entity.Node;
import entity.Snake;

public class EggFactory {
  public Egg birth(Snake snake){
    Egg egg;
    do {
      int _x = (int) (Math.random() * (GridConstant.X_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      int _y = (int) (Math.random() * (GridConstant.Y_COUNT - 4) + 2) * GridConstant.BLOCK_SIZE;
      egg = new Egg(_x, _y);
    }while (this.isOverlap(snake, egg));
    return egg;
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
