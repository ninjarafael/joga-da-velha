import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Grid extends JFrame {
    private Container pane;
    Grid()
    {
        pane = getContentPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        pane.setLayout(new GridLayout(3,  3));
        IntStream.range(0, 9).forEach(i -> pane.add(botao()));
        pack();
        setVisible(true);
    }

    public String getValorBotao(int indice)
    {
        return ((JButton) pane.getComponent(indice)).getText();
    }

    public void popUp(String mensagem)
    {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void desabilitarBotoes()
    {
        for(Component component : pane.getComponents())
        {
            ((JButton) component).setEnabled(false);
        }
    }

    private JButton botao()
    {
        JButton botao = new JButton();

        botao.setPreferredSize(new Dimension(50, 50));
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent)
            {
                clicarBotao(botao);
            }
        });

        return botao;
    }

    private void desabilitarBotao(JButton botao)
    {
        botao.setEnabled(false);
    }

    private void clicarBotao(JButton botao)
    {
        desabilitarBotao(botao);
        botao.setText(JogoDaVelha.getSimbolo());
        JogoDaVelha.mudarSimbolo();
    }
}
