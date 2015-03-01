/**
 * 
 */
package net.mindsoup.charactersoup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.mindsoup.charactersoup.pf.util.Calculation;

/**
 * @author Valentijn
 *
 */
public class CalculationView extends TextView {
	
	private Calculation calculation = null;

	public CalculationView(Context context) {
		super(context);
		
		createOnClickListener(context);
	}
	
	public CalculationView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		
		createOnClickListener(context);
	}
	
	public void setCalculation(Calculation c) {
		calculation = c;
	}
	
	@Override
	public void setText(CharSequence text, TextView.BufferType type) {
		if(calculation != null)
			super.setText(text + Integer.toString(calculation.sum()), type);
		else
			super.setText(text, type);
	}
	
	private void createOnClickListener(Context context) {
		this.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(calculation != null)
					Toast.makeText(getContext(), calculation.toString(), Toast.LENGTH_LONG).show();
			}
		});
	}
	
	
	

}
