package com.example.alertdialogpersonalizado;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog,null);
        EditText editTextNome = view.findViewById(R.id.editTextNome);
        builder.setView(view)
                .setTitle("Personalizado")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nome = editTextNome.getText().toString();
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Você clicou em sim "+nome, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nome = editTextNome.getText().toString();
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Você clicou em não "+nome, Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}//class
