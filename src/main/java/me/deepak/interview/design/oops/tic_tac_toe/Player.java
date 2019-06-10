package me.deepak.interview.design.oops.tic_tac_toe;

import java.util.Arrays;

public class Player {

	private String name;
	private Symbol symbol;
	private int[] rowSum;
	private int[] columnSum;
	private int digSum;
	private int revDigSum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public int[] getRowSum() {
		return rowSum;
	}

	public void setRowSum(int[] rowSum) {
		this.rowSum = rowSum;
	}

	public int[] getColumnSum() {
		return columnSum;
	}

	public void setColumnSum(int[] columnSum) {
		this.columnSum = columnSum;
	}

	public int getDigSum() {
		return digSum;
	}

	public void setDigSum(int digSum) {
		this.digSum = digSum;
	}

	public int getRevDigSum() {
		return revDigSum;
	}

	public void setRevDigSum(int revDigSum) {
		this.revDigSum = revDigSum;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", symbol=" + symbol + ", rowSum=" + Arrays.toString(rowSum) + ", columnSum="
				+ Arrays.toString(columnSum) + ", digSum=" + digSum + ", revDigSum=" + revDigSum + "]";
	}

}
