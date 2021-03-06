package com.kunminx.linkage.defaults;
/*
 * Copyright (c) 2018-2019. KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context;
import android.widget.TextView;

import com.kunminx.linkage.R;
import com.kunminx.linkage.adapter.viewholder.LevelSecondaryHeaderViewHolder;
import com.kunminx.linkage.adapter.viewholder.LevelSecondaryViewHolder;
import com.kunminx.linkage.bean.BaseGroupedItem;
import com.kunminx.linkage.bean.DefaultGroupedItem;
import com.kunminx.linkage.contract.ILevelSecondaryAdapterConfig;

/**
 * Create by KunMinX at 19/5/8
 */
public class DefaultLevelSecondaryAdapterConfig implements ILevelSecondaryAdapterConfig<DefaultGroupedItem.ItemInfo> {

    private Context mContext;
    private OnSecondaryItemBindListener mItemBindListener;
    private OnSecondaryHeaderBindListener mHeaderBindListener;
    private static final int SPAN_COUNT = 3;

    public void setItemBindListener(OnSecondaryItemBindListener itemBindListener, OnSecondaryHeaderBindListener headerBindListener) {
        mItemBindListener = itemBindListener;
        mHeaderBindListener = headerBindListener;
    }

    @Override
    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public int getGridLayoutId() {
        return R.layout.default_adapter_linkage_level_secondary_grid;
    }

    @Override
    public int getLinearLayoutId() {
        return R.layout.default_adapter_linkage_level_secondary_linear;
    }

    @Override
    public int getHeaderLayoutId() {
        return R.layout.default_adapter_linkage_level_secondary_header;
    }

    @Override
    public int getSpanCountOfGridMode() {
        return SPAN_COUNT;
    }

    @Override
    public void onBindViewHolder(LevelSecondaryViewHolder holder,
                                 BaseGroupedItem<DefaultGroupedItem.ItemInfo> item, int position) {

        ((TextView) holder.getView(R.id.level_2_title)).setText(item.info.getTitle());
        ((TextView) holder.getView(R.id.level_2_content)).setText(item.info.getContent());

        if (mItemBindListener != null) {
            mItemBindListener.onBindViewHolder(holder, item, position);
        }
    }

    @Override
    public void onBindHeaderViewHolder(LevelSecondaryHeaderViewHolder holder,
                                       BaseGroupedItem<DefaultGroupedItem.ItemInfo> item, int position) {

        ((TextView) holder.getView(R.id.level_2_header)).setText(item.header);

        if (mHeaderBindListener != null) {
            mHeaderBindListener.onBindHeaderViewHolder(holder, item, position);
        }
    }

    public interface OnSecondaryItemBindListener {
        void onBindViewHolder(LevelSecondaryViewHolder secondaryHolder,
                              BaseGroupedItem<DefaultGroupedItem.ItemInfo> item, int position);
    }

    public interface OnSecondaryHeaderBindListener {
        void onBindHeaderViewHolder(LevelSecondaryHeaderViewHolder headerHolder,
                                    BaseGroupedItem<DefaultGroupedItem.ItemInfo> item, int position);
    }
}
