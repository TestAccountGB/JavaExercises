package interfaces.exercise3.model.entities;

import interfaces.exercise3.model.enums.Color;

public abstract class AbstractShape implements Shape {
	//Fazer desse jeito pode ser maneiro, pois podemos ter classes que apenas implementam "shape", e assim nao
	//Vamos obrigar todos os "shape" ter "color".

	private Color color;

	public AbstractShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
