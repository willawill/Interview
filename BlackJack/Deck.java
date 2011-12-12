public class Deck(){

private ArrayList<T extends Card> cards = new ArrayList<T extends Card>();
private int dealtIndex; // Store which is the last card assigned.

public Deck(ArrayList<T extends Card c, int index){
	this.cards = c;
	this dealtIndex = index;
}

public void shuffle(){

int currentCard = -1;
for(int i =0; i<51;i++){
	int temp = (int) Math.random()*52;
	T card1 =  cards.get(i);
	T card2 = cards.get(temp);
	cards.setCard(i,card2);
	cards.setCard(j,card1);
	}
}
public ArrayList<T> getCard(){
	return cards;
	
}
public void setCard(int index, T card){
	cards.put(index, card);
}
public int getDealtIndex(){
	return this.dealtIndex;
}

public void setDealtIndex(int i){
	this.dealtIndex = i;
}
public int remainCards(){
	return cards.size() - dealtIndex;
}
public T dealCard(){
	if (remainCards() == 0){
		return null;
}
	T card = cards.get(dealtIndex);
	card.markUnavailable;
	dealtIndex ++;
	return card;

}

public T[] dealHands(int number){
	if (remainCards()<number){
		return null;
}
	T[] hand = (T[])new Card[number];
	int count = 0;
	while(count < number){
		T card = dealCard();
		if (card!=null){
		hand[count] = card;
		count ++
}
}
	return hand;

}

}
