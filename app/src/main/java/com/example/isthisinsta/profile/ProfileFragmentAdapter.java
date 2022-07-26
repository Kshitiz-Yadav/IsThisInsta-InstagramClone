package com.example.isthisinsta.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileFragmentAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> fNumFromFragment = new HashMap<>();
    private final HashMap<String, Integer> fNumFromName = new HashMap<>();
    private final HashMap<Integer, String> fNameFromNum = new HashMap<>();

    public ProfileFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String fragmentName){
        fragmentList.add(fragment);
        fNumFromFragment.put(fragment, fragmentList.size() - 1);
        fNumFromName.put(fragmentName, fragmentList.size() - 1);
        fNameFromNum.put(fragmentList.size() - 1, fragmentName);
    }

    public Integer getFragmentNum(String fName){
        if(fNumFromName.containsKey(fName)){
            return fNumFromName.get(fName);
        }
        else{
            return null;
        }
    }

    public Integer getFragmentNum(Fragment f){
        if(fNumFromFragment.containsKey(f)){
            return fNumFromFragment.get(f);
        }
        else{
            return null;
        }
    }

    public String getFragmentName(Integer fNum){
        if(fNameFromNum.containsKey(fNum)){
            return fNameFromNum.get(fNum);
        }
        else{
            return null;
        }
    }
}
