package ControledeEstoque;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JFramePedidos extends JFrame {

	private JPanel contentPane;
	private JTextField txtid_Cliente;
	private JLabel lblQualProduto;
	private JLabel lblnomeproduto;
	private JTextField txtnomeproduto;
	private JButton btnFazerPedido;
	private JButton btnListagemDePedidos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePedidos frame = new JFramePedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
////Construtor
	public JFramePedidos() {
		super("Controle de Estoque - Pedidos");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Controle_do_Estoque";
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 27, 27, 0, 0,27, 0, 27};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblidcliente = new JLabel("Forneça o id_Cliente");
		GridBagConstraints gbc_lblidcliente = new GridBagConstraints();
		gbc_lblidcliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblidcliente.gridx = 0;
		gbc_lblidcliente.gridy = 1;
		contentPane.add(lblidcliente, gbc_lblidcliente);
		
		txtid_Cliente = new JTextField();
		GridBagConstraints gbc_txtid_Cliente = new GridBagConstraints();
		gbc_txtid_Cliente.gridwidth = 2;
		gbc_txtid_Cliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtid_Cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid_Cliente.gridx = 1;
		gbc_txtid_Cliente.gridy = 1;
		contentPane.add(txtid_Cliente, gbc_txtid_Cliente);
		txtid_Cliente.setColumns(10);
		
		lblQualProduto =  new JLabel("Qual Produto ele(a) Comprou?");
		GridBagConstraints gbc_lblQualProduto = new GridBagConstraints();
		gbc_lblQualProduto.gridwidth = 3;
		gbc_lblQualProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblQualProduto.gridx = 0;
		gbc_lblQualProduto.gridy = 2;
		contentPane.add(lblQualProduto, gbc_lblQualProduto);
		
		lblnomeproduto = new JLabel("Nome do Produto");
		GridBagConstraints gbc_lblnomeproduto = new GridBagConstraints();
		gbc_lblnomeproduto.fill = GridBagConstraints.BOTH;
		gbc_lblnomeproduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblnomeproduto.gridx = 0;
		gbc_lblnomeproduto.gridy = 3;
		contentPane.add(lblnomeproduto, gbc_lblnomeproduto);
		
		txtnomeproduto = new JTextField();
		GridBagConstraints gbc_txtnomeproduto = new GridBagConstraints();
		gbc_txtnomeproduto.gridwidth = 2;
		gbc_txtnomeproduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtnomeproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnomeproduto.gridx = 1;
		gbc_txtnomeproduto.gridy = 3;
		contentPane.add(txtnomeproduto, gbc_txtnomeproduto);
		txtnomeproduto.setColumns(10);
		
		btnListagemDePedidos = new JButton("Listagem de Pedidos deste Cliente");
		btnListagemDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ListagemPedidos(txtid_Cliente.getText());	
			}
		});
		GridBagConstraints gbc_btnListagemDePedidos = new GridBagConstraints();
		gbc_btnListagemDePedidos.gridwidth = 2;
		gbc_btnListagemDePedidos.insets = new Insets(0, 0, 5, 5);
		gbc_btnListagemDePedidos.gridx = 0;
		gbc_btnListagemDePedidos.gridy = 6;
		contentPane.add(btnListagemDePedidos, gbc_btnListagemDePedidos);
		
		btnFazerPedido = new JButton("Fazer Pedido");
		btnFazerPedido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFazerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_prod= new String();
				try {
		            //Registra JDBC driver
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
		            ///Executando Query
		            java.sql.Statement st = conn.createStatement();
		            st.executeQuery("SELECT id_Cliente FROM Cliente "
		            + "WHERE id_Cliente='"+ txtid_Cliente.getText()+"'");
		            ResultSet rs = st.getResultSet();
		if (!rs.next()){JOptionPane.showMessageDialog(rootPane,"Cliente não existe no Banco de Dados\n Cadastre-o!!");
	     JFrameCliente.main(null);}//Este if verifica se o Banco de Dados não esta vazio
		else{//Este else funciona caso não seja um cliente inexistente                 
		            st.executeQuery("SELECT id_Produto FROM Produto "
		            		+ "WHERE Nome='"+ txtnomeproduto.getText()+"'");
		            rs = st.getResultSet();
		            if (!rs.next()){JOptionPane.showMessageDialog(rootPane,"Desculpe! Não temos este produto.\n Veja a Lista de Produtos Disponiveis");
	        		new ListagemProdutos();}//Este if verifica se o Banco de Dados não esta vazio
		            else{///Caso não esteja vazio ele salva na tabela Pedido
					            	try{
					            		st.executeQuery("SELECT id_Produto FROM Produto "
					            				+ "WHERE Nome='"+ txtnomeproduto.getText()+"'");
							            rs = st.getResultSet();
							            int cont= 0;
						            	while(rs.next()){
						            		id_prod = rs.getString("id_Produto");
						            		if(cont>=1){
						            		throw new SQLException();}
						            		cont++;
						            	}//Fim do while
						            	}catch(SQLException x){//Este erro aparece no caso de ter dois produtos do mesmo nome no banco
							        		JOptionPane.showMessageDialog(rootPane, "A dois produtos cadastrados com este nome!! ");
					            			new ListagemProdutos();
					            			id_prod = JOptionPane.showInputDialog("Viu na lista agora coloque o id do produto que você quer.");
					            			st.executeQuery("SELECT id_Produto FROM Produto "
					    		            		+ "WHERE id_Produto='"+ id_prod+"'");
					            			st.executeUpdate("INSERT INTO Pedido (id_produto,id_cliente) VALUES (" 
									            	+ id_prod + ",'"
									                + txtid_Cliente.getText() +"')");	
					            			JOptionPane.showMessageDialog(rootPane, "Seu Pedido foi realizado com sucesso!");
						            	}//fim try para produtos repetidos
		            	st.executeUpdate("INSERT INTO Pedido (id_produto,id_cliente) VALUES (" 
				            + id_prod + ",'"
				            + txtid_Cliente.getText() +"')");
				        
		            	JOptionPane.showMessageDialog(rootPane, "Seu Pedido foi realizado com sucesso!");
		            }//FIM else
		}//Fim Else caso:Cliente inexistente
		        } catch (SQLException | ClassNotFoundException ex) {
		        	String state = "23000";//Esta String está aqui pois este erro já foi tratado anteriormente no codigo
		        	if(state.equals(((SQLException) ex).getSQLState())){}//Esta condição é para que o mesmo erro não seja pego duas vezes
					else{
		            JOptionPane.showMessageDialog(rootPane, ex);
		            System.out.println("SQLException: " + ex.getMessage());
					 System.out.println("SQLState: "+ ((SQLException) ex).getSQLState());
					 System.out.println("VendorError: "+ ((SQLException) ex).getErrorCode());}
		        }catch(Exception ev){
					 System.out.println("Não foi possivel conectar!!");
				 }//Fim try
		
				}});
		GridBagConstraints gbc_btnFazerPedido = new GridBagConstraints();
		gbc_btnFazerPedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnFazerPedido.gridx = 2;
		gbc_btnFazerPedido.gridy = 6;
		contentPane.add(btnFazerPedido, gbc_btnFazerPedido);
		
	}

}
