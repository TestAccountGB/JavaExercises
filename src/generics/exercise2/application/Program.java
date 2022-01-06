package generics.exercise2.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		
		List<Object> hello = new ArrayList<>();
		List<Integer> inteiros = Arrays.asList(4, 5, 6);
		List<Double> decimais = Arrays.asList(3.5, 10.2);
		
		copy(inteiros, hello);
		System.out.println(hello);
		copy(decimais, hello);
		System.out.println(hello);
		
	}
	
	private static void copy(List<? extends Number> source, List<? super Number> target) {
		for(Number number : source) {
			target.add(number);
		}
	}
}
