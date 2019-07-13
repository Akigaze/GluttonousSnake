package constant;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameConstant {
  public static final int POSITION_X = 100;
  public static final int POSITION_Y = 40;
  public static final int GRID_WIDTH = 1000;
  public static final int GRID_HEIGHT = 600;

  public static final Color DEFAULT_EGG_COLOR = Color.orange;
  public static final Color DEFAULT_SNAKE_COLOR = Color.GRAY;

  private static List<Color> palette = new ArrayList<>();

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
}
