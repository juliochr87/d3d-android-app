package com.corporacionjoules.www.myapplication.utilities;

/**
 * Created by jhernandez on 7/5/2017.
 */

public class Utils {

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}
