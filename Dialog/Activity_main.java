public class CustomDialog3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog3);

        findViewById(R.id.showDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.content_custom_dialog_3);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        EditText et_post = dialog.findViewById(R.id.et_post);
        RatingBar rating_bar = dialog.findViewById(R.id.rating_bar);

        (dialog.findViewById(R.id.bt_cancel)).setOnClickListener(v -> dialog.dismiss());

        (dialog.findViewById(R.id.bt_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review = et_post.getText().toString().trim();
                if (review.isEmpty()) {
                    Toast.makeText(CustomDialog3.this, "Please fill review text", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CustomDialog3.this, "Submitted with" + rating_bar.getRating() + " ratings", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}
