package ControledeEstoque;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListagemPedidos extends JFrame{
	private JTextArea txtLista = new JTextArea(10,40);
	String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Controle_do_Estoque";

	public ListagemPedidos(String cliente){
	super("Listagem de Pedidos");
	
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
        if(cliente.equals("")){
        	st.executeQuery("SELECT * FROM Pedido");
        	        ResultSet rs = st.getResultSet();
        	        //Lista os alunos no console
        	        while (rs.next()) {
        	            txtLista.setText(txtLista.getText()+rs.getString("id_cliente") + ", "
        	            +rs.getString("id_produto")+"\n");
        }//fim while
        }else{
        st.executeQuery("SELECT id_Cliente,id_produto FROM Pedido "
        +"WHERE id_Cliente='"+ cliente + "'");
        ResultSet rs = st.getResultSet();
        //Lista os alunos no console
        while (rs.next()) {
            txtLista.setText(txtLista.getText()+rs.getString("id_cliente") + ", "
            +rs.getString("id_produto")+"\n");
        }}
       
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
