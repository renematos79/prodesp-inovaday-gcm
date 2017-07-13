package br.com.prodesp.inovadaygcm;

/**
 * Created by root on 26/10/16.
 */

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.widget.EditText;
    import android.widget.ListView;
    import android.widget.TextView;

    import java.util.List;

public class NotificacaoActivity  extends AppCompatActivity {

    public static String NOTIFY_EXTRA_MESSAGE = "NOTIFY_EXTRA_MESSAGE";

    private List<NotificacaoModel> list;
    private NotificacaoAdapter adapter;
    private ListView listView;
    private TextView lblNavUserName;
    private TextView lblNavUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // inicializa a object list
        this.list = loadData("");
        this.adapter = new NotificacaoAdapter(this, list);

        // inicializ a list view
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public List<NotificacaoModel> loadData(String search) {
        return NotificacaoProxy.Notificacoes;
    }
}
