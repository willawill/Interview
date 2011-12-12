public abstract class hand{

protected ArrayList<T extends Card> cards = new ArrayList(T extends Card);


public int score(){
	int score = 0;
	for (T card: cards){
		int tempScore = card.Value();
		score += tempScore;
}
	return score;
}



}

