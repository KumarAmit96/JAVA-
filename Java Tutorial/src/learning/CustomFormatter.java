package learning;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

	@Override
	public String format(LogRecord log) {
		Date date=new Date(log.getMillis());
		String level=log.getLevel().getName();
		String message="["+date.toString()+" "+level+"]\n";
		message+= log.getMessage()+" \n\n";
		Throwable thr=log.getThrown();
		if(thr!=null)
			message+=thr.toString();
		return message;
	}

}
