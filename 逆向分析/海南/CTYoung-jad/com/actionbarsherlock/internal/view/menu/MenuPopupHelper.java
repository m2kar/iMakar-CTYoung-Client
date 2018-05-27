// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.*;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuPresenter, MenuBuilder, SubMenuBuilder, MenuItemImpl, 
//            MenuView, ListMenuItemView

public class MenuPopupHelper
    implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.PopupWindow.OnDismissListener, View_OnAttachStateChangeListener, MenuPresenter
{
    private class ExpandedIndexObserver extends DataSetObserver
    {

        public void onChanged()
        {
            mAdapter.findExpandedIndex();
        }

        final MenuPopupHelper this$0;

        private ExpandedIndexObserver()
        {
            this$0 = MenuPopupHelper.this;
            super();
        }

    }

    private class MenuAdapter extends BaseAdapter
    {

        void findExpandedIndex()
        {
            MenuItemImpl menuitemimpl = mMenu.getExpandedItem();
            if(menuitemimpl != null)
            {
                ArrayList arraylist = mMenu.getNonActionItems();
                int j = arraylist.size();
                for(int i = 0; i < j; i++)
                    if((MenuItemImpl)arraylist.get(i) == menuitemimpl)
                    {
                        mExpandedIndex = i;
                        return;
                    }

            }
            mExpandedIndex = -1;
        }

        public int getCount()
        {
            ArrayList arraylist;
            if(mOverflowOnly)
                arraylist = mAdapterMenu.getNonActionItems();
            else
                arraylist = mAdapterMenu.getVisibleItems();
            if(mExpandedIndex < 0)
                return arraylist.size();
            else
                return arraylist.size() - 1;
        }

        public MenuItemImpl getItem(int i)
        {
            int j;
            ArrayList arraylist;
            if(mOverflowOnly)
                arraylist = mAdapterMenu.getNonActionItems();
            else
                arraylist = mAdapterMenu.getVisibleItems();
            j = i;
            if(mExpandedIndex >= 0)
            {
                j = i;
                if(i >= mExpandedIndex)
                    j = i + 1;
            }
            return (MenuItemImpl)arraylist.get(j);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = view;
            if(view == null)
                view1 = mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, viewgroup, false);
            view = (MenuView.ItemView)view1;
            if(mForceShowIcon)
                ((ListMenuItemView)view1).setForceShowIcon(true);
            view.initialize(getItem(i), 0);
            return view1;
        }

        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex;
        final MenuPopupHelper this$0;


        public MenuAdapter(MenuBuilder menubuilder)
        {
            this$0 = MenuPopupHelper.this;
            super();
            mExpandedIndex = -1;
            mAdapterMenu = menubuilder;
            registerDataSetObserver(new ExpandedIndexObserver());
            findExpandedIndex();
        }
    }


    public MenuPopupHelper(Context context, MenuBuilder menubuilder)
    {
        this(context, menubuilder, null, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view)
    {
        this(context, menubuilder, view, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view, boolean flag)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = menubuilder;
        mOverflowOnly = flag;
        context = context.getResources();
        mPopupMaxWidth = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(com.actionbarsherlock.R.dimen.abs__config_prefDialogWidth));
        mAnchorView = view;
        menubuilder.addMenuPresenter(this);
    }

    private int measureContentWidth(ListAdapter listadapter)
    {
        int i = 0;
        View view = null;
        int k = 0;
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int l1 = listadapter.getCount();
        for(int j = 0; j < l1;)
        {
            int i1 = listadapter.getItemViewType(j);
            int l = k;
            if(i1 != k)
            {
                l = i1;
                view = null;
            }
            if(mMeasureParent == null)
                mMeasureParent = new FrameLayout(mContext);
            view = listadapter.getView(j, view, mMeasureParent);
            view.measure(j1, k1);
            i = Math.max(i, view.getMeasuredWidth());
            j++;
            k = l;
        }

        return i;
    }

    public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public void dismiss()
    {
        if(isShowing())
            mPopup.dismiss();
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
    }

    public boolean isShowing()
    {
        return mPopup != null && mPopup.isShowing();
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if(menubuilder == mMenu)
        {
            dismiss();
            if(mPresenterCallback != null)
            {
                mPresenterCallback.onCloseMenu(menubuilder, flag);
                return;
            }
        }
    }

    public void onDismiss()
    {
        mPopup = null;
        mMenu.close();
        if(mTreeObserver != null)
        {
            if(mTreeObserver.isAlive())
                mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        } else
        if(mAnchorView instanceof View_HasStateListenerSupport)
        {
            ((View_HasStateListenerSupport)mAnchorView).removeOnAttachStateChangeListener(this);
            return;
        }
    }

    public void onGlobalLayout()
    {
        if(isShowing())
        {
            View view = mAnchorView;
            if(view == null || !view.isShown())
                dismiss();
            else
            if(isShowing())
            {
                mPopup.show();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = mAdapter;
        ((MenuAdapter) (adapterview)).mAdapterMenu.performItemAction(adapterview.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if(keyevent.getAction() == 1 && i == 82)
        {
            dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if(!submenubuilder.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        boolean flag2;
        MenuPopupHelper menupopuphelper;
        menupopuphelper = new MenuPopupHelper(mContext, submenubuilder, mAnchorView, false);
        menupopuphelper.setCallback(mPresenterCallback);
        flag2 = false;
        j = submenubuilder.size();
        i = 0;
_L8:
        flag = flag2;
        if(i >= j) goto _L4; else goto _L3
_L3:
        MenuItem menuitem = submenubuilder.getItem(i);
        if(!menuitem.isVisible() || menuitem.getIcon() == null) goto _L6; else goto _L5
_L5:
        flag = true;
_L4:
        menupopuphelper.setForceShowIcon(flag);
        flag = flag1;
        if(menupopuphelper.tryShow())
        {
            if(mPresenterCallback != null)
                mPresenterCallback.onOpenSubMenu(submenubuilder);
            flag = true;
        }
_L2:
        return flag;
_L6:
        i++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void onViewAttachedToWindow(View view)
    {
        ((View_HasStateListenerSupport)view).removeOnAttachStateChangeListener(this);
        if(mPopup != null && mTreeObserver == null)
        {
            view = view.getViewTreeObserver();
            mTreeObserver = view;
            view.addOnGlobalLayoutListener(this);
        }
    }

    public void onViewDetachedFromWindow(View view)
    {
    }

    public void setAnchorView(View view)
    {
        mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback)
    {
        mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean flag)
    {
        mForceShowIcon = flag;
    }

    public void show()
    {
        if(!tryShow())
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        else
            return;
    }

    public boolean tryShow()
    {
        View view;
        mPopup = new IcsListPopupWindow(mContext, null, com.actionbarsherlock.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        view = mAnchorView;
        if(view == null) goto _L2; else goto _L1
_L1:
        if(view.getWindowToken() == null) goto _L4; else goto _L3
_L3:
        ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
        if(viewtreeobserver != mTreeObserver)
        {
            if(mTreeObserver != null && mTreeObserver.isAlive())
                mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = viewtreeobserver;
            if(viewtreeobserver != null)
                viewtreeobserver.addOnGlobalLayoutListener(this);
        }
_L5:
        mPopup.setAnchorView(view);
        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(2);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        return true;
_L4:
        if(view instanceof View_HasStateListenerSupport)
            ((View_HasStateListenerSupport)view).addOnAttachStateChangeListener(this);
        if(true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void updateMenuView(boolean flag)
    {
        if(mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

    static final int ITEM_LAYOUT;
    private MenuAdapter mAdapter;
    private View mAnchorView;
    private Context mContext;
    boolean mForceShowIcon;
    private LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private MenuBuilder mMenu;
    private boolean mOverflowOnly;
    private IcsListPopupWindow mPopup;
    private int mPopupMaxWidth;
    private MenuPresenter.Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    static 
    {
        ITEM_LAYOUT = com.actionbarsherlock.R.layout.abs__popup_menu_item_layout;
    }




}
