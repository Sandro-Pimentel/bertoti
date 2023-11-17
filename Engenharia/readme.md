A principal diferença entre programação e engenharia de software é que o engenheiro de sempre busca aperfeiçoar a aplicação tanto em velocidade, quanto em eficiência. Diferentemente do programador, em que sua preocupação é entregar o produto em funcionamento dentro de um prazo definido. 

-------------------------------------------------------------------------------------------------------------------------------------

package enciclopedia;

import java.util.ArrayList;

public class Enciclopedia {
	private ArrayList<Animal> conteudo;
	
	public void adicionaAnimal(Animal animal) {
		conteudo.add(animal);
	}
	
	public Animal buscaNome(String nome) {
		for(Animal animal : conteudo) {
			if(animal.getNome().equals(nome)) {
				return animal;
			}
		}
		
		return null;
	}
	
	public ArrayList<Animal> buscaInformacao(Informacoes info) {
		ArrayList<Animal> animais = new ArrayList<>();
		for(Animal animal: conteudo) {
			if(animal.getInfo().comparaInfos(info)) {
				animais.add(animal);
			}
		}
		
		return animais;
	}
	
	public ArrayList<Animal> getAnimais() {
		return conteudo;
	}
}

---------------------------

package enciclopedia;

public class Animal {
	private String nome;
	private Informacoes info;
	
	public Animal(String nome, Informacoes info) {
		this.setNome(nome);
		this.setInfo(info);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Informacoes getInfo() {
		return info;
	}

	public void setInfo(Informacoes info) {
		this.info = info;
	}	
}
---------------------------

package enciclopedia;

public class Informacoes {
	private String nomeCientifico;
	private String dieta;
	private String epoca;
	
	public Informacoes(String nomeCientifico, String dieta, String epoca, Hierarquia hierarquia) {
		this.nomeCientifico = nomeCientifico;
		this.dieta = dieta;
		this.epoca = epoca;
	}
	
	public String getNomeCientifico() {
		return nomeCientifico;
	}
	
	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public String getEpoca() {
		return epoca;
	}

	public void setEpoca(String epoca) {
		this.epoca = epoca;
	}

	public boolean comparaInfos(Informacoes info) {
		if(this.nomeCientifico.equals(info.nomeCientifico) && this.dieta.equals(info.dieta) && this.epoca.equals(info.epoca)) {
			return true;
		} else {
			return false;
		}
	}
}

---------------------------

![image](https://github.com/Sandro-Pimentel/bertoti/assets/125677890/f7f5d5f7-fc39-48cb-82ca-ac7e539afdb1)
