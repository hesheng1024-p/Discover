package com.example.a14512.discover.modules.main.view.imp;

import com.example.a14512.discover.modules.main.modle.entity.ScenicCommentUser;

import java.util.ArrayList;

/**
 * @author 14512 on 2018/2/1
 */

public interface IScenicView {

    /**
     * @param users
     */
    void setAdapter(ArrayList<ScenicCommentUser> users);
}