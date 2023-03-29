import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Tetris extends Canvas implements MouseListener {

  public void paint(Graphics g) {
    // Board
    g.setColor(Color.black);
    g.drawRect(0, 0, 500, 1000);

    // Green Shape
    g.setColor(Color.green);
    g.fillRect(125, 200, 25, 25);
    g.setColor(Color.green);
    g.fillRect(150, 200, 25, 25);
    g.setColor(Color.green);
    g.fillRect(150, 225, 25, 25);
    g.setColor(Color.green);
    g.fillRect(125, 225, 25, 25);
    // Green Shape Lines
    g.setColor(Color.black);
    g.drawRect(125, 200, 25, 25);
    g.drawRect(150, 200, 25, 25);
    g.drawRect(150, 225, 25, 25);
    g.drawRect(125, 225, 25, 25);

    // Yellow Shape
    g.setColor(Color.yellow);
    g.fillRect(400, 975, 25, 25);
    g.setColor(Color.yellow);
    g.fillRect(425, 975, 25, 25);
    g.setColor(Color.yellow);
    g.fillRect(450, 950, 25, 25);
    g.setColor(Color.yellow);
    g.fillRect(425, 950, 25, 25);
    // Yellow Shape Lines
    g.setColor(Color.black);
    g.drawRect(400, 975, 25, 25);
    g.drawRect(425, 975, 25, 25);
    g.drawRect(450, 950, 25, 25);
    g.drawRect(425, 950, 25, 25);

    // Blue Shape
    g.setColor(Color.blue);
    g.fillRect(450, 975, 25, 25);
    g.setColor(Color.blue);
    g.fillRect(475, 975, 25, 25);
    g.setColor(Color.blue);
    g.fillRect(475, 950, 25, 25);
    g.setColor(Color.blue);
    g.fillRect(475, 925, 25, 25);
    // Blue Shape Lines
    g.setColor(Color.black);
    g.drawRect(450, 975, 25, 25);
    g.drawRect(475, 975, 25, 25);
    g.drawRect(475, 950, 25, 25);
    g.drawRect(475, 925, 25, 25);

    // Red Shape
    g.setColor(Color.red);
    g.fillRect(700, 225, 25, 25);
    g.fillRect(725, 225, 25, 25);
    g.fillRect(750, 225, 25, 25);
    g.fillRect(750, 200, 25, 25);

    // Red Shape Lines
    g.setColor(Color.black);
    g.drawRect(650, 175, 175, 125);
    g.drawRect(700, 225, 25, 25);
    g.drawRect(725, 225, 25, 25);
    g.drawRect(750, 225, 25, 25);
    g.drawRect(750, 200, 25, 25);

    Font stringFont = new Font("TimesRoman", Font.BOLD, 25);

    // Level, Lines, Score Strings
    g.setColor(Color.black);
    g.setFont(stringFont);
    g.drawString("Level:", 650, 500);
    g.drawString("1", 750, 500);
    g.drawString("Lines:", 650, 550);
    g.drawString("0", 750, 550);
    g.drawString("Score:", 650, 600);
    g.drawString("0", 750, 600);
  }

  Tetris() {
    addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    Graphics g = getGraphics();
    Font font = new Font("TimesRoman", Font.BOLD, 40);

    // Pause Button
    g.setColor(Color.blue);
    g.setFont(font);
    g.drawRect(175, 400, 200, 70);
    g.drawString("Pause", 225, 450);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    Graphics g = getGraphics();
    Font font = new Font("TimesRoman", Font.BOLD, 40);

    // Pause Button
    g.setColor(Color.white);
    g.setFont(font);
    g.drawRect(175, 400, 200, 70);
    g.drawString("Pause", 225, 450);
  }

  public static void main(String[] args) {
    Tetris t = new Tetris();
    JFrame frame = new JFrame();
    JButton button = new JButton("QUIT");

    frame.add(t);
    frame.setSize(1800, 2000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout());
    frame.setBackground(Color.white);
    button.setBounds(400, 900, 150, 100);
    frame.add(button);
    button.addActionListener(e -> {
      frame.dispose();
    });
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}