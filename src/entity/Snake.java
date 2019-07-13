package entity;

import constant.GameConstant;
import constant.GridConstant;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by 11755_000 on 2018/1/23.
 */
public class Snake {
  Node head;
  Node tail;
  Color color = Color.GRAY;
  int speed;
  int size = 1;
  public static java.util.List<Color> palette = new ArrayList<>();

  static {
    palette.add(Color.BLACK);
    palette.add(Color.BLUE);
    palette.add(Color.CYAN);
    palette.add(Color.GRAY);
    palette.add(Color.GREEN);
    palette.add(Color.RED);
    palette.add(Color.YELLOW);
    palette.add(Color.ORANGE);
    palette.add(Color.WHITE);
    palette.add(Color.MAGENTA);
    palette.add(Color.PINK);
    palette.add(Color.DARK_GRAY);
    palette.add(Color.LIGHT_GRAY);
  }

  public Snake() {
    head = new Node(2 * GridConstant.BLOCK_SIZE, 2 * GridConstant.BLOCK_SIZE);
    speed = GridConstant.BLOCK_SIZE;

    tail = head;
  }

  public boolean isEating(Egg egg) {
    Rectangle eggRect = new Rectangle(egg.getX(), egg.getY(), egg.getSize(), egg.getSize());
    Rectangle headRect = new Rectangle(head.getX(), head.getY(), head.getSize(), head.getSize());
    return headRect.intersects(eggRect);
  }

  public void move() {
    int _x = head.getX();
    int _y = head.getY();
    switch (head.getDir()) {
      case down:
        _y += speed;
        break;
      case up:
        _y -= speed;
        break;
      case left:
        _x -= speed;
        break;
      case right:
        _x += speed;
        break;
    }
    Node tempHead = new Node(_x, _y);
    tempHead.setDir(head.getDir());
    if (size == 1) {
      head = tempHead;
      tail = tempHead;
    } else {
      Node tempTail = tail.getPre();
      tempHead.setNext(head);
      head.setPre(tempHead);
      head = tempHead;
      tempTail.setNext(null);
      tail = tempTail;
    }

  }

  public void directionChange(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
      case 37: {
        if (head.getDir() != Node.Direction.right)
          head.setDir(Node.Direction.left);
      }
      break;
      case 38: {
        if (head.getDir() != Node.Direction.down)
          head.setDir(Node.Direction.up);
      }
      break;
      case 39: {
        if (head.getDir() != Node.Direction.left)
          head.setDir(Node.Direction.right);
      }
      break;
      case 40: {
        if (head.getDir() != Node.Direction.up)
          head.setDir(Node.Direction.down);
      }
      break;
    }
  }

  public void growUp(Egg egg) {
    Node temp = new Node();
    temp.setY(egg.getY());
    temp.setX(egg.getX());
    temp.setDir(head.getDir());
    head.setPre(temp);
    temp.setNext(head);
    head = temp;
    size++;
  }

  public boolean isDead() {
    boolean fail = false;
    if (head.getX() < 0 || head.getY() < 0 || head.getX() + head.getSize() > GameConstant.GRID_WIDTH || head.getY() + head.getSize() > GameConstant.GRID_HEIGHT) {
      fail = true;
    }
    if (size > 4) {
      Rectangle headRect = new Rectangle(head.getX(), head.getY(), head.getSize(), head.getSize());
      Node temp = head.getNext().getNext().getNext().getNext();
      Rectangle tempRect = null;
      while (temp != null) {
        tempRect = new Rectangle(temp.getX(), temp.getY(), temp.getSize(), temp.getSize());
        if (headRect.intersects(tempRect)) {
          fail = true;
          break;
        }
        temp = temp.getNext();
      }
    }
    return fail;
  }

  public void draw(Graphics g) {
    Node no = head;
    Color c = g.getColor();
    g.setColor(color);
    while (no != null) {
      int index = (int) (Math.random() * palette.size());
      g.fillRect(no.getX(), no.getY(), no.getSize(), no.getSize());
      g.setColor(palette.get(index));
      g.drawRect(no.getX(), no.getY(), no.getSize(), no.getSize());
      no = no.getNext();
    }
    g.setColor(c);
  }

  public int getSize() {
    return size;
  }
}
