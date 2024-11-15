// Command
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
       
        CriadorDeTarefa criadorPessoal = new CriadorTarefaPessoal();
        Tarefa tarefaPessoal = criadorPessoal.criarTarefa("Comprar presentes de aniversário");
        tarefaPessoal.exibirDescricao();

        CriadorDeTarefa criadorTrabalho = new CriadorTarefaTrabalho();
        Tarefa tarefaTrabalho = criadorTrabalho.criarTarefa("Preparar relatório mensal");
        tarefaTrabalho.exibirDescricao();

       
        Tarefa tarefaComNotificacao = new TarefaComNotificacao(
            new TarefaPessoal("Comprar presentes de aniversário"),
            new NotificadorEmail()
        );
        tarefaComNotificacao.exibirDescricao();

       
        Comando concluirComando = new ConcluirTarefa(tarefaTrabalho);
        Comando removerComando = new RemoverTarefa(tarefaTrabalho);

        ControladorDeTarefas controlador = new ControladorDeTarefas();

       
        controlador.setComando(concluirComando);
        controlador.executarComando();

       
        controlador.setComando(removerComando);
        controlador.executarComando();
    }
}