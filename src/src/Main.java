package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        AgendaController controller = new AgendaController(agenda);
        AgendaView view = new AgendaView(agenda);

        view.adicionarController(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = view.getNomeField();
                String telefone = view.getTelefoneField();

                if (e.getActionCommand().equals("Adicionar")) {
                    controller.adicionarContato(nome, telefone);
                } else if (e.getActionCommand().equals("Remover")) {
                    Contato contato = view.getContatoSelecionado();
                    if (contato != null) {
                        controller.removerContato(contato);
                    }
                } else if (e.getActionCommand().equals("Atualizar")) {
                    Contato contato = view.getContatoSelecionado();
                    if (contato != null) {
                        controller.atualizarContato(contato, nome, telefone);
                    }
                }
            }
        });
    }
}
