package fr.thib.alcohoid;

import java.util.ArrayList;

import fr.sensei.alcohoid.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	
	private ArrayList<Alcohol> alcohols;
	private LayoutInflater inflater;
	
	public ListAdapter(Context context, ArrayList<Alcohol> alcohols){
		this.inflater = LayoutInflater.from(context);
		this.alcohols = alcohols;
		
	}

	@Override
	public int getCount() {
		return alcohols.size();
	}

	@Override
	public Object getItem(int position) {
		return this.alcohols.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public static class ViewHolder{
		TextView text_title;
		TextView text_type;
		//TextView text_amount;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.list, null);
			holder = new ViewHolder();
			holder.text_title = (TextView) convertView.findViewById(R.id.tl_title);
			holder.text_type = (TextView) convertView.findViewById(R.id.tl_type);
			//holder.text_amount = (TextView) convertView.findViewById(R.id.tl_amount);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.text_title.setText(alcohols.get(position).getTitle());
		holder.text_type.setText(alcohols.get(position).getType()+ "   Stock : "+ alcohols.get(position).getAmount());
		//holder.text_amount.setText(""+alcohols.get(position).getAmount()+" en stock");
		
		return convertView;
	}

}
