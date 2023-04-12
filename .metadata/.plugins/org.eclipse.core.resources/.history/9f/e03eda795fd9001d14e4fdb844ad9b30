package ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExceptionLogger {

	private static ExceptionLogger instance = null;

	public static ExceptionLogger getInstance() {

		if (instance == null) {
			instance = new ExceptionLogger();
		}
		return instance;
	}

	private ExceptionLogger() {

	}
	
	public synchronized void log(Throwable e) {
		log(null, e);
	}

	public synchronized void log(Object source, Throwable e) {

		try {
			// Write to logfile
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			
			String msg = dateFormat.format(date) + " - ";
			
			if(source != null) {
				 msg += source.getClass().getSimpleName() + " - ";
			}
			
			int idx = 0;

			do {
				msg += "-> ".repeat(idx++);
				msg += e.getClass().getSimpleName() + " - " + e.getMessage() + "\n";
				e = e.getCause();
				
			} while (e != null);

			Files.write(Path.of("cafesanchezlog.txt"), msg.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);

		} catch (IOException ex) {

			ex.printStackTrace();
		}
	}
}
