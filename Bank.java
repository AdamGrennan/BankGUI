/*
 * Author: Adam Grennan
 * Student number: C21445412
*/

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Bank extends JFrame implements ItemListener {
	ArrayList<Customer> list;
	ArrayList<CustomerAccount> accountList;
	ArrayList<AccountTransaction> transactionList;
	ListIterator<Customer> iterator;

	CardLayout card;
	JPanel mainPanel, addPanel, modifyPanel, removePanel, addAccPanel, removeAccPanel, modifyAccPanel, viewPanel,
			viewAccPanel, lodgementPanel, withDrawalPanel, viewTranPanel;
	JButton b1, b2, b3;
	Container c;

	JMenuBar menuBar;
	JMenu customer, accounts, dataBase, transactions, bruh;
	JRadioButtonMenuItem addC, modifyC, removeC, addAccount, modifyAccount, removeAccount, viewCustomers, lodgements,
			withDrawals, viewAcc, viewTran;
	ButtonGroup group = new ButtonGroup();
	Font font = new Font("Arial", Font.BOLD, 12);

	public Bank() {
		list = new ArrayList<Customer>();
		accountList = new ArrayList<CustomerAccount>();
		transactionList = new ArrayList<AccountTransaction>();

		this.setTitle("Bank Control Menu");

		c = getContentPane();

		mainPanel = new JPanel();

		addCus();
		modifyCus();
		removeCus();
		addAcc();
		modifyAcc();
		removeAcc();
		lodgement();
		withdrawal();
		displayAccounts();
		displayCustomers();
		displayTransactions();

		menuBar = new JMenuBar();
		customer = new JMenu("Customer Actions");
		addC = new JRadioButtonMenuItem("Add Customer");
		modifyC = new JRadioButtonMenuItem("Modify Customer");
		removeC = new JRadioButtonMenuItem("Remove Customer");

		group.add(addC);
		group.add(modifyC);
		group.add(removeC);

		addC.addItemListener(this);
		modifyC.addItemListener(this);
		removeC.addItemListener(this);

		customer.add(addC);
		customer.add(modifyC);
		customer.add(removeC);
		menuBar.add(customer);

		accounts = new JMenu("Customer Accounts");
		addAccount = new JRadioButtonMenuItem("Add Customer Account");
		modifyAccount = new JRadioButtonMenuItem("Modify Customer Account");
		removeAccount = new JRadioButtonMenuItem("Remove Customer Account");
		group.add(addAccount);
		group.add(modifyAccount);
		group.add(removeAccount);

		addAccount.addItemListener(this);
		modifyAccount.addItemListener(this);
		removeAccount.addItemListener(this);

		accounts.add(addAccount);
		accounts.add(modifyAccount);
		accounts.add(removeAccount);
		menuBar.add(accounts);

		dataBase = new JMenu("Database");
		viewCustomers = new JRadioButtonMenuItem("View Customers");
		viewTran = new JRadioButtonMenuItem("View Account Transactions");
		group.add(viewCustomers);
		group.add(viewTran);

		viewCustomers.addItemListener(this);
		viewTran.addItemListener(this);

		dataBase.add(viewCustomers);
		dataBase.add(viewTran);
		menuBar.add(dataBase);

		transactions = new JMenu("Transactions");
		lodgements = new JRadioButtonMenuItem("Lodgement");
		withDrawals = new JRadioButtonMenuItem("Withdrawal");
		group.add(lodgements);
		group.add(withDrawals);

		lodgements.addItemListener(this);
		withDrawals.addItemListener(this);

		transactions.add(lodgements);
		transactions.add(withDrawals);
		menuBar.add(transactions);

		viewAcc = new JRadioButtonMenuItem("View Accounts");
		group.add(viewAcc);
		viewAcc.addItemListener(this);
		dataBase.add(viewAcc);

		setJMenuBar(menuBar);

		card = new CardLayout(40, 30);
		mainPanel.setLayout(card);
		// Customer Panels
		mainPanel.add(addPanel, "Add Customer");
		mainPanel.add(modifyPanel, "Modify Customer");
		mainPanel.add(removePanel, "Remove Customer");
		// Customer Account Panels
		mainPanel.add(addAccPanel, "Add Customer Account");
		mainPanel.add(modifyAccPanel, "Modify Customer Account");
		mainPanel.add(removeAccPanel, "Remove Customer Account");
		// Database Panels
		mainPanel.add(viewPanel, "View Customers");
		mainPanel.add(viewAccPanel, "View Accounts");
		mainPanel.add(viewTranPanel, "View Account Transactions");
		// Transaction Panels
		mainPanel.add(lodgementPanel, "Lodgement");
		mainPanel.add(withDrawalPanel, "Withdrawal");

		c.add(mainPanel, BorderLayout.CENTER);
	}

	public void addCus() {
		JLabel ppsLabel, fNameLabel, sNameLabel, dateLabel, passwordLabel;
		JPanel subPanel, buttonPanel;
		JTextField pps, fName, sName;
		JPasswordField password;
		JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		date.setValue(new Date());
		date.setColumns(20);

		pps = new JTextField(20);
		fName = new JTextField(20);
		sName = new JTextField(20);
		password = new JPasswordField(20);

		ppsLabel = new JLabel("PPS number");
		fNameLabel = new JLabel("First name");
		sNameLabel = new JLabel("Surname");
		dateLabel = new JLabel("Date");
		passwordLabel = new JLabel("Create a 7 digit password");

		addPanel = new JPanel(new BorderLayout());
		addPanel.setBorder(new TitledBorder("Add Customer"));

		subPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		addPanel.add(subPanel, BorderLayout.WEST);

		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(ppsLabel, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(pps, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(fNameLabel, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(fName, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel.add(sNameLabel, c);
		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(sName, c);

		c.gridx = 1;
		c.gridy = 3;
		subPanel.add(dateLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		subPanel.add(date, c);

		c.gridx = 1;
		c.gridy = 4;
		subPanel.add(passwordLabel, c);
		c.gridx = 0;
		c.gridy = 4;
		subPanel.add(password, c);

		buttonPanel = new JPanel();
		addPanel.add(buttonPanel, BorderLayout.SOUTH);
		JButton addButton = new JButton("Create Customer");
		buttonPanel.add(addButton);

		JButton clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		JTextArea display = new JTextArea();
		display.setEditable(false);
		addPanel.add(display, BorderLayout.CENTER);
		addPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		display.setFont(font);

		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Customer s;
				Customer x;
				String pps1 = pps.getText();
				String name = fName.getText();
				String sname = sName.getText();
				String date1 = date.getText();
				String password1 = password.getText();
				int id = 0;
				s = new Customer(pps1, name, sname, date1, id, password1);
				x = findCustomer(pps1);
				if (x != null) {
					display.append("\nCould not add user to database as user with this PPS already exists");
				} else {
					list.add(s);

					iterator = list.listIterator();

					display.append("\nCustomer " + " " + s.getfName() + " " + s.getSName() + " " + "added to databaae");
				}
			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pps.setText("");
				fName.setText("");
				sName.setText("");
				date.setText("");
				password.setText("");
			}
		});
		password.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (password.getText().length() >= 7)
					e.consume();
			}
		});

	}

	public void modifyCus() {
		JLabel ppsLabel, fNameLabel, sNameLabel, passwordLabel;
		JPanel subPanel, buttonPanel;
		JTextField pps, fName, sName;
		JPasswordField password;
		modifyPanel = new JPanel(new BorderLayout());
		modifyPanel.setBorder(new TitledBorder("Modify Customer"));

		pps = new JTextField(20);
		fName = new JTextField(20);
		sName = new JTextField(20);
		password = new JPasswordField(20);

		ppsLabel = new JLabel("PPS number");
		fNameLabel = new JLabel("First name");
		sNameLabel = new JLabel("Surname");
		passwordLabel = new JLabel("Enter Password");

		subPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		modifyPanel.add(subPanel, BorderLayout.WEST);

		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(ppsLabel, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(pps, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(fNameLabel, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(fName, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel.add(sNameLabel, c);
		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(sName, c);

		c.gridx = 1;
		c.gridy = 3;
		subPanel.add(passwordLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		subPanel.add(password, c);

		buttonPanel = new JPanel();
		modifyPanel.add(buttonPanel, BorderLayout.SOUTH);
		JButton modifyButton = new JButton("Modify Customer Details");
		buttonPanel.add(modifyButton);

		JButton clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		JTextArea display = new JTextArea();
		display.setEditable(false);
		modifyPanel.add(display, BorderLayout.CENTER);
		modifyPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		display.setFont(font);

		modifyButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Customer s;
				Customer x;
				String PPS = pps.getText();
				String name = fName.getText();
				String sname = sName.getText();
				String passWord = password.getText();

				s = logIn();
				x = findCustomer(PPS);
				if (s == null) {
					display.append("\nSorry no such customer in database");
				} else if (x != null) {
					display.append("\nCan not modify this customer as this PPS already exists");
				} else {

					display.append("\nCustomer details sucessfully modified");
					s.setPPS(PPS);
					s.setfName(name);
					s.setSName(sname);
					s.setPassword(passWord);

				}
			}
		});

	}

	public void removeCus() {

		JLabel ppsLabel1, fNameLabel1, sNameLabel1, passwordLabel1;
		JPanel subPanel1, buttonPanel1;
		JTextField pps1, fName1, sName1;
		JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		date.setValue(new Date());
		JPasswordField password1;

		removePanel = new JPanel(new BorderLayout());
		removePanel.setBorder(new TitledBorder("Remove Customer"));

		pps1 = new JTextField(20);
		fName1 = new JTextField(20);
		sName1 = new JTextField(20);
		password1 = new JPasswordField(20);

		ppsLabel1 = new JLabel("PPS number");
		fNameLabel1 = new JLabel("First name");
		sNameLabel1 = new JLabel("Surname");
		passwordLabel1 = new JLabel("Enter Password");

		subPanel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		removePanel.add(subPanel1, BorderLayout.WEST);

		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel1.add(ppsLabel1, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel1.add(pps1, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel1.add(fNameLabel1, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel1.add(fName1, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel1.add(sNameLabel1, c);
		c.gridx = 0;
		c.gridy = 2;
		subPanel1.add(sName1, c);

		c.gridx = 1;
		c.gridy = 3;
		subPanel1.add(passwordLabel1, c);
		c.gridx = 0;
		c.gridy = 3;
		subPanel1.add(password1, c);

		buttonPanel1 = new JPanel();
		removePanel.add(buttonPanel1, BorderLayout.SOUTH);
		JButton removeButton = new JButton("Remove Customer");
		buttonPanel1.add(removeButton);

		JButton clearButton = new JButton("Clear");
		buttonPanel1.add(clearButton);

		JTextArea view = new JTextArea();
		view.setEditable(false);
		removePanel.add(view, BorderLayout.CENTER);
		removePanel.add(new JScrollPane(view), BorderLayout.CENTER);

		view.setFont(font);

		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer s;
				String pps = pps1.getText();
				String name = fName1.getText();
				String sname = sName1.getText();
				String password = password1.getText();

				s = cancelCustomer(pps, name, sname, password);

				if (s == null) {
					view.append("\nSorry no such customer in database");

				} else {
					if (s.getLocation() == null) {
						list.remove(s);
						view.append("\nCustomer has been removed");
					} else {
						view.append("\nCustomer has an account so can not be removed");
					}
				}
			}

		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pps1.setText("");
				fName1.setText("");
				sName1.setText("");
				date.setText("");
				password1.setText("");
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButtonMenuItem mi = (JRadioButtonMenuItem) e.getItem();
		String myPanelName = mi.getText();
		CardLayout cl = (CardLayout) (mainPanel.getLayout());
		cl.show(mainPanel, myPanelName);
	}

	public void addAcc() {
		JButton addBtn, clearButton;
		JPanel buttonPanel, subPanel;
		JTextArea display;
		JTextField number;
		JLabel num, bal;
		JFormattedTextField balance = new JFormattedTextField(new DecimalFormat("###,###.##"));
		balance.setColumns(20);
		balance.setValue(1000.00);

		addAccPanel = new JPanel(new BorderLayout());
		addAccPanel.setBorder(new TitledBorder("Add Customer Account"));

		buttonPanel = new JPanel();
		addBtn = new JButton("Create Customer Account");
		buttonPanel.add(addBtn);
		addAccPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		display.setEditable(false);
		addAccPanel.add(display, BorderLayout.CENTER);
		addAccPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		subPanel = new JPanel(new GridBagLayout());
		number = new JTextField(20);
		num = new JLabel("Account Number");
		bal = new JLabel("Account Balance");

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		GridBagConstraints c = new GridBagConstraints();
		addAccPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(num, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(number, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(bal, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(balance, c);
		display.setFont(font);

		// Asks customer to log in if they have an account
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer s;
				CustomerAccount a;
				CustomerAccount x;
				String numeric = number.getText();
				double amount = ((Number) balance.getValue()).doubleValue();
				s = logIn();
				x = findAccount(numeric);
				if (s == null) {
					display.append("\nSorry no such customer in database");
				} else if (s.getLocation() != null) {
					display.append("\nCustomer already has account");
				} else if (x != null) {
					display.append("\nAccount with this number already exists");
				} else {

					display.append("\nCustomer found in database");
					a = new CustomerAccount(numeric, amount);
					accountList.add(a);
					s.setLocation(a);
				}
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.setText("");
				balance.setText("");
			}

		});
	}

	public void modifyAcc() {
		JButton modifyBtn, clearButton;
		JPanel buttonPanel, subPanel;
		JTextArea display;
		JTextField number;
		JLabel num, bal;
		JFormattedTextField balance = new JFormattedTextField(new DecimalFormat("###,###.##"));
		balance.setColumns(20);
		balance.setValue(1000.00);

		modifyAccPanel = new JPanel(new BorderLayout());
		modifyAccPanel.setBorder(new TitledBorder("Modify Customer Account"));

		buttonPanel = new JPanel();
		modifyBtn = new JButton("Modify Customer Account");
		buttonPanel.add(modifyBtn);
		modifyAccPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		display.setEditable(false);
		modifyAccPanel.add(display, BorderLayout.CENTER);
		modifyAccPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		subPanel = new JPanel(new GridBagLayout());
		number = new JTextField(20);
		num = new JLabel("Account Number");
		bal = new JLabel("Account Balance");

		GridBagConstraints c = new GridBagConstraints();
		modifyAccPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(num, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(number, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(bal, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(balance, c);
		display.setFont(font);

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccount a;
				String numeric = number.getText();
				double amount = ((Number) balance.getValue()).doubleValue();
				a = logInAcc();
				if (a == null) {
					display.append("\nSorry no such customer in database");
				} else {

					display.append("\nCustomer found in database");
					a.setANumber(numeric);
					a.setBalance(amount);

				}
			}

		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.setText("");
				balance.setText("");
			}

		});

	}

	public void removeAcc() {
		JButton removeBtn, clearButton;
		JPanel buttonPanel, subPanel;
		JTextArea display;
		JTextField number;
		JLabel num;

		removeAccPanel = new JPanel(new BorderLayout());
		removeAccPanel.setBorder(new TitledBorder("Remove Customer Account"));

		buttonPanel = new JPanel();
		removeBtn = new JButton("Remove Customer Account");
		buttonPanel.add(removeBtn);
		removeAccPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		display.setEditable(false);
		removeAccPanel.add(display, BorderLayout.CENTER);
		removeAccPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		subPanel = new JPanel(new GridBagLayout());
		number = new JTextField(20);
		num = new JLabel("Account Number");

		GridBagConstraints c = new GridBagConstraints();
		removeAccPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(num, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(number, c);
		display.setFont(font);

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccount s;
				AccountTransaction x;
				Customer a = null;
				String numeric = number.getText();

				s = findAccount(numeric);
				x = findTran(s);
				a = logIn();

				if (s == null || a == null || x == null) {
					display.append("\nSorry no such customer in database");

				} else {
					if (s.getBalance() == 0) {
						accountList.remove(s);
						transactionList.remove(x);
						a.setLocation(null);
						display.append("\nCustomer Account succesfully removed");
					} else {
						display.append("\nCustomer has an account but it has a balance abouve 0");
					}
				}

			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.setText("");
			}

		});

	}

	public void lodgement() {
		JLabel amount, account, time;
		JPanel subPanel, buttonPanel;
		JButton lodgeBtn, clearButton;
		JTextArea display;
		JTextField num;
		JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		date.setValue(new Date());
		date.setColumns(20);
		JFormattedTextField lodge = new JFormattedTextField(new DecimalFormat("###,###.##"));
		lodge.setColumns(20);
		lodge.setValue(1000.00);

		lodgementPanel = new JPanel(new BorderLayout());
		lodgementPanel.setBorder(new TitledBorder("Lodge Money into Account"));

		buttonPanel = new JPanel();
		lodgeBtn = new JButton("Confirm");
		buttonPanel.add(lodgeBtn);
		lodgementPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		display.setEditable(false);
		lodgementPanel.add(display, BorderLayout.CENTER);
		lodgementPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		subPanel = new JPanel(new GridBagLayout());
		amount = new JLabel("Input Amount");

		account = new JLabel("Account Number");
		num = new JTextField(20);

		time = new JLabel("Date");

		GridBagConstraints c = new GridBagConstraints();
		lodgementPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(account, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(num, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(amount, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(lodge, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel.add(time, c);
		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(date, c);
		display.setFont(font);

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		lodgeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccount s;
				Customer a = null;
				AccountTransaction x;
				double amount = ((Number) lodge.getValue()).doubleValue();
				String numeric = num.getText();
				String time = date.getText();
				String type = "Lodgement";
				double bal = 0;

				a = logIn();
				s = findAccount(numeric);

				if (a == null || s == null) {
					display.append("\nSorry no such customer in database");

				} else {
					bal = amount + s.getBalance() - 15;
					display.append("\nAccount Balance Updated");
					x = new AccountTransaction(s, time, type, amount);
					transactionList.add(x);
					s.setBalance(bal);

				}
			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lodge.setText("");
				num.setText("");
				date.setText("");
			}

		});

	}

	public void withdrawal() {
		JLabel amount, account, time;
		JPanel subPanel, buttonPanel;
		JButton withBtn, clearButton;
		JTextArea display;
		JTextField num;
		JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		date.setValue(new Date());
		date.setColumns(20);
		JFormattedTextField lodge = new JFormattedTextField(new DecimalFormat("###,###.##"));
		lodge.setColumns(20);
		lodge.setValue(1000.00);

		withDrawalPanel = new JPanel(new BorderLayout());
		withDrawalPanel.setBorder(new TitledBorder("Withdraw Money from Account"));

		buttonPanel = new JPanel();
		withBtn = new JButton("Confirm");
		buttonPanel.add(withBtn);

		withDrawalPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		display.setEditable(false);
		withDrawalPanel.add(display, BorderLayout.CENTER);
		withDrawalPanel.add(new JScrollPane(display), BorderLayout.CENTER);

		subPanel = new JPanel(new GridBagLayout());
		amount = new JLabel("Input Amount");

		account = new JLabel("Account Number");
		num = new JTextField(20);

		time = new JLabel("Date");
		GridBagConstraints c = new GridBagConstraints();
		withDrawalPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(account, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(num, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(amount, c);
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(lodge, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel.add(time, c);
		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(date, c);
		display.setFont(font);

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

		withBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccount s;
				Customer a = null;
				AccountTransaction x;
				double amount = ((Number) lodge.getValue()).doubleValue();
				String numeric = num.getText();
				String time = date.getText();
				String type = "Withdrawal";
				double bal = 0;

				a = logIn();
				s = findAccount(numeric);

				if (a == null || s == null) {
					display.append("\nSorry no such customer in database");

				} else {
					bal = s.getBalance() - 15 - amount;
					display.append("\nAccount Balance Updated");
					x = new AccountTransaction(s, time, type, amount);
					transactionList.add(x);
					s.setBalance(bal);

				}
			}
		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lodge.setText("");
				num.setText("");
				date.setText("");
			}

		});

	}

	public void displayCustomers() {
		JButton next, previous, first, last;
		JPanel buttonPanel;
		JTextArea display;

		viewPanel = new JPanel(new BorderLayout());
		viewPanel.setBorder(new TitledBorder("View Customers"));
		buttonPanel = new JPanel();
		first = new JButton("First");
		buttonPanel.add(first);
		next = new JButton("Next");
		buttonPanel.add(next);
		previous = new JButton("Previous");
		buttonPanel.add(previous);
		last = new JButton("Last");
		buttonPanel.add(last);

		viewPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		viewPanel.add(display, BorderLayout.CENTER);
		viewPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		display.setEditable(false);

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer a = null;
				if (iterator.hasNext()) {
					a = iterator.next();
					display.setText(a.toString());
				}
			}

		});

		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer a = iterator.previous();
				if (iterator.hasPrevious()) {
					display.setText(a.toString());
				}
			}
		});

		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer a = null;
				a = list.get(0);
				display.setText(a.toString());

			}

		});

		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer a = null;
				a = list.get(list.size() - 1);
				display.setText(a.toString());

			}

		});

	}

	public void displayAccounts() {
		JPanel buttonPanel;
		JTextArea display;
		JButton viewBtn;

		viewAccPanel = new JPanel(new BorderLayout());
		viewAccPanel.setBorder(new TitledBorder("View Accounts"));

		buttonPanel = new JPanel();
		viewBtn = new JButton("View Account");
		buttonPanel.add(viewBtn);
		viewAccPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		viewAccPanel.add(display, BorderLayout.CENTER);
		viewAccPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		display.setEditable(false);

		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer a = null;
				CustomerAccount x = null;
				a = logIn();
				x = logInAcc();
				if (a == null || x == null) {
					display.append("\nSorry no such customer or account in database");

				} else {
					if (a.getLocation() == null) {
						display.append("\nCustomer found but they do not have an account ");
					} else {
						display.append("\nAccount Found");
						display.setText(x.toString());
					}
				}
			}

		});

	}

	public void displayTransactions() {
		JPanel subPanel, buttonPanel;
		JTextArea display;
		JButton viewBtn, clearButton, clearText;
		JTextField acc;
		JLabel account;

		viewTranPanel = new JPanel(new BorderLayout());
		viewTranPanel.setBorder(new TitledBorder("View Transactions"));

		buttonPanel = new JPanel();
		viewBtn = new JButton("View Transactions");
		buttonPanel.add(viewBtn);
		viewTranPanel.add(buttonPanel, BorderLayout.SOUTH);

		display = new JTextArea();
		viewTranPanel.add(display, BorderLayout.CENTER);
		viewTranPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		display.setEditable(false);

		acc = new JTextField(20);
		account = new JLabel("Account Number");

		subPanel = new JPanel();

		GridBagConstraints c = new GridBagConstraints();
		viewTranPanel.add(subPanel, BorderLayout.WEST);
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(account, c);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(acc, c);
		display.setFont(font);

		clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);
		clearText = new JButton("Clear Text Area");
		buttonPanel.add(clearText);

		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountTransaction a = null;
				CustomerAccount z;
				Customer x;
				String numeric = acc.getText();
				z = findAccount(numeric);
				a = findTran(z);
				x = logIn();
				if (a == null || z == null || x == null) {
					display.append("\nSorry no such customer in database");

				} else {
					if (x.getLocation() == null) {
						display.append("\nCustomer found but they do not have an account ");
					} else {
						AccountTransaction y = null;
						for (AccountTransaction p : transactionList) {
							if (z.equals(p.getNum())) {

								y = p;
								display.setText(y.toString());

							}
						}
					}
				}
			}

		});
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acc.setText("");
			}

		});

		clearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("");
			}

		});
	}

//Methods for ArrayList searching
	public Customer cancelCustomer(String pps, String name, String sname, String password) {

		Customer a = null;

		for (Customer p : list) {
			if (pps.equalsIgnoreCase(p.getPPS()) && name.equalsIgnoreCase(p.getfName())
					&& sname.equalsIgnoreCase(p.getSName()) && password.equalsIgnoreCase(p.getPassWord())) {
				a = p;
			}
		}

		return a;
	}

	public Customer findCustomer(String pps) {

		Customer a = null;

		for (Customer p : list) {
			if (pps.equalsIgnoreCase(p.getPPS())) {
				a = p;
			}
		}

		return a;
	}

	public CustomerAccount findAccount(String number) {
		CustomerAccount a = null;

		for (CustomerAccount p : accountList) {
			if (number.equalsIgnoreCase(p.getANumber())) {

				a = p;
			}
		}
		return a;
	}

	public AccountTransaction findTran(CustomerAccount number) {
		AccountTransaction a = null;

		for (AccountTransaction p : transactionList) {
			if (number.equals(p.getNum())) {

				a = p;

			}
		}
		return a;
	}

	public Customer logIn() {
		Customer c = null;
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter your password:");
		JLabel label1 = new JLabel("Enter your PPS number:");
		JPasswordField pass = new JPasswordField(10);
		JTextField user = new JTextField(10);
		panel.add(label1);
		panel.add(user);
		panel.add(label);
		panel.add(pass);

		String[] options = new String[] { "OK", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, panel, "Customer Log In", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) {
			char[] password = pass.getPassword();
			String text = user.getText();
			String s = String.valueOf(password);
			for (Customer p : list) {
				if (text.equalsIgnoreCase(p.getPPS()) && s.equals(p.getPassWord()) || s.equals(p.getAdminPass())) {
					c = p;
				}

			}
		}
		return c;
	}

	public CustomerAccount logInAcc() {
		CustomerAccount c = null;
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter your Account Number:");

		JTextField acc = new JTextField(10);
		panel.add(acc);
		panel.add(label);

		String[] options = new String[] { "OK", "Cancel" };
		int option = JOptionPane.showOptionDialog(null, panel, "Create Customer Account", JOptionPane.NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (option == 0) {
			String text = acc.getText();
			for (CustomerAccount p : accountList) {
				if (text.equalsIgnoreCase(p.getANumber())) {
					c = p;
				}

			}
		}
		return c;
	}

	public static void main(String[] args) {
		Bank b = new Bank();
		b.setSize(1000, 1000);
		b.setVisible(true);
		b.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}