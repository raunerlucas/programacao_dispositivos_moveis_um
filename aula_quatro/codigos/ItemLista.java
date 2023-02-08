package com.example.minhalistacomplexa;

public class ItemLista {
    private String dados;
    private int imagem;

    public ItemLista()
    {
    }

    public ItemLista(String dados, int imagem)
    {
        this.dados = dados;
        this.imagem = imagem;
    }

    public int getImagem()
    {
        
        return imagem;
    }

    public void setImagem(int imagem)
    {
        
        this.imagem = imagem;
    }

    public String getDados()
    {
        
        return dados;
    }

    public void setDados(String dados)
    {
        
        this.dados = dados;
    }
}
