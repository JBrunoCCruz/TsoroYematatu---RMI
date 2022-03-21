package jogointerface;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import jogointerface.JogoInterface;


public class JogoInterface {
	JFrame frame = new JFrame("Menu");
	JTextField textField_1;
	JTextField textField_2;
	
	JFrame f2 = new JFrame("Tela do jogo");
	JTextArea textAreaChat;
	JTextField textFieldChat;					
	
	// Informa��es gerais do jogo
	static JLabel ipServidorLabel = new JLabel("ipServidor: ");
	static JLabel portaServidorLabel = new JLabel("portaServidor: ");
	static JLabel minhacorLabel = new JLabel("Minha cor: ");
	static JLabel informacaoDaJogadaLabel = new JLabel("...");
	
	// Informa��es do tabuleiro
	static ArrayList<JLabel> peca;
	static String minhaCor  = "vazia";
	static String corDoOponente = "vazia";
	static int turnoDoJogo = 1;
	static boolean meuTurno = false;
	static ArrayList<Boolean> tabuleiroTsoro = new ArrayList<>(Arrays.asList(false, false, false, false, false, false, false));
	JFrame frameResultado = new JFrame("Resultado");
	JLabel labelResultado = new JLabel("resultado");
	static boolean voceComeca = false;

	
	public JogoInterface () {		
		primeiraTela();
	}
	
	
	/*
	 * Menu do jogo
	 * */
	public void primeiraTela () {
		frame.setBounds(150, 150, 500, 600);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* 
		 * Bot�es
		 * */
		JButton btnNewButton_1_1 = new JButton("CONECTAR");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
					
				} else if (!minhaCor.equals("vazia")) {
					frame.setVisible(false);					
					f2.setVisible(true);
					
					segundaTela();					
				}				
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(Color.BLUE);
		btnNewButton_1_1.setBounds(165, 368, 161, 40);
		frame.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("SAIR");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Saindo...");
				frame.dispose();
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1_1.setBounds(164, 511, 161, 40);
		frame.add(btnNewButton_1_1_1);
				
		JButton btnNewButton_1_1_2 = new JButton("CRIAR PARTIDA");
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!minhaCor.equals("vazia")) {
					frame.setVisible(false);								
					f2.setVisible(true);
					
					segundaTela();
				} 			
			}
		});
		btnNewButton_1_1_2.setForeground(Color.BLACK);
		btnNewButton_1_1_2.setBackground(new Color(0, 255, 0));
		btnNewButton_1_1_2.setBounds(165, 296, 161, 40);
		frame.add(btnNewButton_1_1_2);		
		/* 
		 * Bot�es
		 * */
		
		JLabel lblNewLabel = new JLabel("Escolha sua cor");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 252, 120, 25);
		frame.add(lblNewLabel);
		
		JLabel corPecaEscolhidaLabel = new JLabel("Sua cor:");
		corPecaEscolhidaLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		corPecaEscolhidaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		corPecaEscolhidaLabel.setBounds(360, 240, 120, 25);
		frame.add(corPecaEscolhidaLabel);
		
		JLabel corPecaEscolhida = new JLabel("_");
		corPecaEscolhida.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		corPecaEscolhida.setHorizontalAlignment(SwingConstants.CENTER);
		corPecaEscolhida.setBounds(360, 260, 120, 25);
		frame.add(corPecaEscolhida);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tsoro Yematatu");
		lblNewLabel_1_4_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setBounds(164, 11, 161, 23);
		frame.add(lblNewLabel_1_4_1);
		
		/* 
		 * Campos de texto
		 * */
		textField_1 = new JTextField(); // Endere�o
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(82, 419, 138, 31);
		frame.add(textField_1);
		
		textField_2 = new JTextField(); // Porta
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(269, 419, 138, 31);
		frame.add(textField_2);
		/* 
		 * Campos de texto
		 * */
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setHorizontalAlignment(SwingConstants.CENTER);
		lblOu.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblOu.setBounds(221, 341, 46, 25);
		frame.add(lblOu);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblEndereco.setBounds(90, 461, 120, 25);
		frame.add(lblEndereco);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorta.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblPorta.setBounds(279, 461, 120, 25);
		frame.add(lblPorta);
		
		
		/* 
		 * Pe�as
		 * */
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				corPecaEscolhida.setText("vermelha");
				minhaCor = "vermelha";
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecavermelha.png")));
		lblNewLabel_1.setBounds(135, 247, 40, 40);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				corPecaEscolhida.setText("azul");
				minhaCor = "azul";
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecaazul.png")));
		lblNewLabel_1_1.setBounds(198, 247, 40, 40);
		frame.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				corPecaEscolhida.setText("verde");
				minhaCor = "verde";
			}
		});
		lblNewLabel_1_2.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecaverde.png")));
		lblNewLabel_1_2.setBounds(268, 247, 40, 40);
		frame.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				corPecaEscolhida.setText("amarela");
				minhaCor = "amarela";
			}
		});
		lblNewLabel_1_3.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecaamarela.png")));
		lblNewLabel_1_3.setBounds(328, 247, 40, 40);
		frame.add(lblNewLabel_1_3);
		/* 
		 * Pe�as
		 * */
		
		JLabel lblNewLabel_1_4 = new JLabel();
		lblNewLabel_1_4.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/tsorologo2.png")));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(138, 34, 228, 202);
		frame.add(lblNewLabel_1_4);
	}
	
	
	/*
	 * Tela da partida
	 * */
	public void segundaTela () {
		
		/* 
		 * Bot�es
		 * */		
		ArrayList<JButton> botao = new ArrayList<>();
		String nomeDosBotoes[] = {"DESISTIR", "ENVIAR"};
		Color coresDosBotoes[] = {new java.awt.Color(248, 26, 26),
								  new java.awt.Color(26, 114, 248)};
		int i = 0;
		while (i < nomeDosBotoes.length) {			
			botao.add(new JButton(nomeDosBotoes[i]));
			botao.get(i).setBackground(coresDosBotoes[i]);
			botao.get(i).setForeground(Color.white);
			i = i + 1;
		}				
						
		botao.get(0).setBounds(12, 235, 161, 40);
		botao.get(1).setBounds(12, 507, 161, 40);				
		
		// Bot�o de desistir
		botao.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				// Envia mensagem de desistir para o cliente
				perdeuOJogo();
			}
		});
		
		// Bot�o de enviar
		botao.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				textAreaChat.setText(textAreaChat.getText() + "Eu: " + textFieldChat.getText() + "\r\n");
				// Enviar mensagem do CHAT para o oponente
				textFieldChat.setText("");
			}
		});
				
		i = 0;
		while (i < botao.size()) {
			f2.add(botao.get(i));			
			i++;
		}		
		/* 
		 * Bot�es
		 * */
		
		/*
		 * Informa�oes de endere�o e IP do Servidor e Cor e da Jogada
		 * */				
		informacaoDaJogadaLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		informacaoDaJogadaLabel.setForeground(new java.awt.Color(100, 100, 100));
		informacaoDaJogadaLabel.setBounds(12, 100, 161, 40);
		f2.add(informacaoDaJogadaLabel);
				minhacorLabel.setText("Minha cor: " + minhaCor);
		minhacorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		minhacorLabel.setForeground(new java.awt.Color(0, 0, 0));
		minhacorLabel.setBounds(12, 320, 161, 40);
		f2.add(minhacorLabel);
		
		ipServidorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		ipServidorLabel.setForeground(new java.awt.Color(100, 74, 138));
		ipServidorLabel.setBounds(12, 370, 161, 40);
		f2.add(ipServidorLabel);
				
		portaServidorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		portaServidorLabel.setForeground(new java.awt.Color(200, 28, 78));
		portaServidorLabel.setBounds(12, 420, 161, 40);
		f2.add(portaServidorLabel);
		/*
		 * Informa�oes de endere�o e IP do Servidor e Cor e da Jogada
		 * */
				
		/* 
		 * Chat
		 * */		
		textAreaChat = new JTextArea();
		textAreaChat.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textAreaChat);
		scrollPane.setBounds(230, 310, 240, 190);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		textFieldChat = new JTextField();
		textFieldChat.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { /*TODO Auto-generated method stub*/ }
			@Override
			public void keyReleased(KeyEvent e) {/* TODO Auto-generated method stub */ }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textAreaChat.setText(textAreaChat.getText() + "Eu: " + textFieldChat.getText() + "\r\n");
					// Enviar mensagem do CHAT para o oponente
					textFieldChat.setText("");
				}
				
			}
		});
		textFieldChat.setBounds(230, 505, 240, 45);
		textFieldChat.setBorder(BorderFactory.createLineBorder(Color.black));
		
		f2.add(scrollPane);
		f2.add(textFieldChat);		
		/* 
		 * Chat
		 * */
		
		/* 
		 * Jogo
		 * */
		// Tabuleiro
		JLabel tabuleiro = new JLabel();
		tabuleiro.setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/tabuleiro6.png")));
		tabuleiro.setHorizontalAlignment(SwingConstants.CENTER);
		tabuleiro.setBounds(240, 30, 221, 240);
		f2.add(tabuleiro);
		
		// Pecas
		peca = new ArrayList<>();	
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(0).setBounds(330, 25, 40, 40);
		peca.get(0).setName("vazia");
		peca.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(0))));
			}
		});
		f2.add(peca.get(0));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(1).setBounds(270, 150, 40, 40);
		peca.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(1))));
			}
		});
		peca.get(1).setName("vazia");
		f2.add(peca.get(1));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(2).setBounds(330, 150, 40, 40);
		peca.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(2))));
			}
		});
		peca.get(2).setName("vazia");
		f2.add(peca.get(2));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(3).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(3).setBounds(390, 150, 40, 40);
		peca.get(3).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(3))));
			}
		});
		peca.get(3).setName("vazia");
		f2.add(peca.get(3));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(4).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(4).setBounds(230, 240, 40, 40);
		peca.get(4).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(4))));
			}
		});
		peca.get(4).setName("vazia");
		f2.add(peca.get(4));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(5).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(5).setBounds(330, 240, 40, 40);
		peca.get(5).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(5))));
			}
		});
		peca.get(5).setName("vazia");
		f2.add(peca.get(5));
		
		peca.add(new JLabel(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/pecadefault.png"))));
		peca.get(6).setHorizontalAlignment(SwingConstants.CENTER);
		peca.get(6).setBounds(430, 240, 40, 40);
		peca.get(6).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				analisarMinhaJogada(Integer.toString(peca.indexOf(peca.get(6))));
			}
		});
		peca.get(6).setName("vazia");
		f2.add(peca.get(6));
		/* 
		 * Jogo
		 * */
		
		f2.setBounds(150, 150, 500, 600);
		f2.setResizable(false);
		f2.setLayout(null);
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//
		// Inicia "Comunica��o" entre inteface gr�fica e socket cliente
		//		
		new Thread(detectaVencedor).start();
	}
	
		
	
	/*
	 * An�lisa minhas jogadas (Ponto no tabuleiro onde eu cliquei)
	 * */
	public void analisarMinhaJogada (String pontoNoTabuleiro) {
		
		int posiNoTabuleiro = Integer.parseInt(pontoNoTabuleiro); 
		int posiVazia = -1;
		
		if (!(meuTurno)) {
			System.out.println("Turno do oponente");
			informacaoDaJogadaLabel.setText("Turno do oponente");
			
		} else if ( (turnoDoJogo < 7) && peca.get(posiNoTabuleiro).getName().equals("vazia") ) {
			//System.out.println("Minha jogada - ponto: " + pontoNoTabuleiro); // Debug
			peca.get(posiNoTabuleiro).setName(minhaCor);
			peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));
			turnoDoJogo += 1;
			tabuleiroTsoro.set(posiNoTabuleiro, true);
			meuTurno = false;
			informacaoDaJogadaLabel.setText("Turno do oponente");
			// Envia mensagem da jogada para o oponente
			
		} else if (turnoDoJogo >= 7 && peca.get(posiNoTabuleiro).getName().equals(minhaCor) ) {
			// Estrutura��o e execu��o da jogada
			posiVazia = tabuleiroTsoro.indexOf(false);													
			
			if (posiNoTabuleiro == 0) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 1 && (posiVazia == 0 || posiVazia == 2 || posiVazia == 3 || posiVazia == 4) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 2 && (posiVazia == 0 || posiVazia == 1 || posiVazia == 3 || posiVazia == 5) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 3 && (posiVazia == 0 || posiVazia == 1 || posiVazia == 2 || posiVazia == 6) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 4 && (posiVazia == 0 || posiVazia == 1 || posiVazia == 5 || posiVazia == 6) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 5 && (posiVazia == 0 || posiVazia == 2 || posiVazia == 4 || posiVazia == 6) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
				
			} else if (posiNoTabuleiro == 6 && (posiVazia == 0 || posiVazia == 3 || posiVazia == 4 || posiVazia == 5) ) {
				peca.get(posiNoTabuleiro).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + "default".toString() + ".png")));
				peca.get(posiVazia).setIcon(new ImageIcon(JogoInterface.class.getResource("/jogointerface/imagens/peca" + minhaCor + ".png")));			
				peca.get(posiNoTabuleiro).setName("vazia");
				peca.get(posiVazia).setName(minhaCor);		
				turnoDoJogo += 1;
				meuTurno = false;
				informacaoDaJogadaLabel.setText("Turno do oponente");
				// Envia mensagem da jogada para o oponente
				tabuleiroTsoro.set(posiVazia, true);
				tabuleiroTsoro.set(posiNoTabuleiro, false);
			} else {
				System.out.println("Escolha outra pe�a!");
				informacaoDaJogadaLabel.setText("Escolha outra pe�a");
			}
			
		} else {
			System.out.println("Joga inv�lida!");
			informacaoDaJogadaLabel.setText("Jogada inv�lida");
		}
						
	}
	
	
	/*
	 * Detecta o vencedor verificando as cores linha por linha
	 * */
	public Runnable detectaVencedor = new Runnable() {
		@Override
		public void run() {
			while (true) {
				if (!minhaCor.equals("vazia") && !corDoOponente.equals("vazia")) {
					/*
					 * Vit�ria
					 * */
					if (peca.get(0).getName().equals(minhaCor) && peca.get(1).getName().equals(minhaCor) && peca.get(4).getName().equals(minhaCor)) { //0 - 1 - 4												
						System.out.println("Vit�ria!");
						venceuOJogo();
						while(true);
						
					} else if (peca.get(0).getName().equals(minhaCor) && peca.get(2).getName().equals(minhaCor) && peca.get(5).getName().equals(minhaCor)) { // 0 - 2 - 5
						System.out.println("Vit�ria!");
						venceuOJogo();
						while(true);
						
					} else if (peca.get(0).getName().equals(minhaCor) && peca.get(3).getName().equals(minhaCor) && peca.get(6).getName().equals(minhaCor)) { // 0 - 3 - 6
						System.out.println("Vit�ria!");
						venceuOJogo();
						while(true);
						
					} else if (peca.get(1).getName().equals(minhaCor) && peca.get(2).getName().equals(minhaCor) && peca.get(3).getName().equals(minhaCor)) { // 1 - 2 - 3
						System.out.println("Vit�ria!");
						venceuOJogo();
						while(true);
						
					} else if (peca.get(4).getName().equals(minhaCor) && peca.get(5).getName().equals(minhaCor) && peca.get(6).getName().equals(minhaCor)) { // 4 - 5 - 6						
						System.out.println("Vit�ria!");
						venceuOJogo();
						while(true);
					} 
					/*
					 * Derrota
					 * */
					else if (peca.get(0).getName().equals(corDoOponente) && peca.get(1).getName().equals(corDoOponente) && peca.get(4).getName().equals(corDoOponente)) { // 0 - 1 - 4						
						System.out.println("Derrota!");
						perdeuOJogo();
						while(true);
						
					} else if (peca.get(0).getName().equals(corDoOponente) && peca.get(2).getName().equals(corDoOponente) && peca.get(5).getName().equals(corDoOponente)) { // 0 - 2 - 5						
						System.out.println("Derrota!");
						perdeuOJogo();
						while(true);
						
					} else if (peca.get(0).getName().equals(corDoOponente) && peca.get(3).getName().equals(corDoOponente) && peca.get(6).getName().equals(corDoOponente)) { // 0 - 3 - 6						
						System.out.println("Derrota!");
						perdeuOJogo();
						while(true);
						
					} else if (peca.get(1).getName().equals(corDoOponente) && peca.get(2).getName().equals(corDoOponente) && peca.get(3).getName().equals(corDoOponente)) { // 1 - 2 - 3
						System.out.println("Derrota!");
						perdeuOJogo();
						while(true);
						
					} else if (peca.get(4).getName().equals(corDoOponente) && peca.get(5).getName().equals(corDoOponente) && peca.get(6).getName().equals(corDoOponente)) { // 4 - 5 - 6
						System.out.println("Derrota!");						
						perdeuOJogo();
						while(true);
						
					}
				}				
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
			}			
		}
	};
	
	
	/*
	 * Mostra mensagem informando que voc� venceu o jogo
	 * */
	public void venceuOJogo () {		
		f2.setEnabled(false);
		frameResultado.setBounds(200, 200, 200, 100);
		labelResultado.setBounds(25, 25, 100, 50);
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setForeground(new Color(24, 147, 42));		
		labelResultado.setText("Vit�ria, " + minhaCor + "!");
		frameResultado.add(labelResultado);
		frameResultado.setBackground(Color.green);
		frameResultado.setResizable(false);
		frameResultado.setVisible(true);
		frameResultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/*
	 * Mostra mensagem informando que voc� perdeu o jogo
	 * */
	public void perdeuOJogo () {		
		f2.setEnabled(false);
		frameResultado.setBounds(200, 200, 200, 100);
		labelResultado.setBounds(25, 25, 100, 50);
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setForeground(new Color(255, 0, 0));
		labelResultado.setText("Derrota, " + minhaCor + "!");
		frameResultado.add(labelResultado);		
		frameResultado.setResizable(false);
		frameResultado.setVisible(true);
		frameResultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Main
	 * */
	public static void main(String[] args) {
		new JogoInterface();
	}

}
