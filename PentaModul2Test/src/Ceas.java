import java.util.Scanner;
import java.util.stream.Stream;

public class Ceas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Input for hour: ");
//		Scanner scan = new Scanner(System.in);
//		Integer hour = scan.nextInt();
//		
//		System.out.println("Input for minutes: ");
//		Integer minutes = scan.nextInt();
//		
//		System.out.println("Input for seconds: ");
//		Integer seconds = scan.nextInt();
		
		Ceas  ceas = new Ceas();
		System.out.println(ceas.convertTime("15:42:22"));
	}
	
	
	
	private String getSeconds(int seconds) {
		if(seconds%2==0)
			return "Y";
		else
			return "O";
		}
	
	private String OreSus(int nr) {
		return gOnOff(4, gOreSusSemne(nr));
	}
	
	private String OreJos(int nr) {
		return gOnOff(4, nr%5); // gOnOff - 4 lampi, nr%5 semneON;
	}
	
	private String MinuteSus(int nr) {
		return OnOff(11, gOreSusSemne(nr),"Y").replaceAll("YYY", "YYR"); 
	}
	
	private String MinuteJos(int nr) {
		return OnOff(4, nr%5, "Y");
	}
	
	private String gOnOff(int lampi, int SemneON) {
		return OnOff(lampi, SemneON, "R");
	}
	
	private String OnOff(int lampi, int SemneON, String onSing) {
		String out = " ";
		for(int i=0; i<SemneON; i++) {
			out = out + SemneON;
		}
		
		for(int i=0; i<(lampi-SemneON); i++) {
			out = out +"O";
		}
		
		return out;
	}
	
	private int gOreSusSemne(int nr) {
		return (nr-(nr%5))/5;
	}
	
	public String convertTime(String aTime) {
		int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();

		StringBuffer time = new StringBuffer();

		return time.append(getSeconds(parts[2])).append(System.getProperty("line.separator"))
				.append(OreSus(parts[0])).append(System.getProperty("line.separator"))
				.append(OreJos(parts[0])).append(System.getProperty("line.separator"))
				.append(MinuteSus(parts[1])).append(System.getProperty("line.separator"))
				.append(MinuteJos(parts[1])).toString();
	}
	
}
	
