package com.example.module_cart;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.export_cart.CartInfo;
import com.example.export_cart.CartRouterTable;
import com.example.export_cart.ICartService;

/**
 * 购物车组件服务的实现
 * 需要@Route注解、指定CartRouterTable中定义的服务路由
 *
 * @author hufeiyang
 */
@Route(path = CartRouterTable.PATH_SERVICE_CART)
public class CartServiceImpl implements ICartService {

    @Override
    public CartInfo getProductCountInCart() {
        //这里实际项目中 应该是 请求接口 或查询数据库
        CartInfo cartInfo = new CartInfo();
        cartInfo.productCount = 888;
        return cartInfo;
    }

    @Override
    public Fragment getProductFragment() {
        return new MyFragment_01();
    }


    @Override
    public void init(Context context) {
        Log.e("context", context.toString());
    }
}

