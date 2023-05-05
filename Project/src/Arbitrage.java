import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;




public class Arbitrage {
    
    // Convertit un graphe de taux de change en un graphe de logarithme négatif pour être utilisé dans l'algorithme de Bellman-Ford
static double[][] negateLogarithmConvertor(double[][] graph) {
    double[][] result = new double[graph.length][graph.length];
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].length; j++) {
            result[i][j] = -Math.log(graph[i][j]);
        }
    }
    return result;
}

// Détecte les opportunités d'arbitrage dans un ensemble de taux de change
public static void arbitrage(String[] currencies, double[][] rates) {
    // Convertit le graphe des taux de change en graphe de logarithme négatif
    double[][] transGraph = negateLogarithmConvertor(rates);
    int n = transGraph.length;
    int[] pre = new int[n];
    double[] minDist = new double[n];
    // Initialise le tableau des distances minimales et le tableau des prédécesseurs
    Arrays.fill(minDist, Double.POSITIVE_INFINITY);
    int source = 0;
    minDist[source] = 0;
    pre[source] = -1;

    // Effectue n-1 itérations de l'algorithme de Bellman-Ford
    for (int i = 0; i < n - 1; i++) {
        for (int sourceCurr = 0; sourceCurr < n; sourceCurr++) {
            for (int destCurr = 0; destCurr < n; destCurr++) {
                // Met à jour les distances minimales et les prédécesseurs si un chemin plus court est trouvé
                if (minDist[destCurr] > minDist[sourceCurr] + transGraph[sourceCurr][destCurr]) {
                    minDist[destCurr] = minDist[sourceCurr] + transGraph[sourceCurr][destCurr];
                    pre[destCurr] = sourceCurr;
                }
            }
        }
    }

    // Vérifie si une opportunité d'arbitrage est détectée
    for (int sourceCurr = 0; sourceCurr < n; sourceCurr++) {
        for (int destCurr = 0; destCurr < n; destCurr++) {
            if (minDist[destCurr] > minDist[sourceCurr] + transGraph[sourceCurr][destCurr]) {
                // Si une opportunité d'arbitrage est détectée, récupère le cycle de change et l'affiche
                List<Integer> printCycle = new ArrayList<>();
                printCycle.add(destCurr);
                printCycle.add(sourceCurr);
                while (!printCycle.contains(pre[sourceCurr])) {
                    printCycle.add(pre[sourceCurr]);
                    sourceCurr = pre[sourceCurr];
                }
                printCycle.add(pre[sourceCurr]);
                System.out.println("opportunité d'arbitrage détectée: \n");
                Collections.reverse(printCycle);
                System.out.println(String.join(" --> ", Arrays.stream(printCycle.toArray()).map(c -> currencies[(int)c]).toArray(String[]::new)));
            }
        }
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // demander nbr de device
    System.out.println("Entrez le nombre de devices: ");
    int n = scanner.nextInt();
    scanner.nextLine();
scanner.nextLine();
String[] currencies = new String[n];
double[][] rates = new double[n][n];
// demander les devices
System.out.println("Entrez les devices : ");
for(int i = 0; i < n; i++) {
currencies[i] = scanner.nextLine();
}
// Demander le taux
System.out.println("Entrez le taux entre les devices : ");
for(int i = 0; i < n; i++) {
for(int j = 0; j < n; j++) {
rates[i][j] = scanner.nextDouble();
}
scanner.nextLine();
}
scanner.close();
arbitrage(currencies, rates);
}
    
}
