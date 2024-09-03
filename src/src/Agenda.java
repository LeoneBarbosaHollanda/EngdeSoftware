package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Agenda extends Observable {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        setChanged();
        notifyObservers();
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
        setChanged();
        notifyObservers();
    }

    public void atualizarContato(Contato contato, String novoNome, String novoTelefone) {
        contato.setNome(novoNome);
        contato.setTelefone(novoTelefone);
        setChanged();
        notifyObservers();
    }
}
