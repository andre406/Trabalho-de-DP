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