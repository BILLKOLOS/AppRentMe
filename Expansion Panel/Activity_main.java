public class MainActivity extends AppCompatActivity {

    ImageButton bt_toggle_text;
    Button bt_hide_text;
    LinearLayout lyt_expand_text;
    NestedScrollView nested_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_toggle_text = findViewById(R.id.bt_toggle_text);
        bt_hide_text = findViewById(R.id.bt_hide_text);
        lyt_expand_text = findViewById(R.id.lyt_expand_text);
        nested_content = findViewById(R.id.nested_content);

        bt_toggle_text.setOnClickListener(view1 -> toggleSectionText(bt_toggle_text));
        bt_hide_text.setOnClickListener(view12 -> toggleSectionText(bt_toggle_text));

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, MainScreen.class));
            finish();
        }, 1000);
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

    private void toggleSectionText(View view) {
        boolean show = toggleArrow(view);
        if (show) {
            expand(lyt_expand_text, () -> nestedScrollTo(nested_content, lyt_expand_text));
        } else {
            collapse(lyt_expand_text);
        }
    }

    public interface AnimListener {
        void onFinish();
    }

    public static void expand(final View v, final ExpansionPanel1000.AnimListener animListener) {
        Animation a = expandAction(v);
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animListener.onFinish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(a);
    }

    private static Animation expandAction(final View v) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetedHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (targetedHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((int) (targetedHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
        return a;
    }

    public static void nestedScrollTo(final NestedScrollView nested, final View targetView) {
        nested.post(() -> nested.scrollTo(500, targetView.getBottom()));
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
