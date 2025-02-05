package application;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		//CRIAÇÃO DA LISTA
		funcionarios.add(new Funcionario(new BigDecimal("2009.44"), "Operador", "Maria", LocalDate.parse("18/10/2000", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("2284.38"), "Operador", "João", LocalDate.parse("12/05/1990", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("9836.14"), "Coordenador", "Caio", LocalDate.parse("02/05/1961", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("1919.88"), "Diretor", "Miguel", LocalDate.parse("14/10/1988", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("2234.68"), "Recepcionista", "Alice", LocalDate.parse("05/01/1995", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("1582.72"), "Operador", "Heitor", LocalDate.parse("19/11/1999", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("4071.84"), "Contador", "Arthur", LocalDate.parse("31/03/1993", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("3017.45"), "Gerente", "Laura", LocalDate.parse("08/07/1994", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("1606.85"), "Eletricista", "Heloísa", LocalDate.parse("24/05/2003", formatter)));
		funcionarios.add(new Funcionario(new BigDecimal("2799.93"), "Gerente", "Helena", LocalDate.parse("02/09/1996", formatter)));
		
		//REMOVENDO O JOÃO
		funcionarios.removeIf(x -> x.getNome().equals("João"));
		
		//AUMENTO DE 10%
		funcionarios.replaceAll(x -> new Funcionario(
				x.getSalario().multiply(new BigDecimal(1.1)), 
				x.getFuncao(), 
				x.getNome(), 
				x.getDataNascimento()));
		
		//IMPRIME LISTA
		System.out.println("LISTA DE FUNCIONARIOS");
		System.out.println("--------------------------------------------------");
		funcionarios.forEach(System.out::println);
		System.out.println();
		
		//CRIANDO ESTRUTURA MAP COM CHAVE E VALAOR E POVOANDO-A
		Map<String, List<Funcionario>> funcionariosPorCargo = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
		
		//IMPRIME FUNCIONARIOS POR CARGO
		System.out.println("FILTRO POR CARGO");
		System.out.println("--------------------------------------------------");
	       funcionariosPorCargo.forEach((cargo, listaFuncionarios) -> {
	            System.out.println("Cargo: " + cargo);
	            listaFuncionarios.forEach(System.out::println);
	            System.out.println();
	        });
	    System.out.println();
		//FUNCIONARIOS ANIVERSARIANTES
	    System.out.println("ANIVERSARIANTES! (Mes: 10 e 12)");
	    System.out.println("--------------------------------------------------");
	    funcionarios.stream()
	    	.filter(x -> x.getDataNascimento().getMonth() == Month.OCTOBER || x.getDataNascimento().getMonth() == Month.DECEMBER)
	    	.forEach(System.out::println);
	    System.out.println();
	    
		
	    //FUNCIONARIO MAIS VELHO
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow(() -> new RuntimeException("Nenhum funcionário encontrado"));
        LocalDate dataAtual = LocalDate.now();
        System.out.println("FUNCIONARIO COM MAIOR IDADE: ");
        System.out.println("--------------------------------------------------");
        System.out.println("Nome: " + funcionarioMaisVelho.getNome());
        System.out.println("Idade: " + dataAtual.compareTo(funcionarioMaisVelho.getDataNascimento()));
        System.out.println();
        
        //ORDEM ALFABETICA
        System.out.println("ORDEM ALFABETICA");
        System.out.println("--------------------------------------------------");
        funcionarios.stream()
	        .sorted((x ,y) -> x.getNome().compareTo(y.getNome()))
	        .forEach(System.out::println);
        System.out.println();
        
        //TOTAL DE SALARIOS
        System.out.println("SOMA DOS SALARIOS");
        System.out.println("--------------------------------------------------");
        BigDecimal sum= funcionarios.stream()
        	.map(x -> x.getSalario())
        	.reduce((x,y) -> x.add(y)).get();
        
        System.out.println(df.format(sum));
        System.out.println();
        
       //SALARIOS MINIMOS
        System.out.println("SALARIOS MINIMOS");
        System.out.println("--------------------------------------------------");
       funcionarios.stream().forEach(x -> System.out.println(
    		   "Nome: " + x.getNome() +
    		   " - Salarios Minimos: " + df.format( Double.parseDouble(x.getSalario().toString()) / 1212.00)
    		   ));
	    
		
	}

}
