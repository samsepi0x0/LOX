package jLox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
	static boolean hadError = false;
	
	/*
	 * Error handling functions*/
	static void error(int line, String message) {
		report(line, "", message);
	}
	
	/*
	 * Main method marks the start of the program, and this journey.*/
	public static void main(String args[]) throws IOException {
		if (args.length > 1) {
			System.out.println("Usage: lox [script]");
			System.exit(64);
		} else if (args.length == 1) {
			runFile(args[0]);
		} else {
			runPrompt();
		}
	}
	
	private static void report(int line, String where, String message) {
		System.err.println("[Line " + line + "] Error" + where + ": " + message);
		hadError = true;
	}
	
	/*
	 * Function that validates and runs the command entered by 
	 * the programmer. */
	private static void run(String source) {
		Scanner sc = new Scanner(source);
		List<Token> tokens = scanner.scanTokens();
		
		for (Token token: tokens) {
			System.out.println(token);
		}
	}
	
	/*
	 * Reading from a script file for making persistent scripts.*/
	private static void runFile(String path) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		run(new String(bytes, Charset.defaultCharset()));
		
		if (hadError)
			System.exit(65);
	}
	
	/*
	 * Flirting with the interpreter by trying out one code line
	 * at a time.*/
	private static void runPrompt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		for (;;) {
			System.out.print(">> ");
			String line = reader.readLine();
			if (line == null)
				break;
			run(line);
			hadError = false;
		}
	}
}
