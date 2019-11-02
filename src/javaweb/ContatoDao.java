package javaweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
	private Connection connection;
	protected String login;
	
	public ContatoDao() {
		this.connection = new ConnectionNew().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos (id, nome, email, endereco, dataNascimento) values(?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.setString(2, contato.getNome());
			stmt.setString(3, contato.getEmail());
			stmt.setString(4, contato.getEndereco());
			stmt.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {

		String sql = "update contatos  set nome=?, email=?, endereco=?, dataNascimento=?, where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where nome=?");
			stmt.setString(1, contato.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public	List<Contato>	getLista()	{													
		try	{																	
			List<Contato>	contatos	=	new	ArrayList<Contato>();	
			PreparedStatement	stmt	=	this.connection.prepareStatement("select	*	from	Contatos");	
			ResultSet	rs	=	stmt.executeQuery();
			
		
	
	while	(rs.next())	{	
					Contato	contato	=	new	Contato();																					contato.setId(rs.getLong("id"));																					
					contato.setNome(rs.getString("Nome"));	
					contato.setEmail(rs.getString("Email"));
					contato.setEndereco(rs.getString("Endereco"));
					
					//	montando	a	data	através	do	Calendar				
					Calendar	data	=	Calendar.getInstance();																					data.setTime(rs.getDate("dataNascimento"));																					
					contato.setDataNascimento(data);
					//	adicionando	o	objeto	à	lista			
					contatos.add(contato);								
}															
	rs.close();																	
	stmt.close();																	
	return	contatos;													
	}	catch	(SQLException	e)	{																	
		throw	new	RuntimeException(e);													
		}									
	}
	

}

