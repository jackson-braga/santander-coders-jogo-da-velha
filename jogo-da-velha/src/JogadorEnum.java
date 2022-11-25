
public enum JogadorEnum {
	X(10),
	O(100);
	
	JogadorEnum(int valor) {
		this.valor = valor;
	}
	
	private int valor;

	public int getValor() {
		return valor;
	}
}
