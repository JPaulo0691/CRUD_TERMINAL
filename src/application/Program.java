package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.entities.Carro;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos carros estão na garagem: ");
		int nCarros = Integer.parseInt(input.nextLine());
		
		Carro cars = new Carro();
		ArrayList<Carro> listaCarros = new ArrayList<>();
		
		for(int i = 0; i < nCarros; i++) {
			System.out.println("\nDigite os dados do usuário#" + (i + 1) + ":");
			
			System.out.println("IdCarro: ");
			Integer id = Integer.parseInt(input.nextLine());
			
			System.out.print("Proprietário: ");
			String proprietario = input.nextLine();
			
			System.out.print("Marca: ");
			String marca = input.nextLine().toUpperCase();
			
			System.out.print("Placa: ");
			String placa = input.nextLine().toUpperCase();
			
			System.out.print("Ano: ");
			int ano = Integer.parseInt(input.nextLine());
			
			Carro carros = new Carro(id,proprietario, marca, placa, ano);
			listaCarros.add(carros);		
		}		
				
		System.out.println("Usuários presentes no Estacionamento: ");
		for(Carro lista : listaCarros) {
			System.out.println(lista);
		}		
		
		char continuar;
		
		do {
			
			System.out.println("Digite S para entrar no sistema de estacionamento");
			System.out.println("Digite N para encerrar");
			
			System.out.println("Escolha uma das opções: ");
			continuar = input.nextLine().toUpperCase().charAt(0);
			
			if(continuar != 'N' && continuar == 'S') {
				
				System.out.println("DADOS DE VEICULOS DO ESTACIONAMENTO: "); 
				System.out.println("DIGITE 1 -> CONSULTAR"); // READ
				System.out.println("DIGITE 2 -> FILTRAR POR ID "); // CONSULTAR				
				System.out.println("DIGITE 3 -> ATUALIZAR"); // UPDATE
				System.out.println("DIGITE 4 -> DELETAR"); // DELETE
				
				System.out.print("Digite o código do filtro que você deseja: ");
				int codigo = Integer.parseInt(input.nextLine());
				
				switch(codigo) {
				
				case 1:
					System.out.println("RELATÓRIO DE VEÍCULOS NO ESTACIONAMENTO: ");
					
					for(Carro consulta: listaCarros) {
						System.out.println(consulta);
						
						if(consulta == null) {
							System.out.println("Lista Vazia");
						}
					}
				break;
				
				case 2:
					System.out.println("Digite o id do carro que você procura: ");
					Integer findId = Integer.parseInt(input.nextLine());
					
					Integer buscarID = findById(listaCarros, findId);
					
					if(buscarID == null) {
						System.out.println("Id Inexistente!");
					}
					else {
						
						for(int i = 0; i < listaCarros.size(); i++) {
							System.out.println(listaCarros.get(buscarID));// consulta por ID
						}
					}
							
				break;
											
				case 3:
														
					System.out.print("Coloque o nome do Novo proprietário Atual"
							+ "para trocar o antigo registro."
							+ "\nDigite o Id anterior:");
					int atualId = Integer.parseInt(input.nextLine());
					
					Integer updateById =  findById(listaCarros, atualId); 
					
					if(updateById == null) {
						System.out.println("Id não encontrado!");
						break;
					}
					else {
						System.out.println("Novo Proprietário: ");
						String updProprietario = input.nextLine();
																													
						listaCarros.get(updateById).setProprietario(updProprietario); // atualização
						
						System.out.println("ATUALIZADO COM SUCESSO!!!");
						break;					
						
					}				
								
				case 4:
					System.out.println("Relatório de dados dos Veículo: ");
					
					for(Carro consulta : listaCarros) {
						System.out.println(consulta);
					}
					
					System.out.println("Digite o Id do Veículo que você deseja deletar");
					int deletID = Integer.parseInt(input.nextLine());
					
					//Deletando Usuário
					Carro searchID = listaCarros.stream().filter(x -> x.getId() == deletID).findFirst().orElse(null);
					
					if(searchID == null) {
						System.out.println("Id inexistente");
					}
					else {
						listaCarros.remove(searchID);
						System.out.println("Usuário Excluído");
					}
					break;
					
				default:
					System.out.println("Código de Filtro Inválido");
					break;
				}	
				
			}
					
		}while(continuar != 'N');
		
		System.out.println("SISTEMA ENCERRADO!!!");
			

	}
	
	// procurando o Id, o papel desse método é dizer a posição do meu Id na lista
	
	public static Integer findById(List<Carro> list, int id) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}			
		}
		
		return null;
	}
	
}
