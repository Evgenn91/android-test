package dsk.altlombard.test.fragments.entering;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.textfield.TextInputLayout;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentSmsCodeEnteringBinding;
import dsk.altlombard.test.databinding.FragmentWaitingMainBinding;
import dsk.altlombard.test.fragments.WaitingMainFragment;

public class SmsCodeEnteringFragment extends Fragment {

    private FragmentSmsCodeEnteringBinding binding;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSmsCodeEnteringBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewGroup viewGroup = view.findViewById(R.id.layout_for_button_delete);//сюда мы встявляем кнопку "повторное отправление кода"
        TextInputLayout enteredSmsCode = view.findViewById(R.id.enter_smscode);
        TextView textWithCounter = view.findViewById(R.id.smscode_repead_text_timer);

        SharedPreferences registrationEntity = this.getActivity().getSharedPreferences("registration", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = registrationEntity.edit();

        //TODO запуск счетчика должен быть поидее только тогда, когда мы первый раз заходим на этот фрагмент
        //запускаем счетчик по завершении которого генерируем кнопку 'отправки смс повторно'
        startCounterDown(textWithCounter, viewGroup, registrationEntity);

        binding.buttonSmscodeEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedSmsCode = registrationEntity.getString("smsCode","");
                if(!savedSmsCode.equals("") && savedSmsCode.equals(enteredSmsCode.getEditText().getText().toString())){
                    myEdit.remove("smsCode");
                    myEdit.remove("contractNumber");

                    Bundle bundle = new Bundle();
                    bundle.putBoolean("newPinCode", true);
                    NavHostFragment.findNavController(SmsCodeEnteringFragment.this).navigate(R.id.action_smsCodeEnteringFragment_to_codeEnteringFragment, bundle);
                }
                //TODO УДАЛИТЬ!!!
                Bundle bundle = new Bundle();
                bundle.putBoolean("newPinCode", true);
                NavHostFragment.findNavController(SmsCodeEnteringFragment.this).navigate(R.id.action_smsCodeEnteringFragment_to_codeEnteringFragment, bundle);
            }
        });
    }

    private void startCounterDown(TextView textWithCounter, ViewGroup viewGroup, SharedPreferences registrationEntity){
        SharedPreferences.Editor myEdit = registrationEntity.edit();

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                String sec = "Запросить новый код можно через " + millisUntilFinished / 1000 + " сек.";
                textWithCounter.setText(sec);
            }

            public void onFinish() {
                if(getActivity() != null){
                    //создание кнопки
                    TextView deleteButton = new TextView(getActivity());
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = 20;
                    deleteButton.setLayoutParams(params);
                    deleteButton.setText("Отправить");
                    deleteButton.setTextColor(Color.RED);
                    deleteButton.setPadding(20,20,20,20);
                    viewGroup.addView(deleteButton);
                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startCounterDown(textWithCounter, viewGroup, registrationEntity);
                            myEdit.remove("smsCode");

                            String contractNumber = registrationEntity.getString("contractNumber","");
                            String smsCode = "";
                            String globalGUID = "";

                            //TODO запрос на сервер
                            //ЗАПРОС НА СЕРВЕР с contractNumber
                            //smsCode = результат с сервера;
                            //globalGUID = результат с сервера;

                            myEdit.putString("smsCode",smsCode);
                            myEdit.putString("globalGUID",globalGUID);
                            myEdit.commit();
                            viewGroup.removeView(deleteButton);
                        }
                    });
                }
            }
        }.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}