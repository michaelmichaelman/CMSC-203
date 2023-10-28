/*
 * Class: CMSC203 
 * Instructor: Dr. Gary Thai
 * Description: The CryptoManager Class is the class in this project that contains all the heavy-lifting methods.
 * These methods include some enctryption methods for both Caesar and Bellaso, as well as decryptions for these ciphers.
 * There is also a method isStringInBounds that checks to make sure the string given in the FX panel is in the correct
 * ASCII bounds. I call that method in one of the other methods, but not all, because the assignment was confusing.
 * Due: 10/27/2023
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael O'Connell
*/

package Project3;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		boolean boundsOrNah = false; // Set to true and returned if the string is within bounds
		
		for (int i = 0; i < plainText.length(); i++) {
			int d = plainText.charAt(i);
			if (d > UPPER_RANGE || d < LOWER_RANGE) {   //AND HERE Instead of the relationals
				boundsOrNah = false;
			}
			else
				boundsOrNah = true;
		}
		return boundsOrNah;
	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption (String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		if(isStringInBounds (plainText)) {
		 String encryptedText = "";
	        for (int i = 0; i < plainText.length(); i++) {
	            int c = plainText.charAt(i) + key;
	            encryptedText += (char) c;
	        }
	        return encryptedText;
		}
		else 
			return "The selected string is not in bounds, Try again.";
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		String encryptedString = "";
        for (int i = 0; i < plainText.length(); i++) {
            int x = plainText.charAt(i) + bellasoStr.charAt(i % bellasoStr.length()) - LOWER_RANGE;
            if (x > UPPER_RANGE) {
                while (x > UPPER_RANGE) {
                    x -= RANGE;
                }
            } else if (x < LOWER_RANGE) {
                while (x < LOWER_RANGE) {
                    x += RANGE;
                }
            }
            encryptedString += (char) x;
        }
        return encryptedString;
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		return caesarEncryption(encryptedText, -key);
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		String decryptedString = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            int c = encryptedText.charAt(i) - bellasoStr.charAt(i % bellasoStr.length()) + LOWER_RANGE;
            if (c > UPPER_RANGE) {
                while (c > UPPER_RANGE) {
                    c -= RANGE;
                }
            } else if (c < LOWER_RANGE) {
                while (c < LOWER_RANGE) {
                    c += RANGE;
                }
            }
            decryptedString += (char) c;
        }
        return decryptedString;
	}
}
