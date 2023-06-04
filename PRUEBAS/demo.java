package PRUEBAS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.jfree.util.Log;

public class demo {
	
	static Scanner leer = new Scanner(System.in);
	public static void main(String[] args) {
       
		
	
		System.out.print("Escribe la fecha");
		int n=leer.nextInt();
		
		String SN=Integer.toString(n);
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		try {
		    Date dt = sdf.parse(SN);
		    sdf = new SimpleDateFormat("hh:mm");
		    SN=sdf.format(dt);
		    System.out.println(SN);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		
		
          
	}
	

	}
