package ca.georgiancollege.bmiclaculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private float _height;
	private float _weight;
	private float _bmi;
	private String _select;
	private EditText _weightEditText;
	private EditText _heightEditText;
	private TextView _resultView;
	private RadioGroup _radioGroup;
	private RadioButton _selectedButton;
	private Button _calculate;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this._weightEditText = (EditText) findViewById(R.id.weightEditText);
        this._heightEditText = (EditText) findViewById(R.id.heightEditText);
        this._resultView = (TextView) findViewById(R.id.resultView);
        this._calculate = (Button) findViewById(R.id.calculateButton); 
        this._radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
	}

	
	
	public void clickHandler(View view) {
	     
		int rg = this._radioGroup.getCheckedRadioButtonId();
		    this._selectedButton = (RadioButton) findViewById(rg);
		    this._select = (String) this._selectedButton.getText();
		    
	     if (view.getId() == R.id.calculateButton) {

	  
	      this._weight = Float.parseFloat(this._weightEditText.getText().toString());
	      this._height = Float.parseFloat(this._heightEditText.getText().toString());
	 
	      // calculate the bmi value

	      float bmiValue = calculateBMI(this._weight, this._height);
	 
	      // interpret the meaning of the bmi value
	      String bmiInterpretation = interpretBMI(bmiValue);
	 
	      // now set the value in the result text

	      this._resultView.setText(bmiValue + "-" + bmiInterpretation);
	     }
	    }
	 
	    // the formula to calculate the BMI index
	    private float calculateBMI (float weight, float height) {

	    	if(this._select.equals("Imperial")){
	    		this._bmi = ((this._weight * 703) / (this._height * this._height));
	    	}
	    	else if (this._select.equals("Metric")){
	    		this._bmi = (this._weight / (this._height * this._height));
	    	}
	    	return this._bmi;
	    }

	 
	    // interpret what BMI means
	    private String interpretBMI(float bmiValue) {

	     if (bmiValue < 16) {
	      return "Severely underweight";
	     } else if (bmiValue < 18.5) {

	      return "Underweight";
	     } else if (bmiValue < 25) {

	      return "Normal";
	     } else if (bmiValue < 30) {

	      return "Overweight";
	     } else {
	      return "Obese";
	     }

	    }
	    
	    
	    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
