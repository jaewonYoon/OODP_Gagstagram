import javax.swing.*;

public class calender {
    public static void main(String[] args) {
    	
    		int mnth;
    		
	        String cal = JOptionPane.showInputDialog("연도");
	        if(!isNumber(cal)) {
	        	JOptionPane.showMessageDialog(null, "숫자가 아닙니다.");
	            return;
	        }
	        int year = Integer.parseInt(cal);        
	        if (year <= 0) {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	 
	        cal = JOptionPane.showInputDialog("월");
	        if(!isNumber(cal)) {
	            JOptionPane.showMessageDialog(null, "숫자가 아닙니다.");
	            return;
	        }
	        int month = Integer.parseInt(cal);
	        if (month > 12 || month < 0) {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	        
	       if(month == 1) {
	    	   mnth = 1;
	    	   printCalender printCal = new printCalender();
	    	   printCal.print(year, mnth);
	       }
	       if(month == 2) {
	    	   mnth = 2;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 3) {
	    	   mnth = 3;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 4) {
	    	   mnth = 4;
	    	   printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 5) {
	    	   mnth = 5;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 6) {
	    	   mnth = 6;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 7) {
	    	   mnth = 7;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 8) {
	    	   mnth = 8;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 9) {
	    	   mnth = 9;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 10) {
	    	   mnth = 10;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 11) {
	    	   mnth = 11;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       if(month == 12) {
	    	   mnth = 12;
		       printCalender printCal = new printCalender();
		       printCal.print(year, mnth);
		   }
	       
	        return;
	    }
	    
	    // 숫자 여부 체크
	    public static boolean isNumber(String str){
	        boolean result = false; 
	        try{
	            Double.parseDouble(str) ;
	            result = true ;
	        }
	        catch(Exception e){
	        } 
	        return result ;
	    }
	 
	    // 해당 년도가 윤년인지 판별
	    public static boolean isLeapYear(int year){
	        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	    }
	     
	    // 해당 달의 첫 요일을 구해서 돌려줌.
	    public int getStartDay(int year, int month){
	        int monthSum = 0;
	        int leapYear = 0;
	        int daySum = 1;
	 
	        for (int i = 1; i < year; i++){
	            monthSum += 365;
	            if (isLeapYear(i) == true) 
	                leapYear += 1;
	        }
	 
	        for (int j = 1; j < month; j++) 
	            daySum += getNumberOfDaysInMonth(year, j);
	 
	        return (monthSum + leapYear + daySum) % 7;
	    }
	 
	    // 달마다 마지막 날짜를 구한다
	    public int getNumberOfDaysInMonth(int year, int month){
	        if (month == 4 || month == 6 || month == 9 || month == 11){
	            return 30;
	        } 
	        else if (month == 2 && isLeapYear(year) == true){
	            return 29;
	        }
	        else if (month == 2 && isLeapYear(year) == false){
	            return 28;
	        } 
	        else{
	            return 31;
	        }
	    }
	} 
