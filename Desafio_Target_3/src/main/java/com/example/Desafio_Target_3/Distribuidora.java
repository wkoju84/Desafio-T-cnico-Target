package com.example.Desafio_Target_3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class Faturamento {
	int dia;
	double valor;
}

public class Distribuidora {

	public static void main(String[] args) {
		try {

			// Lê o arquivo JSON
			Gson gson = new Gson();
			FileReader reader = new FileReader("arquivo1.json");
			Type list = new TypeToken<ArrayList<Faturamento>>(){}.getType();
			List<Faturamento> faturamentos = gson.fromJson(reader, list);

			double menorFaturamento = Double.MAX_VALUE;
			double maiorFaturamento = Double.MIN_VALUE;
			double somaFaturamento = 0;
			int diasComFaturamento = 0;
			int diasAcimaDaMedia = 0;

			// Calcula o menor, maior e a soma para a média
			for (Faturamento faturamento : faturamentos) {
				if (faturamento.valor > 0) { // Ignorar dias sem faturamento
					if (faturamento.valor < menorFaturamento) {
						menorFaturamento = faturamento.valor;
					}
					if (faturamento.valor > maiorFaturamento) {
						maiorFaturamento = faturamento.valor;
					}
					somaFaturamento += faturamento.valor;
					diasComFaturamento++;
				}
			}

			// Calcula a média
			double mediaFaturamento = somaFaturamento / diasComFaturamento;

			// Conta os dias com faturamento acima da média
			for (Faturamento faturamento : faturamentos) {
				if (faturamento.valor > mediaFaturamento) {
					diasAcimaDaMedia++;
				}
			}

			// Exibir resultados
			System.out.println("Menor faturamento: " + menorFaturamento);
			System.out.println("Maior faturamento: " + maiorFaturamento);
			System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
