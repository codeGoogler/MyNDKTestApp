package cold.yyh.com.myndk01;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class NdkJniUtils {
    static {
        System.loadLibrary("myJniApp");
        System.loadLibrary("unstallApp");
    }
    public native String getCLanguageString();
    public native void uninstallListener();
}
