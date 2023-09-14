package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Venda;

public class VendaDao {

	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			// aqui tenho minha primeira conexão com o Banco de dados, passo o localhost,
			// user e password
			String jdbcUrl = "jdbc:postgresql://localhost:5432/loja";
			String usuario = "postgres";
			String senha = "postgres";

			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(jdbcUrl, usuario, senha);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conexao;
	}
//logo em seguida tem alguns comandos em SQL, que serão executados
	public static int inserir(Venda v) {
		int status = 0;
		try {
			Connection con = VendaDao.obterConexao();

			PreparedStatement ps = con.prepareStatement("INSERT INTO vendas (item, valor) VALUES(?,?)");
			ps.setString(1, v.getItem());
			ps.setDouble(2, v.getValor());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int remover(int id) {
		int status = 0;
		try {
			Connection con = VendaDao.obterConexao();
			PreparedStatement ps = con.prepareStatement("DELETE FROM vendas WHERE id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Venda consultarPorId(int id) {
		Venda v = new Venda();
		try {
			Connection con = VendaDao.obterConexao();
			PreparedStatement ps = con.prepareStatement("SELECT id, item, valor FROM vendas WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String valorTxt = rs.getString("valor");
				double valor = Double.parseDouble(valorTxt);
				v.setId(rs.getInt("id"));
				v.setItem(rs.getString("item"));
				v.setValor(valor);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return v;
	}

	public static List<Venda> listarTodas() {
		List<Venda> listaVendas = new ArrayList<Venda>();
		try {
			Connection con = VendaDao.obterConexao();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vendas ORDER BY id DESC ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String valorTxt = rs.getString("valor");
				double valor = Double.parseDouble(valorTxt);
				Venda v = new Venda();
				v.setId(rs.getInt("id"));
				v.setItem(rs.getString("item"));
				v.setValor(valor);
				listaVendas.add(v);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaVendas;
	}
	public static int alterar(Venda v) {
		List<Venda> listaVendas = new ArrayList<Venda>();
		int status = 0;
		try {
			Connection con = VendaDao.obterConexao();
			PreparedStatement ps = con.prepareStatement("UPDATE vendas SET item=?, valor=? WHERE id=?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String valorTxt = rs.getString("valor");
				double valor = Double.parseDouble(valorTxt);
				Venda va = new Venda();
				va.setId(rs.getInt("id"));
				va.setItem(rs.getString("item"));
				va.setValor(valor);
				listaVendas.add(va);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  status;
	}
	
}