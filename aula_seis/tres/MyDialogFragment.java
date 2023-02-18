package com.example.alertdialoglist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
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
        builder.setTitle("Escolha o dia da semana")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(R.array.array_semana, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Você clicou em: "+i, Toast.LENGTH_SHORT).show();

                        Toast.makeText(getActivity().getApplicationContext(),
                                recuperarItem(i), Toast.LENGTH_SHORT).show();
                    }

                });
        return builder.create();

    }//method

    private String recuperarItem(int i){
        Resources resources = getResources();
        String[] dias_semana = resources.getStringArray(R.array.array_semana);
        return dias_semana[i];
    }
}//class
