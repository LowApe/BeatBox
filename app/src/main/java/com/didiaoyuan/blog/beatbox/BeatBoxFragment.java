package com.didiaoyuan.blog.beatbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
/*onCreateView 加载 fragment 的布局*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_beat_box,container,false);
        RecyclerView recyclerView=view.findViewById(R.id
                .fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new SoundAdapter());
        return view;
    }
    /*ViewHolder 内部类*/
    private class SoundHolder extends RecyclerView.ViewHolder{
        private Button mButton;

        public SoundHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound,container,false));
            mButton=itemView.findViewById(R.id.list_item_sound_button);
        }
    }
    /*Adapter 内部类*/
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            return new SoundHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
