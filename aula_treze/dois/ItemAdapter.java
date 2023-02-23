import android.content.Context;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


   private Context context;

   private ArrayList<ItemModel> itemModelArrayList;


   public ItemAdapter(Context context, ArrayList<ItemModel> itemModelArrayList) {

       this.context = context;

       this.itemModelArrayList = itemModelArrayList;

   }


   @NonNull

   @Override

   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,

                                        int viewType) {

       View view = LayoutInflater.from(parent.getContext()).

               inflate(R.layout.item_layout, parent, false);

       return new ViewHolder(view);

   }


   @Override

   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       ItemModel itemModel = itemModelArrayList.get(position);

       holder.imageView.setImageResource(itemModel.getImagem());

       holder.textView.setText(itemModel.getTexto());

   }


   @Override

   public int getItemCount() {

       return itemModelArrayList.size();

   }


   public class ViewHolder extends RecyclerView.ViewHolder{

       private ImageView imageView;

       private TextView textView;


       public ViewHolder(@NonNull View itemView) {

           super(itemView);

           imageView = itemView.findViewById(R.id.imageView);

           textView = itemView.findViewById(R.id.textView);


       }

   }//inner

}//class
