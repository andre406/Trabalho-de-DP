//  Adapter
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


class TarefaComNotificacao extends Tarefa {
    private Tarefa tarefa;
    private Notificador notificador;

    public TarefaComNotificacao(Tarefa tarefa, Notificador notificador) {
        this.tarefa = tarefa;
        this.notificador = notificador;
    }

    @Override
    public void exibirDescricao() {
        tarefa.exibirDescricao();
        notificador.notificar("A tarefa foi concluída!");
    }
}