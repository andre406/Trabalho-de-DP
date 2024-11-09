// Padrão Comportamental: Command
interface Comando {
    void executar();
}

class ConcluirTarefa implements Comando {
    private Tarefa tarefa;

    public ConcluirTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void executar() {
        System.out.println("Tarefa concluída: ");
        tarefa.exibirDescricao();
    }
}

class RemoverTarefa implements Comando {
    private Tarefa tarefa;

    public RemoverTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void executar() {
        System.out.println("Tarefa removida: ");
        tarefa.exibirDescricao();
    }
}

class ControladorDeTarefas {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void executarComando() {
        comando.executar();
    }
}

public class Main {
    public static void main(String[] args) {
        Tarefa tarefaTrabalho = new TarefaTrabalho("Preparar relatório mensal");

        Comando concluirComando = new ConcluirTarefa(tarefaTrabalho);
        Comando removerComando = new RemoverTarefa(tarefaTrabalho);

        ControladorDeTarefas controlador = new ControladorDeTarefas();

        // Concluindo a tarefa
        controlador.setComando(concluirComando);
        controlador.executarComando();

        // Removendo a tarefa
        controlador.setComando(removerComando);
        controlador.executarComando();
    }
}