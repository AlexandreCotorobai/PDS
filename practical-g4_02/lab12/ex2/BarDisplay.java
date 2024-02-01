import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import thermoMVC.model.Thermometer;
import thermoMVC.model.ThermometerListener;

public class BarDisplay extends JPanel implements ThermometerListener {
    private static final int BAR_WIDTH = 20;
    private static final int BAR_HEIGHT = 200;

    private final Thermometer thermometer;
    private int currentTemperature;

    public BarDisplay(Thermometer thermometer) {
        this.thermometer = thermometer;
        this.currentTemperature = thermometer.getTemperature();
        thermometer.addThermometerListener(this);

        setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
    }

    @Override
    public void temperatureChanged() {
        currentTemperature = thermometer.getTemperature();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int barFillHeight = (int) ((double) currentTemperature / thermometer.getMaximum() * BAR_HEIGHT);
        int barY = BAR_HEIGHT - barFillHeight;

        g.setColor(Color.RED);
        g.fillRect(0, barY, BAR_WIDTH, barFillHeight);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, BAR_WIDTH, BAR_HEIGHT);

        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(Integer.toString(thermometer.getMinimum()), 2, BAR_HEIGHT + 12);
        g.drawString(Integer.toString(thermometer.getMaximum()), 2, 12);
        g.drawString(Integer.toString(currentTemperature), 2, barY - 5);
    }
}
