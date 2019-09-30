package com.e.blackjackapp;


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
        int playerPoints = player.points;
        int dealerPoints = this.points;

        //if both are 21, tied
        if (playerPoints == 21 && dealerPoints == 21) {
            if (player.getHand().size() == 2 && this.getHand().size() != 2) { //only 2 card BlackJack is Ace and 10 card
                return 1; //player wins
            } else if (this.getHand().size() == 2 && player.getHand().size() != 2) {
                return -1; //dealer wins
            } else {
                return 0; //tied
            }
        }

        //If both have busted
        if (this.busted() && player.busted()) {
            return 0;
        } else if (this.busted()) {
            return 1;
        } else if (player.busted()) {
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
