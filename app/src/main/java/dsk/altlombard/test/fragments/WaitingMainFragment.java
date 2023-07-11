package dsk.altlombard.test.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentWaitingMainBinding;


public class WaitingMainFragment extends Fragment {

    private FragmentWaitingMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWaitingMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences registrationEntity = this.getActivity().getSharedPreferences("registration", Context.MODE_PRIVATE);//личное хранилище на телефоне для данного приложения
        String pinCode = registrationEntity.getString("pinCode", "");

        if(pinCode.equals(""))
            NavHostFragment.findNavController(WaitingMainFragment.this).navigate(R.id.action_waitingMainFragment_to_authorizationEnteringFragment);
        else{
            Bundle bundle = new Bundle();
            bundle.putBoolean("newPinCode", false);
            NavHostFragment.findNavController(WaitingMainFragment.this).navigate(R.id.action_waitingMainFragment_to_codeEnteringFragment, bundle);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}