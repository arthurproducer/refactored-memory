package ControledeEstoque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameMenu extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnProduto = new JButton();
	private JButton btnCliente = new JButton();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMenu frame = new JFrameMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameMenu() {
		super("Controle de Estoque - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnProduto.setBackground(Color.WHITE);
		btnProduto.setIcon(new ImageIcon(JFrameMenu.class.getResource("/Imagem4.png")));
		btnProduto.setBorder(new EmptyBorder(0, 0, 0, -20));
		panel.add(btnProduto);
		
		btnCliente.setBackground(Color.WHITE);
		btnCliente.setIcon(new ImageIcon(JFrameMenu.class.getResource("/Imagem5.png")));
		btnCliente.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(btnCliente);
		
	///JComboBox para Pedidos 
		JComboBox cbPedido = new JComboBox(new String[]{"","Fazer Pedido","Excluir Pedido"});
		ItemListener listener = new ItemListener(){  
		    public void itemStateChanged(ItemEvent e) {  
		       int indice=cbPedido.getSelectedIndex();
		    	if(indice == 1){
		    		JFramePedidos.main(null);
		    	}else if(indice == 2){
		    		JFrameExcluirPedidos.main(null);
		    	}
		    }  
		};  
		cbPedido.addItemListener(listener);  
		panel.add(cbPedido);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameMenu.class.getResource("/imagesEX87ZTQEF.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		btnProduto.addActionListener(this);
		btnCliente.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		 if(src == btnProduto){
		 JFrameProdutos.main(null);
		 }
		 else if(src == btnCliente){
		 JFrameCliente.main(null);}
	}

}
