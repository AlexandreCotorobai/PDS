package thermoMVC.view;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import thermoMVC.model.Thermometer;
import thermoMVC.model.ThermometerListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A thermometer that displays as a digital thermometer.
 */
public class ThermRegist extends JPanel implements ThermometerListener {

	// The Unicode symbol for degrees
	private static final char DEGREE_SYMBOL = '\u00B0';

	/** The thermometer whose temperature is being displayed */
	protected Thermometer thermometer;
	protected String filename;

	/**
	 * Creates a digital thermometer
	 * 
	 * @param t the thermometer whose temperature is displayed
	 */
	public ThermRegist(Thermometer t, String file) {
		thermometer = t;
		filename = file;


		// delete file if exists, this way every time you get a clean regist
		// if you want to keep the regist just comment the next lines
		if (file == null) {
            System.out.println("File not found");
        } else {
            File f = new File(file);
            if (f.exists()) {
                if (f.delete()) {
                    System.out.println("File deleted");
                } else {
                    System.out.println("Failed to delete file");
                }
			}
		}

	}

	/**
	 * Create the string to display in the thermometer
	 * 
	 * @return the string to display in the thermometer
	 */
	private String getDisplayString() {
		return "" + thermometer.getTemperature() + DEGREE_SYMBOL + "F";
	}

	/**
	 * Change the temperature displayed
	 */
	@Override
	public void temperatureChanged() {
		// write temperature in file
		try{
			FileWriter fw = new FileWriter(filename, true);
			fw.write(getCurrentTime() + " -> " + getDisplayString() + "\n");
			fw.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

		
	}

	private String getCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date currentTime = new Date();
		return dateFormat.format(currentTime);
	}
}
