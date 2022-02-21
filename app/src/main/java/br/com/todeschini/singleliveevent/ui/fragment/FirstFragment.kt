package br.com.todeschini.singleliveevent.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.todeschini.singleliveevent.R
import br.com.todeschini.singleliveevent.ui.viewmodel.SharedViewModel

class FirstFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FirstFragment","onCreateView called")

        verifyIfShouldNavigate()
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val requestButton = view.findViewById<Button>(R.id.btnRequest)
        requestButton.setOnClickListener {
            sharedViewModel.makeFakeRequest()
        }

        return view
    }

    private fun verifyIfShouldNavigate() {
        sharedViewModel.shouldNavigate.observe(this) {
            if (it) {
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                sharedViewModel.shouldNavigate.removeObservers(this)
            }
        }
    }
}