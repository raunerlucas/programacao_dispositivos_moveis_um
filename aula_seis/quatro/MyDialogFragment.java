package com.example.alertdialogfragmenttest;


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

      // return super.onCreateDialog(savedInstanceState);

      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

      builder.setTitle("Escolha o dia da semana: ")

              .setIcon(R.mipmap.ic_launcher)

              .setMultiChoiceItems(R.array.array_semana, null,       //adiciona uma lista de múltipla escolha

                      new DialogInterface.OnMultiChoiceClickListener() {

                  @Override

                  public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                      if (b) {     //verificar qual item da lista foi selecionado

                        Toast.makeText(getActivity().getApplicationContext(),

                                recuperarItem(i), Toast.LENGTH_SHORT).show();   //mostra qual elemento foi selecionado

                      }

                  }//onClick

              });

      return builder.create();


   }//onCreateDialog


   private String recuperarItem(int i){    

       Resources res = getResources();

       String[] dias_semana = res.getStringArray(R.array.array_semana);

       return dias_semana[i];

   }//

}//class
