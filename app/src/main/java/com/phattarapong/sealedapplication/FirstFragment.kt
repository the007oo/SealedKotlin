package com.phattarapong.sealedapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shopList : ArrayList<ShopModel> = arrayListOf()

        var topic = ShopModel.Topic("สินค้าลดราคา",ShopModel.ShopType.TYPE_TOPIC)
        shopList.add(topic)

        var item = ShopModel.Item("น้ำเปล่า","img",ShopModel.ShopType.TYPE_ITEM)

        Adapter().apply {
            recyclerView.adapter = this
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }.also {
            val dataList : MutableList<Model> = mutableListOf()

            var header = Model.Header(Model.ModelType.TYPE_HEADER,"Header1")
            dataList.add(header)
            var body = Model.Body(Model.ModelType.TYPE_BODY,"body1")
            dataList.add(body)
            var footer = Model.Footer(Model.ModelType.TYPE_FOOTER,"footer1")
            dataList.add(footer)

            it.dataList = dataList
            it.notifyDataSetChanged()
        }

        mutableListOf<String>("a", "b")
        arrayListOf<String>("a", "b")
        /*view.findViewById<Button>(R.id.button_first).setOnClickListener {
             findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
         }*/
    }
}