package arrays.algoexpert;

import java.util.*;

public class TournamentWinner {

    public String tournamentWinner(List<List<String>> competitions, List<Integer> results) {

        int maxPoints = 0;
        String winner = "";

        Map<String, Integer> winnerMap = new HashMap<>();
        for (int i = 0; i < results.size(); i++) {
            int points = 0;
            String team = "";
            // hometeam won.
            if (results.get(i) == 1) {
                team = competitions.get(i).get(0);
            } else {
                team = competitions.get(i).get(1);
            }
            updateMap(team, winnerMap);

            points = winnerMap.get(team);

            if (points > maxPoints) {
                maxPoints = points;
                winner = team;
            }
        }

        return winner;
    }

    private void updateMap(String winner, Map<String, Integer> winnerMap) {
        if (winnerMap.get(winner) == null) {
            winnerMap.put(winner, 3);
        } else {
            winnerMap.put(winner, winnerMap.get(winner) + 1);
        }
    }

    public static void main(String[] args) {
        List<String> compe1 = Arrays.asList("HTML", "C#");
        List<String> compe2 = Arrays.asList("C#", "Python");
        List<String> compe3 = Arrays.asList("Python", "HTML");
        List<List<String>> competitions = Arrays.asList(compe1, compe2, compe3);
        List<Integer> results = Arrays.asList(0, 0, 1);
        String winner = new TournamentWinner().tournamentWinner(competitions, results);
        System.out.println(winner);
    }
}
