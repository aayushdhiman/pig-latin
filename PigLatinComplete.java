
/**
 * Aayush Dhiman
 * Due Monday, September 24th, 2018
 */

import java.util.*;
import java.io.*;

public class PigLatinComplete {
	private static String pigged;
	private static boolean quPig = false;
	private static String originalWord;

	public static void main(String[] args) {
		part_1_using_pig();
		// part_2_using_piglatenizeFile();
	}

	public static void part_1_using_pig() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("\nWhat word (or \"quit\" to quit)? ");
			String originalWord = input.next();
			if (originalWord.equals("quit")) {
				System.out.println("Program Complete.");
				System.exit(0);
			}
			String pigLatinWord = pig(originalWord);
			System.out.println(pigLatinWord);
		}

	}
	
	/**
	 * Turns the word into the word in pig latin.
	 * @param word the word to turn into pig latin
	 * @return pigged the word in pig latin
	 */

	public static String pig(String word) {
		/**
		 * Stores the word in a variable and puts the word into lowercase
		 */

		originalWord = "" + word;
		word = word.toLowerCase();

		/**
		 * Checks to see if there is a qu present in the word. If there is, then it
		 * activates quPig, which runs the part of the for loop for the qu modifier.
		 */

		if (word.contains("qu")) {
			quPig = true;
		}
		
		/**
		 * Checks to see if there are quotes in the word. If there are, they are removed
		 * and added back later in the punctuation block.
		 */
		
		if(word.contains("\"")) {
			word = word.substring(1, word.length() - 1);
		}

		/**
		 * Main for loop. This tests every letter in the word using the substring method
		 * against all the vowels until it finds the first vowel in the word. Then, it
		 * transforms the word into pig latin using the first vowel. After setting
		 * pigged to the pig latin word, it is returned as the final answer.
		 */

		for (int i = 0; i < word.length(); i++) {
			// System.out.println("Current word.substring(i, i + 1): " + word.substring(i, i
			// + 1));

			/**
			 * QU modifier testing block. This should be the last piece of code that
			 * executes in the for loop before the method returns pigged, as it has the
			 * break statement.
			 */

			if (quPig) {
				if (word.substring(i, i + 1).equalsIgnoreCase("u")) {
					// System.out.println("Found u");
					if (word.substring(word.indexOf("u") - 1, word.indexOf("u")).equals("q")) {
						// System.out.println("Found q");
						pigged = word.substring(word.indexOf("u") + 1) + "-" + word.substring(0, word.indexOf("u") + 1)
								+ "ay";
						// System.out.println("qu edited pig: " + pigged);
						break;
					}
				}
			}

			if (word.substring(i, i + 1).equalsIgnoreCase("a") | word.substring(i, i + 1).equalsIgnoreCase("e")
					| word.substring(i, i + 1).equalsIgnoreCase("i") | word.substring(i, i + 1).equalsIgnoreCase("o")
					| word.substring(i, i + 1).equalsIgnoreCase("u") | word.substring(i, i + 1).equalsIgnoreCase("y")) {
				pigged = word.substring(i) + "-" + word.substring(0, i) + "ay";
				// System.out.println("Found vowel, " + word.substring(i, i + 1));
				break;
			}

		}
		if (word.substring(0, 1).equalsIgnoreCase("a") | word.substring(0, 1).equalsIgnoreCase("e")
				| word.substring(0, 1).equalsIgnoreCase("i") | word.substring(0, 1).equalsIgnoreCase("o")
				| word.substring(0, 1).equalsIgnoreCase("u") | word.substring(0, 1).equalsIgnoreCase("y")) {
			pigged = word + "-way";
		}

		/**
		 * Punctuation modifier block. Checks to see if the pigged word has the
		 * punctuation, then moves it to the back. Currently only checks for exclamation
		 * points and questions. Should be the second to last block before the return
		 * statement and outside of the for loop.
		 */

		if (originalWord.contains("!")) {
			pigged = pigged.substring(0, pigged.indexOf("!")) + pigged.substring(pigged.indexOf("-"))
					+ word.substring(word.indexOf("!"));
		} else if (originalWord.contains("?")) {
			pigged = pigged.substring(0, pigged.indexOf("?")) + pigged.substring(pigged.indexOf("-"))
					+ word.substring(word.indexOf("?"));
		} else if (originalWord.contains("\"")) {
			pigged = "\"" + pigged + "\"";
		}

		/**
		 * Uppercase testing block. It compares the first letter of the word to the
		 * first letter made uppercase, and if they are the same, it will capitalize the
		 * first letter of pigged before it returns. This should be directly before the
		 * return statement and outside of the for loop.
		 */

		if (originalWord.substring(0, 1).equals(originalWord.substring(0, 1).toUpperCase())) {
			pigged = pigged.substring(0, 1).toUpperCase() + pigged.substring(1);
		}

		/**
		 * First letter vowel testing block. Checks to see if the first letter of the
		 * word is a vowel or not, and if it is, append "-way" to the back of the word.
		 */

		// returning pigged
		return pigged;
	}

	public static void part_2_using_piglatenizeFile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
		String filename = sc.next();
		Scanner infile = null;
		try {
			infile = new Scanner(new File(filename)); // PigLatin.txt
		} catch (IOException e) {
			System.out.println("oops");
		}
		System.out.print("Output Filename (Including .txt)? Example: PigLatinOut.txt:");
		String filenameOut = sc.next();
		piglatenizeFile(infile, filenameOut);
		System.out.println("Piglatin done!");
		sc.close();
	}

	/******************************
	 * precondition: filename has .txt postcondition: output a piglatinized .txt
	 * file
	 *
	 ******************************/
	public static void piglatenizeFile(Scanner infile, String filename) {
		/***************************
		 *
		 * enter your code here: Scanner, try-catch, nested loops, file output
		 *
		 ****************************/
	}
}