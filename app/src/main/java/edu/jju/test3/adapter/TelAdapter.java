package edu.jju.test3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import edu.jju.test3.R;
import edu.jju.test3.util.Telutil;

public class TelAdapter extends BaseExpandableListAdapter {
    private Context oContext;
    private LayoutInflater oInflater;

    public TelAdapter(Context oContext) {
        this.oContext = oContext;
        oInflater = LayoutInflater.from(oContext);
    }

    public Object getChild(int groupPosition, int childPosition) {

        return Telutil.child_name[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean arg2, View view,
                             ViewGroup arg4) {
        child_ViewHoulder oHoulder = null;
        if (view == null) {
            view = oInflater.inflate(R.layout.tel_child_layout, null);
            oHoulder = new child_ViewHoulder();
            oHoulder.child_name = (TextView) view.findViewById(R.id.child_name);
            oHoulder.child_tel = (TextView) view.findViewById(R.id.child_tel);
            view.setTag(oHoulder);
        } else {
            oHoulder = (child_ViewHoulder) view.getTag();
        }
        oHoulder.child_name.setText(Telutil.child_name[groupPosition][childPosition]);
        oHoulder.child_tel.setText(Telutil.child_tel[groupPosition][childPosition]);
        return view;
    }

    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return Telutil.child_name[groupPosition].length;
    }

    public Object getGroup(int groupPosition) {
        return Telutil.group_name[groupPosition];
    }

    public int getGroupCount() {
        return Telutil.group_name.length;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup arg3) {
        Group_ViewHoudler oHoudler = null;
        if (view == null) {
            oHoudler = new Group_ViewHoudler();
            view = oInflater.inflate(R.layout.tel_group_layout, null);
            oHoudler.group_name = (TextView) view.findViewById(R.id.group_tel);
            view.setTag(oHoudler);
        } else {
            oHoudler = (Group_ViewHoudler) view.getTag();

        }
        oHoudler.group_name.setText(Telutil.group_name[groupPosition]);

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return false;
    }

    class Group_ViewHoudler {
        TextView group_name;
    }

    class child_ViewHoulder {
        TextView child_name, child_tel;
    }

}
