package logic;

public class GetCurrentTime {
	public String get() {
		long millis = System.currentTimeMillis();
	
		long seconds = millis / 1000;
	    long minutes = (seconds / 60) % 60;
	    long hours = (seconds / 3600) % 24 + 9;
	
	    return hours + ":" + minutes + ":" + (seconds % 60);
	}
}
