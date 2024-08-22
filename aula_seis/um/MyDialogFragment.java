package com.example.alertdialogfragmenttest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
// O uso do fragmento ajuda a evitar problemas com as caixas de diálogos, como a perda do estado do diálogo durante rotações de tela.
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Como está o clima hoje?")
                .setTitle("Responda a pergunta")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Quente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Beba muita água", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Frio", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Coloque um casaco", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Ameno", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Aproveite o dia!!", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
//onDismiss não pertence ao ciclo de vida do DialogFragment, mas pode ser usado quando o diálogo for fechado pelo usuário.
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(getActivity().getApplicationContext(), "Encerrando o diálogo", Toast.LENGTH_SHORT).show();
            }
        });
        return dialog;
    }//onCreateDialog
}//class
