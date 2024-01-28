package com.example.expandablelistviewnew.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistviewnew.databinding.GroupItemBinding
import com.example.expandablelistviewnew.databinding.ItemChildBinding
import com.example.expandablelistviewnew.models.Fruits

class ExpandAdapter(val map:HashMap<String, ArrayList<Fruits>>, val titleList:ArrayList<String> )
    :BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        val group = titleList[p0]
        val childList = map[group]
        return childList?.size!!
    }

    override fun getGroup(p0: Int): Any {
        val group = titleList[p0]
        return group
    }

    override fun getChild(p0: Int, p1: Int): Any {
        val group = titleList[p0]
        val childList = map[group]
        return childList?.get(p1)!!
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val itemBinding = GroupItemBinding.inflate(LayoutInflater.from(p3?.context), p3,false)
        itemBinding.itemGroup.text = titleList[p0]
        return itemBinding.root
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val itemChildBinding = ItemChildBinding.inflate(LayoutInflater.from(p4?.context), p4, false)
        val group = titleList[p0]
        val childList = map[group]
        itemChildBinding.txtItemChild.text = childList?.get(p1)?.name
        itemChildBinding.image.setImageResource(childList?.get(p1)?.image!!)

        return itemChildBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}