/**
 * Author: Karan Sharma
 * File Name: MainActivity.java
 * Date: April 2, 2015
 * App Description: This app gives the user body mass index value and displays the information from 
 * health department to the user. This app also allow the user to select different units.
 */


package ca.georgiancollege.bmiclaculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {

	// PRIVATE VARIABLES +++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	private Button _reset;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this._weightEditText = (EditText) findViewById(R.id.weightEditText);
        this._heightEditText = (EditText) findViewById(R.id.heightEditText);
        this._resultView = (TextView) findViewById(R.id.resultView);
        this._calculate = (Button) findViewById(R.id.calculateButton); 
        this._radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        this._reset = (Button) findViewById(R.id.resetButton);
	}

	/**
	 * This method deal with the click of the calculate button
	 * @param view
	 */
	public void clickHandler(View view) {
	     
		int id = this._radioGroup.getCheckedRadioButtonId();
		    this._selectedButton = (RadioButton) findViewById(id);
		    this._select = (String) this._selectedButton.getText();
		    
	     if (view.getId() == R.id.calculateButton) {

	      // get the users values 

	      this._weight = Float.parseFloat(this._weightEditText.getText().toString());
	      this._height = Float.parseFloat(this._heightEditText.getText().toString());
	 
	      // calculate the bmi value 
	      float bmiValue = calculateBMI(this._weight, this._height);
	 
	      // formatting the bmi result upto 2 decimal place
	      String b = String.format("%.02f", bmiValue);
	      
	      // showing the meaning of the bmi value
	      String bmiInterpretation = interpretBMI(bmiValue);
	 
	      // set the color of the text
	      this._resultView.setTextColor(Color.RED);
	      
	   //  set the value in the result text
	      this._resultView.setText(b + " - " + bmiInterpretation);
	    
	     }
	   }
	
	/**
	 * reset the application to the default state
	 * @param view
	 */
	public void resetOnClick(View view) {
		this._radioGroup.clearCheck();
		this._resultView.setText("");
		this._weightEditText.setText("");
		this._heightEditText.setText("");
	}
	 
	  /**
	   * This method calculate the BMI index
	   * @param weight of the user
	   * @param height of the user
	   * @return
	   */
	    private float calculateBMI (float weight, float height) {
           // calculate the bmi if user selects the imperial
	    	if(this._select.equals("Imperial")){
	    		this._bmi = ((this._weight * 703) / (this._height * this._height));
	    	}
	    	// calculate the bmi if user selects the metric
	    	else if (this._select.equals("Metric")){
	    		this._bmi = (this._weight / (this._height * this._height));
	    	}
	    	return this._bmi;
	    }

	 
	    /**
	     * This method interpret meaning of bmi
	     * @param bmiValue
	     * @return the String which is meaning of bmi
	     */
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
