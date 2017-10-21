package com.didiaoyuan.blog.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private static final int MAX_SOUNDS = 5;
    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    /*构造方法*/
    public BeatBox(Context context) {
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames = null;
        try {
//            列出那个文件夹下的资源文件
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG, soundNames + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String filename : soundNames) {
            try {

                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssetManager.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) {
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }
}
