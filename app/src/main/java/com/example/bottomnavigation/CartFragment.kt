package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("dummy", "hoppingcart oncreate")

//        Log.d("dummy", view!!.findViewById<TextView>(R.id.textView5).text.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("dummy", "onstart ran")
        view!!.findViewById<TextView>(R.id.textView5).text =
            MainActivity.globalMessage.joinToString("\n")


//         CALCULATE TOTAL
//         Initialize total variable
//        var total = 0.0
//
//         Loop through the global messages array list
//        for (text in globalMessage) {
//             Strip $price from the text
//            val priceString = text.replace("$", "")
//
//             Convert the price to a double and add it to the total
//            val price = priceString.toDouble()
//            total += price
//        }
//         Display the total in the second textview in the shopping cart
//        secondTextView.text = "$" + total.toString()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("dummy", "inflate layout")
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}