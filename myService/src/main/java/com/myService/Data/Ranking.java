package com.myService.Data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Ranking {
	
	public static List<Pitcher> plist(){
		List<Pitcher> list = new ArrayList<>();
		
		list.add(new Pitcher("류현진", 121, 72, 3.89f) );
		list.add(new Pitcher("히트", 169, 42, 2.31f) );
		list.add(new Pitcher("원태인", 105, 60, 3.56f) );
		return list;
	}
	
	@Getter
	@Setter
	public static class Pitcher{
		private String name;
		private int strikeOut;
		private int lostPoint;
		private float era;
		public Pitcher(String name, int so, int lp, float era) {
			this.name=name;
			this.strikeOut=so;
			this.lostPoint=lp;
			this.era=era;
		}
	}
}
