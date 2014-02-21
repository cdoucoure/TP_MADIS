import java.io.File;
import java.io.IOException;


public class Application {

	public static void main(String[] args) throws IOException {
		
		
		// TODO Auto-generated method stub

		File monFichier = new File("graphe.txt");
		FormatGraphe monGraphe1 = new FormatGraphe(monFichier);
		
		int i=0;
		int j=0;
		
		
		for (Noeud noeud : monGraphe1.graphe.listeNoeuds){
			System.out.println(noeud.getNom());
		}
		
		int[][] matrice;
		matrice= monGraphe1.getMatrice();
		
		for(i=0; i< matrice.length ;i++){
			for(j=0;j<matrice[0].length; j++){
				System.out.println(matrice[i][j]);				
			}
		}	
	System.out.println("Fin");	
	}
}
