package com.didiaoyuan.blog.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Mr.Qu on 2017/10/19.
 * 资源管理类
 * 1变量：用于日志记录
 * 2变量：用于存储声音资源文件目录名
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager mAssetManager;
    public BeatBox(Context context){
        mAssetManager=context.getAssets();
    }
    private void loadSounds(){
        String[] soundNames;
        try {
//            列出那个文件夹下的资源文件
            soundNames=mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,"found"+soundNames.length+"sounds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
