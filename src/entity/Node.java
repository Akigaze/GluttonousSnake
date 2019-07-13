package entity;

import constant.Direction;
import constant.GridConstant;

import java.awt.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */

public class Node {
  private int size;
  private int x;
  private int y;

  private Direction direction;
  private Node pre;
  private Node next;

  Node(int x, int y) {
    size = GridConstant.BLOCK_SIZE;
    direction = Direction.right;
    this.x = x;
    this.y = y;
  }

  Node() {
    this(0, 0);
  }

  int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  Direction getDirection() {
    return direction;
  }

  void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPre() {
    return pre;
  }

  public void setPre(Node pre) {
    this.pre = pre;
  }

  public Rectangle toRectangle(){
    return new Rectangle(this.x, this.y, this.size, this.size);
  }

  public void draw(Graphics g) {
    g.fillRect(this.getX(), this.getY(), this.getSize(), this.getSize());
  }
}

