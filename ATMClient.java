
import java.io.*;
import java.awt.*;
import javax.swing.*;


public class ATMClient {
	//Объекты, которые мы хотим отобразить в компоненте JComboBox
	Bank[] bank ;
	
	JFrame frame;
	JButton displayAccountBalance;
	JButton makeADeposit;
	JButton makeAWithdrawal;
	JTextField dataEntry;
	JTextArea output;
	JTextField message;
	JPanel keyPadPanel;
	JPanel actionButtonPanel;
	JPanel outputs;
	JPanel client;
	//ссылка на объект JComboBox 
	JComboBox myComboBox;

	public void launchFrame() {
		//инициализация фрейма
		frame = new JFrame("Bank ATM");
		frame.setLayout(new BorderLayout());
		//инициализируем массив банков 
		bank = new Bank[10];
		for(int i = 0; i<bank.length; i++) {
			bank[i] = new Bank();
			//устанавливаем имя
			bank[i].setName("Bank " + (i+1));
		}
        //создаем объект нашего класса и передаем ему объект для отображения  - массив банков
		//банк переопределяет метод toString для отображения в списке по полю name 
		myComboBox = new MyJComboBox(bank);
		
		//добавляем на фрейм объект своего класса MyJComboBox
		frame.add(myComboBox, BorderLayout.NORTH);
		
		
		//далее создаем другие элементы GUI
		
		makeADeposit = new JButton("Make a deposit");
		displayAccountBalance = new JButton("Display Account Balance");
		makeAWithdrawal = new JButton("Make a withdrawal");

		dataEntry = new JTextField(10);
		dataEntry.setEditable(false);
		output = new JTextArea(10, 75);
		output.setEditable(false);
		message = new JTextField(75);
		message.setEditable(false);

		actionButtonPanel = new JPanel();
		actionButtonPanel.setLayout(new GridLayout(3, 1));
		actionButtonPanel.add(displayAccountBalance);
		actionButtonPanel.add(makeADeposit);
		actionButtonPanel.add(makeAWithdrawal);

		keyPadPanel = new JPanel();
		keyPadPanel.setLayout(new GridLayout(4, 3));

		for (int i = 0; i < 12; i++) {
			if (i == 9)
				keyPadPanel.add(new JButton("0"));
			else if (i == 10)
				keyPadPanel.add(new JButton("."));
			else if (i == 11)
				keyPadPanel.add(new JButton("ENTER"));
			else
				keyPadPanel.add(new JButton("" + (i + 1) + ""));

		}

		client = new JPanel();
		client.setLayout(new BoxLayout(client, BoxLayout.Y_AXIS));
		client.add(actionButtonPanel);
		client.add(dataEntry);
		client.add(keyPadPanel);

		outputs = new JPanel();
		outputs.setLayout(new BoxLayout(outputs, BoxLayout.Y_AXIS));
		outputs.add(output);
		outputs.add(message);

		
		frame.add(client, BorderLayout.WEST);
		frame.add(outputs, BorderLayout.CENTER);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		// Retrieve the dataFilePath command-line argument

		String dataFilePath = "C:/Users/student/eclipse-workspace/lab12-ex2/src/test.dat";
		ATMClient client = new ATMClient();
		try {
			System.out.println("Reading data file: " + dataFilePath);
			// Create the data source and load the Bank data
			DataSource dataSource = new DataSource(dataFilePath);
			dataSource.loadData();

			// Run the ATM GUI
			
			client.launchFrame();

		} catch (IOException ioe) {
			System.out.println("Could not load the data file.");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace(System.err);

		}
		client.launchFrame();
	}

}
