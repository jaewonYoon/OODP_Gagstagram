import javax.swing.JOptionPane;
 
public class Calendar{
    public static void calendar() {
    		
	        String cal = JOptionPane.showInputDialog("연도");
	        if(!isNumber(cal)) {
	        	JOptionPane.showMessageDialog(null, "오류");
	            return;
	        }
	        int year = Integer.parseInt(cal);        
	        if (year <= 0) {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	 
	        cal = JOptionPane.showInputDialog("월");
	        if(!isNumber(cal)) {
	            JOptionPane.showMessageDialog(null, "오류");
	            return;
	        }
	        int month = Integer.parseInt(cal);
	        if (month > 12 || month < 0) {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	    	
	        if(month==3 || month==4 || month==5) {
	        	Spring spr = new Spring();
	        	spr.printcal(year,month);
	        }	
	        if(month==6|| month==7|| month==8) {
	        	Summer sum = new Summer();
	        	sum.printcal(year, month);
	        }	
	        if(month==9 || month==10|| month==11) {
	        	Fall fal = new Fall();
	        	fal.printcal(year, month);
	        }	
	        if(month==1 || month==2 || month==12) {
	        	Winter win = new Winter();
	        	win.printcal(year, month);
	        }
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
