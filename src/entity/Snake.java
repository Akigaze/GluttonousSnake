package entity;

import constant.Direction;
import constant.GameConstant;

import java.awt.*;
import java.util.Arrays;

import static constant.GameConstant.DEFAULT_SNAKE_COLOR;
import static constant.GameConstant.GRID_HEIGHT;
import static constant.GameConstant.GRID_WIDTH;
import static constant.GridConstant.BLOCK_SIZE;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Snake {

  enum MoveMonitor {
    UP(Direction.up, 0, -1),
    DOWN(Direction.down, 0, 1),
    LEFT(Direction.left, -1, 0),
    RIGHT(Direction.right, 1, 0),
    DEFAULT(null, 0, 0);

    private Direction direction;
    private int x;
    private int y;

    MoveMonitor(Direction direction, int x, int y) {
      this.direction = direction;
      this.x = x;
      this.y = y;
    }

    public static MoveMonitor getMonitor(Direction direction){
      return Arrays.stream(MoveMonitor.values()).filter(m -> m.direction.equals(direction)).findFirst().orElse(DEFAULT);
    }
  }

  private Node head;
  private Node tail;
  private Color color = DEFAULT_SNAKE_COLOR;
  private int speed = BLOCK_SIZE;
  private int size = 1;

  public Snake() {
    this.head = new Node(2 * BLOCK_SIZE, 2 * BLOCK_SIZE);
    this.tail = this.head;
  }

  public boolean isEating(Egg egg) {
    Rectangle eggRect = egg.toRectangle();
    Rectangle headRect = this.head.toRectangle();
    return headRect.intersects(eggRect);
  }

  public void move() {
    Node nextHead = getNextHead();
    this.head.setPre(nextHead);
    nextHead.setNext(this.head);
    this.head = nextHead;

    this.tail = this.tail.getPre();
    this.tail.setNext(null);
  }

  private Node getNextHead() {
    MoveMonitor monitor = MoveMonitor.getMonitor(this.head.getDirection());
    Node nextHead = new Node(monitor.x * this.speed + this.head.getX(), monitor.y * this.speed + this.head.getY());
    nextHead.setDirection(this.head.getDirection());
    return nextHead;
  }

  private Direction getDirection(){
    return this.head.getDirection();
  }

  public void directionChange(int key) {
    Direction keyDirection = Direction.findByKey(key);
    if (keyDirection != null){
      Direction nextDirection = this.getDirection().nextDirection(keyDirection);
      this.head.setDirection(nextDirection);
    }
  }

  public void growUp(Node food) {
    food.setDirection(this.head.getDirection());
    food.setColor(this.color);
    this.head.setPre(food);
    food.setNext(this.head);
    this.head = food;
    size++;
  }

  private boolean isHitBorder() {
    return this.head.getX() < 0
      || this.head.getY() < 0
      || this.head.getX() > GRID_WIDTH
      || this.head.getY() > GRID_HEIGHT;
  }
  private boolean canHitBody(){
    return this.size > 4;
  }

  private boolean isHitBody(){
    Rectangle headRect = this.head.toRectangle();
    Node nearestCanHit = this.head.getNext().getNext().getNext().getNext();
    while (nearestCanHit != null) {
      Rectangle tempRect = nearestCanHit.toRectangle();
      if (headRect.intersects(tempRect)) {
        return true;
      }
      nearestCanHit = nearestCanHit.getNext();
    }
    return false;
  }

  public boolean isDead() {
    if (this.isHitBorder()) {
      return true;
    }
    if (this.canHitBody()) {
      return this.isHitBody();
    }
    return false;
  }

  public void draw(Graphics g) {
    Node node = head;
    Color c = g.getColor();
    g.setColor(color);
    while (node != null) {
      node.draw(g);
//      node.outline(g);
      node = node.getNext();
    }
    g.setColor(c);
  }

  public int getSize() {
    return this.size;
  }

  public Node getHead() {
    return head;
  }
}
