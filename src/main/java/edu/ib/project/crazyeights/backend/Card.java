//Copyright (C) 2021, Grzegorz Stefański
package edu.ib.project.crazyeights.backend;

public class Card {

  private final String color;
  private final String value;

  public Card(String color, String value) {
    this.color = color;
    this.value = value;
  }

  public boolean compare(Card card) {
    return color.equals(card.getColor()) || value.equals(card.getValue());
  }

  public static boolean compareCrazyEight(Card card) {
    return card.getValue().equals("8");
  }

  public String getColor() {
    return color;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Card{" + "color=" + color + ", value=" + value + '}';
  }
}
