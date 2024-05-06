import javax.swing.*;

import backend.PaySystem;
import utils.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Payment extends JFrame implements ActionListener {

    int nipIndex = 0;
    private StringBuilder curNIP;
    JPanel fields, keys, confirm;
    JLabel nipSymbol;
    JComboBox<String> cardselector;
    JTextField amount;
    JButton[] key;
    JButton btnconfirm, clr;
    PaySystem pay;

    Random rnd;

    public Payment() {
        super("Autorización de compra");
        rnd = new Random();
        cardselector = new JComboBox<String>();
        curNIP = new StringBuilder();
        pay = new PaySystem();

        init();
        addListeners();
    }

    public void init() {
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fields = new JPanel();
        fields.setLayout(new FlowLayout());

        fields.add(new JLabel("No. Tarjeta"));
        cardselector = new JComboBox<String>(pay.getCardNumbers());
        cardselector.insertItemAt("Seleccione", 0);
        cardselector.setSelectedIndex(0);
        fields.add(cardselector);

        fields.add(new JLabel("Importe"));
        amount = new JTextField();
        amount.setColumns(8);
        fields.add(amount);

        add(fields, BorderLayout.NORTH);

        keys = new JPanel(); // Panel de botones
        confirm = new JPanel(); // Panel de confirmacion
        keys.setLayout(new GridLayout(0, 3, 1, 1));
        confirm.setLayout(new GridLayout(1, 3, 1, 1));
        doConfirmPanel(); // Crea los botones de confirmación
        add(keys, BorderLayout.CENTER);
        keys.setVisible(false);
        add(confirm, BorderLayout.SOUTH);
        confirm.setVisible(false);
        setVisible(true);

    }

    public void addListeners() {
        cardselector.addActionListener(this);
        amount.addActionListener(this);
        btnconfirm.addActionListener(this);
        clr.addActionListener(this);
    }

    private void doConfirmPanel() {
        nipSymbol = new JLabel("", JLabel.CENTER);
        nipSymbol.setFont(new Font("Courier", Font.PLAIN, 16));
        confirm.add(nipSymbol);
        btnconfirm = new JButton("Autorizar");
        btnconfirm.setBackground(Color.green);
        confirm.add(btnconfirm);
        clr = new JButton("Limpiar");
        clr.setBackground(Color.YELLOW);
        confirm.add(clr);
    }

    private void getKeys() {
        key = Utils.getKeys();
        for (int i = 0; i < key.length + 2; i++) {
            if (i == 9 || i == 11) {
                keys.add(new JLabel("")); // Añade espacios entre el ultimo botón
            } 
            else if (i == 10) {
                keys.add(key[i - 1]);
                key[i - 1].addActionListener(this);
            } 
            else {
                keys.add(key[i]);
                key[i].addActionListener(this);
            }
        }
        keys.setVisible(true);
        confirm.setVisible(true);
    }

    private boolean check(String id, String typedNIP, int amount) {
        return pay.verify(id, typedNIP, amount);
    }

    private void reset() {

        if (key != null) {
            for (JButton btn : key) {
                btn.removeActionListener(this);
            }
            keys.removeAll();
            keys.revalidate();
            keys.repaint();
            key = null;
        }
        clear();
        confirm.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cardselector) {
            reset();
        }
        else if (e.getSource() == amount) {
            if (amount.getText().equals("")) {
                Utils.Alert("Por favor, ingrese un importe valido", "Error");
                return;
            } 
            else if (cardselector.getSelectedItem().equals("Seleccione")) {
                Utils.Alert("Por favor, seleccione una tarjeta", "Error");
                return;
            } 
            else if (key == null) {
                getKeys();
                key[0].requestFocus();
                return;
            }
        } 
        else if (e.getSource() instanceof JButton && e.getSource() != btnconfirm && e.getSource() != clr) {
            if (nipIndex < 4)
                typeNIP(((JButton) e.getSource()).getText());
            else
                nipSymbol.setText(nipSymbol.getText());
            return;
        } 
        else if (e.getSource() == btnconfirm) {
            if (check((String) cardselector.getSelectedItem(), curNIP.toString(), Integer.parseInt(amount.getText())))
                Utils.Alert("Pago Autorizado", "");
            else if (!pay.getInfo((String) cardselector.getSelectedItem()).getNIP().equals(curNIP.toString())) 
                Utils.Alert("NIP Incorrecto", "Error");
            else
                Utils.Alert("Fondos Insuficientes", "Error");
            reset();
            return;
        } 
        else if (e.getSource() == clr) {
            clear();
            return;
        }
    }

    private void clear() {
        amount.setText("");
        nipSymbol.setText("");
        curNIP.delete(0, curNIP.length());
        nipIndex = 0;
    }

    private void typeNIP(String n) {
        String nipType = n;
        String astk = "*";
        curNIP.append(nipType);
        nipSymbol.setText(nipSymbol.getText() + astk);
        nipIndex++;
    }

    public static void main(String[] args) throws Exception {
        new Payment();
    }
}
