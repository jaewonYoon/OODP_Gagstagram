import javax.swing.JOptionPane;

public class calender {
    public static void main(String[] args) {
	 
	        // 년,월 입력 -> factory, factory method...?
	        String cal = JOptionPane.showInputDialog("연도");
	        if(!isNumber(cal))
	        {
	        	JOptionPane.showMessageDialog(null, "숫자가 아닙니다.");
	            return;
	        }
	        int year = Integer.parseInt(cal);        
	        if (year <= 0) {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	 
	        cal = JOptionPane.showInputDialog("월");
	        if(!isNumber(cal))
	        {
	            JOptionPane.showMessageDialog(null, "숫자가 아닙니다.");
	            return;
	        }
	        int month = Integer.parseInt(cal);
	        if (month > 12 || month < 0) 
	        {
	            JOptionPane.showMessageDialog(null, "0보다 작은 수입니다.");
	            return;
	        }
	 
	        printCalender(year, month);
	        return;
	    }
	    
	    // 숫자 여부 체크
	    public static boolean isNumber(String str)
	    {
	        boolean result = false; 
	        try
	        {
	            Double.parseDouble(str) ;
	            result = true ;
	        }
	        catch(Exception e)
	        {
	        	
	        } 
	        return result ;
	    }
	     
	    
	    // 달력의 타이틀과 바디
	    private static void printCalender(int year, int month) 
	    {
	        printMonthForm(year, month);
	        printMonthBody(year, month);
	    }
	 
	    // 해당 년도가 윤년인지 판별
	    public static boolean isLeapYear(int year) {
	        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	    }
	 
	    // 달력 바디 출력
	    private static void printMonthBody(int year, int month) 
	    {
	        int count = 0;
	 
	        for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) 
	        {
	            if (i < 2) 
	            {
	                for (int y = 1; y <= getStartDay(year, month); y++) 
	                {
	                    System.out.print("\t ");
	                    count += 1;
	                }
	            }
	 
	            System.out.printf("\t %2d", i);
	            count += 1;
	            if (count == 7) 
	            {
	                System.out.println();
	                count = 0;
	            }
	        }
	    }
	 
	    // 해당 달의 첫 요일을 구해서 돌려줌.
	    private static int getStartDay(int year, int month) {
	        int monthSum = 0;
	        int leapYear = 0;
	        int daySum = 1;
	 
	        for (int i = 1; i < year; i++) {
	            monthSum += 365;
	            if (isLeapYear(i) == true) {
	                leapYear += 1;
	            }
	        }
	 
	        for (int j = 1; j < month; j++) {
	            daySum += getNumberOfDaysInMonth(year, j);
	        }
	 
	        return (monthSum + leapYear + daySum) % 7;
	 
	    }
	 
	    // 달마다 마지막 날짜를 구한다  => factory, factory method
	    private static int getNumberOfDaysInMonth(int year, int month) {
	 
	        if (month == 4 || month == 6 || month == 9 || month == 11) {
	            return 30;
	        } else if (month == 2 && isLeapYear(year) == true) {
	            return 29;
	        } else if (month == 2 && isLeapYear(year) == false) {
	            return 28;
	        } else {
	            return 31;
	        }
	    }
	 
	    // 출력 포맷
	    private static void printMonthForm(int year, int month) 
	    {
	        System.out.println();
	        System.out.println("\t" + year + "년\t\t\t\t\t\t" + getMonth(month));
	        System.out.println("\t===================================================");
	        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
	        System.out.println("\t===================================================");
	    }
	    
	    //factory,factory method, 계절별로 색을 다르게 한다 ?
	    private static String getMonth(int month) 
	    {
	        String monthName = null;
	        if (month==1) 
	            monthName = "1월";
	        else if(month==2)
	            monthName = "2월";
	        else if(month==3)
	            monthName = "3월";
	        else if(month==4)
	            monthName = "4월";
	        else if(month==5)
	            monthName = "5월";
	        else if(month==6)
	            monthName = "6월";
	        else if(month==7)
	            monthName = "7월";
	        else if(month==8)
	            monthName = "8월";
	        else if(month==9)
	            monthName = "9월";
	        else if(month==10)
	            monthName = "10월";
	        else if(month==11)
	            monthName = "11월";
	        else
	            monthName = "12월";
	        return monthName;
	    }
	}
