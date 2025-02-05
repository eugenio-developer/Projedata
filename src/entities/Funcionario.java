package entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DecimalFormat df = new DecimalFormat("#,##0.00");
	
	
	
	public Funcionario(BigDecimal salario, String funcao, String nome, LocalDate data) {
		super.setDataNascimento(data);
		super.setNome(nome);
		this.salario = salario;
		this.funcao = funcao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	@Override
	public String toString() {
		return "Funcionario ["+"nome= "+ super.getNome() + " - Data de Nascemineto= "+ getDataNascimento().format(formatter) +" - salario= " + df.format(salario) + " - funcao= " + funcao + "]";
	}
	
	
	
	
}
