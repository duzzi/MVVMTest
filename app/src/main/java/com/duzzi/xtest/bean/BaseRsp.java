package com.duzzi.xtest.bean;

import java.util.List;

/**
 * 文件名: BaseRsp
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class BaseRsp<T> {

    /**
     * data : [{"desc":"享学~","id":29,"imagePath":"https://wanandroid.com/blogimgs/6723ca73-bbc2-4b2a-9538-4c36df6edf56.png","isVisible":1,"order":0,"title":"可能是目前最全的《Android面试题及解析》（379页）","type":0,"url":"https://mp.weixin.qq.com/s/XHdGR4ESrO3u84QLuoh4-w"},{"desc":"","id":6,"imagePath":"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png","isVisible":1,"order":1,"title":"我们新增了一个常用导航Tab~","type":1,"url":"https://www.wanandroid.com/navi"},{"desc":"一起来做个App吧","id":10,"imagePath":"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png","isVisible":1,"order":1,"title":"一起来做个App吧","type":1,"url":"https://www.wanandroid.com/blog/show/2"},{"desc":"","id":20,"imagePath":"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png","isVisible":1,"order":2,"title":"flutter 中文社区 ","type":1,"url":"https://flutter.cn/"}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
