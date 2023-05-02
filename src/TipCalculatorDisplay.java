import javax.swing.*;
import java.awt.event.*;

public class TipCalculatorDisplay extends JFrame implements ActionListener{
    private JPanel place;
    private JLabel tipPercent;
    private JLabel numPeople;
    private JLabel bill;
    private JLabel total;
    private JLabel tip;
    private JTextArea billText;
    private JTextArea tipPercentText;
    private JTextArea numPeopleText;
    private JTextArea totalText;
    private JTextArea tipText;
    private JButton button1;

    public TipCalculatorDisplay(){
        createUIComponents();
    }

    private void createUIComponents() {

        setContentPane(place);
        setTitle("Tip Calculator");
        setSize(900,700);
        setLocation(50,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button1.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source instanceof JButton){
            JButton button = (JButton) source;
            double billAmount = Double.parseDouble(billText.getText());
            int tipPercentAmount = Integer.parseInt(tipPercentText.getText());
            int amountPeople = Integer.parseInt(numPeopleText.getText());
             TipCalculator calc = new TipCalculator(billAmount, tipPercentAmount, amountPeople);
             double tipAmount = calc.calculateTip();
             double totalBill = calc.totalBill();
             tipText.setText(tipAmount + "");
             totalText.setText(totalBill + "");
        }
    }
}
