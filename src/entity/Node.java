package entity;

import constant.Direction;

import java.awt.*;

import static constant.GridConstant.BLOCK_SIZE;

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

  private Color color;

  Node(int x, int y) {
    size = BLOCK_SIZE;
    direction = Direction.right;
    this.x = x;
    this.y = y;
  }

  private int getSize() {
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

  void setNext(Node next) {
    this.next = next;
  }

  Node getPre() {
    return pre;
  }

  void setPre(Node pre) {
    this.pre = pre;
  }

  Color getColor() {
    return color;
  }

  void setColor(Color color) {
    this.color = color;
  }

  public Rectangle toRectangle(){
    return new Rectangle(this.x, this.y, this.size, this.size);
  }

  public void draw(Graphics g) {
    g.fillRect(this.getX(), this.getY(), this.getSize(), this.getSize());
  }

  public void outline(Graphics g){
    g.drawRect(this.getX(), this.getY(), this.getSize(), this.getSize());
  }

}

