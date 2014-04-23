package hu.jvrs.lion.helper.tests;

import hu.jvrs.leo.helper.statistics.Statistics;

import org.junit.Test;

public class StatisticsTest {
	private String look;
	
	@Test
	public void test(){
		Statistics.startTimer();
		System.out.println(
		Statistics.getProcessId() +
		Statistics.getRandomUniqueId() +
		Statistics.getProcessorCores() +
		Statistics.getFreeMemory() +
		Statistics.getMaxMemory() +
		Statistics.getTotalMemory() +
		Statistics.getFileSystemsNo() +
		Statistics.getMac(Statistics.getIp()) +
		Statistics.getDuration());
	}
	
	@Test
	public void testException(){		
		try{
			look.toString();
			throw new Exception();
		} catch(Exception e) {
			System.out.println("hiba");
		}
		System.out.println("folyamat");
	}
	
//	@Test
//	public void testParam(){	
//		TestClassPerson tcp = new TestClassPerson("Emi", 30);
//		TestClassPerson tcp2 = null;
//		String a = "a";
//		int three = 3;
//		int seven = 7;
//		tcp2 = mod(a,three,seven,tcp, tcp2);
//		System.out.println(a+three+seven);
//		System.out.println(tcp.getAge() + tcp2.getAge());
//	}
//	
//	public TestClassPerson mod(String a, int three, int seven, TestClassPerson tcp, TestClassPerson tcp2){
//		tcp.setAge(31);
//		tcp2 = new TestClassPerson("Szabi", 29);
//		a = "b";
//		three = 4;
//		three++;
//		seven++;
//		return tcp2;
//	}
}
