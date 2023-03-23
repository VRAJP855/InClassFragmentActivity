/**
 * Please study this class, but do not modify it
 */

package edu.temple.inclassactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemSelectedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val IMAGES_KEY = "imageList"

class ImageDisplayFragment : Fragment() {

    private lateinit var images: IntArray

    private val MainViewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        SavedInstanceState: Bundle?
    ): View? {
        // The inflated layout file is returned to the parent/host and displayed to the user
        return inflater.inflate(R.layout.fragment_image_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // The recycler view is the root element of the Fragment's layout
        // as such the view argument passed to onViewCreated() is the RecyclerView
        with(view as RecyclerView) {

            MainViewModel.getImageIds().observe(requireActivity()) {
                adapter = CustomRecyclerAdapter(it) {
                    (requireActivity() as ItemSelectedInterface).itemSelected(it)
                }
                }
            }
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    interface ItemSelectedInterface {
        fun itemSelected(item: Int)
    }

}