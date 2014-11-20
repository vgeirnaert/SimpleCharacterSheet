package net.mindsoup.pathfindercharactersheet.pf.util;

import java.util.HashMap;
import java.util.Map;

public class Calculation {
	private Map<String, Integer> values = new HashMap<String, Integer>();
	
	public void add(String name, int value) {
		add(name, value, false);
	}
	
	public void add(String name, int value, boolean addZeroToo) {
		if(value != 0 || addZeroToo) {
            if(values.containsKey(name)) {
                int total = value + values.get(name);
                if(!addZeroToo && total == 0) {
                    values.remove(name);
                } else {
                    values.put(name, total);
                }
            } else {
                values.put(name, value);
            }
        }
	}
	
	public int sum() {
		int sum = 0;
		
		for(Integer i : values.values())
			sum += i;
		
		return sum;
	}
	
	public void add(Calculation c) {
		for(String s: c.getValues().keySet()) {
			Integer i = values.get(s);
			
			if(i == null)
				i = 0;
			
			Integer value =  c.getValues().get(s) + i; 
			values.put(s, value);
		}
			
	}
	
	public Map<String, Integer> getValues() {
		return values;
	}
	
	@Override
	public String toString() {
		return this.sum() + " = [" + this.explain() + "]";
	}
	
	public String explain() {
		String explanation = "";
		boolean firstRun = true;
		for(String s : values.keySet()) {
			String operand = "+";
			
			if(values.get(s) < 0)
				operand = "";
			
			if(firstRun) {
				operand = "";
				firstRun = false;
			}
			
			
			explanation += operand + values.get(s) + " (" + s + ") "; 
		}
		
		return explanation;
	}
	
	public void remove(String name) {
		values.remove(name);
	}
	
}
