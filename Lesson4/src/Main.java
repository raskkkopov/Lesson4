import javax.swing.*; // Инструменты для создания графических интерфейсов
import java.awt.*; // Добавление базовых классов и интерфейсов, используемые для создания GUI
import java.awt.event.ActionEvent; // Используются для обработки нажатия кнопок и других элементов GUI
import java.awt.event.ActionListener; // Используется для обработки событий, связанных с кнопками


public class Main extends JFrame {
    private final JButton[] buttons;
    private boolean isCrossTurn;

    // Создание интерфейса
    public Main() {
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        isCrossTurn = true;

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
            buttons[i].addActionListener(new ButtonClickListener());
            add(buttons[i]);
        }

        setSize(300, 300);
        setVisible(true);
    }

    // Создание нажатия кнопки
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int buttonIndex = -1;

            for (int i = 0; i < 9; i++) {
                if (buttons[i] == clickedButton) {
                    buttonIndex = i;
                    break;
                }
            }

            if (buttonIndex != -1 && buttons[buttonIndex].getText().isEmpty()) {
                if (isCrossTurn) {
                    buttons[buttonIndex].setText("X");
                } else {
                    buttons[buttonIndex].setText("O");
                }

                isCrossTurn = !isCrossTurn;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}