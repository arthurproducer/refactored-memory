package ControledeEstoque;
import java.awt.EventQueue;
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
import javax.swing.border.TitledBorder;

public class JFrameProdutos extends JFrame{

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameProdutos frame = new JFrameProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

///////Construtor
	public JFrameProdutos() {
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
////////Panel para Inserir Produtos
		JPanel panelIns = new JPanel();
		panelIns.setBorder(new TitledBorder(null, "Inserir Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));//Titulo 
		GridBagConstraints gbc_panelIns = new GridBagConstraints();
		gbc_panelIns.gridx = 0;
		gbc_panelIns.gridy = 0;
		gbc_panelIns.fill = GridBagConstraints.BOTH;
		gbc_panelIns.insets = new Insets(0, 0, 5, 5);
		contentPane.add(panelIns, gbc_panelIns);
		GridBagLayout gbl_panelIns = new GridBagLayout();
		gbl_panelIns.columnWidths = new int[]{116, 116, 116};//Comprimento das Colunas
		gbl_panelIns.rowHeights = new int[]{27, 27, 27,27,27};//Altura das Linhas
		gbl_panelIns.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelIns.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelIns.setLayout(gbl_panelIns);
				
				JLabel lblid = new JLabel("ID_Produto");			
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
				JLabel lbldes = new JLabel("Descrição");
				GridBagConstraints gbc_lbldes = new GridBagConstraints();
				gbc_lbldes.fill = GridBagConstraints.BOTH;
				gbc_lbldes.insets = new Insets(0, 5, 5, 5);
				gbc_lbldes.gridx = 0;
				gbc_lbldes.gridy = 2;
				panelIns.add(lbldes, gbc_lbldes);
				JTextField txtdesc = new JTextField();
				GridBagConstraints gbc_txtdesc = new GridBagConstraints();
				gbc_txtdesc.gridwidth = 2;
				gbc_txtdesc.fill = GridBagConstraints.BOTH;
				gbc_txtdesc.insets = new Insets(0, 0, 5, 5);
				gbc_txtdesc.gridx = 1;
				gbc_txtdesc.gridy = 2;
				panelIns.add(txtdesc, gbc_txtdesc);
				JLabel lblpreco = new JLabel("Preço");
				GridBagConstraints gbc_lblpreco = new GridBagConstraints();
				gbc_lblpreco.fill = GridBagConstraints.BOTH;
				gbc_lblpreco.insets = new Insets(0, 5, 5, 5);
				gbc_lblpreco.gridx = 0;
				gbc_lblpreco.gridy = 3;
				panelIns.add(lblpreco, gbc_lblpreco);
				JTextField txtpreco = new JTextField();
				GridBagConstraints gbc_txtpreco = new GridBagConstraints();
				gbc_txtpreco.fill = GridBagConstraints.BOTH;
				gbc_txtpreco.gridwidth = 2;
				gbc_txtpreco.insets = new Insets(0, 0, 5, 5);
				gbc_txtpreco.gridx = 1;
				gbc_txtpreco.gridy = 3;
				panelIns.add(txtpreco, gbc_txtpreco);
				
				JButton btnIns = new JButton("Inserir");
				btnIns.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						try {
				            //Registra JDBC driver
							 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				 
				            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
				 
				            //Executa a query de inserção
				            java.sql.Statement st = conn.createStatement();
				            st.executeUpdate("INSERT INTO Produto (id_Produto,Nome,Descrição,Preço) VALUES ("
				                    + txtid.getText() + ",'"
				                    + txtnome.getText() + "','"
				                    + txtdesc.getText() + "','"
				                    + txtpreco.getText() +"')");
				 
				            JOptionPane.showMessageDialog(rootPane, "Produto inserido");
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
		panelAtu.setBorder(new TitledBorder(null, "Atualizar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
			JLabel lblnewid = new JLabel("ID_Produto");
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
			
			JLabel lblnewdesc = new JLabel("Descrição");
			GridBagConstraints gbc_lblnewdesc = new GridBagConstraints();
			gbc_lblnewdesc.fill = GridBagConstraints.BOTH;
			gbc_lblnewdesc.insets = new Insets(0, 5, 5, 5);
			gbc_lblnewdesc.gridx = 0;
			gbc_lblnewdesc.gridy = 2;
			panelAtu.add(lblnewdesc, gbc_lblnewdesc);
			
			JTextField txtnewdesc = new JTextField();
			GridBagConstraints gbc_txtnewdesc = new GridBagConstraints();
			gbc_txtnewdesc.gridwidth = 2;
			gbc_txtnewdesc.fill = GridBagConstraints.BOTH;
			gbc_txtnewdesc.insets = new Insets(0, 0, 5, 5);
			gbc_txtnewdesc.gridx = 1;
			gbc_txtnewdesc.gridy = 2;
			panelAtu.add(txtnewdesc, gbc_txtnewdesc);
			
			JLabel lblnewpreco = new JLabel("Preço");
			GridBagConstraints gbc_lblnewpreco = new GridBagConstraints();
			gbc_lblnewpreco.fill = GridBagConstraints.BOTH;
			gbc_lblnewpreco.insets = new Insets(0, 5, 5, 5);
			gbc_lblnewpreco.gridx = 0;
			gbc_lblnewpreco.gridy = 3;
			panelAtu.add(lblnewpreco, gbc_lblnewpreco);
			
			JTextField txtnewpreco = new JTextField();
			GridBagConstraints gbc_txtnewpreco = new GridBagConstraints();
			gbc_txtnewpreco.gridwidth = 2;
			gbc_txtnewpreco.fill = GridBagConstraints.BOTH;
			gbc_txtnewpreco.insets = new Insets(0, 0, 5, 5);
			gbc_txtnewpreco.gridx = 1;
			gbc_txtnewpreco.gridy = 3;
			panelAtu.add(txtnewpreco, gbc_txtnewpreco);
			
			JButton btnAtu = new JButton("Atualizar");
			btnAtu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//Registra JDBC driver
						 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 
			            Connection conn = DriverManager.getConnection(connectionUrl,"sa","NM7AJI3VRA8");
			 
			            //Executa a query de inserção
			            java.sql.Statement st = conn.createStatement();
			            st.executeUpdate("UPDATE Produto SET nome='"
			                    + txtnewnome.getText() + "',Descrição='"
			                    + txtnewdesc.getText() + "',Preço='" 
			                    + txtnewpreco.getText()
			                    + "' WHERE id_Produto='" + txtnewid.getText() + "'");
			            JOptionPane.showMessageDialog(rootPane, "Produto atualizado");
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
		panelExc.setBorder(new TitledBorder(null, "Excluir Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				
				JLabel lblEXCid = new JLabel("ID_Produto");
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
					            st.executeUpdate("DELETE FROM Produto WHERE id_Produto='" + txtEXCid.getText() + "'");
					            JOptionPane.showMessageDialog(rootPane, "Produto excluído");
					        } catch (SQLException | ClassNotFoundException ex) {
					            JOptionPane.showMessageDialog(rootPane, ex);
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
				
				JButton btnListagemDeProdutos = new JButton("Listagem de Produtos");
				btnListagemDeProdutos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					new ListagemProdutos();
					}
				});
				GridBagConstraints gbc_btnListagemDeProdutos = new GridBagConstraints();
				gbc_btnListagemDeProdutos.gridx = 1;
				gbc_btnListagemDeProdutos.gridy = 1;
				contentPane.add(btnListagemDeProdutos, gbc_btnListagemDeProdutos);
	}
}