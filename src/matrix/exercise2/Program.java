package matrix.exercise2;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("How many row do you want?");
		int row = scan.nextInt();

		System.out.println("How many columns do you want?");
		int column = scan.nextInt();

		int[][] matrix = new int[row][column];
		int index = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.println("Type the number " + (index));
				matrix[i][j] = scan.nextInt();
				index++;
			}
		}
		
		for(int[] ro : matrix) {
			System.out.println();
			for(int col : ro) {
				System.out.print(col + " ");
			}
		}
		
		System.out.println("\nWhich number do you want for me to show the adjacent numbers:");
		int number = scan.nextInt();
		scan.close();
		boolean foundNumber = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == number) {
					foundNumber = true;
					System.out.println("Position " + i + ", " + j);
					if (j > 0) {
						System.out.println("Left - " + matrix[i][j - 1]);
					}
					if (j < matrix[i].length - 1) {
						System.out.println("Right - " + matrix[i][j + 1]);
					}
					if (i > 0) {
						System.out.println("Up - " + matrix[i - 1][j]);
					}
					if (i < matrix.length - 1) {
						System.out.println("Down - " + matrix[i + 1][j]);
					}
				}
			}
		}

		
		if(!foundNumber) {
			System.out.println("This number does not exist");
		}
	}
}
