package com.didiaoyuan.blog.beatbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by Mr.Qu on 2017/10/18.
 */

public class BeatBoxFragment extends Fragment {
    /*变量定义*/
    private BeatBox mBeatBox;


    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }
/*onCreate 方法初始化控件*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox=new BeatBox(getActivity());

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }
/*onCreateView 加载 fragment 的布局*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_beat_box,container,false);
        RecyclerView recyclerView=view.findViewById(R.id
                .fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));
        return view;
    }
    /*ViewHolder 内部类*/
    private class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Button mButton;
        private Sound mSound;
        public SoundHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound,container,false));
            mButton=itemView.findViewById(R.id.list_item_sound_button);
            mButton.setOnClickListener(this);
        }

        /*绑定声音方法*/
        public void bindSound(Sound sound){
            mSound=sound;
            mButton.setText(mSound.getName());
            Log.e("sample_sounds", "times1 ID:"+mSound.getSoundId());
        }

        @Override
        public void onClick(View view) {
            Log.e("sample_sounds", "times2 ID:"+mSound.getSoundId());
            mBeatBox.play(mSound);
        }
    }

    /*Adapter 内部类*/
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
        private List<Sound> mSounds;
        public SoundAdapter(List<Sound> sounds){
            mSounds=sounds;
        }
        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            return new SoundHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
            Sound sound=mSounds.get(position);

            holder.bindSound(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }


}
