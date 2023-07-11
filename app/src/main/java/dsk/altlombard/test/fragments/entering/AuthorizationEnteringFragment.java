package dsk.altlombard.test.fragments.entering;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.MainActivity;
import dsk.altlombard.test.R;
import dsk.altlombard.test.SplashScreen;
import dsk.altlombard.test.databinding.FragmentAuthorizationEnteringBinding;
import dsk.altlombard.test.databinding.FragmentSmsCodeEnteringBinding;

public class AuthorizationEnteringFragment extends Fragment {

    private FragmentAuthorizationEnteringBinding binding;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAuthorizationEnteringBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSelectContractEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AuthorizationEnteringFragment.this).navigate(R.id.action_authorizationEnteringFragment_to_contractEnteringFragment);
            }
        });

        binding.buttonSelectLoginPasswordEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(AuthorizationEnteringFragment.this).navigate(R.id.??????);
            }
        });

        binding.buttonSelectQrcodeEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(AuthorizationEnteringFragment.this).navigate(R.id.?????????);
            }
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //настройка кнопки назад(выход из приложения)
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().moveTaskToBack(true);
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}