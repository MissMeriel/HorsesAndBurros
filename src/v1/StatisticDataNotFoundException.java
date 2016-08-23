package v1;

import java.time.LocalDate;

/**
 * This exception should be thrown whenever you
cannot find the filename that contains the data
 * @author Meriel Stein, Nolan Lynch
 *
 */
public class StatisticDataNotFoundException extends Exception{

	LocalDate now;
	String filename;
	
	public StatisticDataNotFoundException(String filename){
		super(filename + " not available at "+ LocalDate.now());
		now = LocalDate.now();
		this.filename = filename;
	}
	
	public String getFilename(){
		return filename;
	}
	
	public LocalDate getLocalDate(){
		return now;
	}
}
