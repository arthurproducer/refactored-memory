package ControledeEstoque;

import java.awt.BorderLayout;
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

public class JFrameExcluirPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField txtid_Cliente;
	private JLabel lblidproduto;
	private JTextField txtidproduto;
	private JButton btnExcluirPedido;
	private JButton btnExcluirTodos;
	private JButton btnListagemProdutos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExcluirPedidos frame = new JFrameExcluirPedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
///Construtor
	public JFrameExcluirPedidos() {
		super("Controle de Estoque - Excluir Pedidos");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Controle_do_Estoque";
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{27, 0, 0, 0, 0,27, 0,27};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblidcliente = new JLabel("ID_Cliente");
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
		
		lblidproduto = new JLabel("ID_Produto");
		GridBagConstraints gbc_lblidproduto = new GridBagConstraints();
		gbc_lblidproduto.fill = GridBagConstraints.BOTH;
		gbc_lblidproduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblidproduto.gridx = 0;
		gbc_lblidproduto.gridy = 2;
		contentPane.add(lblidproduto, gbc_lblidproduto);
		
		txtidproduto = new JTextField();
		GridBagConstraints gbc_txtidproduto = new GridBagConstraints();
		gbc_txtidproduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtidproduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtidproduto.gridx = 1;
		gbc_txtidproduto.gridy = 2;
		contentPane.add(txtidproduto, gbc_txtidproduto);
		txtidproduto.setColumns(10);
		
		btnExcluirPedido = new JButton("Excluir Pedido");
		btnExcluirPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            //Registra JDBC driver
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
		            ///Executando Query
		            java.sql.Statement st = conn.createStatement();
		            st.executeQuery("SELECT id_cliente FROM Pedido  "
				            + "WHERE id_cliente='"+ txtid_Cliente.getText()+"'");
				            ResultSet rs = st.getResultSet();
				    if (!rs.next()){JOptionPane.showMessageDialog(rootPane,"Este Pedido não consta no Banco de Dados!.\n Veja se não errou o ID do Produto");
			        new ListagemProdutos();}//Este if verifica se o Banco de Dados não esta vazio
				    else{///Caso não esteja vazio ele exclui na tabela Pedido
		            st.executeUpdate("DELETE FROM Pedido "
		            		+ "WHERE id_produto='"+ txtidproduto.getText()+
		            		"' AND id_cliente='"+ txtid_Cliente.getText()+"'");
		       
		            JOptionPane.showMessageDialog(rootPane, "Pedido Excluido!");
		            }//Fimelse
		           
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
		GridBagConstraints gbc_btnExcluirPedido = new GridBagConstraints();
		gbc_btnExcluirPedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluirPedido.gridx = 2;
		gbc_btnExcluirPedido.gridy = 2;
		contentPane.add(btnExcluirPedido, gbc_btnExcluirPedido);
///////Button Escluir Todos os Pedidos deste Cliente
		btnExcluirTodos = new JButton("Excluir Todos os Pedidos deste Cliente");
		btnExcluirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							try {
					            //Registra JDBC driver
								 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					 
					            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
					            ///Executando Query
					            java.sql.Statement st = conn.createStatement();
					            st.executeQuery("SELECT id_cliente FROM Pedido  "
					            + "WHERE id_cliente='"+ txtid_Cliente.getText()+"'");
					            ResultSet rs = st.getResultSet();
					   if (!rs.next()){JOptionPane.showMessageDialog(rootPane,"Este Cliente não tem nenhum pedido!");}
					            else{///Caso não esteja vazio ele exclui na tabela Pedido
					            				int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo apagar todos os pedidos deste cliente?");
												if(escolha == JOptionPane.YES_OPTION){
								            	st.executeUpdate("DELETE FROM Pedido  "
									            		+ "WHERE id_cliente='"+ txtid_Cliente.getText()+"'");
								            			JOptionPane.showMessageDialog(rootPane, "Todos os Pedidos deste Cliente Foram Excluidos!");
												}//fim if escolha
					            }//Fimelse
					           
					        } catch (SQLException | ClassNotFoundException ex) {
					            JOptionPane.showMessageDialog(rootPane, ex);
					            System.out.println("SQLException: " + ex.getMessage());
								 System.out.println("SQLState: "+ ((SQLException) ex).getSQLState());
								 System.out.println("VendorError: "+ ((SQLException) ex).getErrorCode());
					        }catch(Exception ev){
								 System.out.println("Não foi possivel conectar!!");
							 }//Fim try
				
				}});
		GridBagConstraints gbc_btnExcluirTodos = new GridBagConstraints();
		gbc_btnExcluirTodos.gridwidth = 2;
		gbc_btnExcluirTodos.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluirTodos.gridx = 0;
		gbc_btnExcluirTodos.gridy = 4;
		contentPane.add(btnExcluirTodos, gbc_btnExcluirTodos);
		
		btnListagemProdutos = new JButton("N\u00E3o Sabe o ID do Produto, clique aqui    ");
		btnListagemProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				new ListagemProdutos();
			}
		});
		GridBagConstraints gbc_btnListagemProdutos = new GridBagConstraints();
		gbc_btnListagemProdutos.gridwidth = 2;
		gbc_btnListagemProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_btnListagemProdutos.gridx = 0;
		gbc_btnListagemProdutos.gridy = 5;
		contentPane.add(btnListagemProdutos, gbc_btnListagemProdutos);
		
	}

}
