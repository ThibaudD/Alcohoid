package fr.thib.alcohoid;

import fr.sensei.alcohoid.R;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class ListenersCreate implements OnClickListener, OnMenuItemClickListener, OnLongClickListener{
	private  CreateActivity ca;
	
	public ListenersCreate(CreateActivity ca){
		this.ca = ca;
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.button_return:
			ca.finish();
			break;
			
		case R.id.button_add_bottle:
			Alcohol a = new Alcohol();
			EditText et_title = (EditText) ca.findViewById(R.id.et_title);
			EditText et_type = (EditText) ca.findViewById(R.id.et_type);
			EditText et_country = (EditText) ca.findViewById(R.id.et_country);
			EditText et_region = (EditText) ca.findViewById(R.id.et_region);
			EditText et_price = (EditText) ca.findViewById(R.id.et_price);
			EditText et_date = (EditText) ca.findViewById(R.id.et_date);
			EditText et_comments = (EditText) ca.findViewById(R.id.et_comments);
			RatingBar et_rate = (RatingBar) ca.findViewById(R.id.rate);
			EditText et_amount = (EditText) ca.findViewById(R.id.et_amount);
			
			a.setTitle(et_title.getText().toString());
			a.setType(et_type.getText().toString());
			a.setCountry(et_country.getText().toString());
			a.setRegion(et_region.getText().toString());
			a.setPrice(Float.parseFloat(et_price.getText().toString()));
			a.setDate(et_date.getText().toString());
			a.setComments(et_comments.getText().toString());
			a.setRate(et_rate.getRating());
			a.setAmount(Integer.parseInt(et_amount.getText().toString()));
			AlcohoidActivity.alcohols.add(a);
			AlcohoidActivity.db.AddAlcohol(a);
			AlcohoidActivity.list.invalidateViews();
			
			Toast.makeText(ca, "Bouteille ajoutée", Toast.LENGTH_SHORT).show();
			ca.finish();
			break;
			
		}
		
	}

}
