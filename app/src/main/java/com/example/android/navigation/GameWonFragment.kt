
package com.example.android.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding
import java.util.stream.DoubleStream.builder


class GameWonFragment : Fragment() {
    private lateinit var builder:AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )
        builder=AlertDialog.Builder(requireContext())

        binding.nextMatchButton.setOnClickListener {
        builder.setTitle("Wait !!")
            .setMessage("You want share Your Success??")
            .setCancelable(true)
            .setPositiveButton("Yes"){dailog,it ->
                shareSucess()
            }
            .setNegativeButton("No"){dailog,it ->
                view?.findNavController()?.navigate(R.id.action_gameWonFragment_to_titleFragment)
            }
            .setNeutralButton("Help"){dailog,it->
                view?.findNavController()?.navigate(R.id.aboutFragment)
            }
            .show()

        //
        }
        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(
            context,
            "NumQuestion ${args.numQuestion} and QuestionCorrect ${args.questionNumber}",
            Toast.LENGTH_SHORT
        ).show()
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)

    }


    private fun getshareIntent(): Intent {
        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text,args.numQuestion,args.questionNumber))
        return shareIntent
    }
    private fun shareSucess(){
        startActivity(getshareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            R.id.share -> shareSucess()
        }
        return super.onOptionsItemSelected(item)
    }
}