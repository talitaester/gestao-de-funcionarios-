package application;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import models.Funcionario;
import service.FuncionarioService;

public class Main {
    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2 - Remover João
        service.removerFuncionarioPorNome(funcionarios, "João");

        // 3.3 - Imprimir funcionários com formatação
        System.out.println("--- LISTA DE FUNCIONÁRIOS ---");
        service.imprimirFuncionarios(funcionarios);

        // 3.4 - Aumento de 10%
        service.aplicarAumento(funcionarios, 10.0);

        // 3.5 - Agrupar por função
        Map<String, List<Funcionario>> agrupados = service.agruparPorFuncao(funcionarios);

        // 3.6 - Imprimir agrupados
        System.out.println("\n--- FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ---");
        service.imprimirAgrupadosPorFuncao(agrupados);

        // 3.8 - Imprimir aniversariantes meses 10 e 12
        System.out.println("\n--- ANIVERSARIANTES (MÊS 10 E 12) ---");
        service.imprimirAniversariantes(funcionarios, 10, 12);

        // 3.9 - Imprimir mais velho
        System.out.println("\n--- FUNCIONÁRIO MAIS VELHO ---");
        service.imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 - Imprimir em ordem alfabética
        System.out.println("\n--- ORDEM ALFABÉTICA ---");
        service.imprimirOrdemAlfabetica(funcionarios);

        // 3.11 - Imprimir total dos salários
        System.out.println("\n--- TOTAL DE SALÁRIOS ---");
        service.imprimirTotalSalarios(funcionarios);

        // 3.12 - Imprimir salários mínimos
        System.out.println("\n--- SALÁRIOS MÍNIMOS (Base: R$ 1212,00) ---");
        service.imprimirQuantidadeSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}
