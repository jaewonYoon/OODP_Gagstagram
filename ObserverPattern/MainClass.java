
public class MainClass {
	public static void main(String[] args) {
		NewsMachine newsMachine = new NewsMachine();
		AnnualSubscriber as = new AnnualSubscriber(newsMachine);
		EventSubscriber es = new EventSubscriber(newsMachine);
		
		newsMachine.setNewsInfo("today's classes are all canceled", "We expect warm weather today");
		newsMachine.setNewsInfo("his is the 23rd Student Government ‘faith’", "Courses opened for this Summer Semester are announced on Hisnet Notice.");
		System.out.println(newsMachine.numberofArray());
		/**Observer한개 탈퇴  **/ 
		newsMachine.delete(es);
		//아직 as는 남아있다!!  
		System.out.println(newsMachine.numberofArray());
		//es가 삭제되었기에 아래의 "삭제하였습니다" 문구는 나오지 않을 것. 
		newsMachine.setNewsInfo("삭제하였습니다.", newsMachine.numberofArray());
		EventSubscriber es2 = new EventSubscriber(newsMachine);
		newsMachine.setNewsInfo("추가하였습니다.", newsMachine.numberofArray());

		
	}
}
