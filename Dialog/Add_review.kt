class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btnShowDialog).setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.item_dialog_703)
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        val et_post = dialog.findViewById<EditText>(R.id.et_post)
        val rating_bar = dialog.findViewById<RatingBar>(R.id.rating_bar)
        dialog.findViewById<View>(R.id.bt_cancel)
            .setOnClickListener { v: View? -> dialog.dismiss() }
        dialog.findViewById<View>(R.id.bt_submit).setOnClickListener { v: View? ->
            val review = et_post.text.toString().trim { it <= ' ' }
            if (review.isEmpty()) {
                Toast.makeText(this, "Please fill review text", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Submitted with" + rating_bar.rating + " ratings", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        dialog.show()
        dialog.window!!.attributes = lp
    }
}
