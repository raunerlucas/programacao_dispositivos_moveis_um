import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;


public class ExampleFragment extends Fragment {


   public ExampleFragment() {

       super(R.layout.example_fragment);   //carregando o layout

   }


   @Override

   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

       super.onViewCreated(view, savedInstanceState);

       Integer someInt = requireArguments().getInt("some_int");  //obtém o valor passado pela activity

       Toast.makeText(getContext(),someInt.toString(),Toast.LENGTH_SHORT).show();

   }

}
