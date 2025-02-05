package application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		

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
		
		funcionarios.removeIf(x -> x.getNome().equals("João"));
		
		funcionarios.replaceAll(x -> new Funcionario(
				x.getSalario().multiply(new BigDecimal(1.1)), 
				x.getFuncao(), 
				x.getNome(), 
				x.getDataNascimento()));
		
		
		
		funcionarios.forEach(System.out::println);
	}

}
