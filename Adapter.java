// Padrão Estrutural: Adapter
interface Notificador {
    void notificar(String mensagem);
}

class NotificadorEmail implements Notificador {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Enviando notificação por e-mail: " + mensagem);
    }
}

class NotificadorSMS implements Notificador {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Enviando notificação por SMS: " + mensagem);
    }
}

interface TarefaNotificavel {
    void notificarConclusao();
}

class TarefaComNotificacao implements TarefaNotificavel {
    private Tarefa tarefa;
    private Notificador notificador;

    public TarefaComNotificacao(Tarefa tarefa, Notificador notificador) {
        this.tarefa = tarefa;
        this.notificador = notificador;
    }

    @Override
    public void notificarConclusao() {
        tarefa.exibirDescricao();
        notificador.notificar("A tarefa foi concluída!");
    }
}

public class Main {
    public static void main(String[] args) {
        Tarefa tarefaPessoal = new TarefaPessoal("Comprar presentes de aniversário");
        Notificador email = new NotificadorEmail();
        
        TarefaNotificavel tarefaNotificavel = new TarefaComNotificacao(tarefaPessoal, email);
        tarefaNotificavel.notificarConclusao();
    }
}