package com.test;

public class Main {
    public static void main(String[] args) {
        int[] arr={3,1,7,9,9,5};
        System.out.println(digit(arr));
        int[] stan = {0,200,375,550,750,950,1351};
        System.out.println(stantion(stan,400));
    }

    public static int stantion(int[] stan, int bak){//сколько остановок для заправки должна сделать машина при условии что у неё бак 400л
        int back=bak;
        int n = 0;
        for(int i = 0;i<stan.length-1;i++){
            if(back<stan[i+1]-stan[i]){
                back=bak+stan[i]-stan[i+1];
                n++;
            }
            else {
                    back -= stan[i + 1] - stan[i];
            }
            if (back<0){
                return -1;
            }

        }
        return n;
    }

    public static String digit(int[] arr){//алгоритм по сортировки массива по убыванию
        String str = "";
        for(int j=0;j<arr.length;j++){
            int n=arr[j];
            for(int i=j;i<arr.length;i++) {
                if(n<arr[i]){
                    int k=arr[i];
                    arr[i]=n;
                    n=k;
                }

            }
            arr[j]=n;
        }
        for (int i=0;i< arr.length;i++){
            str+=String.valueOf(arr[i]);
        }
        return str;
    }
}
