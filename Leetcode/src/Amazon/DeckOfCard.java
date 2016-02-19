package Amazon;

import java.util.ArrayList;

public class DeckOfCard {
	public enum Suit{
		Club, Diamond, Heart, Spade;
	}
	
	public class Deck<T extends Card>{
		private ArrayList<T> cards;
		private int dealtNum = 0;
		private void setDeckOfCards(ArrayList<T> deckOfCards){
			
		}
		public void shuffle(){
			
		}
		public int remainingCards(){
			return cards.size() - dealtNum;
		}
		public void dealCard(){
			
		}
	}
	
	public abstract class Card{
		private boolean isAvailable = true;
		private int value;
		private Suit suit;
		public Card(int val, Suit s){
			this.value = val;
			this.suit = s;
		}
		
	}
}
