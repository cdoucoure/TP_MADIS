import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Bellmann {
		
	public static void main(String[] args) throws IOException {
		//Initialisation du graphe
		File monFichier = new File("graphe3.txt");
		FormatGraphe monGraphe1 = new FormatGraphe(monFichier);
		Graphe graph = monGraphe1.graphe;
		
		
		int nbSom = graph.getNbSommets();
		String[][][] matrice = new String[nbSom][nbSom][nbSom];
		int m, i, j;
		m = 0;
		for (i = 0; i < nbSom; i++) {
			for (j = 0; j < nbSom; j++) {
				if (i == j) {
				matrice[m][i][j] = "0";
				}
				else if (graph.getNoeud(i).getSucc(graph.getNoeud(j).getNom()) != null) {
					//Noeud j est successeur du noeud i
					int indexJ = graph.getNoeud(i).successeurs.indexOf(graph.getNoeud(j));
					matrice[m][i][j] = graph.getNoeud(i).flux.get(indexJ).toString();
					
				}
				else {
					matrice[m][i][j] = "inf";
				}
			}
		}
		
		for (m = 1; m < nbSom; m++) {
			for (i = 0; i < nbSom; i++) {
				for (j = 0; j < nbSom; j++) {
					String a = matrice[m-1][i][j];
					String b = matrice[m-1][i][m];
					String c = matrice[m-1][m][j];
					if (a == "inf") {
						if (b == "inf" || c== "inf") {
							matrice[m][i][j] = "inf";
						}
						else {
							matrice[m][i][j] = Integer.toString(Integer.parseInt(b)+Integer.parseInt(c));
						}
					}
					else {
						if (b == "inf" || c== "inf") {
							matrice[m][i][j] = Integer.toString(Integer.parseInt(a));
						}
						else {
							matrice[m][i][j] = Integer.toString(Math.min(Integer.parseInt(a), Integer.parseInt(b)+Integer.parseInt(c)));
						}
					}					
				}
			}
		}
		System.out.println("Résultat :");
		i = 0;
		for (String[][] strings : matrice) {
			i++;
			System.out.println("Itération n° " + i);
			for (String[] strings2 : strings) {
				for (String string : strings2) {
					System.out.print(string + "	");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
	}

}
