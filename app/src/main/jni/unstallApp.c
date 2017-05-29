#include <stdio.h>
#include <unistd.h>
#include <android/log.h>
#include <jni.h>

#define LOG_TAG "System.out.c"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

JNIEXPORT void JNICALL Java_cold_yyh_com_myndk01_NdkJniUtils_uninstallListener(JNIEnv *env, jobject obj){
    int code = fork();

    if (code > 0) {

        //父进程
        LOGD("parent-->code=%d\n", code);
    } else if (code == 0) {
        //子进程
        LOGD("children-->code=%d\n", code);
        int stop = 1;

        while (stop) {
            //每隔1秒钟判断应用目录是否存在
            sleep(1);
            FILE *file = fopen("/data/data/com.edwin.uninstallapp", "r");
            if (file == NULL) {

                LOGD("uninstall-->code=%d\n", code);
                //TODO 通过Linux命令启动浏览器问卷调查...删除文件等等操作
                execlp("am", "am", "start", "-a", "android.intent.action.VIEW", "-d",
                       "http://wuhaoyou.com/wp/", NULL);
                stop = 0;
            }
        }
    } else {
        //其它
        LOGD("error-->code=%d\n", code);
    }
};