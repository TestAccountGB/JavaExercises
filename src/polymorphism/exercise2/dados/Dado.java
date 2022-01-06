package polymorphism.exercise2.dados;
import java.util.Random;
public abstract class Dado {
	
	protected int lados;
	protected Random random = new Random();
	public int rolarDado() {
		int valor = random.nextInt(this.lados);
		if(valor == 0) {
			valor++;
		}
		return valor;
	}
}
