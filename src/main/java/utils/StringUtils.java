package utils;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isAnyNullOrEmpty(String... strings) {
        if (strings == null)
            return true;

        for (String string : strings) {
            if (isNullOrEmpty(string))
                return true;
        }

        return false;
    }

}
