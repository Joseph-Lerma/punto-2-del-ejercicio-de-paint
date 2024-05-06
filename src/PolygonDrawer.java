import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PolygonDrawer extends JFrame {
    private ArrayList<Point> points;

    public PolygonDrawer() {
        setTitle("Dibujar poligono");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        points = new ArrayList<>();

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (points.size() > 1) {
                    for (int i = 1; i < points.size(); i++) {
                        g.drawLine(points.get(i - 1).x, points.get(i - 1).y, points.get(i).x, points.get(i).y);
                    }
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                points.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PolygonDrawer drawer = new PolygonDrawer();
            drawer.setVisible(true);
        });
    }
}