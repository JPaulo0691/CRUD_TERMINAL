package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.entities.Carro;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos carros est�o na garagem: ");
		int nCarros = Integer.parseInt(input.nextLine());
		
		Carro cars = new Carro();
		ArrayList<Carro> listaCarros = new ArrayList<>();
		
		for(int i = 0; i < nCarros; i++) {
			System.out.println("\nDigite os dados do usu�rio#" + (i + 1) + ":");
			
			System.out.println("IdCarro: ");
			Integer id = Integer.parseInt(input.nextLine());
			
			System.out.print("Propriet�rio: ");
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
				
		System.out.println("Usu�rios presentes no Estacionamento: ");
		for(Carro lista : listaCarros) {
			System.out.println(lista);
		}		
		
		char continuar;
		
		do {
			
			System.out.println("Digite S para continuar");
			System.out.println("Digite N para encerrar");
			
			System.out.println("Escolha uma das op��es: ");
			continuar = input.nextLine().toUpperCase().charAt(0);
			
			if(continuar != 'N' && continuar == 'S') {
				
				System.out.println("DADOS DE VEICULOS DO ESTACIONAMENTO: "); 
				System.out.println("DIGITE 1 -> CONSULTAR"); // READ
				System.out.println("DIGITE 2 -> FILTRAR POR ID "); // CONSULTAR				
				System.out.println("DIGITE 3 -> ATUALIZAR"); // UPDATE
				System.out.println("DIGITE 4 -> DELETAR"); // DELETE
				
				System.out.print("Digite o c�digo do filtro que voc� deseja: ");
				int codigo = Integer.parseInt(input.nextLine());
				
				switch(codigo) {
				
				case 1:
					System.out.println("RELAT�RIO DE VE�CULOS NO ESTACIONAMENTO: ");
					
					for(Carro consulta: listaCarros) {
						System.out.println(consulta);
						
						if(consulta == null) {
							System.out.println("Lista Vazia");
						}
					}
				break;
				
				case 2:
					System.out.println("Qual marca voc� procura: ");
					Integer findId = Integer.parseInt(input.nextLine());
					
					for(Carro buscarId : listaCarros) {
						
						if(findId == buscarId.getId()) {
							System.out.println(buscarId);
							break;
						}
						else {
							System.out.println("Id n�o encontrado");
							break;
						}						
					}				
				break;
											
				case 3:
														
					System.out.print("Coloque o nome do Novo propriet�rio Atual"
							+ "para trocar o antigo registro."
							+ "\nDigite o Id anterior:");
					int atualId = Integer.parseInt(input.nextLine());
					
					Integer updateById =  findById(listaCarros, atualId);
					
					if(updateById == null) {
						System.out.println("Id n�o encontrado!");
						break;
					}
					else {
						System.out.println("Novo Propriet�rio: ");
						String updProprietario = input.nextLine();
																													
						listaCarros.get(updateById).setProprietario(updProprietario); // atualiza��o
						
						System.out.println("ATUALIZADO COM SUCESSO!!!");
						break;					
						
					}				
								
				case 4:
					System.out.println("Relat�rio de dados dos Ve�culo: ");
					
					for(Carro consulta : listaCarros) {
						System.out.println(consulta);
					}
					
					System.out.println("Digite o Id do Ve�culo que voc� deseja deletar");
					int deletID = Integer.parseInt(input.nextLine());
					
					Integer delById = findById(listaCarros, deletID);
					
					if(delById == null) {
						System.out.println("Id n�o encontrado");
						break;
					}
					else {			
												
																		
						System.out.println("Deletado com Sucesso");
						break;
						
					}
					
				default:
					System.out.println("C�digo de Filtro Inv�lido");
					break;
				}	
				
			}
					
		}while(continuar != 'N');
		
		System.out.println("SISTEMA ENCERRADO!!!");
			

	}
	
	// procurando o Id, o papel desse m�todo � dizer a posi��o do meu Id na lista
	
	public static Integer findById(List<Carro> list, int id) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}			
		}
		
		return null;
	}
	
	public static void deleteById(List<Carro> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getId() == id) {
				list.remove(i);					
			}			
		}
	}
	
	

}
