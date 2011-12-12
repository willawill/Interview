public class BlackJackCard extends Card{

public BlackJackCard(String s, int rank){
	super(s, rank);
}

public int value(){
	if (isAce()) return 1;
	else if (rank >=11 || rank <=13) return 10;
	else return rank;
}

public int minValue(){
	if (isAce()) return 1;
	else return value();

}

public int maxValue(){
	if (isAce()) return 11;
	else return value();
}

public boolean isAce(){
	return rank == 1;
}
public boolean isFaceRank(){
	return rank >= 11 || rank <= 13;

}
}
