package com.exercises.years.Michele;

public class NonRepeatingYearTest {
	
	
	/*Write a program to count the number of years in an inclusive range of years that have no repeated digits.
	For example, 2012 has a repeated digit (2) while 2013 does not. 
	Given the range [1980, 1987], your program would return 7 (1980, 1982, 1983, 1984, 1985, 1986, 1987).*/
	
	public static void main (String[] args) {
		int range_min = 1980 ;
		int range_max = 1987 ;
		NonRepeatingYearTest nonRepeatingYears = new NonRepeatingYearTest();
//		int[] count = nonRepeatingYears.count(range_min, range_max);
//		System.out.println("From " + range_min + " to " + range_max + " there are " + count + " of years with no repeated digits");
//		nonRepeatingYears.count(range_min, range_max);
		controllaDoppie(1981);
	}

	private void count(int range_min, int range_max) {
		int size = ((range_max + 1) - range_min);
		int[] count = new int[size];
		int data = range_min;
		int contatore = 0;
			for(int i=0; i<count.length; i++) {
				if(controllaDoppie(data) == true);				
					count[i] = data;
					data++;						
					contatore++;
					System.out.println(count[i]);
			}
			System.out.println(contatore);
		//return count;
	}
	
	public static boolean controllaDoppie(int n) {
		String d = Integer.toString(n);
		for(int j=0, k=0 ; j<d.length(); j++, k++) {
			if(j==j+1) {
				System.out.println("numero doppio");
			}
		}
		return false;
	}

}
