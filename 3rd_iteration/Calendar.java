import javax.swing.JOptionPane;
 
public class Calendar {
    private static Calendar Instance = new Calendar();
	public Calendar() {
    		
	        String cal = JOptionPane.showInputDialog("����");
	        if(!isNumber(cal)) {
	        	JOptionPane.showMessageDialog(null, "����");
	            return;
	        }
	        int year = Integer.parseInt(cal);        
	        if (year <= 0) {
	            JOptionPane.showMessageDialog(null, "0���� ���� ���Դϴ�.");
	            return;
	        }
	 
	        cal = JOptionPane.showInputDialog("��");
	        if(!isNumber(cal)) {
	            JOptionPane.showMessageDialog(null, "����");
	            return;
	        }
	        int month = Integer.parseInt(cal);
	        if (month > 12 || month < 0) {
	            JOptionPane.showMessageDialog(null, "0���� ���� ���Դϴ�.");
	            return;
	        }
	        
	       if(month == 1) {
	    	   PrintCalendar printCal = new PrintCalendar();
	    	   printCal.print(year, month);
	       }
	       if(month == 2) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 3) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 4) {
	    	   PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 5) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 6) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 7) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 8) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 9) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 10) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 11) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       if(month == 12) {
		       PrintCalendar printCal = new PrintCalendar();
		       printCal.print(year, month);
		   }
	       
	        return;
	    }
	    
	    // ���� ���� üũ
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
	 
	    // �ش� �⵵�� �������� �Ǻ�
	    public static boolean isLeapYear(int year){
	        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	    }
	     
	    // �ش� ���� ù ������ ���ؼ� ������.
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
	 
	    // �޸��� ������ ��¥�� ���Ѵ�
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
	    public static Calendar getinstance() {
	    	if(Instance==null) {
	    		Instance = new Calendar();
	    	}
	    	return Instance; 
	    }
	}
