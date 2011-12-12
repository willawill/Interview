//Card shuffling and dealing program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeckOfCards extends JFrame 
     {
     private Card deck[];
     private int currentCard;
     private JButton dealButton, shuffleButton;
     private JTextField displayCard;
     private JLabel status;
    
     public DeckOfCards()
         {
         super( "Card Dealing Program" );
        
             String faces[] = { "Ace", "Deuce", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
         String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
        
         deck = new Card[ 52 ];
         currentCard = -1;
        
         for ( int i = 0; i < deck.length; i++ )
         deck[ i ] = new Card( faces[ i % 13 ], suits[ i / 13 ] );
        
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
        
         dealButton = new JButton( "Deal card" );
         dealButton.addActionListener( new ActionListener() 
             { 
             public void actionPerformed( ActionEvent e )
                 {
                 Card dealt = dealCard();
                
                 if ( dealt != null ) 
                     {
                     displayCard.setText( dealt.toString() );
                     status.setText( "Card #: " + currentCard );
                 }
                 else 
                     {
                     displayCard.setText( "NO MORE CARDS TO DEAL" );
                     status.setText( "Shuffle cards to continue" );
                 }
             }
         } );
         c.add( dealButton );
        
         shuffleButton = new JButton( "Shuffle cards" );
         shuffleButton.addActionListener( new ActionListener() 
             {
             public void actionPerformed( ActionEvent e )
                 {
                 displayCard.setText( "SHUFFLING ..." );
                 shuffle();
                 displayCard.setText( "DECK IS SHUFFLED" );
             }
         });
         c.add( shuffleButton );
        
         displayCard = new JTextField( 20 );
         displayCard.setEditable( false );
         c.add( displayCard );
        
         status = new JLabel();
         c.add( status );
        
         setSize( 275, 120 ); // set the window size
         show(); // show the window
     }
    
     public void shuffle()
         {
         currentCard = -1;
        
         for ( int i = 0; i < deck.length; i++ ) 
             {
             int j = ( int ) ( Math.random() * 52 );
             Card temp = deck[ i ]; // swap
             deck[ i ] = deck[ j ]; // the
             deck[ j ] = temp; // cards
         }
        
         dealButton.setEnabled( true );
     }
    
     public Card dealCard()
         {
         if ( ++currentCard < deck.length )
         return deck[ currentCard ];
         else 
             {
             dealButton.setEnabled( false );
             return null;
         }
     }
    
     public static void main( String args[] )
         {
         DeckOfCards app = new DeckOfCards();
        
         app.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
}

class Card 
     {
     private String face;
     private String suit;
    
     public Card( String f, String s )
         {
         face = f;
         suit = s;
     }
    
     public String toString() 
         { 
         return face + " of " + suit; 
     }
}

