package matrix.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("What is the length do you want? ");
		int tamanho = scan.nextInt();

		int[][] matrix = new int[tamanho][tamanho];
		System.out.println(tamanho + " x " + tamanho + " = " + (tamanho*tamanho));
		
		int linha2 = 0;
		int i2 = 0;
		for(int[] coluna : matrix) {
			int i = 0;
			for(@SuppressWarnings("unused") int linha : coluna) {
				System.out.println("Type number " + (i2+1));
				int numero = scan.nextInt();
				matrix[linha2][i] = numero;
				i++;
				i2++;
			}
			linha2++;
		}

		List<Integer> negativeNumbers = new ArrayList<>();
		int diagonal = 0;
		System.out.println("\nMain diagonal: ");
		
		for (int[] coluna : matrix) {
			System.out.println(matrix[diagonal][diagonal] + " ");
			diagonal++;
			for (int linha : coluna) {
				if (linha < 0) {
					negativeNumbers.add(linha);
				}
			}
		}

		System.out.print("Negative Numbers: ");
		for (int negativeNumber : negativeNumbers) {
			System.out.print(negativeNumber);
		}
		System.out.println("\nNegative Numbers Quantity: " + negativeNumbers.size());
		
		scan.close();
		
	}
}
