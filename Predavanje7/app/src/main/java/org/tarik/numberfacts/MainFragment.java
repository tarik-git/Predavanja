package org.tarik.numberfacts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.tarik.numberfacts.databinding.FragmentMainBinding;
import org.tarik.numberfacts.retrofit.MainResponse;
import org.tarik.numberfacts.retrofit.NumbersRetrofit;
import org.tarik.numberfacts.retrofit.NumbersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private static final String BUNDLE_TYPE = "BUNDLE_TYPE";
    public static final String TYPE_TRIVIA = "trivia";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_YEAR = "year";
    public static final String TYPE_MATH = "math";
    private static final String BUNDLE_ANSWER = "BUNDLE_ANSWER";
    private static final String TAG = "MainFragment";

    private String type;
    private NumbersService numbersService;
    private final Callback<MainResponse> callback = new Callback<MainResponse>() {
        @Override
        public void onResponse(@NonNull Call<MainResponse> call, Response<MainResponse> response) {
            if (response.isSuccessful()) {
                MainResponse mainResponse = response.body();
                if (mainResponse != null) {
                    binding.answerTextView.setText(mainResponse.text);
                }
            }
        }

        @Override
        public void onFailure(@NonNull Call<MainResponse> call, @NonNull Throwable t) {
        }
    };

    public static MainFragment getInstance(String type) {
        MainFragment fragment = new MainFragment();

        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            type = arguments.getString(BUNDLE_TYPE);
        }

        numbersService = NumbersRetrofit.getRetrofitInstance().create(NumbersService.class);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            String answer = savedInstanceState.getString(BUNDLE_ANSWER, "");
            if (answer != null && !answer.isEmpty()) {
                binding.answerTextView.setText(answer);
            }
        }

        if (type != null) {
            if (type.equals(TYPE_TRIVIA)) {
                setupFragmentType(
                        getString(R.string.trivia_question_label),
                        v -> onAskTriviaQuestionClick()
                );
            } else if (type.equals(TYPE_DATE)) {
                setupFragmentType(
                        getString(R.string.date_question_label),
                        v -> onAskDateQuestionClick()
                );
            } else if (type.equals(TYPE_MATH)) {
                setupFragmentType(
                        getString(R.string.math_question_label),
                        v -> onAskMathQuestionClick()
                );
            } else if (type.equals(TYPE_YEAR)) {
                setupFragmentType(
                        getString(R.string.year_question_label),
                        v -> onAskYearQuestionClick()
                );
            }

        }

    }

    private void setupFragmentType(String label, View.OnClickListener listener) {
        binding.titleTextView.setText(label);
        binding.askQuestionButton.setOnClickListener(listener);
    }

    private void onAskTriviaQuestionClick() {
        String numberText = binding.numberEditText.getText().toString();
        if (numberText.isEmpty()) {
            numbersService.getTriviaAnswer("random").enqueue(callback);
        } else {
            numbersService.getTriviaAnswer(numberText).enqueue(callback);
        }
    }

    private void onAskDateQuestionClick() {
        String numberText = binding.numberEditText.getText().toString();
        if (numberText.isEmpty()) {
            numbersService.getDateAnswer("random").enqueue(callback);
        } else {
            numbersService.getDateAnswer(numberText).enqueue(callback);
        }
    }

    private void onAskYearQuestionClick() {
        String numberText = binding.numberEditText.getText().toString();
        if (numberText.isEmpty()) {
            numbersService.getYearAnswer("random").enqueue(callback);
        } else {
            numbersService.getYearAnswer(numberText).enqueue(callback);
        }
    }

    private void onAskMathQuestionClick() {
        String numberText = binding.numberEditText.getText().toString();
        if (numberText.isEmpty()) {
            numbersService.getMathAnswer("random").enqueue(callback);
        } else {
            numbersService.getMathAnswer(numberText).enqueue(callback);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
        String answerText = binding.answerTextView.toString();
        outState.putString(BUNDLE_ANSWER, answerText);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
