package com.didiaoyuan.blog.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Qu on 2017/10/19.
 * 资源管理类
 * 1变量：用于日志记录
 * 2变量：用于存储声音资源文件目录名
 */

public class BeatBox {
    /*变量初始化*/
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();

    /*构造方法*/
    public BeatBox(Context context) {
        mAssetManager = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames=null;
        try {
//            列出那个文件夹下的资源文件
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG,soundNames+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" +filename;
            Sound sound=new Sound(assetPath);
            mSounds.add(sound);
        }
    }
    public List<Sound> getSounds(){
        return mSounds;
    }
}
