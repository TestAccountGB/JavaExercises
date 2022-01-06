package generics.exercise.services;

import java.util.List;

public class CalculationService {

	public static <T extends Comparable<? super T>> T max(List<T> list) {
		//Ou seja, ele so vai aceitar um tipo T que implemente a interface Comparable<>, com o tipo T ou o super dele
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		} 
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				//Caso voce nao saiba, o compareTo retorna positivo caso o "item" seja maior que o "max" no for acima, e claro,
				//O java vai considerar tal "item" maior que o "max" dependendo do seu metodo compareTo sobreescrito na
				//Classe T
				max = item;
			}
		}
		return max;
	}
}
