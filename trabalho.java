//  Factory Method
abstract class Tarefa {
    String descricao;

    public abstract void exibirDescricao();
}

class TarefaPessoal extends Tarefa {
    public TarefaPessoal(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void exibirDescricao() {
        System.out.println("Tarefa Pessoal: " + descricao);
    }
}

class TarefaTrabalho extends Tarefa {
    public TarefaTrabalho(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void exibirDescricao() {
        System.out.println("Tarefa de Trabalho: " + descricao);
    }
}

abstract class CriadorDeTarefa {
    public abstract Tarefa criarTarefa(String descricao);
}

class CriadorTarefaPessoal extends CriadorDeTarefa {
    @Override
    public Tarefa criarTarefa(String descricao) {
        return new TarefaPessoal(descricao);
    }
}

class CriadorTarefaTrabalho extends CriadorDeTarefa {
    @Override
    public Tarefa criarTarefa(String descricao) {
        return new TarefaTrabalho(descricao);
    }
}




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