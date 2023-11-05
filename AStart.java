package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStart implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
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
					int pastcothNew=current.getG()+1;
					if (!frontier.contains(child) && !ex.contains(child)) {
						child.setG(pastcothNew);
						child.setH(model.computeH1(child));
						frontier.add(child);
					}else if(frontier.contains(child)) {
						if(child.getG()>pastcothNew) {
							child.setG(pastcothNew);
						}
					}

				}
			}
		}

		return null;

	}

}
