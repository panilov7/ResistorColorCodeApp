package com.panilov.resistorcolorcode;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private static final String PREFS_NAME = "ResistorValueFile";
	private TextView tvOut, tvCol1, tvCol2, tvCol3, tvCol4;
	private Button b1Brown, b1Red, b1Orange, b1Yellow, b1Green, b1Blue,
			b1Violet, b1Gray, b1White;
	private Button b2Black, b2Brown, b2Red, b2Orange, b2Yellow, b2Green,
			b2Blue, b2Violet, b2Gray, b2White;
	private Button b3Black, b3Brown, b3Red, b3Orange, b3Yellow, b3Green,
			b3Blue, b3Violet, b3Gray, b3White, b3Gold, b3Silver;
	private Button b4Brown, b4Red, b4Green, b4Blue, b4Violet, b4Gray, b4Gold,
			b4Silver;
	private int color1, color2, color3, color4;

	private Resistor r = new Resistor();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sharedPref = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean scrollAllColors = sharedPref.getBoolean(
				"checkbox_scroll_colors", true);

		if (scrollAllColors) {
			setContentView(R.layout.activity_main_all);
		} else {
			setContentView(R.layout.activity_main);
		}

		tvOut = (TextView) findViewById(R.id.tv1);
		tvCol1 = (TextView) findViewById(R.id.tv_Color1);
		tvCol2 = (TextView) findViewById(R.id.tv_Color2);
		tvCol3 = (TextView) findViewById(R.id.tv_Color3);
		tvCol4 = (TextView) findViewById(R.id.tv_Color4);

		b1Brown = (Button) findViewById(R.id.btn1_Brown);
		b1Red = (Button) findViewById(R.id.btn1_Red);
		b1Orange = (Button) findViewById(R.id.btn1_Orange);
		b1Yellow = (Button) findViewById(R.id.btn1_Yellow);
		b1Green = (Button) findViewById(R.id.btn1_Green);
		b1Blue = (Button) findViewById(R.id.btn1_Blue);
		b1Violet = (Button) findViewById(R.id.btn1_Violet);
		b1Gray = (Button) findViewById(R.id.btn1_Gray);
		b1White = (Button) findViewById(R.id.btn1_White);

		b2Black = (Button) findViewById(R.id.btn2_Black);
		b2Brown = (Button) findViewById(R.id.btn2_Brown);
		b2Red = (Button) findViewById(R.id.btn2_Red);
		b2Orange = (Button) findViewById(R.id.btn2_Orange);
		b2Yellow = (Button) findViewById(R.id.btn2_Yellow);
		b2Green = (Button) findViewById(R.id.btn2_Green);
		b2Blue = (Button) findViewById(R.id.btn2_Blue);
		b2Violet = (Button) findViewById(R.id.btn2_Violet);
		b2Gray = (Button) findViewById(R.id.btn2_Gray);
		b2White = (Button) findViewById(R.id.btn2_White);

		b3Black = (Button) findViewById(R.id.btn3_Black);
		b3Brown = (Button) findViewById(R.id.btn3_Brown);
		b3Red = (Button) findViewById(R.id.btn3_Red);
		b3Orange = (Button) findViewById(R.id.btn3_Orange);
		b3Yellow = (Button) findViewById(R.id.btn3_Yellow);
		b3Green = (Button) findViewById(R.id.btn3_Green);
		b3Blue = (Button) findViewById(R.id.btn3_Blue);
		b3Violet = (Button) findViewById(R.id.btn3_Violet);
		b3Gray = (Button) findViewById(R.id.btn3_Gray);
		b3White = (Button) findViewById(R.id.btn3_White);
		b3Gold = (Button) findViewById(R.id.btn3_Gold);
		b3Silver = (Button) findViewById(R.id.btn3_Silver);

		b4Brown = (Button) findViewById(R.id.btn4_Brown);
		b4Red = (Button) findViewById(R.id.btn4_Red);
		b4Green = (Button) findViewById(R.id.btn4_Green);
		b4Blue = (Button) findViewById(R.id.btn4_Blue);
		b4Violet = (Button) findViewById(R.id.btn4_Violet);
		b4Gray = (Button) findViewById(R.id.btn4_Gray);
		b4Gold = (Button) findViewById(R.id.btn4_Gold);
		b4Silver = (Button) findViewById(R.id.btn4_Silver);

		b1Brown.setOnClickListener(this);
		b1Red.setOnClickListener(this);
		b1Orange.setOnClickListener(this);
		b1Yellow.setOnClickListener(this);
		b1Green.setOnClickListener(this);
		b1Blue.setOnClickListener(this);
		b1Violet.setOnClickListener(this);
		b1Gray.setOnClickListener(this);
		b1White.setOnClickListener(this);

		b2Black.setOnClickListener(this);
		b2Brown.setOnClickListener(this);
		b2Red.setOnClickListener(this);
		b2Orange.setOnClickListener(this);
		b2Yellow.setOnClickListener(this);
		b2Green.setOnClickListener(this);
		b2Blue.setOnClickListener(this);
		b2Violet.setOnClickListener(this);
		b2Gray.setOnClickListener(this);
		b2White.setOnClickListener(this);

		b3Black.setOnClickListener(this);
		b3Brown.setOnClickListener(this);
		b3Red.setOnClickListener(this);
		b3Orange.setOnClickListener(this);
		b3Yellow.setOnClickListener(this);
		b3Green.setOnClickListener(this);
		b3Blue.setOnClickListener(this);
		b3Violet.setOnClickListener(this);
		b3Gray.setOnClickListener(this);
		b3White.setOnClickListener(this);
		b3Gold.setOnClickListener(this);
		b3Silver.setOnClickListener(this);

		b4Brown.setOnClickListener(this);
		b4Red.setOnClickListener(this);
		b4Green.setOnClickListener(this);
		b4Blue.setOnClickListener(this);
		b4Violet.setOnClickListener(this);
		b4Gray.setOnClickListener(this);
		b4Gold.setOnClickListener(this);
		b4Silver.setOnClickListener(this);

	}

	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("color1", color1);
		editor.putInt("color2", color2);
		editor.putInt("color3", color3);
		editor.putInt("color4", color4);

		editor.commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
		color1 = prefs.getInt("color1", Resistor.COLOR_BROWN);
		color2 = prefs.getInt("color2", Resistor.COLOR_BLACK);
		color3 = prefs.getInt("color3", Resistor.COLOR_BROWN);
		color4 = prefs.getInt("color4", Resistor.COLOR_GOLD);

		r.newResistor(color1, color2, color3, color4);

		switch (color1) {
		case Resistor.COLOR_BROWN:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case Resistor.COLOR_RED:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case Resistor.COLOR_ORANGE:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case Resistor.COLOR_YELLOW:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case Resistor.COLOR_GREEN:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case Resistor.COLOR_BLUE:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case Resistor.COLOR_VIOLET:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case Resistor.COLOR_GRAY:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case Resistor.COLOR_WHITE:
			tvCol1.setBackgroundColor(getResources().getColor(R.color.white));
			break;
		}

		switch (color2) {
		case Resistor.COLOR_BLACK:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.black));
			break;
		case Resistor.COLOR_BROWN:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case Resistor.COLOR_RED:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case Resistor.COLOR_ORANGE:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case Resistor.COLOR_YELLOW:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case Resistor.COLOR_GREEN:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case Resistor.COLOR_BLUE:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case Resistor.COLOR_VIOLET:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case Resistor.COLOR_GRAY:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case Resistor.COLOR_WHITE:
			tvCol2.setBackgroundColor(getResources().getColor(R.color.white));
			break;
		}

		switch (color3) {
		case Resistor.COLOR_BLACK:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.black));
			break;
		case Resistor.COLOR_BROWN:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case Resistor.COLOR_RED:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case Resistor.COLOR_ORANGE:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case Resistor.COLOR_YELLOW:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case Resistor.COLOR_GREEN:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case Resistor.COLOR_BLUE:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case Resistor.COLOR_VIOLET:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case Resistor.COLOR_GRAY:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case Resistor.COLOR_WHITE:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.white));
			break;
		case Resistor.COLOR_GOLD:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.gold));
			break;
		case Resistor.COLOR_SILVER:
			tvCol3.setBackgroundColor(getResources().getColor(R.color.silver));
			break;
		}

		switch (color4) {
		case Resistor.COLOR_BROWN:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case Resistor.COLOR_RED:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.red));
			break;

		case Resistor.COLOR_GREEN:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case Resistor.COLOR_BLUE:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case Resistor.COLOR_VIOLET:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case Resistor.COLOR_GRAY:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case Resistor.COLOR_GOLD:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.gold));
			break;
		case Resistor.COLOR_SILVER:
			tvCol4.setBackgroundColor(getResources().getColor(R.color.silver));
			break;
		}

		tvOut.setText(r.toString());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_settings:
			startActivity(new Intent(this, SettingsActivity.class));
			break;
		}

		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//
		case R.id.btn1_Brown:
			color1 = Resistor.COLOR_BROWN;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case R.id.btn1_Red:
			color1 = Resistor.COLOR_RED;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case R.id.btn1_Orange:
			color1 = Resistor.COLOR_ORANGE;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case R.id.btn1_Yellow:
			color1 = Resistor.COLOR_YELLOW;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case R.id.btn1_Green:
			color1 = Resistor.COLOR_GREEN;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case R.id.btn1_Blue:
			color1 = Resistor.COLOR_BLUE;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case R.id.btn1_Violet:
			color1 = Resistor.COLOR_VIOLET;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case R.id.btn1_Gray:
			color1 = Resistor.COLOR_GRAY;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case R.id.btn1_White:
			color1 = Resistor.COLOR_WHITE;
			tvCol1.setBackgroundColor(getResources().getColor(R.color.white));
			break;

		//
		case R.id.btn2_Black:
			color2 = Resistor.COLOR_BLACK;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn2_Brown:
			color2 = Resistor.COLOR_BROWN;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case R.id.btn2_Red:
			color2 = Resistor.COLOR_RED;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case R.id.btn2_Orange:
			color2 = Resistor.COLOR_ORANGE;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case R.id.btn2_Yellow:
			color2 = Resistor.COLOR_YELLOW;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case R.id.btn2_Green:
			color2 = Resistor.COLOR_GREEN;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case R.id.btn2_Blue:
			color2 = Resistor.COLOR_BLUE;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case R.id.btn2_Violet:
			color2 = Resistor.COLOR_VIOLET;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case R.id.btn2_Gray:
			color2 = Resistor.COLOR_GRAY;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case R.id.btn2_White:
			color2 = Resistor.COLOR_WHITE;
			tvCol2.setBackgroundColor(getResources().getColor(R.color.white));
			break;

		//
		case R.id.btn3_Black:
			color3 = Resistor.COLOR_BLACK;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn3_Brown:
			color3 = Resistor.COLOR_BROWN;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case R.id.btn3_Red:
			color3 = Resistor.COLOR_RED;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case R.id.btn3_Orange:
			color3 = Resistor.COLOR_ORANGE;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.orange));
			break;
		case R.id.btn3_Yellow:
			color3 = Resistor.COLOR_YELLOW;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.yellow));
			break;
		case R.id.btn3_Green:
			color3 = Resistor.COLOR_GREEN;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case R.id.btn3_Blue:
			color3 = Resistor.COLOR_BLUE;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case R.id.btn3_Violet:
			color3 = Resistor.COLOR_VIOLET;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case R.id.btn3_Gray:
			color3 = Resistor.COLOR_GRAY;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case R.id.btn3_White:
			color3 = Resistor.COLOR_WHITE;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.white));
			break;
		case R.id.btn3_Gold:
			color3 = Resistor.COLOR_GOLD;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.gold));
			break;
		case R.id.btn3_Silver:
			color3 = Resistor.COLOR_SILVER;
			tvCol3.setBackgroundColor(getResources().getColor(R.color.silver));
			break;

		//
		case R.id.btn4_Brown:
			color4 = Resistor.COLOR_BROWN;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.brown));
			break;
		case R.id.btn4_Red:
			color4 = Resistor.COLOR_RED;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.red));
			break;
		case R.id.btn4_Green:
			color4 = Resistor.COLOR_GREEN;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.green));
			break;
		case R.id.btn4_Blue:
			color4 = Resistor.COLOR_BLUE;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.blue));
			break;
		case R.id.btn4_Violet:
			color4 = Resistor.COLOR_VIOLET;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.violet));
			break;
		case R.id.btn4_Gray:
			color4 = Resistor.COLOR_GRAY;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.gray));
			break;
		case R.id.btn4_Gold:
			color4 = Resistor.COLOR_GOLD;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.gold));
			break;
		case R.id.btn4_Silver:
			color4 = Resistor.COLOR_SILVER;
			tvCol4.setBackgroundColor(getResources().getColor(R.color.silver));
			break;
		}

		r.newResistor(color1, color2, color3, color4);
		tvOut.setText(r.toString());

	}
}
