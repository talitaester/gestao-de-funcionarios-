

## Funcionalidades Implementadas

O sistema atende a todos os requisitos propostos, executando as seguintes ações de forma sequencial:

1. **Inserção em lote:** Cadastro inicial de todos os funcionários com seus respectivos nomes, datas de nascimento, salários e funções.
2. **Remoção dinâmica:** Exclusão de funcionários específicos (ex: "João") da lista de registros.
3. **Formatação de Dados:** Exibição detalhada dos funcionários com datas no padrão brasileiro (`dd/MM/yyyy`) e valores monetários com separador de milhar e decimal.
4. **Atualização em lote:** Aplicação de um aumento salarial de 10% para todos os funcionários registrados.
5. **Agrupamento de Dados:** Mapeamento e agrupamento estruturado dos funcionários de acordo com suas funções.
6. **Filtragem por Período:** Identificação e listagem dos funcionários que fazem aniversário nos meses 10 e 12 .
7. **Cálculos de Idade:** Lógica para encontrar o funcionário com a maior idade e calcular sua idade exata com base na data atual.
8. **Ordenação:** Exibição da lista de funcionários em ordem alfabética.
9. **Cálculos Agregados:** Somatório total da folha de pagamento.
10. **Conversão de Moeda:** Cálculo de quantos salários mínimos cada funcionário recebe.

---

##  Arquitetura e Organização do Código

O projeto foi refatorado para seguir o **Princípio da Responsabilidade Única (SRP)** do SOLID, dividindo as responsabilidades em pacotes lógicos:

* **`models`**: Contém as entidades de domínio (`Pessoa` e `Funcionario`). Aplica conceitos de Herança e Encapsulamento. Utiliza `LocalDate` para datas e `BigDecimal` para precisão financeira.
* **`utils`**: Contém a classe `FormatadorUtil`, responsável exclusivamente por centralizar as regras de formatação visual de datas e moedas, facilitando futuras manutenções.
* **`service`**: Contém a classe `FuncionarioService`, o "cérebro" da aplicação. Isola as regras de negócio e utiliza amplamente a **Streams API** do Java para filtragens, mapeamentos e agrupamentos sem causar efeitos colaterais.
* **`application`**: Contém a classe `Main`, que atua como o ponto de entrada da aplicação (método `main`), orquestrando as chamadas ao serviço.

---

## Como Executar o Projeto

1. Certifique-se de ter o **Java JDK** instalado e configurado nas variáveis de ambiente da sua máquina.
2. Clone ou baixe este repositório.
3. Abra a pasta do projeto na sua IDE favorita.
4. Navegue até o diretório `src/application/`.
5. Execute a classe `Main.java`.
6. Os resultados das operações serão exibidos imediatamente no Terminal da sua IDE.

