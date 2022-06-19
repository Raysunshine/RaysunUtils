package com.raysun.utils.PermissionsUtils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.raysun.utils.LogUtils.Logs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermissionUtils {

    private final static int CODE_MULTI_PERMISSION = 520;

    /**
     * 日历权限
     */
    // Allows an application to read the user's calendar data.
    public final static int CODE_READ_CALENDAR = 0;
    // Allows an application to write the user's calendar data.
    public final static int CODE_WRITE_CALENDAR = 1;

    /**
     * 相机权限
     */
    // Required to be able to access the camera device.
    public final static int CODE_CAMERA = 2;

    /**
     * 联系人权限
     */
    // Allows an application to write the user's contacts data.
    public final static int CODE_WRITE_CONTACTS = 3;
    // Allows an application to read the user's contacts data.
    public final static int CODE_READ_CONTACTS = 4;
    // Allows access to the list of accounts in the Accounts Service.
    public final static int CODE_GET_ACCOUNTS = 5;

    /**
     * 位置权限
     */
    // Allows an app to access location in the background.
    public final static int CODE_ACCESS_BACKGROUND_LOCATION = 6;
    // Allows an app to access approximate location.
    public final static int CODE_ACCESS_COARSE_LOCATION = 7;
    // Allows an app to access precise location.
    public final static int CODE_ACCESS_FINE_LOCATION = 8;
    // Allows an application to access any geographic locations persisted in the user's shared collection.
    public final static int CODE_ACCESS_MEDIA_LOCATION = 9;

    /**
     * 麦克风权限
     */
    // Allows an application to record audio.
    public final static int CODE_RECORD_AUDIO = 10;

    /**
     * 电话权限
     */
    // Allows a calling app to continue a call which was started in another app.
    public final static int CODE_ACCEPT_HANDOVER = 11;
    // Allows an application to initiate a phone call without going through the Dialer user interface for the user to confirm the call.
    public final static int CODE_CALL_PHONE = 12;
    // Allows an application to read the user's call log.
    public final static int CODE_READ_CALL_LOG = 13;
    // Allows an application to write (but not read) the user's call log data.
    public final static int CODE_WRITE_CALL_LOG = 14;
    // Allows the app to answer an incoming phone call.
    public final static int CODE_ANSWER_PHONE_CALLS = 15;
    // Allows an application to use SIP service.
    public final static int CODE_USE_SIP = 16;

    /**
     * 手机权限
     */
    // Allows read access to the device's phone number(s).
    public final static int CODE_READ_PHONE_NUMBERS = 17;
    // Allows read only access to phone state, including the current cellular network information, the status of any ongoing calls, and a list of any PhoneAccounts registered on the device.
    public final static int CODE_READ_PHONE_STATE = 18;
    // Allows an application to add voicemails into the system.
    public final static int CODE_ADD_VOICEMAIL = 19;
    // Required to be able to range to devices using ultra-wide_band.
    public final static int CODE_UWB_RANGING = 20;


    /**
     * 存储权限
     */
    // Allows an application to write to external storage.
    // WRITE_EXTERNAL_STORAGE no longer provides write access when targeting Android 10+
    public final static int CODE_WRITE_EXTERNAL_STORAGE = 21;
    // Allows an application to read from external storage.
    public final static int CODE_READ_EXTERNAL_STORAGE = 22;


    /**
     * 蓝牙权限
     */
    // Required to be able to advertise to nearby Bluetooth devices.
    public final static int CODE_BLUETOOTH_ADVERTISE = 23;
    // Required to be able to connect to paired Bluetooth devices.
    public final static int CODE_BLUETOOTH_CONNECT = 24;
    // Required to be able to discover and pair nearby Bluetooth devices.
    public final static int CODE_BLUETOOTH_SCAN = 25;

    /**
     * 传感器权限
     */
    // Allows an application to access data from sensors that the user uses to measure what is happening inside their body, such as heart rate.
    public final static int CODE_BODY_SENSORS = 26;


    /**
     * 短信权限
     */
    // Allows an application to read SMS messages.
    public final static int CODE_READ_SMS = 27;
    // Allows an application to monitor incoming MMS messages.
    public final static int CODE_RECEIVE_MMS = 28;
    // Allows an application to receive SMS messages.
    public final static int CODE_RECEIVE_SMS = 29;
    // Allows an application to receive WAP push messages.
    public final static int CODE_RECEIVE_WAP_PUSH = 30;
    // Allows an application to send SMS messages.
    public final static int CODE_SEND_SMS = 31;

    /**
     * 其他权限
     */
    // Allows an application to recognize physical activity.
    public final static int CODE_ACTIVITY_RECOGNITION = 32;
    // This constant was deprecated in API level 29.
    // Applications should use CallRedirectionService instead of the Intent.ACTION_NEW_OUTGOING_CALL broadcast.
    public final static int CODE_PROCESS_OUTGOING_CALLS = 33;

    /**
     * 权限不存在，请不要申请
     */
    // Required to be able to advertise and connect to nearby devices via Wi-Fi.
    // NULL public final static int CODE_NEARBY_WIFI_DEVICES = 34;
    // Allows an app to post notifications
    // NULL public final static int CODE_POST_NOTIFICATIONS = 35;
    // Allows an application to read audio files from external storage.
    // NULL public final static int CODE_READ_MEDIA_AUDIO = 36;
    // Allows an application to read image files from external storage.
    // NULL public final static int CODE_READ_MEDIA_IMAGES = 37;
    // Allows an application to read video files from external storage.
    // NULL public final static int CODE_READ_MEDIA_VIDEO = 38;
    // Allows an application to access data from sensors that the user uses to measure what is happening inside their body, such as heart rate.
    // NULL public final static int CODE_BODY_SENSORS_BACKGROUND = 39;

    public final static String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public final static String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    public final static String CAMERA = Manifest.permission.CAMERA;
    public final static String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public final static String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public final static String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public final static String ACCESS_BACKGROUND_LOCATION = Manifest.permission.ACCESS_BACKGROUND_LOCATION;
    public final static String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public final static String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public final static String ACCESS_MEDIA_LOCATION = Manifest.permission.ACCESS_MEDIA_LOCATION;
    public final static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public final static String ACCEPT_HANDOVER = Manifest.permission.ACCEPT_HANDOVER;
    public final static String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public final static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public final static String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public final static String ANSWER_PHONE_CALLS = Manifest.permission.ANSWER_PHONE_CALLS;
    public final static String USE_SIP = Manifest.permission.USE_SIP;
    public final static String READ_PHONE_NUMBERS = Manifest.permission.READ_PHONE_NUMBERS;
    public final static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public final static String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public final static String UWB_RANGING = Manifest.permission.UWB_RANGING;
    public final static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public final static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public final static String BLUETOOTH_ADVERTISE = Manifest.permission.BLUETOOTH_ADVERTISE;
    public final static String BLUETOOTH_CONNECT = Manifest.permission.BLUETOOTH_CONNECT;
    public final static String BLUETOOTH_SCAN = Manifest.permission.BLUETOOTH_SCAN;
    public final static String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    public final static String READ_SMS = Manifest.permission.READ_SMS;
    public final static String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    public final static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public final static String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public final static String SEND_SMS = Manifest.permission.SEND_SMS;
    public final static String ACTIVITY_RECOGNITION = Manifest.permission.ACTIVITY_RECOGNITION;
    public final static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    // NULL public final static String NEARBY_WIFI_DEVICES = Manifest.permission.NEARBY_WIFI_DEVICES;
    // NULL public final static String POST_NOTIFICATIONS = Manifest.permission.POST_NOTIFICATIONS;
    // NULL public final static String READ_MEDIA_AUDIO = Manifest.permission.READ_MEDIA_AUDIO;
    // NULL public final static String READ_MEDIA_IMAGES = Manifest.permission.READ_MEDIA_IMAGES;
    // NULL public final static String READ_MEDIA_VIDEO = Manifest.permission.READ_MEDIA_VIDEO;
    // NULL public final static String BODY_SENSORS_BACKGROUND = Manifest.permission.BODY_SENSORS_BACKGROUND;

    /**
     * 请求权限数组
     */
    private final static String[] requestPermissions = {
            READ_CALENDAR, WRITE_CALENDAR, CAMERA, WRITE_CONTACTS,
            READ_CONTACTS, GET_ACCOUNTS, ACCESS_BACKGROUND_LOCATION, ACCESS_COARSE_LOCATION,
            ACCESS_FINE_LOCATION, ACCESS_MEDIA_LOCATION, RECORD_AUDIO, ACCEPT_HANDOVER,
            CALL_PHONE, READ_CALL_LOG, WRITE_CALL_LOG, ANSWER_PHONE_CALLS,
            USE_SIP, READ_PHONE_NUMBERS, READ_PHONE_STATE, ADD_VOICEMAIL,
            UWB_RANGING, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, BLUETOOTH_ADVERTISE,
            BLUETOOTH_CONNECT, BLUETOOTH_SCAN, BODY_SENSORS, READ_SMS,
            RECEIVE_MMS, RECEIVE_SMS, RECEIVE_WAP_PUSH, SEND_SMS,
            ACTIVITY_RECOGNITION, PROCESS_OUTGOING_CALLS
    };

    /**
     * single - 动态申请权限
     *
     * @param mContext        上下文
     * @param requestCode     请求权限编码
     * @param permissionGrant 请求接口回调
     */
    public static void requestPermission(Context mContext, int requestCode, PermissionGrant permissionGrant) {
        if (mContext == null) {
            return;
        }
        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            Logs.e("Please exclude the wrong request code");
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        String requestPermission = requestPermissions[requestCode];
        int checkSelfPermission;
        try {
            checkSelfPermission = ActivityCompat.checkSelfPermission(mContext, requestPermission);
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
            Logs.w("Please open the permission");
            ActivityCompat.requestPermissions((Activity) mContext, new String[]{requestPermission}, requestCode);
        } else {
            permissionGrant.onPermissionGranted(requestCode);
            Logs.i("The permission is granted");
        }
    }

    /**
     * multiple - 动态申请权限
     * @param mContext      上下文
     * @param requestPermissionsGroup       申请权限码集合
     * @param permissionGrant       申请接口回调
     */
    public static void requestPermissions(Context mContext,int[] requestPermissionsGroup,PermissionGrant permissionGrant){
        ArrayList<String> permissionsGroup = new ArrayList<>();
        for (int i:requestPermissionsGroup){
            permissionsGroup.add(requestPermissions[i]);
        }
        ArrayList<String> noPermissionGrantedList = getNoPermissionGrantedList(mContext, permissionsGroup);
        if (noPermissionGrantedList == null){
            return;
        }
        if (noPermissionGrantedList.size()>0){
            ActivityCompat.requestPermissions((Activity) mContext,
                    noPermissionGrantedList.toArray(new String[noPermissionGrantedList.size()]),
                    CODE_MULTI_PERMISSION);
        }else {
            permissionGrant.onPermissionGranted(CODE_MULTI_PERMISSION);
        }
    }

    /**
     * 获取没有得到权限的列表
     * @param permissionsGroup  申请的权限列表
     */
    private static ArrayList<String> getNoPermissionGrantedList(Context mContext,ArrayList<String> permissionsGroup) {
        ArrayList<String> permissions = new ArrayList<>();
        for (int i = 0; i < permissionsGroup.size(); i++) {
            String requestPermission = permissionsGroup.get(i);
            int checkSelfPermission = -1;
            try{
                checkSelfPermission = ActivityCompat.checkSelfPermission(mContext,requestPermission);
            }catch (Exception exception){
                exception.printStackTrace();
                return null;
            }
            if(checkSelfPermission!=PackageManager.PERMISSION_GRANTED){
                permissions.add(requestPermission);
            }
        }
        return permissions;
    }

    /**
     * single - 申请结果
     *
     * @param mContext        上下文
     * @param requestCode     请求权限编码
     * @param permissions     请求权限
     * @param grantResults    请求结果
     * @param permissionGrant 请求接口回调
     */
    public static void requestPermissionResult(Context mContext, int requestCode,
                                               @NonNull String[] permissions, @NonNull int[] grantResults,
                                               PermissionGrant permissionGrant) {
        if (mContext == null) {
            return;
        }
        if (requestCode < 0 || requestCode >= requestPermissions.length) {
            Logs.e("Please exclude the wrong request code");
            return;
        }
        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionGrant.onPermissionGranted(requestCode);
        } else {
            String permissionError = requestPermissions[requestCode];
            Logs.w("The permission :" + permissionError + " is not granted");
            openSettingActivity((Activity) mContext);
        }
    }

    /**
     * multiple - 申请结果
     *
     * @param mContext        上下文
     * @param permissions     权限数组
     * @param grantResults    请求结果
     * @param permissionGrant 请求接口回调
     */
    public static void requestPermissionsResult(Context mContext, @NonNull String[] permissions, @NonNull int[] grantResults,
                                                PermissionGrant permissionGrant) {
        if (mContext == null) {
            return;
        }
        Map<String, Integer> multiplePermissions = new HashMap<>();
        ArrayList<String> notGranted = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            multiplePermissions.put(permissions[i], grantResults[i]);
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                notGranted.add(permissions[i]);
            }
        }
        Logs.d(""+notGranted.size());
        if (notGranted.size() == 0) {
            permissionGrant.onPermissionGranted(CODE_MULTI_PERMISSION);
        } else {
//            openSettingActivity((Activity) mContext);
        }
    }

    /**
     * 打开设置页面
     *
     * @param mContext 上下文
     */
    private static void openSettingActivity(Context mContext) {
        showMessageOKCancel(mContext, (dialog, which) -> {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
            intent.setData(uri);
            mContext.startActivity(intent);
        });
    }

    /**
     * 弹出Dialog
     *
     * @param mContext   上下文
     * @param okListener 确定接口回调
     */
    private static void showMessageOKCancel(Context mContext, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(mContext)
                .setMessage("请打开权限!")
                .setPositiveButton("OKay", okListener)
                .setNegativeButton("Cancel", null)
                .create().show();
    }

    /**
     * 表示授权成功的接口
     */
    public interface PermissionGrant {
        void onPermissionGranted(int requestCode);
    }


}
