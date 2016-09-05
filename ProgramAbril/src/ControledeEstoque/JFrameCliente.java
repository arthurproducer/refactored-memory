package ControledeEstoque;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JFrameCliente extends JFrame{
private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCliente frame = new JFrameCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrameCliente(){
		super("Controle do Estoque");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Controle_do_Estoque";
		setBounds(0, 0, 800, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{387, 387, 0};
		gbl_contentPane.rowHeights = new int[]{128, 128, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
////////Panel para Inserir Clientes
	JPanel panelIns = new JPanel();
	panelIns.setBorder(new TitledBorder(null, "Inserir Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));//Titulo 
	GridBagConstraints gbc_panelIns = new GridBagConstraints();
	gbc_panelIns.gridx = 0;
	gbc_panelIns.gridy = 0;
	gbc_panelIns.fill = GridBagConstraints.BOTH;
	gbc_panelIns.insets = new Insets(0, 0, 5, 5);
	contentPane.add(panelIns, gbc_panelIns);
	GridBagLayout gbl_panelIns = new GridBagLayout();
	gbl_panelIns.columnWidths = new int[]{116, 116, 116};//Comprimento das Colunas
	gbl_panelIns.rowHeights = new int[]{27, 27, 27,27};//Altura das Linhas
	gbl_panelIns.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gbl_panelIns.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	panelIns.setLayout(gbl_panelIns);
	
		JLabel lblid = new JLabel("ID_Cliente");			
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.fill = GridBagConstraints.BOTH;
		gbc_lblid.insets = new Insets(0, 5, 5, 5);
		gbc_lblid.gridx = 0;
		gbc_lblid.gridy = 0;
		panelIns.add(lblid, gbc_lblid);
		JTextField txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.gridwidth = 2;
		gbc_txtid.fill = GridBagConstraints.BOTH;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 0;
		panelIns.add(txtid, gbc_txtid);
		JLabel lblnome = new JLabel("Nome");
		GridBagConstraints gbc_lblnome = new GridBagConstraints();
		gbc_lblnome.fill = GridBagConstraints.BOTH;
		gbc_lblnome.insets = new Insets(0, 5, 5, 5);
		gbc_lblnome.gridx = 0;
		gbc_lblnome.gridy = 1;
		panelIns.add(lblnome, gbc_lblnome);
		JTextField txtnome = new JTextField();
		GridBagConstraints gbc_txtnome = new GridBagConstraints();
		gbc_txtnome.gridwidth = 2;
		gbc_txtnome.fill = GridBagConstraints.BOTH;
		gbc_txtnome.insets = new Insets(0, 0, 5, 5);
		gbc_txtnome.gridx = 1;
		gbc_txtnome.gridy = 1;
		panelIns.add(txtnome, gbc_txtnome);

		JLabel lblemail = new JLabel("E-mail");
		GridBagConstraints gbc_lblemail = new GridBagConstraints();
		gbc_lblemail.fill = GridBagConstraints.BOTH;
		gbc_lblemail.insets = new Insets(0, 5, 5, 5);
		gbc_lblemail.gridx = 0;
		gbc_lblemail.gridy = 2;
		panelIns.add(lblemail, gbc_lblemail);
		JTextField txtemail = new JTextField();
		GridBagConstraints gbc_txtemail = new GridBagConstraints();
		gbc_txtemail.gridwidth = 2;
		gbc_txtemail.fill = GridBagConstraints.BOTH;
		gbc_txtemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtemail.gridx = 1;
		gbc_txtemail.gridy = 2;
		panelIns.add(txtemail, gbc_txtemail);
		JLabel lblfone = new JLabel("Fone");
		GridBagConstraints gbc_lblfone = new GridBagConstraints();
		gbc_lblfone.fill = GridBagConstraints.BOTH;
		gbc_lblfone.insets = new Insets(0, 5, 5, 5);
		gbc_lblfone.gridx = 0;
		gbc_lblfone.gridy = 3;
		panelIns.add(lblfone, gbc_lblfone);
		JTextField txtfone = new JTextField();
		GridBagConstraints gbc_txtfone = new GridBagConstraints();
		gbc_txtfone.fill = GridBagConstraints.BOTH;
		gbc_txtfone.gridwidth = 2;
		gbc_txtfone.insets = new Insets(0, 0, 5, 5);
		gbc_txtfone.gridx = 1;
		gbc_txtfone.gridy = 3;
		panelIns.add(txtfone, gbc_txtfone);
		
		JButton btnIns = new JButton("Inserir");
		btnIns.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
		            //Registra JDBC driver
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
		 
		            //Executa a query de inserção
		            java.sql.Statement st = conn.createStatement();
		            st.executeUpdate("INSERT INTO Cliente (id_Cliente,Nome) VALUES ("
		                    + txtid.getText() + ",'"
		                    + txtnome.getText() + "')");
		            st.executeUpdate("INSERT INTO Email (id_usuario,email) VALUES ("
		                    + txtid.getText() + ",'"
		                    + txtemail.getText() + "')");
		            st.executeUpdate("INSERT INTO Fone (id_usuario,fone) VALUES ("
		                    + txtid.getText() + ",'"
		                    + txtfone.getText() + "')");
		            if(txtemail.getText() == null){
		            	 st.executeUpdate("INSERT INTO Email (id_usuario,email) VALUES ("
				                    + txtid.getText() + "')");
		            }
		            if(txtfone.getText() == null){
		            	 st.executeUpdate("INSERT INTO Fone (id_usuario,fone) VALUES ("
				                    + txtid.getText() + "')");
		            }
		            JOptionPane.showMessageDialog(rootPane, "Cliente Cadastrado");
		        } catch (SQLException | ClassNotFoundException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex);
		            System.out.println("SQLException: " + ex.getMessage());
					 System.out.println("SQLState: "+ ((SQLException) ex).getSQLState());
					 System.out.println("VendorError: "+ ((SQLException) ex).getErrorCode());
		        }catch(Exception ev){
					 System.out.println("Não foi possivel conectar!!");
				 }//Fim try

			}
		});
		GridBagConstraints gbc_btnIns = new GridBagConstraints();
		gbc_btnIns.insets = new Insets(0, 0, 0, 5);
		gbc_btnIns.fill = GridBagConstraints.BOTH;
		gbc_btnIns.gridx = 2;
		gbc_btnIns.gridy = 4;
		panelIns.add(btnIns, gbc_btnIns);
/////////Panel para Atualizar Produtos
		JPanel panelAtu = new JPanel();
		panelAtu.setBorder(new TitledBorder(null, "Atualizar Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelAtu = new GridBagConstraints();
		gbc_panelAtu.gridx = 1;
		gbc_panelAtu.gridy = 0;
		gbc_panelAtu.fill = GridBagConstraints.BOTH;
		gbc_panelAtu.insets = new Insets(0, 0, 5, 0);
		contentPane.add(panelAtu, gbc_panelAtu);
		GridBagLayout gbl_panelAtu = new GridBagLayout();
		gbl_panelAtu.columnWidths = new int[]{116, 116,116};
		gbl_panelAtu.rowHeights = new int[]{27, 27, 27, 27, 27};
		gbl_panelAtu.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAtu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelAtu.setLayout(gbl_panelAtu);
		
		JLabel lblnewid = new JLabel("ID_Cliente");
		GridBagConstraints gbc_lblnewid = new GridBagConstraints();
		gbc_lblnewid.fill = GridBagConstraints.BOTH;
		gbc_lblnewid.insets = new Insets(0, 5, 5, 5);
		gbc_lblnewid.gridx = 0;
		gbc_lblnewid.gridy = 0;
		panelAtu.add(lblnewid, gbc_lblnewid);
		
		JTextField txtnewid = new JTextField();
		GridBagConstraints gbc_txtnewid = new GridBagConstraints();
		gbc_txtnewid.gridwidth = 2;
		gbc_txtnewid.fill = GridBagConstraints.BOTH;
		gbc_txtnewid.insets = new Insets(0, 0, 5, 5);
		gbc_txtnewid.gridx = 1;
		gbc_txtnewid.gridy = 0;
		panelAtu.add(txtnewid, gbc_txtnewid);
		
		JLabel lblnewnome = new JLabel("Nome");
		GridBagConstraints gbc_lblnewnome = new GridBagConstraints();
		gbc_lblnewnome.fill = GridBagConstraints.BOTH;
		gbc_lblnewnome.insets = new Insets(0, 5, 5, 5);
		gbc_lblnewnome.gridx = 0;
		gbc_lblnewnome.gridy = 1;
		panelAtu.add(lblnewnome, gbc_lblnewnome);
		
		JTextField txtnewnome = new JTextField();
		GridBagConstraints gbc_txtnewnome = new GridBagConstraints();
		gbc_txtnewnome.gridwidth = 2;
		gbc_txtnewnome.fill = GridBagConstraints.BOTH;
		gbc_txtnewnome.insets = new Insets(0, 0, 5, 5);
		gbc_txtnewnome.gridx = 1;
		gbc_txtnewnome.gridy = 1;
		panelAtu.add(txtnewnome, gbc_txtnewnome);
		
		JLabel lblnewemail = new JLabel("E-mail");
		GridBagConstraints gbc_lblnewemail = new GridBagConstraints();
		gbc_lblnewemail.fill = GridBagConstraints.BOTH;
		gbc_lblnewemail.insets = new Insets(0, 5, 5, 5);
		gbc_lblnewemail.gridx = 0;
		gbc_lblnewemail.gridy = 2;
		panelAtu.add(lblnewemail, gbc_lblnewemail);
		
		JTextField txtnewemail = new JTextField();
		GridBagConstraints gbc_txtnewemail = new GridBagConstraints();
		gbc_txtnewemail.gridwidth = 2;
		gbc_txtnewemail.fill = GridBagConstraints.BOTH;
		gbc_txtnewemail.insets = new Insets(0, 0, 5, 5);
		gbc_txtnewemail.gridx = 1;
		gbc_txtnewemail.gridy = 2;
		panelAtu.add(txtnewemail, gbc_txtnewemail);
		
		JLabel lblnewfone = new JLabel("Fone");
		GridBagConstraints gbc_lblnewfone = new GridBagConstraints();
		gbc_lblnewfone.fill = GridBagConstraints.BOTH;
		gbc_lblnewfone.insets = new Insets(0, 5, 5, 5);
		gbc_lblnewfone.gridx = 0;
		gbc_lblnewfone.gridy = 3;
		panelAtu.add(lblnewfone, gbc_lblnewfone);
		
		JTextField txtnewfone = new JTextField();
		GridBagConstraints gbc_txtnewfone = new GridBagConstraints();
		gbc_txtnewfone.gridwidth = 2;
		gbc_txtnewfone.fill = GridBagConstraints.BOTH;
		gbc_txtnewfone.insets = new Insets(0, 0, 5, 5);
		gbc_txtnewfone.gridx = 1;
		gbc_txtnewfone.gridy = 3;
		panelAtu.add(txtnewfone, gbc_txtnewfone);
		
		JButton btnAtu = new JButton("Atualizar");
		btnAtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Registra JDBC driver
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
		 
		            //Executa a query de inserção
		            java.sql.Statement st = conn.createStatement();
		            st.executeUpdate("UPDATE Cliente SET Nome='"
		                    + txtnewnome.getText() 
		                    + "' WHERE id_Cliente='" + txtnewid.getText() + "'");
		            st.executeUpdate("UPDATE Email SET email='"
		                    + txtnewemail.getText() 
		                    + "' WHERE id_usuario='" + txtnewid.getText() + "'");
		            st.executeUpdate("UPDATE Fone SET fone='"
		                    + txtnewfone.getText() 
		                    + "' WHERE id_usuario='" + txtnewid.getText() + "'");
		            JOptionPane.showMessageDialog(rootPane, "Dados do Cliente atualizado");
		        } catch (SQLException | ClassNotFoundException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex);
		        }//Fim try

			}
		});
		GridBagConstraints gbc_btnAtu = new GridBagConstraints();
		gbc_btnAtu.fill = GridBagConstraints.BOTH;
		gbc_btnAtu.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtu.gridx = 2;
		gbc_btnAtu.gridy = 4;
		panelAtu.add(btnAtu, gbc_btnAtu);
		
/////////Panel para Excluir Produtos	
		JPanel panelExc = new JPanel();
		panelExc.setBorder(new TitledBorder(null, "Excluir Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelExc = new GridBagConstraints();
		gbc_panelExc.fill = GridBagConstraints.BOTH;
		gbc_panelExc.insets = new Insets(0, 0, 0, 5);
		gbc_panelExc.gridx = 0;
		gbc_panelExc.gridy = 1;
		contentPane.add(panelExc, gbc_panelExc);
		GridBagLayout gbl_panelExc = new GridBagLayout();
		gbl_panelExc.columnWidths = new int[]{116, 116,0, 116};
		gbl_panelExc.rowHeights = new int[]{27, 27};
		gbl_panelAtu.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAtu.rowWeights = new double[]{0.0, 0.0};
		panelExc.setLayout(gbl_panelExc);
				
				JLabel lblEXCid = new JLabel("ID_Cliente");
				GridBagConstraints gbc_lblEXCid = new GridBagConstraints();
				gbc_lblEXCid.fill = GridBagConstraints.BOTH;
				gbc_lblEXCid.insets = new Insets(0, 5, 5, 5);
				gbc_lblEXCid.gridx = 0;
				gbc_lblEXCid.gridy = 0;
				panelExc.add(lblEXCid, gbc_lblEXCid);
				
				JTextField txtEXCid = new JTextField();
				GridBagConstraints gbc_txtEXCid = new GridBagConstraints();
				gbc_txtEXCid.gridwidth = 3;
				gbc_txtEXCid.fill = GridBagConstraints.BOTH;
				gbc_txtEXCid.insets = new Insets(0, 0, 5, 5);
				gbc_txtEXCid.gridx = 1;
				gbc_txtEXCid.gridy = 0;
				panelExc.add(txtEXCid, gbc_txtEXCid);
				
				JButton btnEXCid = new JButton("Excluir");
				btnEXCid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 try {
							//Registra JDBC driver
							 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 
				            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
				 
				            //Executa a query de inserção
				            java.sql.Statement st = conn.createStatement();
				            	try{
				                st.executeUpdate("DELETE FROM Email WHERE id_usuario='" + txtEXCid.getText() + "'");
						        st.executeUpdate("DELETE FROM Fone WHERE id_usuario='" + txtEXCid.getText() + "'");
					            st.executeUpdate("DELETE FROM Cliente WHERE id_Cliente='" + txtEXCid.getText() + "'");
					            
					            JOptionPane.showMessageDialog(rootPane, "Cliente excluído");
				            	}catch(SQLException x){
				            		System.out.println("SQLException: " + x.getMessage());
							   		 System.out.println("SQLState: "+ ((SQLException) x).getSQLState());
							   		 System.out.println("VendorError: "+ ((SQLException) x).getErrorCode());
				            	JOptionPane.showMessageDialog(rootPane,"Este Cliente não pode ser excluido pois tem pedidos pendentes.\n"+
				            	"Para Excluir vá em Pedidos e exclua-os");
				            	}
					           
					        } catch (SQLException | ClassNotFoundException ex) {
					            JOptionPane.showMessageDialog(rootPane, ex);
						         System.out.println("SQLException: " + ex.getMessage());
						   		 System.out.println("SQLState: "+ ((SQLException) ex).getSQLState());
						   		 System.out.println("VendorError: "+ ((SQLException) ex).getErrorCode());
						      }catch(Exception ev){
						   		 System.out.println("Não foi possivel conectar!!");
						       }//Fim try

					}
				});
				GridBagConstraints gbc_btnEXCid = new GridBagConstraints();
				gbc_btnEXCid.gridwidth = 2;
				gbc_btnEXCid.insets = new Insets(0, 0, 0, 5);
				gbc_btnEXCid.fill = GridBagConstraints.BOTH;
				gbc_btnEXCid.gridx = 2;
				gbc_btnEXCid.gridy = 1;
				panelExc.add(btnEXCid, gbc_btnEXCid);
/////Listagem dos Clientes
				
				JButton btnListagemDosClientes = new JButton("Listagem dos Clientes");
				btnListagemDosClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					new ListagemClientes();
					}
				});//Fim Action Listener
				GridBagConstraints gbc_btnListagemDosClientes = new GridBagConstraints();
				gbc_btnListagemDosClientes.gridx = 1;
				gbc_btnListagemDosClientes.gridy = 1;
				contentPane.add(btnListagemDosClientes, gbc_btnListagemDosClientes);
}//Fim Construtor
}//Fim da Class
