/**
 * 
 */
package parcheggio;

/**
 * @author UTENTE8
 *
 */
public class TestOlClass {
	
//	private static boolean test1 = true;
//	private static boolean test2 = true;
//	private static boolean test3 = false;
//	private static boolean test4 = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (test1()) {
			System.out.println("TEST 1");
		}
		if ((test2())&(test3())) {
			System.out.println("TEST 2");
		}
		if ((test1())&&(test2())) {
			System.out.println("TEST 3");
		}
		if ((test2())|(test3())) {
			System.out.println("TEST 4");
		}
		if ((test2())||(test3())) {
			System.out.println("TEST 5");
		}
		
	}
	
	public static boolean test1 () {
		System.out.println("method test 1");
		return true;
	}
	
	public static boolean test2 () {
		System.out.println("method test 2");
		return true;
	}
	
	public static boolean test3 () {
		System.out.println("method test 3");
		return false;
	}
	
}