package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import model.util.Data;

public class Program {

	public static void main(String[] args){
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar gc = new GregorianCalendar();		
		Scanner sc = new Scanner(System.in);
		
		try {
		Date date = sdf.parse(sc.nextLine());
		Date currentDate = new Date();
		
		gc.setTime(currentDate);
		gc.add(Calendar.DAY_OF_MONTH, -1);
		
		while(date.before(gc.getTime())) {
			System.out.print("Please type a valid date: ");
			date = sdf.parse(sc.nextLine());
		}
		
		
		gc.setTime(date);
		
		System.out.println("The day you typed is " + gc.get(Calendar.DAY_OF_MONTH));
		System.out.println("The month you typed is "+ Data.month(gc.get(Calendar.MONTH)));
		System.out.println("The year you typed is "+ gc.get(Calendar.YEAR));
		System.out.println();
		System.out.println("The week of the year is "+ gc.get(Calendar.WEEK_OF_YEAR));
		gc.add(Calendar.MONTH, 1);
		System.out.println("The next month will be "+ Data.month(gc.get(Calendar.MONTH)));
		
		}
		catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
		sc.close();
		} 
	}

}
