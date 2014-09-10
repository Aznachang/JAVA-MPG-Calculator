package MPG;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MPG_Data {
	
	//Fields 
	private double total_mpg;
	private double avg_mpg;
	private double mpg_counter;		//counts how many fuel adds
	private double last_mpg;			//last mpg
	private String last_date;			//last date
	private String dates;
	private String mpgs;
	private String mpgList = "";
		
	//Constructor
	public MPG_Data()
	{
		total_mpg = 0;
		mpg_counter = 0;
	}

	//Total Score Method
	public void Total_MPG(List<String> mpg)
	{
		//variables
		int m;				//print index for dates
		double temp = 0; 	//temporary variable for comparing date
		double date_cvt;  
		String year = "";
		
		//odd entries - Scores
		for(int n=0; n < mpg.size(); n+=2)
		{
			total_mpg+= Double.parseDouble(mpg.get(n));
			mpgs = mpg.get(n);		//mpg
			m = n + 1;				//even elements -dates
			dates = mpg.get(m);		//date
			
			mpgList += "MPG: " + mpgs + "  (" + dates + ") \n";
			mpg_counter++;
			
			//Get last date and score
			//First convert string date into year/month/day		
			String day = dates.substring(3,5);   
			String month = dates.substring(0,2); 
			
			//ONLY ACCEPT this Date Format: MM/dd/yyyy
			if (dates.length() == 10){
				year = dates.substring(6,10); 
			}
			//Prompts user for correct Date Format: MM/dd/yyyy
			else {
				JOptionPane.showMessageDialog(null,"Must Enter Correct Date Format: MM/dd/yyyy!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			date_cvt = Double.parseDouble(year + month + day);  
			
			//save the bigger 'converted' date to the 'temp' variable
			if (temp < date_cvt) 
			{
				temp = date_cvt;
				last_date = dates;
				last_mpg = Double.parseDouble(mpgs);
			}
		}
	}	
	
	//Method for Date format validation
	public boolean isValidDate(String in_Date) {
	    SimpleDateFormat myDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    myDateFormat.setLenient(false);
	    
	    try {
	        myDateFormat.parse(in_Date);
	    } 
	    catch (ParseException e) {
	    	return false;
	    }
	    return true;
	}
	
	public String AllMPG()
	{
		return mpgList;
	}

	public String Dates()
	{
		return dates;
	}

	public String MPG()
	{
		return mpgs;
	}

	//Average Score Method
	public double Avg_MPG()
	{	
		//Calculate average bowling score
		avg_mpg = total_mpg / mpg_counter;
		return avg_mpg;
	}
		
	//Print out Last Score Game
	public double Last_MPG()
	{
		return last_mpg; 
	}

	//Print out Last Date Game
	public String Last_Date()
	{
		return last_date;
	}

}
