package src;



public class AgendaController {
    private Agenda agenda;

    public AgendaController(Agenda agenda) {
        this.agenda = agenda;
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        agenda.adicionarContato(contato);
    }

    public void removerContato(Contato contato) {
        agenda.removerContato(contato);
    }

    public void atualizarContato(Contato contato, String novoNome, String novoTelefone) {
        agenda.atualizarContato(contato, novoNome, novoTelefone);
    }
}
