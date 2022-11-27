package com.example.mysayac;

import android.content.Context;
import android.content.SharedPreferences;

public class SetupClass {

    int upperLimit;
    int lowerLimit;
    int currentValue ; // uygulamadan çıkıldığında en son hangi sayıda kaldığını gösterir

   boolean upperVib; // üst limite ulaştığında titreşim yapsın.
   boolean upperSound;
   boolean loweVib ;
   boolean lowerSound;

   Context context;
   SharedPreferences sharedPreferences;
   SharedPreferences.Editor editor;

   static  SetupClass setupClass = null; // Bunu yapınca ne yapmış olduk. Classımdan türetilmiş nesneleri yani instınsları
                                          // gösterebilen bir referans üretilmiş oldu. Ancak şu an classımdan hiçbir nesne
                                          // türetilmediği için bu değer hiçbir şey göstermiyor.


    private SetupClass(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("setup",Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();

    }
       public static SetupClass getInstance(Context context) {
        if(setupClass==null){
            setupClass=new SetupClass(context);
        }
        return setupClass;
       }


}
