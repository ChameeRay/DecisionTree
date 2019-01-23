package com.web.main; 

import java.util.Scanner;

import com.web.tree.Tree;


public class Main{
	public static void main(String agrs[]) {	
	
		Scanner sc = new Scanner(System.in);
		Tree dt = new Tree(); 
		
		String level = "Start"; 
		
		String level_0 = "Premier Fois "; 
		String level_00 = "Etudiant";
		String level_01 = "Salarié"; 
		String level_1 = "Renouvellement"; 
		String level_10 = "Carte Sejour";
		String level_11 = "Passeport Talent";
		String level_000 = "UE";             
		String level_001 = "Etranger";        
		String level_010 = "CDI";             
	    String level_011 = "CDD";            
	    String level_100 = "1 ans";          
	    String level_101 = "2 ans ";         
	    String level_110 = "Seul";           
	    String level_111 = "Famille";         
	    

		dt.addItem(level, "");
		dt.addItem(level_0, "0");
		dt.addItem(level_00, "00");
		dt.addItem(level_01, "01");
		dt.addItem(level_1, "1");
		dt.addItem(level_10, "10");
		dt.addItem(level_11, "11");	
		dt.addItem(level_000, "000");		
		dt.addItem(level_001, "001");		
		dt.addItem(level_010, "010");		
		dt.addItem(level_011, "011");		
		dt.addItem(level_100, "100");		
		dt.addItem(level_101, "101");
		dt.addItem(level_110, "110");
		dt.addItem(level_111, "111");
		
		
		
		System.out.println(" Cliquez sur entrer pour commencer !!!");
		
		boolean keepProcessing = true; 
		int levelProcess = 0; 
		String path = ""; 
		String currentChoice = "";
		
		while(keepProcessing) {
			if(levelProcess == 0) {
				String title = dt.getData(path);
				System.out.println(title);
				sc.nextLine(); 
				System.out.println(dt.getData("0") + "   " + dt.getData("1"));
				System.out.println("0:gauche      1:droite");
				int choix = sc.nextInt(); 
				if (choix == 0) {
					currentChoice = "0";
				}
				else if(choix == 1) {
					currentChoice = "1";
				}
			}
			else {
				String childs = dt.computeNewChild(path, currentChoice); 
				path += currentChoice; 
				System.out.println(childs);
				System.out.println("0:gauche      1:droite");
				int choix = sc.nextInt(); 
				if (choix == 0) {
					currentChoice = "0";
				}
				else if(choix == 1) {
					currentChoice = "1";
				}
				
			}
			levelProcess++; 
			keepProcessing = levelProcess != 3;
		}
			
		System.out.println("");
		System.out.println("le chemin de prise de décision est : " + path + currentChoice);  
		System.out.println("");

		System.out.println("Afficher l'arbre de décision général !");

		System.out.println("0:oui      1:non");
		
		int choix = sc.nextInt(); 
		if (choix == 0) {
			System.out.println("l'arbre de décision a la forme suivante : ");
			dt.display();		}
		else if(choix == 1) {
			System.out.println("");
	
		}
 
		sc.close();
	
	}
}
