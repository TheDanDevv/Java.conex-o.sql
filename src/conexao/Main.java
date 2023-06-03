package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws SQLException  {
		
		Conexao conexao = new Conexao();
		conexao.getConnection();
		System.out.println("Conexão bem sucedida");
		
		//----------------------conexão----------------------------------------------------
		
		String sql = "Insert into contatos (nome, email, endereco, nascimento) values (?,?,?,?)";
		PreparedStatement smts = conexao.getConnection().prepareStatement(sql);
		smts.setString(1, "Ricardo zé da manga");
		smts.setString(2, "ZéDaManga@teste.com");
		smts.setString(3, "Rua das mangas, 100");
		smts.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		smts.execute();
		
		System.out.println("Gravado");
		
		conexao.getConnection().close();
		
		//--------------inserção de dados--------------------------------
		
		conexao.getConnection();
		
		String sql2 = "select * from contatos";
		
		smts = conexao.getConnection().prepareStatement(sql2);
		
		ResultSet rs = smts.executeQuery();
		
		while(rs.next()) {
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			System.out.println(nome + email);
			
		}
		
		
		
		conexao.getConnection().close();
		
		//----------------------consulta de dados------------------------------
		
		conexao.getConnection();
		
		String sql3 = "delete from contatos where nome=?";
		
		smts = conexao.getConnection().prepareStatement(sql3);
		
		smts.setString(1, "João");
		
		smts.execute();
		
		conexao.getConnection().close();
		
		//----------------------------------------------------------------------
		
		conexao.getConnection();
		
		String sql4 = "update contatos set email=? where nome=?";
		
		smts = conexao.getConnection().prepareStatement(sql4);
		
		smts.setString(1, "MariaDaManga@teste.com");
		smts.setString(2, "Ricardo zé da manga");
		
		smts.execute();
		
		conexao.getConnection().close();
		

	}

}
