//Copyright (C) 2021, Grzegorz Stefański
package edu.ib.project.crazyeights.backend;

import java.util.List;

public class Player {

  private String name;
  private List<Card> playerCards;
  private int score;
  private boolean cheater;

  public Player(String name, List<Card> playerCards) {
    this.name = name;
    this.playerCards = playerCards;
    this.score = 0;
    this.cheater = false;
  }

  public void playCard(Deck deck, int cardIndex) throws Exception {
    Card lastCardOnDiscardPile = deck.getLastCardFromDiscardPile();
    Card cardToPlay = playerCards.get(cardIndex);

    if (cardToPlay.compare(lastCardOnDiscardPile)) {
      playerCards.remove(cardToPlay);
      deck.addCardToDiscardPile(cardToPlay);
    } else throw new Exception("Player can't play this card now!");
  }

  public void playCrazyEight(Deck deck, int cardIndex, String newColor) {
    Card cardToPlay = playerCards.get(cardIndex);

    playerCards.remove(cardToPlay);
    deck.addCardToDiscardPile(cardToPlay, newColor);
  }

  public void drawCard(Deck deck) {
    try {
      if (playerCards.size() < 10) playerCards.add(deck.getCardFromDeck());
    } catch (Exception e) {
      cheater = true;
    }
  }

  public boolean isPlayersCardEmpty() {
    return playerCards.isEmpty();
  }

  public boolean isCheater() {
    return cheater;
  }

  public Card getCard(int index) {
    return playerCards.get(index);
  }

  public List<Card> getPlayerCards() {
    return playerCards;
  }
}
