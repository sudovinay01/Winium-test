package Winium.WiniumTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Port {

	public static void killPort(int portToKill) throws IOException {
		String command = "cmd /c netstat -ano | findstr :9999";
		Process process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] tokens = line.trim().split("\\s+");
			String pid = tokens[tokens.length - 1];
			Runtime.getRuntime().exec("taskkill /F /PID " + pid);
			System.out.println("Kill process with PID: " + pid);
		}
	}
}
