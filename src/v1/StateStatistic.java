package v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This class will manage statistics for USA Herd Management data
 * 
 * Herd Areas (HAs) are those geographic areas where wild horses and/or burros
 * were found at the passage of the Wild Horse and Burros Act in 1971.
 * 
 * Herd Management Areas (HMAs) are those areas within Herd Areas where the
 * decision has been made, through Land Use Plans, to manage for populations of
 * wild horses and/or burros.
 * 
 * BLM stands for the Bureau of Land Management
 * 
 * @author myersjac, Nolan Lynch, Meriel Stein
 *
 */
public class StateStatistic extends Statistic implements Serializable {

	/** the serialization ID */
	private static final long serialVersionUID = 1L;

	/** the state that contains herds of horses and burros **/
	private State state;

	/** the number of acres that contain horses and burros overseen by the BLM **/
	private long herdAreaAcresBLM;

	/**
	 * the number of acres that contain horses and burros not overseen by the
	 * BLM
	 **/
	private long herdAreaAcresOther;

	/**
	 * the subset of herdAreaAcres overseen by the BLM where population
	 * management is active
	 **/
	private long herdManagementAreaAcresBLM;

	/**
	 * the subset of herdAreaAcres not overseen by the BLM where population
	 * management is active
	 **/
	private long herdManagementAreaAcresOther;

	/** the number of wild horses in the state **/
	private long numHorses;

	/** the number of wild burros in the state **/
	private long numBurros;

	/** the relative pathway to the serialized file **/
	private static String FILE_NAME = // "E:\\School\\Spring 2016\\OOPDA\\Horses
										// and Burros\\
	"src/serializedState.ser";

	/**
	 * the full argument constructor
	 * 
	 * @param state
	 *            the state that contains herds of horses and burros
	 * @param herdAreaAcresBLM
	 *            the number of acres that contain horses and burros overseen by
	 *            the BLM
	 * @param herdAreaAcresOther
	 *            the number of acres that contain horses and burros not
	 *            overseen by the BLM
	 * @param herdManagementAreaAcresBLM
	 *            the subset of herdAreaAcres overseen by the BLM where
	 *            population management is active
	 * @param herdManagementAreaAcresOther
	 *            the subset of herdAreaAcres not overseen by the BLM where
	 *            population management is active
	 * @param numHorses
	 *            the number of wild horses in the state
	 * @param numBurros
	 *            the number of wild burros in the state
	 */
	public StateStatistic(State state, long herdAreaAcresBLM,
			long herdAreaAcresOther, long herdManagementAreaAcresBLM,
			long herdManagementAreaAcresOther, long numHorses, long numBurros) {
		super();
		this.state = state;
		this.herdAreaAcresBLM = herdAreaAcresBLM;
		this.herdAreaAcresOther = herdAreaAcresOther;
		this.herdManagementAreaAcresBLM = herdManagementAreaAcresBLM;
		this.herdManagementAreaAcresOther = herdManagementAreaAcresOther;
		this.numHorses = numHorses;
		this.numBurros = numBurros;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	herdAreaAcresBLM
	 */
	public long getHerdAreaAcresBLM() {
		return herdAreaAcresBLM;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param herdAreaAcresBLM
	 *            the herdAreaAcresBLM to set
	 */
	public void setHerdAreaAcresBLM(long herdAreaAcresBLM) {
		this.herdAreaAcresBLM = herdAreaAcresBLM;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	herdAreaAcresOther
	 */
	public long getHerdAreaAcresOther() {
		return herdAreaAcresOther;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param herdAreaAcresOther
	 *            the herdAreaAcresOther to set
	 */
	public void setHerdAreaAcresOther(long herdAreaAcresOther) {
		this.herdAreaAcresOther = herdAreaAcresOther;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	herdManagementAreaAcresBLM
	 */
	public long getHerdManagementAreaAcresBLM() {
		return herdManagementAreaAcresBLM;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param herdManagementAreaAcresBLM
	 *            the herdManagementAreaAcresBLM to set
	 */
	public void setHerdManagementAreaAcresBLM(long herdManagementAreaAcresBLM) {
		this.herdManagementAreaAcresBLM = herdManagementAreaAcresBLM;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	herdManagementAreaAcresOther
	 */
	public long getHerdManagementAreaAcresOther() {
		return herdManagementAreaAcresOther;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param herdManagementAreaAcresOther
	 *            the herdManagementAreaAcresOther to set
	 */
	public void setHerdManagementAreaAcresOther(
			long herdManagementAreaAcresOther) {
		this.herdManagementAreaAcresOther = herdManagementAreaAcresOther;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	numHorses
	 */
	public long getNumHorses() {
		return numHorses;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param numHorses
	 *            the numHorses to set
	 */
	public void setNumHorses(long numHorses) {
		this.numHorses = numHorses;
	}

	/**
	 * Standard accessor method
	 * 
	 * @return	numBurros
	 */
	public long getNumBurros() {
		return numBurros;
	}

	/**
	 * Standard mutator method
	 * 
	 * @param numBurros
	 *            the numBurros to set
	 */
	public void setNumBurros(long numBurros) {
		this.numBurros = numBurros;
	}

	/**
	 * Serializes the object it is called upon to FILE_NAME
	 * 
	 */
	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream(FILE_NAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
			
			//Printing out the filepath seems to be standard in serialize() methods
			System.out.println(
					"Serialized data of StateStatistic object is saved in "+
					FILE_NAME);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	/** Deserializes StateStatistic object written to FILE_NAME
	 * 
	 * @return StateStatistic	object serialized to FILE_NAME
	 */
	public StateStatistic deserialize() {
		StateStatistic ss = null;
		try {
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ss = (StateStatistic) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println("There are " + ss.getNumHorses() + " horses and "
//				+ ss.getNumBurros() + " burros in " + ss.state + ".");
		return ss;
	}

}
