
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sky extends JFrame {
    private List<Star> stars = new ArrayList<>();

    public List<Star> getStars() {
        return stars;
    }
    
    public void placeStar(Star star) {
        stars.add(star);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Star star : stars) {
            star.draw(graphics);
        }
    }
}