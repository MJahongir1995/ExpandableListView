package com.example.expandablelistviewnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.expandablelistviewnew.adapters.ExpandAdapter
import com.example.expandablelistviewnew.databinding.ActivityMainBinding
import com.example.expandablelistviewnew.models.Fruits

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var map:HashMap<String, ArrayList<Fruits>>
    lateinit var titleList:ArrayList<String>
    lateinit var expandAdapter: ExpandAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()
        expandAdapter = ExpandAdapter(map,titleList)
        binding.expandView.setAdapter(expandAdapter)

        binding.expandView.setOnGroupClickListener(object :ExpandableListView.OnGroupClickListener{
            override fun onGroupClick(
                p0: ExpandableListView?,
                p1: View?,
                p2: Int,
                p3: Long
            ): Boolean {
                Toast.makeText(this@MainActivity, titleList[p2], Toast.LENGTH_SHORT).show()
                return false
            }
        })

        binding.expandView.setOnChildClickListener(object :ExpandableListView.OnChildClickListener{
            override fun onChildClick(
                p0: ExpandableListView?,
                p1: View?,
                p2: Int,
                p3: Int,
                p4: Long
            ): Boolean {
                Toast.makeText(this@MainActivity, map[titleList[p2]]?.get(p3)?.name, Toast.LENGTH_SHORT).show()
            return false
            }
        })
    }

    private fun loadData() {
        map = HashMap()
        titleList = ArrayList()

        titleList.add("Real Madrid")
        var realList = arrayListOf(Fruits("Apple", R.drawable.apple), Fruits("Mango", R.drawable.mango),
            Fruits("Banana", R.drawable.banana),Fruits("Peach",R.drawable.peach))

        titleList.add("Barcelona")
        var barcaList = arrayListOf(Fruits("Neymar",R.drawable.peach), Fruits("Messi", R.drawable.banana),
            Fruits ("Havi", R.drawable.mango),Fruits("Inesta", R.drawable.apple))

        map[titleList[0]] = realList
        map[titleList[1]] = barcaList
    }
}