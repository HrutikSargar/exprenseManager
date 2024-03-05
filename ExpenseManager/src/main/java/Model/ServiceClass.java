package Model;

import java.util.Calendar;
import java.util.Date;

//to perform operation regarding date
public class ServiceClass {
	public static void main(String[] args) {
//		Calendar calender=Calendar.getInstance();
//		System.out.println(calender.getActualMinimum(Calendar.DATE));
//		System.out.println(calender.getActualMaximum(calender.DATE));
//		
//		String endpoint="";
//		
//		int date=calender.getActualMaximum(calender.DATE);
//		Date d =new Date();
//		
//		int month=d.getMonth()+1;
//		int year=d.getYear()+1990;
//		
//		endpoint=year+"-"+month+"-"+date;
		
		Calendar calendar=Calendar.getInstance();
		
		int date = calendar.getActualMaximum(calendar.DATE);
		int month = calendar.getActualMaximum(calendar.MONTH);
		int week = calendar.getActualMaximum(calendar.WEEK_OF_MONTH);
		System.out.println(date);
		System.out.println(month);
		System.out.println(week);
		System.out.println("=======================");
		
		
		
		Date d=new Date();
		System.out.println(d.getDay());
		System.out.println(d.getDate());
		System.out.println(d.getMonth()+1);
		System.out.println(d.getYear()+1900);
		System.out.println("==============================");
		System.out.println(startPoint());
		System.out.println(endPoint());
					
	}
	public static String startPoint() {
		Calendar calender=Calendar.getInstance();
//		System.out.println(calender.getActualMinimum(Calendar.DATE));
//		System.out.println(calender.getActualMaximum(calender.DATE));
		
		String startPoint="";
		
		int date=calender.getActualMinimum(calender.DATE);
		Date d =new Date();
		int month=d.getMonth()+1;
		int year=d.getYear()+1900;
		
		
		if(month<10) {
			startPoint=year+"-0"+month+"-0"+date;
		}else {
			startPoint=year+"-"+month+"-0"+date;
		}
		
		return startPoint;
	}
	public static String endPoint() {
		Calendar calender=Calendar.getInstance();
//		System.out.println(calender.getActualMinimum(Calendar.DATE));
//		System.out.println(calender.getActualMaximum(calender.DATE));
		
		String endpoint="";
		
		int date=calender.getActualMaximum(calender.DATE);
		Date d =new Date();
		
		int month=d.getMonth()+1;
		int year=d.getYear()+1900;
		
		if(month<10) {
			endpoint=year+"-0"+month+"-"+date;
		}else {
			endpoint=year+"-"+month+"-"+date;
		}
		
		
		
		return endpoint;
	}
}
