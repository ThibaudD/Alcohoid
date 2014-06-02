package fr.thib.alcohoid;

import fr.sensei.alcohoid.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class ListenersAlcohoid implements OnClickListener, OnMenuItemClickListener,
											OnLongClickListener, OnItemClickListener,
											OnItemLongClickListener,
											android.content.DialogInterface.OnClickListener{
	private  AlcohoidActivity aActivity;
	private	 Alcohol alcohol = new Alcohol();
	private View lastview;
	private boolean first = true;
	
	public ListenersAlcohoid(AlcohoidActivity aActivity){
		this.aActivity = aActivity;
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
		TextView tv_amount = (TextView) aActivity.findViewById(R.id.amount);
		
		switch(v.getId()){
		
		case R.id.button_add:
			aActivity.startActivityForResult(new Intent(aActivity,CreateActivity.class), 100);
			break;
			
			
		case R.id.button_add_bottle:
			alcohol.setAmount(alcohol.getAmount()+1);
			AlcohoidActivity.list.invalidateViews();
			AlcohoidActivity.db.UpdateAlcohol(alcohol);
			tv_amount.setText(""+alcohol.getAmount());
			
			break;
			
		case R.id.button_remove_bottle:
			alcohol.setAmount(alcohol.getAmount()-1);
			AlcohoidActivity.list.invalidateViews();
			AlcohoidActivity.db.UpdateAlcohol(alcohol);
			tv_amount.setText(""+alcohol.getAmount());
			break;
			
			
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if(!first){
			lastview.setBackgroundColor(android.graphics.Color.rgb(224, 236, 248));
		}
		first = false;
		lastview = view;
		view.setBackgroundColor(android.graphics.Color.GRAY);
		alcohol = AlcohoidActivity.alcohols.get(position);
		TextView title = (TextView) aActivity.findViewById(R.id.title);
		TextView type = (TextView) aActivity.findViewById(R.id.type);
		TextView country = (TextView) aActivity.findViewById(R.id.country);
		TextView region = (TextView) aActivity.findViewById(R.id.region);
		TextView price = (TextView) aActivity.findViewById(R.id.price);
		TextView date = (TextView) aActivity.findViewById(R.id.date);
		TextView comments = (TextView) aActivity.findViewById(R.id.comments);
		RatingBar rate = (RatingBar) aActivity.findViewById(R.id.rating);
		TextView amount = (TextView) aActivity.findViewById(R.id.amount);
		
		title.setText(alcohol.getTitle());
		type.setText(alcohol.getType());
		country.setText(alcohol.getCountry());
		region.setText(alcohol.getRegion());
		price.setText(""+alcohol.getPrice() + " €");
		date.setText(alcohol.getDate());
		comments.setText(alcohol.getComments());
		rate.setRating(alcohol.getRate());
		amount.setText(""+alcohol.getAmount());
		
		
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		Alcohol a = AlcohoidActivity.alcohols.get(position);
		Dialog(a);
		
		return true;
	}
	public void Dialog(Alcohol a){
		AlertDialog.Builder ad = new AlertDialog.Builder(aActivity);
		ad.setIcon(R.drawable.ic_launcher);
		ad.setTitle(a.getTitle());
		ad.setItems(new String[]{"Modifier","Supprimer"}, this);
		this.alcohol = a;
		
		ad.show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch(which){
		case 0:
			Toast.makeText(aActivity, "Pas encore disponible", 1000).show();
			//aActivity.startActivityForResult(new Intent(aa,CreateActivity.class), (int) alcohol.getAmount());
			break;
			
		case 1:
			Toast.makeText(aActivity, "Suppression de " + alcohol.getTitle(), Toast.LENGTH_SHORT).show();
			AlcohoidActivity.alcohols.remove(alcohol);
			AlcohoidActivity.db.DeleteAlcohol(alcohol.getId());
			AlcohoidActivity.list.invalidateViews();
			break;
		}
		
	}


}
