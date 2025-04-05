package main;

import logic.GetCurrentTime;

public class App {

	public static void main(String[] args) {
		System.out.println("current time is ...");
		
		GetCurrentTime getCurrentTime = new GetCurrentTime();
		
		String currentTime = getCurrentTime.get();
		
		System.out.println(currentTime);

	}

}
