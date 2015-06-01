package com.nhpatt.exampleofusingcards;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.dexafree.materialList.cards.SmallImageCard;
import com.dexafree.materialList.cards.internal.SmallImageCardItemView;
import com.dexafree.materialList.view.MaterialListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String CARD_NUMBER = "CARD_NUMBER";
	private int cardNumber;
	private MaterialListView listView;
	private LinearLayout scrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.add_card).setOnClickListener(this);
		listView = (MaterialListView) findViewById(R.id.material_listview);
		scrollView = (LinearLayout) findViewById(R.id.card_list);
	}

	@Override
	public void onClick(View v) {
		cardNumber++;
		scrollView.addView(getLayoutInflater().inflate(R.layout.card_example, null));

		SmallImageCard card = createCard();
		SmallImageCardItemView view = (SmallImageCardItemView) getLayoutInflater().inflate(card.getLayout(), null);
		view.build(card);

		scrollView.addView(view);

		listView.add(card);

		listView.add(createCard(), 1);
	}

	@NonNull
	private SmallImageCard createCard() {
		SmallImageCard card = new SmallImageCard(this);
		card.setDescription("Ejemplo " + cardNumber);
		card.setTitle("Titulo");
		card.setDrawable(R.drawable.ic_launcher);
		return card;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("cardNumber", cardNumber);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		cardNumber = savedInstanceState.getInt(CARD_NUMBER);
		super.onRestoreInstanceState(savedInstanceState);
	}
}
