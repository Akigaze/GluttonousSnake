package constant;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public enum Direction {
  up(KeyEvent.VK_UP, 1),
  down(KeyEvent.VK_DOWN, 1),
  left(KeyEvent.VK_LEFT, -1),
  right(KeyEvent.VK_RIGHT, -1);

  private int key;
  private int dimension;

  Direction(int key, int dimension) {
    this.key = key;
    this.dimension = dimension;
  }

  public static Direction findByKey(int key){
    return Arrays.stream(Direction.values()).filter(d -> d.key == key).findFirst().orElse(null);
  }

  public Direction nextDirection(Direction to){
    return isOpposite(to) ? this : to;
  }

  private boolean isOpposite(Direction d) {
    return this.dimension == d.dimension;
  }
}
