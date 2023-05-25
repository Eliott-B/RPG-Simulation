import java.util.TreeMap;

/**
 * Classe des critères
 * @author Eliott-B
 * @see Solution
 */
public class Criterion {
    /**
     * Map des solutions
     * (Solution, (Meilleur/Pire, nombre de fois))
     */
    private TreeMap <String, TreeMap <Boolean, Integer>> solutions;

    /**
     * Constructeur de la classe.
     * Instancie le TreeMap
     */
    public Criterion(){
        solutions = new TreeMap<>();
    }

    /**
     * Ajoute un critère au TreeMap.
     * (solution, meilleur ou pire, nombre de fois)
     * @param solution String
     * @param type boolean
     * @param number int
     */
    public void addCriterion(String solution, boolean type, int number){
        // Vérifie si la solution n'existe pas déjà
        if(solutions.get(solution) == null){
            TreeMap <Boolean,Integer> map = new TreeMap<>();
            map.put(type, number);
            solutions.put(solution, map);
        }else{
            TreeMap<Boolean, Integer> object = solutions.get(solution);
            // Vérifie si le type de cette solution n'a pas déjà été défini
            if(object.get(type) == null){
                object.put(type, number);
            }else{
                object.replace(type, object.get(type), number);
            }
        }
    }

    /**
     * Lance les solutions demandés avec les critères.
     * Le retour sera sous la forme :
     * {Nom scénario + type, {durée: ??, nombre quêtes: ??, déplacements: ??}}
     * @return TreeMap<String, TreeMap <String, Integer>>
     */
    public TreeMap<String, TreeMap <String, Integer>> launch() throws ExceptionCriterion {
        TreeMap<String, TreeMap <String, Integer>> results = new TreeMap<>();
        // Parcours les solutions
        for (String solution : solutions.keySet()) {
            // Parcours les types
            for (boolean type : solutions.get(solution).keySet()) {
                // Récupère le nombre
                int number = solutions.get(solution).get(type);
                switch (solution.toUpperCase()){
                    case "GLOUTONNE":
                        break;
                    default:
                        throw new ExceptionCriterion(0);
                }
            }
        }
        return results;
    }

    /**
     * Affiche l'objet dans le terminal
     * @return String
     */
    public String toString(){
        return solutions.toString();
    }
}
