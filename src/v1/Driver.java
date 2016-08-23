package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

//serialization slide 67 onward
public class Driver //throws IndexOutOfBoundsException,IOException
{
	
	//double-check exception handling

	/** the relative pathway to the file; rel. pathways allow for more flexiblity between machines */
	final static String filename = //"E:\\School\\Spring 2016\\OOPDA\\Horses and Burros\\" +
			 "src/herdManagement.csv";
	final static int headerRows = 3;
	
	public static void main(String[] args){
		DataSet ds = new DataSet();
		try{
			loadStatistics(ds, filename, headerRows);
			displayStatistics(ds);
			Random rand = new Random();
			StateStatistic stateStat = ((StateStatistic)ds.getStats().get(rand.nextInt(ds.getStats().size()) - 1));
			stateStat.serialize();
			StateStatistic newStateStat = stateStat.deserialize();
			System.out.println("There are " + newStateStat.getNumBurros() + " burros and " + 
								newStateStat.getNumHorses() + " horses in " + newStateStat.getState()+".");
		}
		catch(StatisticDataNotFoundException e){
			e.getMessage();
			e.printStackTrace();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		//lecture 9 slide 73 to serialize
	} // end main

	static void loadStatistics(DataSet ds, String filename, int headerRows) throws StatisticDataNotFoundException, FileNotFoundException, IOException{

			BufferedReader br = new BufferedReader(new FileReader(filename));

			// skip the first three lines of the file (title, linebreak,
			// headers)
			for(int i = 1; i <= headerRows; i++) {
				br.readLine();
			}
			
			// Read each line of data and split the line into an array of
			// Strings
			String delims = ",";
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] lineArray = line.split(delims);
				ds.addStatistic(new StateStatistic(State.valueOf(lineArray[0]), Long.parseLong(lineArray[1]),
						Long.parseLong(lineArray[2]), Long.parseLong(lineArray[3]), Long.parseLong(lineArray[4]),
						Long.parseLong(lineArray[5]), Long.parseLong(lineArray[6])));
			} // end while
			
	}// loadStatistics

	static void displayStatistics(DataSet ds) {
		// Display  each StateStatistic instance loaded into the dataset in a row
		for(Statistic s : ds.getStats()) {
			System.out.println(((StateStatistic)s).getState().toString() + ", " +
							   ((StateStatistic)s).getHerdAreaAcresBLM() + ", " +
							   ((StateStatistic)s).getHerdAreaAcresOther() + ", " +
							   ((StateStatistic)s).getHerdManagementAreaAcresBLM() + ", " +
							   ((StateStatistic)s).getHerdManagementAreaAcresOther() + ", " +
							   ((StateStatistic)s).getNumHorses() + ", " +
							   ((StateStatistic)s).getNumBurros());
		}
		System.out.println("");
		System.out.println("");
	} // end displaystatistics

} // end Driver
