package com.panilov.resistorcolorcode;

import java.text.DecimalFormat;

public class Resistor {

	public static final int COLOR_BLACK = 0;
	public static final int COLOR_BROWN = 1;
	public static final int COLOR_RED = 2;
	public static final int COLOR_ORANGE = 3;
	public static final int COLOR_YELLOW = 4;
	public static final int COLOR_GREEN = 5;
	public static final int COLOR_BLUE = 6;
	public static final int COLOR_VIOLET = 7;
	public static final int COLOR_GRAY = 8;
	public static final int COLOR_WHITE = 9;
	public static final int COLOR_GOLD = 10;
	public static final int COLOR_SILVER = 11;
	public static final int COLOR_NONE = 12;

	private double value = 0;
	private float tolerance = 0;

	// 4 band resistor
	public void newResistor(int c1, int c2, int c3, int c4) {
		value = c1 * 10 + c2;
		if (c3 == COLOR_BLACK) {
			value *= 1;
		} else if (c3 == COLOR_BROWN) {
			value *= 10;
		} else if (c3 == COLOR_RED) {
			value *= 100;
		} else if (c3 == COLOR_ORANGE) {
			value *= 1000;
		} else if (c3 == COLOR_YELLOW) {
			value *= 10000;
		} else if (c3 == COLOR_GREEN) {
			value *= 100000;
		} else if (c3 == COLOR_BLUE) {
			value *= 1000000;
		} else if (c3 == COLOR_VIOLET) {
			value *= 10000000;
		} else if (c3 == COLOR_GRAY) {
			value *= 100000000;
		} else if (c3 == COLOR_WHITE) {
			value *= 1000000000;
		} else if (c3 == COLOR_GOLD) {
			value *= 0.1;

		} else if (c3 == COLOR_SILVER) {
			value *= 0.01;
		}

		if (c4 == COLOR_BROWN) {
			tolerance = 1f;
		} else if (c4 == COLOR_RED) {
			tolerance = 2f;
		} else if (c4 == COLOR_GREEN) {
			tolerance = 0.5f;
		} else if (c4 == COLOR_BLUE) {
			tolerance = 0.25f;
		} else if (c4 == COLOR_VIOLET) {
			tolerance = 0.1f;
		} else if (c4 == COLOR_GRAY) {
			tolerance = 0.05f;
		} else if (c4 == COLOR_GOLD) {
			tolerance = 5f;
		} else if (c4 == COLOR_SILVER) {
			tolerance = 10f;
		} else if (c4 == COLOR_NONE) {
			tolerance = 20f;
		}

	}

	public double getValue() {
		return value;
	}

	public float getTolerance() {
		return tolerance;
	}

	public String toString() {
		String s = " ";

		if (value >= 1000000) {
			value /= 1000000;
			s = " M";
		} else if (value >= 1000) {
			value /= 1000;
			s = " k";
		}

		String vv = String.valueOf(value);
		vv = vv.substring(vv.indexOf(".")).substring(1);
		long v = Long.valueOf(vv);

		String tt = String.valueOf(tolerance);
		tt = tt.substring(tt.indexOf(".")).substring(1);
		int t = Integer.valueOf(tt);

		if (v == 0) {
			if (t == 0) {
				return (int) value + s + '\u03A9' + " " + '\u00B1' + " "
						+ (int) tolerance + "%";
			}

			return (int) value + s + '\u03A9' + " " + '\u00B1' + " "
					+ tolerance + "%";
		}

		DecimalFormat df = new DecimalFormat("#.##");

		if (t == 0) {
			return df.format(value) + s + '\u03A9' + ", " + '\u00B1' + " "
					+ (int) tolerance + "%";
		}

		return df.format(value) + s + '\u03A9' + ", " + '\u00B1' + " "
				+ tolerance + "%";

	}
}
