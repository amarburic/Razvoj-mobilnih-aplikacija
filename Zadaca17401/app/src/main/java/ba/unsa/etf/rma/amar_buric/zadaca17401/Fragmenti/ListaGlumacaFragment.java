package ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.GlumacArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnGlumacItemClick} interface
 * to handle interaction events.
 * Use the {@link ListaGlumacaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaGlumacaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnGlumacItemClick ogic;

    public ListaGlumacaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaGlumacaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaGlumacaFragment newInstance(String param1, String param2) {
        ListaGlumacaFragment fragment = new ListaGlumacaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView lista = (ListView)getView().findViewById(R.id.listGlumci);

        ogic = (OnGlumacItemClick)getActivity();

        final GlumacArrayAdapter adapter = new GlumacArrayAdapter(getActivity(), R.layout.element_liste_glumaca,
                Podaci.glumci);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               ogic.onGlumacItemClicked(position);

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_glumaca, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        ogic = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnGlumacItemClick {
        // TODO: Update argument type and name
        void onGlumacItemClicked(int item);
    }
}
