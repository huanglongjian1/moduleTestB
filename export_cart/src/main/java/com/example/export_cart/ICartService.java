package com.example.export_cart;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface ICartService extends IProvider {
    CartInfo getProductCountInCart();
    Fragment getProductFragment();
}
