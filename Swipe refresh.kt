class MainActivity : AppCompatActivity() {

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var tvNumber: TextView
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefresh = findViewById(R.id.swipeRefresh)
        tvNumber = findViewById(R.id.number)

        swipeRefresh.setOnRefreshListener {
            number++
            tvNumber.text = number.toString()
            swipeRefresh.setRefreshing(false)
        }
    }
}
