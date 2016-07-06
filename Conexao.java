import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.mysql.jdbc.PreparedStatement;
public class Conexao {

	static String status = "";
	
	
public static void Connection(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Deu certo!");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//INSERINDO DADOS NO BANCO DE DADOS ATRAVES DO JAVA
public static void ConnectionToMySql(String titulo, String autor, String isbn, int edicao, int quantidade){
	Connection();
	String host = "jdbc:MySql://localhost:NumeroDoSeuLocalhost/bibliotecapoo"; //TEM QUE DESCOBRIR O SEU LOCALHOST "BIBLIOTECAPOO" É O NOME DO BANCO DE DADOS, TROQUE PELO QUE VOCE CRIAR
	
	String username = "root"; // usuario do mysql 
	String password = "******"; //senha do mysql
	try {
		Connection connect = DriverManager.getConnection(host, username, password);
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO livro(titulo,autor,isbn,edicao,quantidade)VALUES(?,?,?,?,?)");
		statement.setString(1, titulo);
		statement.setString(2, autor);
		statement.setString(3, isbn);
		statement.setLong(4,  edicao  );
		statement.setLong(5,  quantidade );
		statement.executeUpdate();
		statement.close();
		System.out.println("WORKS!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
// DELETANDO ALGUM DADO ATRAVÉS DO TITULO DO LIVRO NO BANCO DE DADOS 
public static void DeleteToMySql(String titulo){
	Connection();
	String host = "jdbc:MySql://localhost:NumeroDoSeuLocalhost/bibliotecapoo";
	String username = "root";
	String password = "******";
	try {
		Connection connect = DriverManager.getConnection(host, username, password);
		PreparedStatement statement = (PreparedStatement) connect.prepareStatement("DELETE FROM livro WHERE titulo = ?");
		statement.setString(1, titulo);
		statement.executeUpdate();
		statement.close();
		System.out.println("WORKS!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}

/*Conexao.Connection();
		Conexao.DeleteToMySql("*******"); // titulo do livro a ser deletado
		System.out.println(Conexao.status); 
*/
