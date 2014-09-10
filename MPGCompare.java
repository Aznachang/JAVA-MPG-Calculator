package MPG;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.*;

public class MPGCompare {

	//Variables on JPanels
	private JFrame frmCarMpgComparison;
	private JTextField txtTankSize;
	private JTextField txtPrice;
	private JTextField txtClaimMPG;
	private JTextField txtAvgMPG;
	private JTextField txtFill;
	private JTextField txtDate;
	private JTextField txtMilesDriven;

	//variables - comboBoxCar
	private double m_mpg;
	private String m_Date;
	private boolean Date_OK = false;		
	//Date date = null;
	private double m_MilesDriven;
	private double m_GallonsFilled;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MPGCompare window = new MPGCompare();
					window.frmCarMpgComparison.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}

	/**
	 * Create the application.
	 */
	public MPGCompare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarMpgComparison = new JFrame();
		frmCarMpgComparison.setTitle("Car MPG Comparison");
		frmCarMpgComparison.setBounds(100, 100, 325, 340);
		frmCarMpgComparison.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarMpgComparison.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Panel Initial Set-Up
		final JPanel CarMenu = new JPanel();
		frmCarMpgComparison.getContentPane().add(CarMenu, "name_2311361691594");
		CarMenu.setLayout(null);
		CarMenu.setVisible(true);
		
		final JPanel Statistics = new JPanel();
		frmCarMpgComparison.getContentPane().add(Statistics, "name_2315729688832");
		Statistics.setLayout(null);
		Statistics.setVisible(false);

		final JLabel lblCAR = new JLabel("");
		lblCAR.setHorizontalAlignment(SwingConstants.CENTER);
		lblCAR.setBounds(99, 11, 125, 14);
		Statistics.add(lblCAR);
		
		//Create a Map for storage
		final Map<String, List<String>> map = new HashMap<String,List<String>>();
		
		//Car 'ArrayList' for Each of the Six Cars Pre-populated in 'ComboBox'
		final List<String> carOne = new ArrayList<String>();	//Chevy
		final List<String> carTwo = new ArrayList<String>();	//Ford
		final List<String> carThree = new ArrayList<String>();	//Honda 
		final List<String> carFour = new ArrayList<String>();	//Hyundai
		final List<String> carFive = new ArrayList<String>();	//Mazda
		final List<String> carSix = new ArrayList<String>();	//Toyota
		
		//Map out Cars (key) with their respective MPGs and dates (values)
		map.put("Chevrolet Cruze", carOne);
		map.put("Ford Focus", carTwo);
		map.put("Honda Civic", carThree);
		map.put("Hyundai Elantra", carFour);
		map.put("Mazda 3", carFive);
		map.put("Toyota Corolla", carSix);
		
		//Round to 2 Decimal Values
		final DecimalFormat df = new DecimalFormat(".##");
		//Date Format
		final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chevrolet Cruze", "Ford Focus", "Honda Civic", "Hyundai Elantra", "Mazda 3", "Toyota Corolla"}));
		comboBox.setBounds(30, 60, 242, 20);
		CarMenu.add(comboBox);
		
		//----------------------Car Main Menu Panel---------------------------------
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 124, 242, 2);
		CarMenu.add(separator);
		
		//Statistics BUTTON
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Initialize 'MPG statistical data' class
				final MPG_Data data = new MPG_Data();	
				
				//Key is assigned to Selected 'Car' ComboBox selection
				String key = comboBox.getSelectedItem().toString();
				//Obtain List of MPG and Date Values from the specific 'Car' key
				List<String> values = map.get(key);
				
				lblCAR.setText(comboBox.getSelectedItem().toString());
				
				//Get the MPG Data Figures	
				data.Total_MPG(values);
				
				//Round to 2 decimal places for "AvgMPG' textbox
				String AvgMpg = df.format(data.Avg_MPG());
				
				//Initially the Average MPG will be 'NaN' because there is no MPG data (user has to add via 'Add Fuel' button) 
				  if (comboBox.getSelectedItem().equals("Chevrolet Cruze"))
				  {
					  txtTankSize.setText("14");
					  txtPrice.setText("$18,118 - $25,174");
					  txtClaimMPG.setText("25 City / 35 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  else if (comboBox.getSelectedItem().equals("Ford Focus"))
				  {
					  txtTankSize.setText("13.2");
					  txtPrice.setText("$17,125 - $23,972");
					  txtClaimMPG.setText("26 City / 36 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  else if (comboBox.getSelectedItem().equals("Honda Civic"))
				  {
					  txtTankSize.setText("14");
					  txtPrice.setText("$18,014 - $28,530");
					  txtClaimMPG.setText("30 City / 39 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  else if (comboBox.getSelectedItem().equals("Hyundai Elantra"))
				  {
					  txtTankSize.setText("13.2");
					  txtPrice.setText("$17,556 - $22,008");
					  txtClaimMPG.setText("27 City / 37 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  else if (comboBox.getSelectedItem().equals("Mazda 3"))
				  {
					  txtTankSize.setText("14");
					  txtPrice.setText("$17,265 - $26,426");
					  txtClaimMPG.setText("30 City / 41 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  else if (comboBox.getSelectedItem().equals("Toyota Corolla"))
				  {
					  txtTankSize.setText("13.2");
					  txtPrice.setText("$16,960 - $21,234");
					  txtClaimMPG.setText("27 City / 36 Hwy");
					  txtAvgMPG.setText(AvgMpg);
				  }
				  
				  //Switch to Statistics Panel upon clicking on 'Statistics' button
					Statistics.setVisible(true);
					CarMenu.setVisible(false);	  
			}
		});
		btnStatistics.setBounds(66, 202, 166, 23);
		CarMenu.add(btnStatistics);
			
		JLabel lblCompactSedanManufacturer = new JLabel("Compact Sedan Manufacturer/ Model");
		lblCompactSedanManufacturer.setBounds(30, 27, 213, 39);
		CarMenu.add(lblCompactSedanManufacturer);
		
		//----------------------Car Statistics Panel------------------------------
		JLabel lblTankSizegallons = new JLabel("Tank Size (Gallons)");
		lblTankSizegallons.setBounds(20, 39, 192, 14);
		Statistics.add(lblTankSizegallons);
		
		txtTankSize = new JTextField();
		txtTankSize.setEditable(false);
		txtTankSize.setColumns(10);
		txtTankSize.setBounds(20, 59, 189, 20);
		Statistics.add(txtTankSize);
		
		JLabel lblPrice = new JLabel("Price ($)");
		lblPrice.setBounds(20, 90, 192, 14);
		Statistics.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(20, 110, 189, 20);
		Statistics.add(txtPrice);
		
		JLabel lblTheoreticalMpg = new JLabel("Theoretical MPG");
		lblTheoreticalMpg.setBounds(20, 150, 192, 14);
		Statistics.add(lblTheoreticalMpg);
		
		txtClaimMPG = new JTextField();
		txtClaimMPG.setEditable(false);
		txtClaimMPG.setColumns(10);
		txtClaimMPG.setBounds(20, 170, 189, 20);
		Statistics.add(txtClaimMPG);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statistics.setVisible(false);
				CarMenu.setVisible(true);
			}
		});
		btnOk.setBounds(120, 267, 89, 23);
		Statistics.add(btnOk);
		
		JLabel lblActualAvgMpg = new JLabel("Tested Actual Avg MPG");
		lblActualAvgMpg.setBounds(20, 205, 192, 14);
		Statistics.add(lblActualAvgMpg);
		
		txtAvgMPG = new JTextField();
		txtAvgMPG.setEditable(false);
		txtAvgMPG.setColumns(10);
		txtAvgMPG.setBounds(20, 225, 189, 20);
		Statistics.add(txtAvgMPG);

		//------------------------Actual MPG Figures Panel------------------------
		final JPanel ActualMPG = new JPanel();
		frmCarMpgComparison.getContentPane().add(ActualMPG, "name_13442105327611");
		ActualMPG.setLayout(null);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActualMPG.setVisible(false);
				CarMenu.setVisible(true);
			}
		});
		btnOk_1.setBounds(108, 256, 89, 23);
		ActualMPG.add(btnOk_1);
		
		final JTextPane txtSumPane = new JTextPane();
		txtSumPane.setEditable(false);
		txtSumPane.setBounds(10, 34, 289, 201);
		ActualMPG.add(txtSumPane);
		
		final JLabel lblCar = new JLabel("");
		lblCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCar.setBounds(92, 11, 129, 14);
		ActualMPG.add(lblCar);
		
		//Actual MPG Figures (All MPG, Last MPG, Last Date)
		JButton btnActualMpgFigures = new JButton("Actual MPG Figures");
		btnActualMpgFigures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				//Initialize 'MPG statistical data' class
				final MPG_Data data = new MPG_Data();	
					
				String key = comboBox.getSelectedItem().toString();
				List<String> values = map.get(key);
				
				//lblCar.setText(key);
				data.Total_MPG(values);
				
				//MPG Summary and Last MPG and Date for each of the six cars in a JTextPane
				if (comboBox.getSelectedItem().equals("Chevrolet Cruze"))
				  {
					  lblCar.setText("Chevrolet Cruze");  
					  txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				  else if (comboBox.getSelectedItem().equals("Ford Focus"))
				  {
					  lblCar.setText("Ford Focus");
					  txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				  else if (comboBox.getSelectedItem().equals("Honda Civic"))
				  {
					  lblCar.setText("Honda Civic");
					  txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				  else if (comboBox.getSelectedItem().equals("Hyundai Elantra"))
				  {
					  lblCar.setText("Hyundai Elantra");
					  txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				  else if (comboBox.getSelectedItem().equals("Mazda 3"))
				  {
					  lblCar.setText("Mazda 3");
					  txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				  else if (comboBox.getSelectedItem().equals("Toyota Corolla"))
				  {
					 lblCar.setText("Toyota Corolla");
					 txtSumPane.setText(data.AllMPG() + "-----------------------------\n" + "Last MPG: " + Double.toString(data.Last_MPG()) + "\n" + "Last Date: " + data.Last_Date());
				  }
				
				ActualMPG.setVisible(true);
				CarMenu.setVisible(false);
			}
		});
		btnActualMpgFigures.setBounds(66, 251, 166, 23);
		CarMenu.add(btnActualMpgFigures);
		
		//--------------------Add Fuel Panel------------------------
		final JPanel AddFuel = new JPanel();
		frmCarMpgComparison.getContentPane().add(AddFuel, "name_23672580070031");
		AddFuel.setLayout(null);
		
		//Add Fuel Button
		JButton btnAddFuel = new JButton("Add Fuel");
		btnAddFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Reset back to stock set values in 'AddFuel' Panel every time user hits 'Add Fuel' Button
				txtMilesDriven.setText("");
				txtDate.setText("01/01/1990");
				txtFill.setText("");
				
				AddFuel.setVisible(true);
				CarMenu.setVisible(false);
			}
		});
		btnAddFuel.setBounds(66, 155, 166, 23);
		CarMenu.add(btnAddFuel);
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddFuel.setVisible(false);
				CarMenu.setVisible(true);
			}
		});
		button.setBounds(158, 233, 89, 23);
		AddFuel.add(button);
		
		//OK Button - This is where the user-input data is done
		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final MPG_Data data = new MPG_Data();
				
				try {
					  m_MilesDriven = Double.parseDouble(txtMilesDriven.getText());
					  m_GallonsFilled = Double.parseDouble(txtFill.getText());
					  m_mpg = m_MilesDriven/m_GallonsFilled;
					  m_Date = txtDate.getText();
					}//end of try statement
				
				  //Make Sure User Types in Double Values for 'Miles Driven' and 'Gallons Filled'
		          catch(NumberFormatException e) 
		            {
		            	JOptionPane.showMessageDialog(null,"Invalid Values entered!","Warning",JOptionPane.WARNING_MESSAGE);
		            	return;
		            }
			
					//Validate Date Format: (MM/dd/yyyy)
					Date_OK = data.isValidDate(m_Date);
				
					if(Date_OK ==false){
						JOptionPane.showMessageDialog(null,"Must Enter Correct Date Format: MM/dd/yyyy!","Warning",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
		            //check if the user inputs BLANK miles
		            if (txtMilesDriven.getText() == "" || txtDate.getText() == "" || txtFill.getText() == "")
		            {
		            	JOptionPane.showMessageDialog(null,"Inputs cannot be blank!","Warning",JOptionPane.WARNING_MESSAGE);
		            	return;
		            }
		            
		            //Make sure user enters positive values for 'Miles Driven' and 'Gallons Filled'
		            else if (Float.parseFloat(txtMilesDriven.getText()) <=0.0 || Float.parseFloat(txtFill.getText()) <= 0.0)
		            {
		            	JOptionPane.showMessageDialog(null,"Must enter positive values!","Warning",JOptionPane.WARNING_MESSAGE);
		            	return;
		            }

		            else{
						  String mpg = df.format(m_mpg);
						  
		            	if (comboBox.getSelectedItem().equals("Chevrolet Cruze"))
						  {
							  carOne.add(mpg);
							  carOne.add(m_Date);
						  }
						  else if (comboBox.getSelectedItem().equals("Ford Focus"))
						  {
							  carTwo.add(mpg);
							  carTwo.add(m_Date);
						  }
						  else if (comboBox.getSelectedItem().equals("Honda Civic"))
						  {
							  carThree.add(mpg);
							  carThree.add(m_Date);
						  }
						  else if (comboBox.getSelectedItem().equals("Hyundai Elantra"))
						  {
							  carFour.add(mpg);
							  carFour.add(m_Date);
						  }
						  else if (comboBox.getSelectedItem().equals("Mazda 3"))
						  {
							  carFive.add(mpg);
							  carFive.add(m_Date);
						  }
						  else if (comboBox.getSelectedItem().equals("Toyota Corolla"))
						  {
							  carSix.add(mpg);
							  carSix.add(m_Date);
						  }
		            	
		        		//Key is assigned to Selected 'Car' ComboBox selection
						String key = comboBox.getSelectedItem().toString();
						//Obtain List of MPG and Date Values from the specific 'Car' key
						List<String> values = map.get(key);
						//Get the MPG Data Figures	
						data.Total_MPG(values);
						
						AddFuel.setVisible(false);
						CarMenu.setVisible(true);
		            }
	
		
			}
		});
		button_1.setBounds(47, 233, 89, 23);
		AddFuel.add(button_1);
		
		JLabel label = new JLabel("Gallons Filled Up");
		label.setBounds(47, 157, 200, 50);
		AddFuel.add(label);
		
		txtFill = new JTextField();
		txtFill.setText("0");
		txtFill.setColumns(10);
		txtFill.setBounds(47, 191, 158, 20);
		AddFuel.add(txtFill);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(47, 126, 158, 20);
		AddFuel.add(txtDate);
		
		JLabel lblDate = new JLabel("Date (mm/dd/yyyy)");
		lblDate.setBounds(47, 92, 200, 50);
		AddFuel.add(lblDate);
		
		txtMilesDriven = new JTextField();
		txtMilesDriven.setText("0");
		txtMilesDriven.setColumns(10);
		txtMilesDriven.setBounds(47, 66, 158, 20);
		AddFuel.add(txtMilesDriven);
		
		JLabel label_2 = new JLabel("Miles Driven");
		label_2.setBounds(47, 25, 200, 50);
		AddFuel.add(label_2);
	}
}
