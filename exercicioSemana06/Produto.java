package exercicioSemana06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Produto implements Serializable{
	
	private int codigo;
	private String descricao;
	private double valor;
	private int quantidadeEstoque;
	
	public String toString() {
		return "["+codigo+","+descricao+","+valor+","+quantidadeEstoque+"]";
	}

	
	/**
	 * Metodo que efetua a gravação do objeto. 
	 * @return - Retorna uma mensagem identificando se a gravação deu certo ou não.
	 */
	public String gravar() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(codigo+".obj"));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			return "Produto cadastrado com sucesso!!!";
		} catch (IOException erro) {
			return "Erro: " + erro.toString();
		}
	}

	/**
	 * Método que le um objeto criado a partir de um paramentro.
	 * @param codigo - código a utilizado para efetuar a pesquisa.
	 * @return - o objeto procurado, caso não haja ele retorna nulo.
	 */
	public Produto ler(int codigo) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(codigo+".obj"));
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Produto produto = (Produto)objectInputStream.readObject();
			
			objectInputStream.close();
			return produto;
		}
			catch (Exception erro) {				
				return null;
		}
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	
	
}
