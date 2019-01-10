package com.veirn.launguagemiwok;

public class word {
    private String m ;
    private String w ;
    private int i;
   private int d ;

    public word(String m , String w,int i,int d) {
        this.m = m;
        this.w= w;
        this.i = i;
        this.d = d ;

    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getM() {

        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return String.format("%s \n%s" ,m ,w) ;
    }
}
