LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)


LOCAL_MODULE:= unstallApp
LOCAL_SRC_FILES:= unstallApp.c
LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)

LOCAL_LDLIBS+= -llog
include $(BUILD_SHARED_LIBRARY)


