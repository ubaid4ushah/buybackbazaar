package com.member.buybackbazaar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.member.buybackbazaar.utils.LocaleUtils;


public class SplashActivity extends BaseActivity {

    private ImageView imgLogo, ivDummy;
    private ProgressBar progressBar;
    private View viewLayer;
    private Button btnRetry;
    private boolean isAnimOver, isDoingAnim;



    private void startAnim() {
        isDoingAnim = true;
        int height = imgLogo.getMeasuredHeight() + 50;

        try {
            ObjectAnimator anim1 = ObjectAnimator.ofFloat(viewLayer, "translationY", -height);
            anim1.setDuration(750);

            ValueAnimator anim2 = ValueAnimator.ofInt(height);
            anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = viewLayer.getLayoutParams();
                    layoutParams.height = val;
                    viewLayer.setLayoutParams(layoutParams);
                }
            });

            anim2.setDuration(750);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(200);
            animatorSet.playSequentially(anim1, anim2);

            viewLayer.setVisibility(View.VISIBLE);
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    hideLayer();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animatorSet.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        LocaleUtils.setLocale(this, LocaleUtils.ENGLISH);

        imgLogo = findViewById(R.id.imgLogo);
        ivDummy = findViewById(R.id.img_dummy);
        progressBar = findViewById(R.id.pb_loader);
        btnRetry = findViewById(R.id.btn_retry);
        viewLayer = findViewById(R.id.view_layer);
        startAnim();
    }

    private void hideLayer() {

        imgLogo.setVisibility(View.VISIBLE);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(viewLayer, "translationY", 0);
        anim1.setDuration(750);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(ivDummy, "alpha", 1f, 0f);
        anim2.setDuration(750);

        ValueAnimator anim3 = ValueAnimator.ofInt(viewLayer.getMeasuredHeight(), 0);



        anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = viewLayer.getLayoutParams();
                layoutParams.height = val;
                viewLayer.setLayoutParams(layoutParams);
            }
        });
        anim3.setDuration(750);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(anim1, anim2, anim3);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ObjectAnimator transition = ObjectAnimator.ofFloat(imgLogo, "translationY", -300);
                transition.setDuration(750);
                transition.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        isDoingAnim = false;
                        isAnimOver = true;

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                transition.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }


}