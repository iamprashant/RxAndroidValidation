package <package Name>


import butterknife.ButterKnife;
import butterknife.Bind;
import android.support.v7.app.AppCompatActivity;
import static android.text.TextUtils.isEmpty;

public class RxSingleTextViewValidation extends AppCompatActivity{
    @Bind(R.id.title)
    EditText txtTitle;
    
    @Bind(R.id.description)
    EditText txtDescription;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxTextView.textChanges(txtTitle).filter(new Func1<CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence title_changed) {
                return (TextUtils.isEmpty(title_changed));
            }
        }).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                txtTitle.setError("Enter valid data in title");
            }
        });
        
        RxTextView.textChanges(txtDescription)
        .filter(changed_txt -> !(TextUtils.isEmpty(changed_txt)))
        .subscribe(changed_val -> {
           priceIncreaseEditText.setError("Enter valid Description");
         });
        
        
  }
}
