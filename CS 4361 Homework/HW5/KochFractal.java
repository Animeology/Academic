import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Canvas
// Draw Sierpinsky Gasket
class Canvas extends JPanel {

  public Canvas() {
    // Set BG To Black
    setBackground(Color.BLACK);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    // Draw Koch Curve
    g.setColor(Color.WHITE);
    // For Every Depth, Each Line Segment Is Divided Into 5 Points
    // We Know Starting And Ending Point
    // 3 Points Of Triangle
    int p1x = 300, p1y = 0;
    int p2x = 0, p2y = 450;
    int p3x = 600, p3y = 450;
    // For Depth = 4, Draw 3 Segments Of Triangle
    drawKochFractal(g, 4, p1x, p1y, p2x, p2y);
    drawKochFractal(g, 4, p2x, p2y, p3x, p3y);
    drawKochFractal(g, 4, p3x, p3y, p1x, p1y);
  }

  // Recursive Function To Draw Koch Curve
  private void drawKochFractal(Graphics g, int depth, int x1, int y1, int x5, int y5) {
    // Base Condition
    // Draw A Line From X1, Y1 To X5, Y5
    if (depth == 0) {
      g.drawLine(x1, y1, x5, y5);
    } else {
      int deltaX = x5 - x1;
      int deltaY = y5 - y1;

      // Find X2, Y2
      // Simply 1/3 Of Length From X1, Y1
      int x2 = x1 + deltaX / 3;
      int y2 = y1 + deltaY / 3;

      // Find X3, Y3
      // This Is The Top Point Of The Equilateral Triangle In The Mid
      // Of Each Segment
      int x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
      int y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

      // Find X4, Y4
      // Simply 2/3 Of Length From X1, Y1
      int x4 = x1 + 2 * deltaX / 3;
      int y4 = y1 + 2 * deltaY / 3;

      // For 4 Segments, Call DrawKochFractal Recursively
      // Decrease Depth Each Time
      drawKochFractal(g, depth - 1, x1, y1, x2, y2);
      drawKochFractal(g, depth - 1, x2, y2, x3, y3);
      drawKochFractal(g, depth - 1, x3, y3, x4, y4);
      drawKochFractal(g, depth - 1, x4, y4, x5, y5);
    }
  }
}

// Main Application
public class KochFractal extends JFrame {

  public KochFractal() {
    // Set Height And Width Of The Frame
    setSize(620, 660);
    // Add Canvas Where Actual Drawing Takes Place
    getContentPane().add(new Canvas());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {
    // Create Instance Of Frame
    new KochFractal();
  }
}