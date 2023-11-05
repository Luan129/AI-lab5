package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		ArrayList<Node> ex = new ArrayList<>();
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.equals(model.getGoalState())) {
				return current;
			} else {
				ex.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !ex.contains(child)) {
						child.setG(current.getG() + 1);
						child.setH(model.computeH1(child));
						frontier.add(child);

					}

				}
			}
		}

		return null;
	}

	
}
