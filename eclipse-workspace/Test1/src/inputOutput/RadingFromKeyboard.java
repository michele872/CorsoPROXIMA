package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RadingFromKeyboard {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a line:");
		System.out.println(stdin.readLine());
		System.out.println("Enter an other line....:");
		System.out.println(stdin.readLine());
	}

}
