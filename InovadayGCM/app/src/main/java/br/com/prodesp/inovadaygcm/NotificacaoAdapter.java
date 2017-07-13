package br.com.prodesp.inovadaygcm;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class NotificacaoAdapter extends BaseAdapter {

    Context ctx;
    List<NotificacaoModel> list;

    public NotificacaoAdapter(Context ctx, List<NotificacaoModel> list)
    {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NotificacaoModel model = list.get(position);
        // prepare ClientViewHolder
        NotificacaoViewHolder holder;
        if (convertView ==  null)
        {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.list_item_notificacao, null);
            holder = new NotificacaoViewHolder();
            holder.lblData = (TextView)convertView.findViewById(R.id.lblData);
            holder.lblMensagem = (TextView)convertView.findViewById(R.id.lblMensagem);
            holder.lblNew = (TextView)convertView.findViewById(R.id.lblNew);

            holder.lblMensagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NotificacaoModel model = (NotificacaoModel)v.getTag();
                    model.DataLeitura = ConvertHelper.ToString(new Date());
                    NotificacaoAdapter.this.notifyDataSetChanged();
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (NotificacaoViewHolder)convertView.getTag();
        }

        // set values
        holder.lblData.setText(model.DataEnvio);
        holder.lblMensagem.setText(model.Mensagem);
        holder.lblNew.setVisibility(TextUtils.isEmpty(model.DataLeitura) ? View.VISIBLE : View.GONE);

        // mantem a tag com o ID do objeto para permitir a marcacao como registro lido
        holder.lblData.setTag(model);
        holder.lblMensagem.setTag(model);


        // retorna a instancia da view
        return convertView;
    }

    static class NotificacaoViewHolder
    {
        TextView lblData;
        TextView lblMensagem;
        TextView lblNew;
    }
}
