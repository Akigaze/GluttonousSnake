package game;

import method.Constant;

/**
 * Created by 11755_000 on 2018/1/23.
 */

public class Node {
  public enum direction {
    up, down, left, right;
  }

  int size;
  int x;
  int y;
  private direction dir;
  Node pre;
  Node next;

  public Node(int x, int y) {
    size = Constant.BLOCK_SIZE;
    dir = direction.right;
    this.x = x;
    this.y = y;
  }

  public Node() {
    this(0, 0);
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public direction getDir() {
    return dir;
  }

  public void setDir(direction dir) {
    this.dir = dir;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}

