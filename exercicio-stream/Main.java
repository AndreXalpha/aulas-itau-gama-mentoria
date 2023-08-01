import java.util.List;
import java.util.Optional;

// Listar todas as pessoas
// Listar as 10 primeiras pessoas
// Listar as pessoas que são do Brasil
// Listar as pessoas do Brasil com o nome em Uppercase e suas idades
// Listar as pessoas que são do Brasil, em ordem de nome
// Listar as pessoas que são do Brasil, em ordem de idade
// Contar quantas pessoas tem mais de 45 anos
// Calcular a média de idade das pessoas

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Dados.getPessoas();

        // Listar todas as pessoas
        pessoas.stream().forEach(System.out::println);

        // Listar as 10 primeiras pessoas
        pessoas.stream()
                .limit(10)
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil
        System.out.println("\nPessoas do Brasil");
        pessoas.stream()
                .filter(p -> p.getPais()
                .equals("Brazil"))
                .forEach(System.out::println);

        // Listar as pessoas do Brasil com o nome em Uppercase e suas idades
        System.out.println("\nPessoas do Brasil com nome maiusculo ");
        pessoas.stream()
                .filter(p -> p.getPais()
                .equals("Brazil"))
                .map(p -> p.getNome().toUpperCase() + ", " + p.getIdade() + ", " + p.getPais())
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de nome
        System.out.println("\nPessoas do Brasil em ordem por nome");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .map(p -> p.getNome() + ", " + p.getPais()).sorted()
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de idade
        System.out.println("\nPessoas do Brasil em ordem de idade");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .map(p -> p.getIdade() + ", " + p.getNome() + ", " + p.getPais()).sorted()
                .forEach(System.out::println);

        // Contar quantas pessoas tem mais de 45 anos
        System.out.println("\nPessoas acima de 45 anos");
        System.out.println(pessoas.stream()
                .filter(p ->p.getIdade() > 45)
                .map(p -> p.getIdade())
                .count() + ", pessoas.");

        // Calcular a média de idade das pessoas
        System.out.println("\nMédia de idade das pessoas");
        double reduce = pessoas.stream()
                        .mapToInt(m -> m.getIdade()).average().getAsDouble();
                        System.out.println(reduce);
    }

}
