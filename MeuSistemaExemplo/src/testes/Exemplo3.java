package testes;

import modelo.Livro;

public class Exemplo3 {

	public static void main(String[] args) {
		
		Livro umLivro1 = new Livro(101, "Aprenda Java em 20 Dias", 2016);
		Livro umLivro2 = new Livro(227, "Java para Web Fácil", 2019);

		umLivro1.imprimirDados();
		
		umLivro2.imprimirDados();		
	}
}

