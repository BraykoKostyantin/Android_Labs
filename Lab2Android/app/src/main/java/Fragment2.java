import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kostyantin.lab2android.R;

public class Fragment2 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView2 = inflater.inflate(R.layout.fragment2, container, false);

        final TextView t1=(TextView) rootView2.findViewById(R.id.textView5);
        final TextView t2=(TextView) rootView2.findViewById(R.id.textView6);
        final TextView t3=(TextView) rootView2.findViewById(R.id.textView7);

        return rootView2;
    }
}
