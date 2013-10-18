package com.jeremie.shopsTallySystem.strategy;

public class CashRebate implements CashSuper {
	
	private double monryRebate = 1;
	
	 public CashRebate(String moneyRebate){
         this.monryRebate = Double.parseDouble(moneyRebate);
     }
	 
	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money * monryRebate;
	}

}
