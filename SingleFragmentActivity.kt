
/**
 * This class contains the common behavior between
 * classes that only host one fragment.
 */
abstract class SingleFragmentActivity : AppCompatActivity(){

    abstract fun setupContentView()

    abstract fun getFrameContainerId(): Int

    abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupContentView()

        val refToFragment = supportFragmentManager.findFragmentById(getFrameContainerId())

        if(refToFragment == null){
            val fragmentToAdd = createFragment()

            supportFragmentManager
                    .beginTransaction()
                    .add(getFrameContainerId(), fragmentToAdd)
                    .commit()
        }
    }
}