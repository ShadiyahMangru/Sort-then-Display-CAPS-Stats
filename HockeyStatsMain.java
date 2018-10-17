import java.util.*;
import java.io.*;

class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	
	//constructors
	public HockeyPlayer(String lastName, String position){
		this.lastName = lastName;
		this.position = position;
	}
	
	public HockeyPlayer(HockeyPlayer hp){
		this(hp.lastName, hp.position);
	}
	
	//setters
	public void setLastName(String lastName){
		this.lastName = lastName;	
	}
	
	public void setPosition(String position){
		this.position = position;	
	}
	
	//getters
	public String getLastName(){
		return lastName;	
	}
	
	public String getPosition(){
		return position;	
	}
	
	//print
	public String printPositionDetails(){
		return "\nName: " + lastName + "\tPosition: " + position;
	}
}


class Goalies extends HockeyPlayer implements Comparable<Goalies>{
	//fields
	private int shotsAgainst;
	private int goalsAgainst;
	private int saves;
	private ArrayList<Goalies> goaliesRoster;
	private static int sortGoaliesBy;
	
	//constructors
	public Goalies(){
		super(" ", " ");
		setGoaliesRoster();	
	}
	
	public Goalies(int sortGoaliesBy){
		super(" ", " ");
		setGoaliesRoster();
		this.sortGoaliesBy = sortGoaliesBy;
	}
	
	public Goalies(String lastName, String position, int shotsAgainst, int goalsAgainst, int saves){
		super(lastName, position);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	public Goalies(HockeyPlayer hp, int shotsAgainst, int goalsAgainst, int saves){
		super(hp);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
	}
	
	/**
	* a method that defines how to sort Goalies numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Goalies other) {
    	switch(sortGoaliesBy){
    	case 1:
    		if (this.getShotsAgainst() < other.getShotsAgainst()) {
    			return -1;
    		}
    		if (this.getShotsAgainst() == other.getShotsAgainst()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoalsAgainst() < other.getGoalsAgainst()) {
    			return -1;
    		}
    		if (this.getGoalsAgainst() == other.getGoalsAgainst()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getSaves() < other.getSaves()) {
    			return -1;
    		}
    		if (this.getSaves() == other.getSaves()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
	
	//setters
	public void setShotsAgainst(int shotsAgainst){
		this.shotsAgainst = shotsAgainst;	
	}
	
	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;	
	}
	
	public void setSaves(int saves){
		this.saves = saves;	
	}
	
	public void setGoaliesRoster(){
		goaliesRoster = new ArrayList<Goalies>();
		goaliesRoster.add(new Goalies("Holtby", "Goalie", 1648, 153, 1495));
		goaliesRoster.add(new Goalies("Grubauer", "Goalie", 953, 73, 880));
	}
	
	//getters
	public int getShotsAgainst(){
		return shotsAgainst;	
	}
	
	public int getGoalsAgainst(){
		return goalsAgainst;	
	}
	
	public int getSaves(){
		return saves;	
	}
	
	public ArrayList<Goalies> getGoaliesRoster(){
		return goaliesRoster;
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tShots Against: " + shotsAgainst + "\tGoals Against: " + goalsAgainst + "\tSaves: " + saves;
	}
}


class Skaters extends HockeyPlayer implements Comparable<Skaters>{
	//fields
	private int goals;
	private int assists;
	private int points;
	private int plusMinus;
	private ArrayList<Skaters> skatersRoster;
	private static int sortSkatersBy;
	
	//constructors
	public Skaters(){
		super(" ", " ");
		setSkatersRoster();	
	}
	
	public Skaters(int sortSkatersBy){
		super(" ", " ");
		setSkatersRoster();
		this.sortSkatersBy = sortSkatersBy;
	}
	
	public Skaters(String lastName, String position, int goals, int assists, int points, int plusMinus){
		super(lastName, position);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	public Skaters(HockeyPlayer hp, int goals, int assists, int points, int plusMinus){
		super(hp);
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.plusMinus = plusMinus;
	}
	
	/**
	* a method that defines how to sort Skaters numerically by a stat
	* @param Player the player to which we are comparing
	*/
	@Override
    	public int compareTo(Skaters other) {
    	switch(sortSkatersBy){
    	case 1:
    		if (this.getPoints() < other.getPoints()) {
    			return -1;
    		}
    		if (this.getPoints() == other.getPoints()) { 
    			return 0;
    		}
    		break;
   	case 2:
    		if (this.getGoals() < other.getGoals()) {
    			return -1;
    		}
    		if (this.getGoals() == other.getGoals()) { 
    			return 0;
    		}
    		break;
    	case 3:
    		if (this.getAssists() < other.getAssists()) {
    			return -1;
    		}
    		if (this.getAssists() == other.getAssists()) { 
    			return 0;
    		}
    		break;
    	case 4:
    		if (this.getPlusMinus() < other.getPlusMinus()) {
    			return -1;
    		}
    		if (this.getPlusMinus() == other.getPlusMinus()) { 
    			return 0;
    		}
    		break;
    	}
    	return 1;
    	}
		
	//setters
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setPoints(int points){
		this.points = points;	
	}
	
	public void setPoints(int goals, int assists){
		points = goals + assists;	
	}
	
	public void setPoints(){
		points = goals + assists;	
	}
	
	public void setPlusMinus(int plusMinus){
		this.plusMinus = plusMinus;	
	}
	
	public void setSkatersRoster(){
		skatersRoster = new ArrayList<Skaters>();
		skatersRoster.add(new Skaters("Ovechkin", "Forward, LW", 49, 38, 87, 3));
		skatersRoster.add(new Skaters("Kuznetsov", "Forward, C", 27, 56, 83, 3));
		skatersRoster.add(new Skaters("Backstrom", "Forward, C", 21, 50, 71, 5));
		skatersRoster.add(new Skaters("Carlson", "Defense", 15, 53, 68, 0));
		skatersRoster.add(new Skaters("Oshie", "Forward, RW", 18, 29, 47, 2));
		skatersRoster.add(new Skaters("Eller", "Forward, C", 18, 20, 38, -6));
	}
	
	//getters
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;
	}	
	
	public int getPoints(){
		return points;	
	}
	
	public int getPlusMinus(){
		return plusMinus;	
	}
	
	public ArrayList<Skaters> getSkatersRoster(){
		return skatersRoster;	
	}
	
	//print
	@Override
	public String printPositionDetails(){
		return super.printPositionDetails() + "\tGoals: " + goals + "\tAssists: " + assists + "\tPoints: " + points + "\t+/-: " + plusMinus;
	}
}


class SortStatsGoalies extends Goalies{
	//fields
	private ArrayList<Goalies> goaliesSorted;
	
	//constructors
	SortStatsGoalies(){
	}
	
	SortStatsGoalies(int g){
		Goalies gl = new Goalies(g);
		setGoaliesSorted();
	}
	
	//setters
	public void setGoaliesSorted(){
		goaliesSorted = new ArrayList<Goalies>(getGoaliesRoster());
		Collections.sort(goaliesSorted);
	}
	
	//getters
	public ArrayList<Goalies> getGoaliesSorted(){
		return goaliesSorted;	
	}
}


class SortStatsSkaters extends Skaters{
	//fields
	private ArrayList<Skaters> skatersSorted;
	
	//constructors
	SortStatsSkaters(){
	}
	
	SortStatsSkaters(int s){
		Skaters sk = new Skaters(s);
		setSkatersSorted();
	}
	
	//setters
	public void setSkatersSorted(){
		skatersSorted = new ArrayList<Skaters>(getSkatersRoster());
		Collections.sort(skatersSorted);
	}
	
	//getters
	public ArrayList<Skaters> getSkatersSorted(){
		return skatersSorted;	
	}
}


abstract class RosterOutput{		
	public static void printRosterDetails(){
		Skaters skaters = new Skaters();
		for(Skaters s : skaters.getSkatersRoster()){
			System.out.println("Name: " + s.getLastName() + "\tPosition: " + s.getPosition() + "\tGoals: " + s.getGoals() + "\tAssists: " + s.getAssists() + "\tPoints: " + s.getPoints() + "\t+/-: " + s.getPlusMinus());	
		}
		Goalies goalies = new Goalies();
		System.out.println();
		for(Goalies g : goalies.getGoaliesRoster()){
			System.out.println("Name: " + g.getLastName() + "\tPosition: " + g.getPosition() + "\tShots Against: " + g.getShotsAgainst() + "\tGoals Against: " + g.getGoalsAgainst() + "\tSaves: " + g.getSaves());	
		}
	}
}


abstract class SortOutput{
	//constructor
	private SortOutput(){
	}
	
	//prints an arrayList of skaterStats
	public static void printSkaters(ArrayList<Skaters> sRoster){
		System.out.println("  POINTS:\t+/-:\tGOALS:\tASSISTS\tPLAYERS:  ");
		for(int i=(sRoster.size() - 1); i>=0; i--){
			System.out.println("  " + sRoster.get(i).getPoints() + "\t\t" + sRoster.get(i).getPlusMinus() + "\t" + sRoster.get(i).getGoals() + "\t" + sRoster.get(i).getAssists() + "\t" + sRoster.get(i).getLastName());	
		}		
	}
	
	//prints an arrayList of goalieStats
	public static void printGoalies(ArrayList<Goalies> gRoster){
		System.out.println("  SHOTS AGAINST:\tGOALS AGAINST:\tSAVES:\t\tPLAYERS:  ");
		for(int i=(gRoster.size() - 1); i>=0; i--){
			System.out.println("  " + gRoster.get(i).getShotsAgainst() + "\t\t\t" + gRoster.get(i).getGoalsAgainst() + "\t\t" + gRoster.get(i).getSaves() + "\t\t" + gRoster.get(i).getLastName());	
		}		
	}
	
	/**
	* a method that outputs a menu to select type of sorted stats to display on screen
	*/
	public static void userOptions(){
		System.out.println();
		System.out.println("**********************************************************************************");
		System.out.println("WELCOME TO 2017-2018 WASHINGTON CAPITALS' (SOME) REGULAR SEASON STATS SORTER!");
		System.out.println("\nSelect a sort by option:\n1.) Points \n2.) Goals\n3.) Assists \n4.) +/- \n5.) Shots Against \n6.) Goals Against \n7.) Saves\n\n8.) Exit");
		System.out.println("\n*********************************************");
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
			System.out.println();
				switch(userChoice){
					case 1: System.out.println("  You selected: Sort Washington Capitals' Stats by POINTS");
						SortStatsSkaters p = new SortStatsSkaters(1);
						SortOutput.printSkaters(p.getSkatersSorted() );
						userOptions();
						break;
					case 2: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS");
						SortStatsSkaters g = new SortStatsSkaters(2);
						SortOutput.printSkaters(g.getSkatersSorted() );
						userOptions();
						break;
					case 3: System.out.println("  You selected: Sort Washington Capitals' Stats by ASSISTS");
						SortStatsSkaters a = new SortStatsSkaters(3);
						SortOutput.printSkaters(a.getSkatersSorted() );
						userOptions();
						break;
					case 4: System.out.println("  You selected: Sort Washington Capitals' Stats by +/-");
						SortStatsSkaters pm = new SortStatsSkaters(4);
						SortOutput.printSkaters(pm.getSkatersSorted() );
						userOptions();
						break;
					case 5: System.out.println("  You selected: Sort Washington Capitals' Stats by SHOTS AGAINST");
						SortStatsGoalies sa = new SortStatsGoalies(1);
						SortOutput.printGoalies(sa.getGoaliesSorted() );
						userOptions();
						break;
					case 6: System.out.println("  You selected: Sort Washington Capitals' Stats by GOALS AGAINST");
						SortStatsGoalies ga = new SortStatsGoalies(2);
						SortOutput.printGoalies(ga.getGoaliesSorted() );
						userOptions();
						break;
					case 7: System.out.println("  You selected: Sort Washington Capitals' Stats by SAVES");
						SortStatsGoalies s = new SortStatsGoalies(3);
						SortOutput.printGoalies(s.getGoaliesSorted() );
						userOptions();
						break;
					case 8: System.out.print("  You selected: EXIT");
						System.exit(0);
						break;
					default: userOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
		userOptions();
		}
	}
}


public class HockeyStatsMain{
	//constructor
	public HockeyStatsMain(){	
	}
	
	//main method
	public static void main(String... args){
		System.out.println("************************************************");
		System.out.println("SOME 2017-2018 REGULAR SEASON STATS:\n");
		RosterOutput.printRosterDetails();
		
		
		SortOutput.userOptions();
	}
}