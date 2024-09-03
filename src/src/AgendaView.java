package src;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class AgendaView extends JFrame implements Observer {
    private final Agenda agenda;
    private final JList<Contato> listaContatos;
    private final DefaultListModel<Contato> listModel;

    private final JTextField nomeField;
    private final JTextField telefoneField;
    private final JButton adicionarButton;
    private final JButton removerButton;
    private final JButton atualizarButton;

    public AgendaView(Agenda agenda) {
        this.agenda = agenda;
        this.agenda.addObserver(this);

        listModel = new DefaultListModel<>();
        listaContatos = new JList<>(listModel);
        nomeField = new JTextField(15);
        telefoneField = new JTextField(15);
        adicionarButton = new JButton("Adicionar");
        removerButton = new JButton("Remover");
        atualizarButton = new JButton("Atualizar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Telefone:"));
        inputPanel.add(telefoneField);
        inputPanel.add(adicionarButton);
        inputPanel.add(removerButton);
        inputPanel.add(atualizarButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(listaContatos), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setTitle("Agenda Telefônica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    public void adicionarController(ActionListener controller) {
        adicionarButton.addActionListener(controller);
        removerButton.addActionListener(controller);
        atualizarButton.addActionListener(controller);
    }

    public Contato getContatoSelecionado() {
        return listaContatos.getSelectedValue();
    }

    public String getNomeField() {
        return nomeField.getText();
    }

    public String getTelefoneField() {
        return telefoneField.getText();
    }

    @Override
    public void update(Observable o, Object arg) {
        listModel.clear();
        for (Contato contato : agenda.getContatos()) {
            listModel.addElement(contato);
        }
    }
}
