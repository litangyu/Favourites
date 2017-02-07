package com.acg233.favorites.network;

import com.acg233.favorites.bean.BadQQRequest;
import com.acg233.favorites.bean.BaseRequest;
import com.acg233.favorites.bean.LoginRequest;
import com.acg233.favorites.bean.UserResponse;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Describe
 * <p>Version: v1.0</p>
 * <p>Created by: lty</p>
 * <p>Created on: 2017/1/22 上午11:24</p>
 * <p>Email: lty81372860@sina.com</p>
 * <p>Copyright © 2017年 lty. All rights reserved.</p>
 * <p>Revision：</p>
 */

public interface FavoritesService {
    @GET("time")
    Observable<Long> getTime();

    @GET("date")
    Observable<String> getDate();

    @POST("permission")
    Observable<Object> postToken();

    @POST("version")
    Observable<Integer> checkVersion(@Body BaseRequest request);

    @GET("download")
    @Streaming  //@Streaming作用为在下载大文件中使用。添加了该注解后，下载文件不会将所有的下载内容加载到内存
    Observable<ResponseBody> download(@Url String url);

    @POST("login")
    Observable<UserResponse> login(@Body LoginRequest loginRequest);

    @POST("badqq")
    Observable<Object> postBadQQ(@Body BadQQRequest badQQRequest);
}