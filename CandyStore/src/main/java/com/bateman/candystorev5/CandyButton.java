package com.bateman.candystorev5;

import android.content.Context;
import android.widget.Button;

public class CandyButton extends android.support.v7.widget.AppCompatButton {
  private Candy candy;

  public CandyButton( Context context, Candy newCandy ) {
    super( context );
    candy = newCandy;
  }

  public double getPrice( ) {
    return candy.getPrice( );
  }
}
