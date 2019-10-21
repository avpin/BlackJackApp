package com.e.blackjackapp;

/**
 * A model of a BlackJack Dealer
 *
 * @author Aaron Pin
 * @version 1.0 09/29/2019
 */
public class Dealer extends Player {

    /**
     * The Dealer's constructor, as a subclass of Player
     *
     * @param deck the deck object from the game
     */
    public Dealer(Deck deck) {
        super(deck);
    }

    /**
     * This method runs the dealer's automated turn
     *
     * @param player the dealer's opponent
     * @return -1 if dealer wins, 0 on tie, and 1 if player wins, -2 if error occurred
     */
    public int turn(Player player) {
        int playerPoints = player.points; // should not directly refer to points
        int dealerPoints = this.points;



        //if both are 21, tied
        if (player.blackJack() && this.blackJack()) {
            if (player.getHand().size() == 2 && this.getHand().size() != 2) { //only 2 card BlackJack is Ace and 10 card
                return 1; //player wins
            } else if (this.getHand().size() == 2 && player.getHand().size() != 2) {
                return -1; //dealer wins
            } else {
                return 0; //tied
            }
        }
        //one person has blackjack
        if(this.blackJack() && !player.blackJack()){
            return -1;
        }

        //If both have busted
        if (this.busted() && player.busted()) {
            return 0;
        }
        if (this.busted()) { //if only dealer has busted
            return 1;
        }
        if (player.busted()) { //if only player has busted
            return -1;
        }





        if (dealerPoints > playerPoints) {
            return -1;
        }
        if (playerPoints >= dealerPoints) { //if dealer losing
            if (dealerPoints < 21 && this.getHand().size() < 5) { //if the dealer can draw, do so
                this.hit();
                return turn(player);
            }
            return 1;
        }
        return -2;
    }

}
