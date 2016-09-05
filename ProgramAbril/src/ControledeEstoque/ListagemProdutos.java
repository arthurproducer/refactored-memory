package ControledeEstoque;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListagemProdutos extends JFrame{
	private JTextArea txtLista = new JTextArea(10,40);
	String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Controle_do_Estoque";

	public ListagemProdutos(){
	super("Listagem de Produtos");
	

	JPanel p = new JPanel();
	p.setLayout(new GridLayout(0,1));
	
	p.add(txtLista);
	this.setContentPane(p);
	this.pack();
	//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	
	try{
		//Registra JDBC driver
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");

        //Executa a query de inserção
        java.sql.Statement st = conn.createStatement();
        st.executeQuery("select * from Produto");
        ResultSet rs = st.getResultSet();

        //Lista os alunos no console
        while (rs.next()) {
            txtLista.setText(txtLista.getText()+rs.getString("id_Produto") + ", "
            +rs.getString("Nome") + ", "
            +rs.getString("Descrição") + ", "
            +rs.getString("Preço")+"\n");
        }
       
    }catch (SQLException | ClassNotFoundException ex) {
    	JOptionPane.showMessageDialog(rootPane, ex);
        System.out.println("SQLException: " + ex.getMessage());
		 System.out.println("SQLState: "+ ((SQLException) ex).getSQLState());
		 System.out.println("VendorError: "+ ((SQLException) ex).getErrorCode());
   }catch(Exception ev){
		 System.out.println("Não foi possivel conectar!!");
    }//Fim try
	}
}
