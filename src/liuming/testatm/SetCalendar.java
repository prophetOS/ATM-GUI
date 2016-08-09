package liuming.testatm;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class SetCalendar {
	public SetCalendar(){
		Date now = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-HH mm∑÷ss√Î");
		String date = simp.format(now);
		JOptionPane.showMessageDialog(null, date);
	}
}
