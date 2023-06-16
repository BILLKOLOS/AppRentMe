public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefresh;
    TextView tvNumber;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefresh = findViewById(R.id.swipeRefresh);
        tvNumber = findViewById(R.id.number);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                number++;
                tvNumber.setText(String.valueOf(number));
                swipeRefresh.setRefreshing(false);
            }
        });
    }

}
