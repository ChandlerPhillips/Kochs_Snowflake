//Chandler Phillips
//Koch's Snowflake
import java.awt.*;
import javax.swing.*;

public class Snowflake extends JFrame {

    private double sin60 = -0.8660254;

    public Snowflake() {
        super("Koch's Snowflake Example | Depth = 4");
        setSize(580, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.CYAN);
        repaint();
        
    }

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Point pointOne = new Point(120, 320);
        Point pointTwo = new Point(440, 320);
        Point pointThree = new Point(280, 40);
        drawFlake(g, 4, pointOne, pointTwo, pointThree);
    }

    private void drawFlake(Graphics g, int lev, Point p1, Point p2, Point p3) {
        drawKochCurve(g, lev, p1, p2);
        drawKochCurve(g, lev, p2, p3);
        drawKochCurve(g, lev, p3, p1);
    }

    private void drawKochCurve(Graphics g, int depth, Point p1, Point p2) {
        if (depth == 0) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        if (depth >= 1) {
            Point distance = new Point((p2.x - p1.x) / 3, (p2.y - p1.y) / 3);
            Point point1 = new Point(p1.x + distance.x, p1.y + distance.y);
            Point point2 = new Point(p2.x - distance.x, p2.y - distance.y);
            Point tip = new Point(point1.x + (int) (distance.x * 0.5 + distance.y * sin60),point1.y + (int) (distance.y * 0.5 - distance.x * sin60));
            drawKochCurve(g, depth - 1, p1, point1);
            drawKochCurve(g, depth - 1, point1, tip);
            drawKochCurve(g, depth - 1, tip, point2);
            drawKochCurve(g, depth - 1, point2, p2);
        }
    }
}
