package service;
import models.Funcionario;
import models.Pessoa;
import utils.FormatadorUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    public void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println(String.format("%-10s | %-12s | %-12s | %-15s", "Nome", "Data Nasc.", "Salário", "Função"));
        System.out.println("---------------------------------------------------------------");
        for (Funcionario f : funcionarios) {
            System.out.println(String.format("%-10s | %-12s | %-12s | %-15s",
                    f.getNome(),
                    FormatadorUtil.formatarData(f.getDataNascimento()),
                    FormatadorUtil.formatarMoeda(f.getSalario()),
                    f.getFuncao()));
        }
    }

    public void aplicarAumento(List<Funcionario> funcionarios, double percentual) {
        BigDecimal multiplicador = BigDecimal.valueOf(1 + (percentual / 100));
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(multiplicador)));
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> mapFuncionarios) {
        mapFuncionarios.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        List<Integer> mesesBusca = Arrays.stream(meses).boxed().collect(Collectors.toList());
        funcionarios.stream()
                .filter(f -> mesesBusca.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.println(f.getNome() + " faz aniversário em: " + FormatadorUtil.formatarData(f.getDataNascimento())));
    }

    public void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Pessoa::getDataNascimento));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Mais velho: " + maisVelho.getNome() + " | Idade: " + idade + " anos");
    }

    public void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(f -> System.out.println(f.getNome()));
    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + FormatadorUtil.formatarMoeda(total));
    }

    public void imprimirQuantidadeSalariosMinimos(List<Funcionario> funcionarios, BigDecimal valorSalarioMinimo) {
        funcionarios.forEach(f -> {
            BigDecimal qtdSalarios = f.getSalario().divide(valorSalarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalarios + " salários mínimos.");
        });
    }
}