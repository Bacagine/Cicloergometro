/* Pessoa.java: 
 *
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@gmail.com>
 * 
 * Data: 03/06/2022
 * Data da última modificação: 07/11/2022
 */

package org.java.cicloergometro.model.bean;

import java.time.LocalDate;
//import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa{
	private int id;
	private String login;
	private String senha;
	private String nome;
	private String RG;
	private String CPF;
	private char sexo;
	private double peso;
	private double altura;
	private Endereco endereco;
	private String telefone;
	private String email;
	private LocalDate dataNascimento;
	private int idade = 0;
	public static final DateTimeFormatter BRAZZILIAN_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/* Construtores */
	public Pessoa(){

	}
	
	public Pessoa(String nome, String CPF){
		this.setNome(nome);
		this.setCPF(CPF);
	}

	public Pessoa(String login, String senha, String nome, String CPF, char sexo){
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
	}

	public Pessoa(String login, String senha, String nome, String CPF, char sexo, String telefone, Endereco endereco){
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
	}

	public Pessoa(String nome, String CPF, char sexo){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone){
		this.setNome(nome);
		this.setRG(RG);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone,
	       Endereco endereco){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, LocalDate dataNascimento,
	              String telefone, Endereco endereco){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setDataNascimento(dataNascimento);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setIdade(dataNascimento);
	}
	
	public Pessoa(String nome, String RG, String CPF, char sexo, LocalDate dataNascimento,
		          String telefone){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setDataNascimento(dataNascimento);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setIdade(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, LocalDate dataNascimento,
	              String telefone, Endereco endereco, String email){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setDataNascimento(dataNascimento);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setIdade(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone, Endereco endereco,
	              LocalDate dataNascimento){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, double peso, double altura,
	              String telefone, Endereco endereco, LocalDate dataNascimento){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setPeso(peso);
		this.setAltura(altura);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone, Endereco endereco,
	              String email, LocalDate dataNascimento){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, double peso, double altura,
	              String telefone, Endereco endereco, String email, LocalDate dataNascimento){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setPeso(peso);
		this.setAltura(altura);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone, Endereco endereco,
	       LocalDate dataNascimento, String nacionalidade){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, double peso, double altura,
	              String telefone, Endereco endereco, LocalDate dataNascimento, String nacionalidade){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setPeso(peso);
		this.setAltura(altura);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String RG, String CPF, char sexo, String telefone, Endereco endereco,
	              String email, LocalDate dataNascimento, String nacionalidade){
		this.setNome(nome);
		this.setCPF(CPF);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
	}

	public Pessoa(String login, String senha, String nome, String CPF) {
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCPF(CPF);
	}

	/* Getters */
	public int getID(){
		return this.id;
	}

	public String getLogin(){
		return this.login;
	}

	public String getSenha(){
		return this.senha;
	}

	public String getNome(){
		return this.nome;
	}

	public String getRG(){
		return this.RG;
	}

	public String getCPF(){
		return this.CPF;
	}

	public char getSexo(){
		return this.sexo;
	}

	public double getPeso(){
		return this.peso;
	}

	public double getAltura(){
		return this.altura;
	}

	public String getTelefone(){
		return this.telefone;
	}

	public Endereco getEndereco(){
		return this.endereco;
	}

	public String getEmail(){
		return this.email;
	}

	public LocalDate getDataNascimento(){
		return this.dataNascimento;
	}
	
	public int getIdade(){
		return this.idade;
	}

	/* Verifica se a pessoa esta viva */
/*	public boolean estaViva(){
		return this.vida;
	}*/

	/* Setters */
	public void setID(int id){
		this.id = id;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setRG(String RG){
		this.RG = RG;
	}

	public void setCPF(String CPF){
		this.CPF = CPF;
	}

	public void setSexo(char sexo){
		this.sexo = sexo;
	}

	public void setPeso(double peso){
		this.peso = peso;
	}

	public void setAltura(double altura){
		this.altura = altura;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setDataNascimento(LocalDate dataNascimento){
		this.dataNascimento = dataNascimento;
	}

	public void setIdade(){
		this.idade = this.calculaIdade(this.getDataNascimento());
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public void setIdade(LocalDate dataNascimento){
		this.idade = this.calculaIdade(dataNascimento);
	}
	

	/* Outros metodos */

	/* Metodo para converter a data do padrão
	 * brasileiro para o americano */
	public static String converteData(String data){
		int dataLength = data.length();
		char c[] = new char[dataLength];
		int j = 6;
		data = data.replace("/", "-");
		for(int i = 0; i < dataLength; i++){
			if(i < 5){
				c[i] = data.charAt(j);
				j++;
				if(j == dataLength){
					j = 2;
					i++;
					c[i] = data.charAt(j);
					j++;
				}
			}
			else if(i < 9){
				c[i] = data.charAt(j);
				j++;
				if(j == 6){
					j = 0;
				}
			}
			else{
				c[i] = data.charAt(j);
				j++;
			}
		}
		j = 0;
		data = String.valueOf(c[j]);
		
		for(j = 1; j < dataLength; j++){
			data += String.valueOf(c[j]);
		}

		return data;
	}
	
	/* Metodo baseado no artigo a seguir:
	 * https://pt.stackoverflow.com/questions/462189/c%c3%a1lculo-de-idade-em-java#462216 */
	public int calculaIdade(LocalDate dataNascimento){
		LocalDate hoje = LocalDate.now();
		int idade = hoje.getYear() - dataNascimento.getYear();
		int mesAtual = hoje.getMonthValue();

		// se ainda não chegou o aniversário, diminui 1 ano
		if((mesAtual == dataNascimento.getMonthValue() && hoje.getDayOfMonth() < dataNascimento.getDayOfMonth()) || mesAtual < dataNascimento.getMonthValue()){
			idade--;
		}
		return idade;
	}



	public void realizarCadastro(){

	}

	public void alterarCadastro(){

	}

	public void excluirCadastro(){

	}

	public void cancelarConsulta(int codAgendamento){

	}
}
