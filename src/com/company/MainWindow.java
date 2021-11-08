package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Objects;

public class MainWindow extends JFrame{

    HashMap<String,String> users = new HashMap<String,String>();

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow("Login panel");
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
    public MainWindow() throws HeadlessException {
        this("undefined");
    }

    public void prefillDB(){
        users.put("john","ruth");
        users.put("martin","luther");
        users.put("steve","jobs");
        users.put("alex","smith");
        users.put("dalai","lama");
    }
    public void printDB(){
        for (String i : users.keySet()) {
            System.out.println(i);
        }
    }
    public MainWindow(String title) throws HeadlessException {
        super(title);
        prefillDB();
        printDB();
        buildFrame();
    }
    void buildFrame(){

        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel message = new JLabel("");
        JLabel login = new JLabel("Login:");
        JTextField loginField = new JTextField("", 20);
        JLabel password = new JLabel("\nHasło");
        JPasswordField passwordField = new JPasswordField("",20);
        JButton submit = new JButton("Zaloguj!");
        JButton reset = new JButton("Reset!");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginInput = loginField.getText();
                String passwordInput = new String(passwordField.getPassword());
                System.out.println(loginInput);
                System.out.println(passwordInput);
                boolean flag = false;
                for (String i : users.keySet()) {
                    System.out.println(i);
                    if(Objects.equals(loginInput, i) && passwordInput.equals(users.get(i))){
                        flag = true;
                        getContentPane().setBackground(Color.GREEN);
                        message.setText("Zalogowano pomyślnie!");
                        break;
                    }
                }
                if(!flag) {
                    message.setText("Login albo hasło niepoprawne!");
                    getContentPane().setBackground(Color.RED);
                }

            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.WHITE);
                loginField.setText("");
                passwordField.setText("");
                message.setText("");
            }
        });
        message.setBounds(20, 70, 200, 20);
        panel.add(message);
        login.setBounds(30,100,100,20);
        panel.add(login);
        loginField.setBounds(100,100,100,20);
        panel.add(loginField);
        password.setBounds(30,130,100,20);
        panel.add(password);
        passwordField.setBounds(100,130,100,20);
        panel.add(passwordField);
        submit.setBounds(60,180,100,20);
        panel.add(submit);
        reset.setBounds(60,210,100,20);
        panel.add(reset);
        setContentPane(panel);
    }


}
