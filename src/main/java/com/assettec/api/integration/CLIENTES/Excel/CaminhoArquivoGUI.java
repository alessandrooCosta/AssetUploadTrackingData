package com.assettec.api.integration.CLIENTES.Excel;

import com.assettec.api.ApiApplication;
import com.assettec.api.integration.CLIENTES.Excel.Modulos.*;
import com.assettec.api.internal.core.entities.asset.AssetService;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import com.assettec.api.internal.users.AppUser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.FileSystemException;
import java.util.prefs.Preferences;
import javax.swing.filechooser.FileNameExtensionFilter;

import static com.assettec.api.integration.CLIENTES.Excel.CarregamentoSwingWorker.calcularTotalLinhas;

public class CaminhoArquivoGUI extends JFrame {
	private JProgressBar progressBar;
	private TrackingDataCreator trackingDataCreator;
	private static final String PREFS_NODE_NAME = "CaminhoArquivoGUI";
	private static final String TOKEN_PREF_KEY = "lastGeneratedToken";
	private ApiUserService apiUserService;
	private AssetService assetService;
	private WorkOrderCreationService workOrderCreationService;
	private StyledLabel styledLabel;
	private JTextField caminhoTextField;
	private JComboBox<String> guiaDropdown;
	private JTextField tokenTextField;
	private JTextField serverTextField;
	private JTextField portTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField organizationTextField;
	private JLabel resultadoLabel;
	private JTextField tenantTextField;
	private JButton executarButton;
	private JButton salvarInformacoesButton;
	private JButton importButton;

	private String selectedGuia;

	private String caminhoPlanilha;
	private JPanel dropZonePanel;

	// Função para criar uma pasta e um arquivo de log
	private void criarPastaELog() {
		try {
			// Obtém o diretório atual de trabalho do usuário
			String diretorioAtual = System.getProperty("user.dir");

			// Cria um diretório chamado "logs" no diretório atual
			File diretorioLogs = new File(diretorioAtual + File.separator + "logs");
			if (!diretorioLogs.exists()) {
				diretorioLogs.mkdir();
			}

			// Cria um arquivo de log com base na data e hora atual
			String nomeArquivoLog = "log_" + System.currentTimeMillis() + ".txt";
			File arquivoLog = new File(diretorioLogs, nomeArquivoLog);

			// Inicializa o FileOutputStream para escrever no arquivo de log
			FileOutputStream fileOutputStream = new FileOutputStream(arquivoLog);

			// Cria um TeeOutputStream para enviar a saída para ambos os destinos
			OutputStream teeOutputStream = new TeeOutputStream(System.out, fileOutputStream);

			// Inicializa o PrintStream para escrever no arquivo de log
			PrintStream logPrintStream = new PrintStream(teeOutputStream);

			// Redireciona a saída do console para o arquivo de log e para o console
			System.setOut(logPrintStream);

			// Imprime a data e hora no arquivo de log
			System.out.println("Data e Hora: " + java.time.LocalDateTime.now());

			// Restante do seu código aqui...

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Implementação de TeeOutputStream para enviar a saída para vários destinos
	class TeeOutputStream extends OutputStream {
		private final OutputStream outputStream1;
		private final OutputStream outputStream2;

		public TeeOutputStream(OutputStream outputStream1, OutputStream outputStream2) {
			this.outputStream1 = outputStream1;
			this.outputStream2 = outputStream2;
		}

		@Override
		public void write(int b) throws IOException {
			outputStream1.write(b);
			outputStream2.write(b);
		}

		@Override
		public void write(byte[] b) throws IOException {
			outputStream1.write(b);
			outputStream2.write(b);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			outputStream1.write(b, off, len);
			outputStream2.write(b, off, len);
		}

		@Override
		public void flush() throws IOException {
			outputStream1.flush();
			outputStream2.flush();
		}

		@Override
		public void close() throws IOException {
			outputStream1.close();
			outputStream2.close();
		}
	}

	// Ícone vetorial simples que desenha a lupa equivalente ao SVG solicitado
	static class SearchIcon implements Icon {
		private final int width;
		private final int height;

		SearchIcon(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(((c != null) ? c.getForeground() : new Color(120,120,120)));
			int w = getIconWidth();
			int h = getIconHeight();
			float stroke = Math.max(1f, Math.min(w, h) / 12f);
			g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			int cx = x + w / 2;
			int cy = y + h / 2;
			int r = Math.max(3, Math.min(w, h) / 2 - 4);
			g2.drawOval(cx - r, cy - r, r * 2, r * 2);
			int startX = x + (int) (w * 0.66);
			int startY = y + (int) (h * 0.66);
			int endX = x + (int) (w * 0.9);
			int endY = y + (int) (h * 0.9);
			g2.drawLine(startX, startY, endX, endY);
			g2.dispose();
		}

		@Override
		public int getIconWidth() { return width; }

		@Override
		public int getIconHeight() { return height; }
	}

	public CaminhoArquivoGUI(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, AssetService assetService) {
		this(apiUserService, workOrderCreationService, assetService, true);
	}

	// Novo construtor: permite abrir a UI antes dos serviços estarem prontos
	public CaminhoArquivoGUI() {
		this(null, null, null, false);
	}

	private CaminhoArquivoGUI(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, AssetService assetService, boolean servicesReady) {
		this.apiUserService = apiUserService;
		this.workOrderCreationService = workOrderCreationService;
		this.assetService = assetService;
		setTitle("AssetUpload");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 460);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		// Recuperar o último token salvo
		Preferences prefs = Preferences.userNodeForPackage(getClass());
		String lastToken = prefs.get("lastToken", "");

		// Carrega o ícone personalizado
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/A.png"));
		setIconImage(customIcon.getImage());

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
		panel.setLayout(new GridLayout(13, 2, 11, 2));

		JPanel tokenPathPanel = new JPanel();
		tokenPathPanel.setLayout(new GridLayout(2, 2, 10, 10));

		StyledLabel labelServer = new StyledLabel("Server:");
		serverTextField = new JTextField(20);
		// Cria um JPanel para conter a label "Port:" e o texto "(Opcional)"
		JPanel portLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		StyledLabel labelPort = new StyledLabel("Port:");
		portLabelPanel.add(labelPort);
		// Cria um JLabel para o texto "(Opcional)" em cinza
		JLabel optionalPortLabel = new JLabel(" (Opcional)");
		optionalPortLabel.setForeground(Color.GRAY);
		portLabelPanel.add(optionalPortLabel);
		portTextField = new JTextField(10);
		panel.add(labelServer);
		panel.add(serverTextField);
		panel.add(portLabelPanel); // Adicionar o painel com a label do Port e o label opcional
		panel.add(portTextField);

		StyledLabel labelOrganization = new StyledLabel("Organization:");
		organizationTextField = new JTextField(20);
		StyledLabel labelTenant = new StyledLabel("Tenant:");
		tenantTextField = new JTextField(20);
		panel.add(labelOrganization);
		panel.add(organizationTextField);
		panel.add(labelTenant);
		panel.add(tenantTextField);

		StyledLabel labelUsername = new StyledLabel("Username:");
		usernameTextField = new JTextField(20);
		StyledLabel labelPassword = new StyledLabel("Password:");
		passwordTextField = new JTextField(20);
		panel.add(labelUsername);
		panel.add(usernameTextField);
		panel.add(labelPassword);
		panel.add(passwordTextField);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(tokenPathPanel, BorderLayout.NORTH); // Adicionando abaixo do painel de botões

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		StyledLabel labelCaminho = new StyledLabel("Selecione a Planilha:");
		caminhoTextField = new JTextField(20);
		caminhoTextField.setEditable(false);
		caminhoTextField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (caminhoPlanilha == null || caminhoPlanilha.trim().isEmpty()) {
			caminhoTextField.setText("Clique para selecionar a planilha");
			caminhoTextField.setForeground(Color.GRAY);
		}
		caminhoTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openFileChooserAndLoad();
			}
		});
		importButton = new JButton(new SearchIcon(16, 16));
		importButton.setFocusable(false);
		importButton.setMargin(new Insets(0, 6, 0, 6));
		importButton.setPreferredSize(new Dimension(30, 26));
		importButton.setForeground(new Color(120, 120, 120));
		importButton.setToolTipText("Selecionar guia");
		importButton.addActionListener(e -> openFileChooserAndLoad());
		JPanel filePickerPanel = new JPanel(new BorderLayout(6, 0));
		filePickerPanel.add(caminhoTextField, BorderLayout.CENTER);
		filePickerPanel.add(importButton, BorderLayout.EAST);
		panel.add(labelCaminho);
		panel.add(filePickerPanel);

		// Dropdown para seleção de aba da planilha
		StyledLabel labelGuia = new StyledLabel("Selecione a Guia:");
		JPanel guiaPanel = new JPanel(); // Painel para conter o dropdown e o rótulo
		guiaPanel.setLayout(new BoxLayout(guiaPanel, BoxLayout.X_AXIS));
		panel.add(labelGuia);

		// Use o campo de classe para o dropdown e inicialize desabilitado
		guiaDropdown = new JComboBox<>();
		guiaDropdown.setEnabled(false);
		panel.add(guiaDropdown);

		// Barra de progresso
		progressBar = new JProgressBar(); // Cria uma barra de progresso com valores de 0 a 100
		progressBar.setStringPainted(true); // Ativa a exibição de porcentagem na barra de progresso
		progressBar.setLayout(new GridLayout(2, 2, 15, 15));
		panel.add(progressBar);

		resultadoLabel = new JLabel(servicesReady ? "" : "Inicializando serviços...");
		panel.add(new JLabel()); // Placeholder
		panel.add(resultadoLabel); // Adiciona o resultadoLabel

		executarButton = new JButton("Executar");
		executarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Executa a ação em uma nova thread para não bloquear a UI
				new Thread(() -> {
					String selectedGuia = (String) guiaDropdown.getSelectedItem();
					String selectedAction = "[CREATE] TrackingData";

					// Validações iniciais (ainda na thread da UI antes de desabilitar botões)
					if (caminhoPlanilha == null || caminhoPlanilha.trim().isEmpty()) {
						SwingUtilities.invokeLater(() -> {
							resultadoLabel.setForeground(Color.RED);
							resultadoLabel.setText("Informe o caminho da planilha.");
						});
						return;
					}

					if (selectedGuia == null || selectedGuia.trim().isEmpty()) {
						SwingUtilities.invokeLater(() -> {
							resultadoLabel.setForeground(Color.RED);
							resultadoLabel.setText("Selecione a guia (aba) antes de executar.");
						});
						return;
					}

					// Valida o cabeçalho da guia selecionada
					if (!isGuiaValida(caminhoPlanilha, selectedGuia)) {
						SwingUtilities.invokeLater(() -> {
							resultadoLabel.setForeground(Color.RED);
							resultadoLabel.setText("<html>Formato de guia inválido. Verifique se a guia é compatível com TrackingData'.</html>");
						});
						// Não reabilita os botões aqui, pois a validação é rápida e o usuário pode corrigir e tentar de novo.
						return;
					}

					// Desabilita botões e inicia feedback visual
					SwingUtilities.invokeLater(() -> {
						executarButton.setEnabled(false);
						importButton.setEnabled(false);
						resultadoLabel.setForeground(Color.BLUE);
						resultadoLabel.setText("Autenticando usuário...");
						progressBar.setValue(0);
						progressBar.setIndeterminate(true); // Fica indeterminada durante a autenticação
					});

					try {
						String token = criarToken(); // Gera o token
						executarAcao(token, caminhoPlanilha, selectedGuia, selectedAction); // Executa a ação com o token
					} catch (Exception ex) {
						// Trata falhas na geração do token
						handleTokenCreationError(ex);
					}
				}).start();
			}
		});

		// Crie um JPanel para conter o botão "Baixar Modelo" à esquerda dos botões
		JPanel downloadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Crie um JLabel para "Baixar Modelo"
		JLabel baixarModeloLabel = new JLabel("<html><u>Baixar Modelo</u></html>");
		baixarModeloLabel.setForeground(Color.BLUE); // Define a cor do link
		baixarModeloLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor para o estilo de mão

		// Adicione um MouseListener para o link "Baixar Modelo"
		baixarModeloLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// Use o ClassLoader para carregar o arquivo do modelo da planilha
					ClassLoader classLoader = getClass().getClassLoader();
					try (InputStream inputStream = classLoader.getResourceAsStream("sheetModel/AssetModel.xlsx")) {

						if (inputStream != null) {
							// Lê o recurso em memória para permitir tentativas múltiplas de gravação
							ByteArrayOutputStream buffer = new ByteArrayOutputStream();
							byte[] data = new byte[8192];
							int nRead;
							while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
								buffer.write(data, 0, nRead);
							}
							buffer.flush();
							byte[] bytes = buffer.toByteArray();

							String destinoPath = System.getProperty("user.home") + "/Downloads/AssetModel.xlsx";
							Path destino = Paths.get(destinoPath);
							try {
								Files.write(destino, bytes);
								JOptionPane.showMessageDialog(null, "O modelo da planilha foi baixado com sucesso para:\n" + destinoPath, "Download Concluído", JOptionPane.INFORMATION_MESSAGE);
							} catch (FileSystemException fse) {
								// Arquivo está em uso; salva com nome alternativo
								String alternativePath = System.getProperty("user.home") + "/Downloads/AssetModel_" + System.currentTimeMillis() + ".xlsx";
								Files.write(Paths.get(alternativePath), bytes);
								JOptionPane.showMessageDialog(null, "O arquivo de destino está em uso. Salvamos como:\n" + alternativePath, "Arquivo em uso", JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "O modelo da planilha não foi encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao baixar o modelo da planilha.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// Define o texto do link para ficar sublinhado quando o mouse passar sobre ele
				baixarModeloLabel.setText("<html><u><font color='blue'>Baixar Modelo</font></u></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Remove o sublinhado quando o mouse sair do link
				baixarModeloLabel.setText("<html>Baixar Modelo</html>");
			}
		});

		// Adicione o JLabel "Baixar Modelo" ao JPanel de download
		downloadPanel.add(baixarModeloLabel);

		// Crie um JPanel para conter os botões ao centro
		JPanel buttonsCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonsCenterPanel.add(executarButton);

		// Crie um JPanel para conter tanto o downloadPanel quanto o buttonsCenterPanel
		JPanel combinedPanel = new JPanel(new BorderLayout());
		combinedPanel.add(downloadPanel, BorderLayout.WEST);
		combinedPanel.add(buttonsCenterPanel, BorderLayout.CENTER);

		// Configure o layout do buttonPanel para usar FlowLayout com alinhamento central
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Adicione o combinedPanel ao painel de botões
		buttonPanel.add(combinedPanel);

		// Desabilita ações dependentes de serviços quando ainda não prontos
		setServicesEnabled(servicesReady);
	}

	private void setServicesEnabled(boolean enabled) {
		if (salvarInformacoesButton != null) salvarInformacoesButton.setEnabled(enabled);
		if (executarButton != null) executarButton.setEnabled(enabled);
		if (importButton != null) importButton.setEnabled(true); // permitir selecionar arquivo já
	}

	// Permite injetar os serviços após o Spring iniciar em background
	public void setServices(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, AssetService assetService) {
		this.apiUserService = apiUserService;
		this.workOrderCreationService = workOrderCreationService;
		this.assetService = assetService;
		resultadoLabel.setText("");
		setServicesEnabled(true);
	}

	private String criarToken() throws Exception {
		try {
			String server = serverTextField.getText();
			String port = portTextField.getText();
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();
			String organization = organizationTextField.getText();
			String tenant = tenantTextField.getText();

			AppUser appUser = new AppUser();
			appUser.setServer(server);
			appUser.setPort(port);
			appUser.setUsername(username);
			appUser.setPassword(password);
			appUser.setOrganization(organization);
			appUser.setTenant(tenant);

			ApiUser apiUser = apiUserService.createUser(appUser);

			// Salvar o token nas preferências para uso futuro, se desejado
			Preferences prefs = Preferences.userNodeForPackage(getClass());
			prefs.put("lastToken", apiUser.getToken());

			return apiUser.getToken();
		} catch (Exception e) {
			// Relança a exceção para ser tratada no chamador
			throw new Exception("Falha na autenticação: " + e.getMessage(), e);
		}
	}

	private void handleTokenCreationError(Exception ex) {
		SwingUtilities.invokeLater(() -> {
			resultadoLabel.setForeground(Color.RED);
			resultadoLabel.setText("<html>Erro de autenticação: " + ex.getMessage() + "</html>");
			// Reabilita os botões após o erro
			executarButton.setEnabled(true);
			importButton.setEnabled(true);
			progressBar.setIndeterminate(false);
			progressBar.setValue(0);
		});
	}

	private boolean isGuiaValida(String caminhoPlanilha, String nomeGuia) {
		if (caminhoPlanilha == null || nomeGuia == null) {
			return false;
		}

		try (FileInputStream fileStream = new FileInputStream(new File(caminhoPlanilha));
			 Workbook workbook = WorkbookFactory.create(fileStream)) {

			Sheet sheet = workbook.getSheet(nomeGuia);
			if (sheet == null) {
				return false; // Guia não encontrada
			}

			Row headerRow = sheet.getRow(0); // Pega a primeira linha (cabeçalho)
			if (headerRow == null || headerRow.getPhysicalNumberOfCells() == 0) {
				return false; // Sem cabeçalho ou cabeçalho vazio
			}

			// Itera sobre todas as células do cabeçalho
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

				// Ignora células completamente vazias no final, mas valida as que existem
				if (cell == null || cell.getCellType() == CellType.BLANK) continue;

				if (cell.getCellType() != CellType.STRING || !cell.getStringCellValue().trim().startsWith("TKD_")) {
					return false; // Formato inválido encontrado
				}
			}
			return true; // Todos os cabeçalhos são válidos
		} catch (IOException e) {
			e.printStackTrace();
			return false; // Erro ao ler o arquivo
		}
	}

	private void executarAcao(String token, String caminhoPlanilha, String selectedGuia, String selectedAction) {

        if ("[CREATE] TrackingData".equalsIgnoreCase(selectedAction)) {
			this.trackingDataCreator = new TrackingDataCreator(apiUserService, workOrderCreationService, resultadoLabel, this, progressBar);
			this.trackingDataCreator.createTrackingData(token, caminhoPlanilha, selectedGuia);
		} else {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					resultadoLabel.setForeground(Color.RED);
					resultadoLabel.setText("Ação não reconhecida.");
				}
			});
			// Reabilita os botões se a ação não for reconhecida
			SwingUtilities.invokeLater(() -> {
				executarButton.setEnabled(true);
				importButton.setEnabled(true);
			});
		}
	}

	private void openFileChooserAndLoad() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Planilhas Excel (*.xls, *.xlsx, *.xlsm)", "xls", "xlsx", "xlsm"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			handleSelectedFile(selectedFile);
		}
	}

	private void handleSelectedFile(File selectedFile) {
		if (selectedFile == null) return;
		String path = selectedFile.getAbsolutePath();
		caminhoPlanilha = path;
		caminhoTextField.setText(caminhoPlanilha);
		caminhoTextField.setForeground(Color.BLACK);
		populateSheetDropdown(caminhoPlanilha);
	}

	private void populateSheetDropdown(String path) {
		if (path == null || path.trim().isEmpty()) {
			return;
		}
		File file = new File(path);
		if (!file.exists() || !file.isFile()) {
			return;
		}
		try (FileInputStream fileStream = new FileInputStream(file)) {
			guiaDropdown.removeAllItems();

			Workbook workbook;
			if (path.toLowerCase().endsWith(".xls")) {
				workbook = new HSSFWorkbook(fileStream); // Para arquivos no formato .xls
			} else if (path.toLowerCase().endsWith(".xlsx") || path.toLowerCase().endsWith(".xlsm")) {
				workbook = new XSSFWorkbook(fileStream); // Para arquivos no formato .xlsx/.xlsm
			} else {
				JOptionPane.showMessageDialog(null, "Formato de arquivo não suportado.", "Erro", JOptionPane.ERROR_MESSAGE);
				guiaDropdown.setEnabled(false);
				return;
			}

			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				guiaDropdown.addItem(workbook.getSheetName(i));
			}
			guiaDropdown.setEnabled(workbook.getNumberOfSheets() > 0);
			caminhoPlanilha = path;
		} catch (IOException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível abrir a planilha.", "Erro", JOptionPane.ERROR_MESSAGE);
			guiaDropdown.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CaminhoArquivoGUI gui = new CaminhoArquivoGUI();
				gui.setVisible(true);

				// Chama a função para criar pasta e log
				gui.criarPastaELog();

				// Inicia o Spring em background para não bloquear a UI
				new Thread(() -> {
					ApplicationContext context = SpringApplication.run(ApiApplication.class, args);
					ApiUserService apiUserService = context.getBean(ApiUserService.class);
					WorkOrderCreationService workOrderCreationService = context.getBean(WorkOrderCreationService.class);
					AssetService assetService = context.getBean(AssetService.class);
					SwingUtilities.invokeLater(() -> gui.setServices(apiUserService, workOrderCreationService, assetService));
				}).start();
			}
		});
	}

}
