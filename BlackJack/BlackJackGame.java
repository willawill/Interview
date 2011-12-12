public class BlackJackGame(){

private int num;
private Deck deck = new Deck();
private ArrayList<BlackJackHand> hands = new ArrayList<BlackJackHand>(num);

public BlackJackGmae(int num){
	this.num = num;
	for (int i =0;i<num;i++){
		BlackJackHand hand = new BlackJackHand();
		hands.add(hand);
}
}

public void initialDeck(){

	String[] rank = {"A","2","3"...."K"};
	String[] suit = {"Club", "Spade", "Diamonds","Hearts"};
	for (int i=0; i< 51; i++){
		BlackJackCard card = new BlackJackCard(suit[i%13],rank[i%13]);
		deck.setCard(i,card);
}
	deck.shuffle();
	}
public boolean initialHands(){//assign two cards to players.
	Iterator i = hands.iterator();
	while(i.hadNext()){
		BlackJackCard card1 = deck.dealCard();
		BlackJackCard card2 = deck.dealCard();
		if (card1 == null || card2 == null)
			return false;

}		hand.addCard(card1);
		hand.addCard(card2);
		return true;

}

public boolean playHand(int i){
	BlackJackHand h = hands.get(i);
	return playHand(h);

}
public boolean getBlackJack(){

//winner +1 if iti's blackjack
}

public boolean isBlackJack(){
//A + JQK || JQK + A
	return true
}

public boolean playHand(BlackJackHand h){
	if (h.score() <  17){
		//hit
	BlackJackCard card = deck.dealCard();
	if (card == null) return false;
	else
		h.addCard(card);
		return true;

}

public boolean playAllHand(){
	Iterator i = hand.Iterator();
	while (i.hasNext()){
		BlackJackHand temp = (BlackJackHand)i.next();
		if (!playHand(temp)) return false;
}
return true;

}
public ArrayList<BlackJackHand> getWinner(){
	Iterator i = hand.Iterator();
	int winningScore = 0;
	while(i.hasNext){
		BlackJackHand temp = (BlackJackHand) i.next();
		int tempScore = temp.score();
		if (!temp.isBusted()){
			if (tempScore > winningScore){
				winningScore = tempScore;
				winner.clear();
				winner.add(temp);
}
			else if(tempScore == winningScore){
				winner.add(temp);
}

}
}
	return winner;

}

}

public ArrayList<BlackJackHand> getBlackJack(){
	//add blackjack 
}
		

}


}


}
