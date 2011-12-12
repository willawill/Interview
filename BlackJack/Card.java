public abstract class Card{

protected Suit suit;
protected int rank;
private boolean available;

public Card(String s, int rank){
	this.suit = s;
	this.rank = rank;
}

public abstract int value(Card c);


public void markAvailable(){
	available = true;}

public void markUnavailable(){
	available = false;
}

}
