package modelo;


public class Livro {

	private int codigo;
	private String titulo;
	private int anoPublicacao;
	

	public Livro(int codigo, String titulo, int anoPublicacao) {

		this.codigo = codigo;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}
	

	public void imprimirDados() {	
	

		System.out.println("Código: "+this.codigo+" - título: "+ this.titulo);
	}
}

